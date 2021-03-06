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

package ims.careuk.vo.beans;

public class PatientElectiveListForDNAAppointmentsVoBean extends ims.vo.ValueObjectBean
{
	public PatientElectiveListForDNAAppointmentsVoBean()
	{
	}
	public PatientElectiveListForDNAAppointmentsVoBean(ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.electiveliststatus = vo.getElectiveListStatus() == null ? null : (ims.careuk.vo.beans.ElectiveListStatusVoBean)vo.getElectiveListStatus().getBean();
		if(vo.getElectiveListStatusHistory() != null)
		{
			this.electiveliststatushistory = new ims.vo.RefVoBean[vo.getElectiveListStatusHistory().size()];
			for(int electiveliststatushistory_i = 0; electiveliststatushistory_i < vo.getElectiveListStatusHistory().size(); electiveliststatushistory_i++)
			{
				this.electiveliststatushistory[electiveliststatushistory_i] = new ims.vo.RefVoBean(vo.getElectiveListStatusHistory().get(electiveliststatushistory_i).getBoId(),vo.getElectiveListStatusHistory().get(electiveliststatushistory_i).getBoVersion());
			}
		}
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.careuk.vo.beans.TCIForPatientElectiveListAppointmentDNAVoBean)vo.getTCIDetails().getBean();
		if(vo.getTCIHistory() != null)
		{
			this.tcihistory = new ims.vo.RefVoBean[vo.getTCIHistory().size()];
			for(int tcihistory_i = 0; tcihistory_i < vo.getTCIHistory().size(); tcihistory_i++)
			{
				this.tcihistory[tcihistory_i] = new ims.vo.RefVoBean(vo.getTCIHistory().get(tcihistory_i).getBoId(),vo.getTCIHistory().get(tcihistory_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.electiveliststatus = vo.getElectiveListStatus() == null ? null : (ims.careuk.vo.beans.ElectiveListStatusVoBean)vo.getElectiveListStatus().getBean(map);
		if(vo.getElectiveListStatusHistory() != null)
		{
			this.electiveliststatushistory = new ims.vo.RefVoBean[vo.getElectiveListStatusHistory().size()];
			for(int electiveliststatushistory_i = 0; electiveliststatushistory_i < vo.getElectiveListStatusHistory().size(); electiveliststatushistory_i++)
			{
				this.electiveliststatushistory[electiveliststatushistory_i] = new ims.vo.RefVoBean(vo.getElectiveListStatusHistory().get(electiveliststatushistory_i).getBoId(),vo.getElectiveListStatusHistory().get(electiveliststatushistory_i).getBoVersion());
			}
		}
		this.tcidetails = vo.getTCIDetails() == null ? null : (ims.careuk.vo.beans.TCIForPatientElectiveListAppointmentDNAVoBean)vo.getTCIDetails().getBean(map);
		if(vo.getTCIHistory() != null)
		{
			this.tcihistory = new ims.vo.RefVoBean[vo.getTCIHistory().size()];
			for(int tcihistory_i = 0; tcihistory_i < vo.getTCIHistory().size(); tcihistory_i++)
			{
				this.tcihistory[tcihistory_i] = new ims.vo.RefVoBean(vo.getTCIHistory().get(tcihistory_i).getBoId(),vo.getTCIHistory().get(tcihistory_i).getBoVersion());
			}
		}
	}

	public ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.PatientElectiveListForDNAAppointmentsVo();
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
	public ims.careuk.vo.beans.ElectiveListStatusVoBean getElectiveListStatus()
	{
		return this.electiveliststatus;
	}
	public void setElectiveListStatus(ims.careuk.vo.beans.ElectiveListStatusVoBean value)
	{
		this.electiveliststatus = value;
	}
	public ims.vo.RefVoBean[] getElectiveListStatusHistory()
	{
		return this.electiveliststatushistory;
	}
	public void setElectiveListStatusHistory(ims.vo.RefVoBean[] value)
	{
		this.electiveliststatushistory = value;
	}
	public ims.careuk.vo.beans.TCIForPatientElectiveListAppointmentDNAVoBean getTCIDetails()
	{
		return this.tcidetails;
	}
	public void setTCIDetails(ims.careuk.vo.beans.TCIForPatientElectiveListAppointmentDNAVoBean value)
	{
		this.tcidetails = value;
	}
	public ims.vo.RefVoBean[] getTCIHistory()
	{
		return this.tcihistory;
	}
	public void setTCIHistory(ims.vo.RefVoBean[] value)
	{
		this.tcihistory = value;
	}

	private Integer id;
	private int version;
	private ims.careuk.vo.beans.ElectiveListStatusVoBean electiveliststatus;
	private ims.vo.RefVoBean[] electiveliststatushistory;
	private ims.careuk.vo.beans.TCIForPatientElectiveListAppointmentDNAVoBean tcidetails;
	private ims.vo.RefVoBean[] tcihistory;
}
