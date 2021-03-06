//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.37 build 2120.20101)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.spinalinjuries.domain.impl;

import java.util.ArrayList;
import java.util.List;
import ims.admin.domain.HcpAdmin;
import ims.admin.domain.impl.HcpAdminImpl;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.core.domain.VitalSignsAll;
import ims.core.domain.impl.VitalSignsImpl;
import ims.core.patient.vo.PatientRefVo;
import ims.core.vo.CareContextLiteVo;
import ims.core.vo.CareContextShortVoCollection;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.VSMetricsCollection;
import ims.core.vo.VitalSignsVo;
import ims.core.vo.VitalSignsVoCollection;
import ims.core.vo.domain.CareContextShortVoAssembler;
import ims.core.vo.domain.VitalSignsVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.impl.DomainImpl;
import ims.generalmedical.vo.SleepReferralVo;
import ims.generalmedical.vo.SleepReferralVoCollection;
import ims.generalmedical.vo.domain.SleepReferralVoAssembler;
import ims.medical.domain.objects.SleepReferral;
import ims.spinalinjuries.domain.OPDMedExam;

public class SleepAssessmentImpl extends DomainImpl implements ims.spinalinjuries.domain.SleepAssessment, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void saveSleepAssessmentVo(SleepReferralVo voSleepAssessment) throws StaleObjectException, UniqueKeyViolationException 
	{
		// Ensure the value object has been validated
		if (!voSleepAssessment.isValidated())
			throw new DomainRuntimeException("Sleep has not been validated");
		
		DomainFactory factory = getDomainFactory();
		if (voSleepAssessment.getID_SleepReferral() == null)//Inserting a record
		{
			StringBuffer hql = new StringBuffer();
			hql.append("from SleepReferral as s where s.careContext.id = :CCID and s.isRIE is null");
			java.util.List list = getDomainFactory().find(hql.toString(), "CCID",voSleepAssessment.getCareContext().getID_CareContext());
			if (list == null || list.size() > 0)
				throw new UniqueKeyViolationException("A record exists for this Care Context, the screen will be refreshed");
		}
		SleepReferral doSleep = SleepReferralVoAssembler.extractSleepReferral(factory, voSleepAssessment);
		factory.save(doSleep);
	}

	public VitalSignsVo saveVitalsVo(VitalSignsVo voVitals) throws StaleObjectException 
	{
		VitalSignsAll impl = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		return impl.saveVitalSign(voVitals);
	}

	public SleepReferralVoCollection listSleepByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from SleepReferral sleepRef ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getID_CareContextIsNotNull())
		{
			hql.append(andStr + " sleepRef.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List sleepList = factory.find(query,markers,values);
		SleepReferralVoCollection voSleepReferralColl = SleepReferralVoAssembler.createSleepReferralVoCollectionFromSleepReferral(sleepList);
		if(voSleepReferralColl.size()>0)
			return voSleepReferralColl;
		else
			return null;
	}

	public VitalSignsVoCollection listVitalsByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from VitalSigns vs ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " vs.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List vsList = factory.find(query,markers,values);
		VitalSignsVoCollection voVitalSignsColl = VitalSignsVoAssembler.createVitalSignsVoCollectionFromVitalSigns(vsList);
		if(voVitalSignsColl.size()>0)
			return voVitalSignsColl;
		else
			return null;
	}

	public SleepReferralVo getSleepAssessmentByCareContext(CareContextLiteVo voCareContext)
	{
		 if (voCareContext == null)
				throw new RuntimeException("Cannot get SleepReferralVo for null CareContextLiteVo");

			StringBuffer hql = new StringBuffer("from SleepReferral as o1_1 where o1_1.careContext.id = :CCID and o1_1.isRIE is null");
			List list = getDomainFactory().find(hql.toString(), "CCID", voCareContext.getID_CareContext());
			
			if (list == null || list.size() == 0)
				return null;
			else if (list.size() > 1)
				throw new RuntimeException("More than one SleepReferral found for the current Care Context");

			SleepReferralVoCollection voList = SleepReferralVoAssembler.createSleepReferralVoCollectionFromSleepReferral(list);;
			if (voList.size() > 0)
				return voList.get(0);

			return null;  
	}

	public VitalSignsVo getVitalSignsByCareContext(CareContextLiteVo voCareContext)
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer();
		String query = " from VitalSigns vs ";
		ArrayList markers= new ArrayList();
		ArrayList values = new ArrayList();
		String andStr = " ";

		if(voCareContext.getEpisodeOfCareIsNotNull())
		{
			hql.append(andStr + " vs.careContext.id = :ec");
			markers.add("ec");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}
		
		if (markers.size() > 0) query += " where ";
		query += hql.toString();	
		
		java.util.List vsList = factory.find(query,markers,values);
		VitalSignsVoCollection voVitalSignsColl = VitalSignsVoAssembler.createVitalSignsVoCollectionFromVitalSigns(vsList);
		if(voVitalSignsColl.size()>0)
			return voVitalSignsColl.get(0);
		else
			return null;
	}

	public SleepReferralVo getSleepAssessmentVo(ClinicalContactShortVo voClinicalContact)
	{
		SleepReferralVoCollection voSleepReferralColl  = new SleepReferralVoCollection();
		
		DomainFactory factory = getDomainFactory();
		
		String hql = " from SleepReferral sleepRef "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		if(voClinicalContact.getID_ClinicalContact() != null)
		{
			condStr.append(andStr + " sleepRef.clinicalContact.id = :id_ClinicalContact"); 
			markers.add("id_ClinicalContact");
			values.add(voClinicalContact.getID_ClinicalContact());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		voSleepReferralColl = SleepReferralVoAssembler.createSleepReferralVoCollectionFromSleepReferral(factory.find(hql, markers, values));
		if(voSleepReferralColl.size()>0)
			return voSleepReferralColl.get(0);
		else return null;		
	}

	public VitalSignsVo getVitalsVo(ClinicalContactShortVo voClinicalContact)
	{
		VitalSignsAll impl = (VitalSignsAll)getDomainImpl(VitalSignsImpl.class);
		VitalSignsVo voVS = new VitalSignsVo();
		ClinicalContactShortVo voClinContact = new ClinicalContactShortVo();
		voClinContact.setID_ClinicalContact(voClinicalContact.getID_ClinicalContact());
		voVS.setClinicalContact(voClinContact);
		return impl.getVitalSignsRecord(voVS);
	}

	public CareContextShortVoCollection listSleepCareContextsByEpisodeOfCare(EpisodeOfCareRefVo voRefEpisodeOfCare) 
	{
		DomainFactory factory = getDomainFactory();
		String hql= "select careContext from SleepReferral sr where sr.careContext.episodeOfCare.id = " + voRefEpisodeOfCare.getID_EpisodeOfCare();
		List lstsleepreferrals = factory.find(hql);		
		return CareContextShortVoAssembler.createCareContextShortVoCollectionFromCareContext(lstsleepreferrals);
	}

	public HcpCollection listMedics(HcpFilter voHcpFilter) 
	{
		HcpAdmin hcpAdmin = (HcpAdmin)getDomainImpl(HcpAdminImpl.class);
		return hcpAdmin.listMedics(voHcpFilter);
	}

	public VSMetricsCollection listMetricsData(PatientRefVo voRefPatient) 
	{
		OPDMedExam impl = (OPDMedExam) getDomainImpl(OPDMedExamImpl.class);
		return impl.listMetricsData(voRefPatient);
	}


}
