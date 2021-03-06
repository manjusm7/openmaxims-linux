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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.beans;

public class ClinicalContactFilterVoBean extends ims.vo.ValueObjectBean
{
	public ClinicalContactFilterVoBean()
	{
	}
	public ClinicalContactFilterVoBean(ims.core.vo.ClinicalContactFilterVo vo)
	{
		this.contacttype = vo.getContactType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContactType().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getLocation().getBean();
		this.memberofstaff = vo.getMemberOfStaff() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMemberOfStaff().getBean();
		this.iscontacttypeinpatient = vo.getIsContactTypeInpatient();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.parentclinicalcontact = vo.getParentClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getParentClinicalContact().getBean();
		this.includedischarged = vo.getIncludeDischarged();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ClinicalContactFilterVo vo)
	{
		this.contacttype = vo.getContactType() == null ? null : (ims.vo.LookupInstanceBean)vo.getContactType().getBean();
		this.datefrom = vo.getDateFrom() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateFrom().getBean();
		this.dateto = vo.getDateTo() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateTo().getBean();
		this.location = vo.getLocation() == null ? null : (ims.core.vo.beans.LocShortVoBean)vo.getLocation().getBean(map);
		this.memberofstaff = vo.getMemberOfStaff() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMemberOfStaff().getBean(map);
		this.iscontacttypeinpatient = vo.getIsContactTypeInpatient();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.parentclinicalcontact = vo.getParentClinicalContact() == null ? null : (ims.core.vo.beans.ClinicalContactShortVoBean)vo.getParentClinicalContact().getBean(map);
		this.includedischarged = vo.getIncludeDischarged();
	}

	public ims.core.vo.ClinicalContactFilterVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ClinicalContactFilterVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ClinicalContactFilterVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ClinicalContactFilterVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ClinicalContactFilterVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.vo.LookupInstanceBean getContactType()
	{
		return this.contacttype;
	}
	public void setContactType(ims.vo.LookupInstanceBean value)
	{
		this.contacttype = value;
	}
	public ims.framework.utils.beans.DateBean getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.beans.DateBean value)
	{
		this.datefrom = value;
	}
	public ims.framework.utils.beans.DateBean getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.beans.DateBean value)
	{
		this.dateto = value;
	}
	public ims.core.vo.beans.LocShortVoBean getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.core.vo.beans.LocShortVoBean value)
	{
		this.location = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getMemberOfStaff()
	{
		return this.memberofstaff;
	}
	public void setMemberOfStaff(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.memberofstaff = value;
	}
	public Boolean getIsContactTypeInpatient()
	{
		return this.iscontacttypeinpatient;
	}
	public void setIsContactTypeInpatient(Boolean value)
	{
		this.iscontacttypeinpatient = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.ClinicalContactShortVoBean getParentClinicalContact()
	{
		return this.parentclinicalcontact;
	}
	public void setParentClinicalContact(ims.core.vo.beans.ClinicalContactShortVoBean value)
	{
		this.parentclinicalcontact = value;
	}
	public Boolean getIncludeDischarged()
	{
		return this.includedischarged;
	}
	public void setIncludeDischarged(Boolean value)
	{
		this.includedischarged = value;
	}

	private ims.vo.LookupInstanceBean contacttype;
	private ims.framework.utils.beans.DateBean datefrom;
	private ims.framework.utils.beans.DateBean dateto;
	private ims.core.vo.beans.LocShortVoBean location;
	private ims.core.vo.beans.MemberOfStaffShortVoBean memberofstaff;
	private Boolean iscontacttypeinpatient;
	private ims.core.vo.beans.PatientShortBean patient;
	private ims.core.vo.beans.ClinicalContactShortVoBean parentclinicalcontact;
	private Boolean includedischarged;
}
