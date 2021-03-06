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

package ims.icp.vo.beans;

public class PatientICPFullVoBean extends ims.vo.ValueObjectBean
{
	public PatientICPFullVoBean()
	{
	}
	public PatientICPFullVoBean(ims.icp.vo.PatientICPFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICPLiteVoBean)vo.getICP().getBean();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.starteddatetime = vo.getStartedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartedDateTime().getBean();
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		if(vo.getAppointments() != null)
		{
			this.appointments = new ims.vo.RefVoBean[vo.getAppointments().size()];
			for(int appointments_i = 0; appointments_i < vo.getAppointments().size(); appointments_i++)
			{
				this.appointments[appointments_i] = new ims.vo.RefVoBean(vo.getAppointments().get(appointments_i).getBoId(),vo.getAppointments().get(appointments_i).getBoVersion());
			}
		}
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.criticalevents = vo.getCriticalEvents() == null ? null : vo.getCriticalEvents().getBeanCollection();
		this.evaluationnotes = vo.getEvaluationNotes() == null ? null : vo.getEvaluationNotes().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.PatientICPFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hasoutstandingadminactions = vo.getHasOutstandingAdminActions();
		this.hasoutstandingnursingactions = vo.getHasOutstandingNursingActions();
		this.hasoutstandingphysioactions = vo.getHasOutstandingPhysioActions();
		this.hasoutstandingclinicalactions = vo.getHasOutstandingClinicalActions();
		this.icp = vo.getICP() == null ? null : (ims.icp.vo.beans.ICPLiteVoBean)vo.getICP().getBean(map);
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.patient = vo.getPatient() == null ? null : new ims.vo.RefVoBean(vo.getPatient().getBoId(), vo.getPatient().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.starteddatetime = vo.getStartedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartedDateTime().getBean();
		this.stages = vo.getStages() == null ? null : vo.getStages().getBeanCollection();
		this.clinicalcontact = vo.getClinicalContact() == null ? null : new ims.vo.RefVoBean(vo.getClinicalContact().getBoId(), vo.getClinicalContact().getBoVersion());
		this.completeddatetime = vo.getCompletedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCompletedDateTime().getBean();
		if(vo.getAppointments() != null)
		{
			this.appointments = new ims.vo.RefVoBean[vo.getAppointments().size()];
			for(int appointments_i = 0; appointments_i < vo.getAppointments().size(); appointments_i++)
			{
				this.appointments[appointments_i] = new ims.vo.RefVoBean(vo.getAppointments().get(appointments_i).getBoId(),vo.getAppointments().get(appointments_i).getBoVersion());
			}
		}
		this.pasevent = vo.getPasEvent() == null ? null : new ims.vo.RefVoBean(vo.getPasEvent().getBoId(), vo.getPasEvent().getBoVersion());
		this.criticalevents = vo.getCriticalEvents() == null ? null : vo.getCriticalEvents().getBeanCollection();
		this.evaluationnotes = vo.getEvaluationNotes() == null ? null : vo.getEvaluationNotes().getBeanCollection();
	}

	public ims.icp.vo.PatientICPFullVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.icp.vo.PatientICPFullVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.PatientICPFullVo vo = null;
		if(map != null)
			vo = (ims.icp.vo.PatientICPFullVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.icp.vo.PatientICPFullVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public Boolean getHasOutstandingAdminActions()
	{
		return this.hasoutstandingadminactions;
	}
	public void setHasOutstandingAdminActions(Boolean value)
	{
		this.hasoutstandingadminactions = value;
	}
	public Boolean getHasOutstandingNursingActions()
	{
		return this.hasoutstandingnursingactions;
	}
	public void setHasOutstandingNursingActions(Boolean value)
	{
		this.hasoutstandingnursingactions = value;
	}
	public Boolean getHasOutstandingPhysioActions()
	{
		return this.hasoutstandingphysioactions;
	}
	public void setHasOutstandingPhysioActions(Boolean value)
	{
		this.hasoutstandingphysioactions = value;
	}
	public Boolean getHasOutstandingClinicalActions()
	{
		return this.hasoutstandingclinicalactions;
	}
	public void setHasOutstandingClinicalActions(Boolean value)
	{
		this.hasoutstandingclinicalactions = value;
	}
	public ims.icp.vo.beans.ICPLiteVoBean getICP()
	{
		return this.icp;
	}
	public void setICP(ims.icp.vo.beans.ICPLiteVoBean value)
	{
		this.icp = value;
	}
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public ims.vo.RefVoBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.vo.RefVoBean value)
	{
		this.patient = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartedDateTime()
	{
		return this.starteddatetime;
	}
	public void setStartedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.starteddatetime = value;
	}
	public ims.icp.vo.beans.PatientICPStagesFullVoBean[] getStages()
	{
		return this.stages;
	}
	public void setStages(ims.icp.vo.beans.PatientICPStagesFullVoBean[] value)
	{
		this.stages = value;
	}
	public ims.vo.RefVoBean getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.vo.RefVoBean value)
	{
		this.clinicalcontact = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCompletedDateTime()
	{
		return this.completeddatetime;
	}
	public void setCompletedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.completeddatetime = value;
	}
	public ims.vo.RefVoBean[] getAppointments()
	{
		return this.appointments;
	}
	public void setAppointments(ims.vo.RefVoBean[] value)
	{
		this.appointments = value;
	}
	public ims.vo.RefVoBean getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.vo.RefVoBean value)
	{
		this.pasevent = value;
	}
	public ims.icp.vo.beans.PatientCriticalEventsVoBean[] getCriticalEvents()
	{
		return this.criticalevents;
	}
	public void setCriticalEvents(ims.icp.vo.beans.PatientCriticalEventsVoBean[] value)
	{
		this.criticalevents = value;
	}
	public ims.icp.vo.beans.PatientICPEvaluationNoteVoBean[] getEvaluationNotes()
	{
		return this.evaluationnotes;
	}
	public void setEvaluationNotes(ims.icp.vo.beans.PatientICPEvaluationNoteVoBean[] value)
	{
		this.evaluationnotes = value;
	}

	private Integer id;
	private int version;
	private Boolean hasoutstandingadminactions;
	private Boolean hasoutstandingnursingactions;
	private Boolean hasoutstandingphysioactions;
	private Boolean hasoutstandingclinicalactions;
	private ims.icp.vo.beans.ICPLiteVoBean icp;
	private ims.vo.RefVoBean carecontext;
	private ims.vo.RefVoBean patient;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.framework.utils.beans.DateTimeBean starteddatetime;
	private ims.icp.vo.beans.PatientICPStagesFullVoBean[] stages;
	private ims.vo.RefVoBean clinicalcontact;
	private ims.framework.utils.beans.DateTimeBean completeddatetime;
	private ims.vo.RefVoBean[] appointments;
	private ims.vo.RefVoBean pasevent;
	private ims.icp.vo.beans.PatientCriticalEventsVoBean[] criticalevents;
	private ims.icp.vo.beans.PatientICPEvaluationNoteVoBean[] evaluationnotes;
}
