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

public class PatientFilterBean extends ims.vo.ValueObjectBean
{
	public PatientFilterBean()
	{
	}
	public PatientFilterBean(ims.core.vo.PatientFilter vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.forename2 = vo.getForename2();
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.county = vo.getCounty() == null ? null : (ims.vo.LookupInstanceBean)vo.getCounty().getBean();
		this.address = vo.getAddress();
		this.persid = vo.getPersId() == null ? null : (ims.core.vo.beans.PatientIdBean)vo.getPersId().getBean();
		this.cca = vo.getCCA() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getCCA().getBean();
		this.excludequickregistrationpatients = vo.getExcludeQuickRegistrationPatients();
		this.excludedeceasedpatients = vo.getExcludeDeceasedPatients();
		this.postcode = vo.getPostCode();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.PatientFilter vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.surname = vo.getSurname();
		this.forename = vo.getForename();
		this.forename2 = vo.getForename2();
		this.sex = vo.getSex() == null ? null : (ims.vo.LookupInstanceBean)vo.getSex().getBean();
		this.dob = vo.getDob() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getDob().getBean();
		this.county = vo.getCounty() == null ? null : (ims.vo.LookupInstanceBean)vo.getCounty().getBean();
		this.address = vo.getAddress();
		this.persid = vo.getPersId() == null ? null : (ims.core.vo.beans.PatientIdBean)vo.getPersId().getBean(map);
		this.cca = vo.getCCA() == null ? null : (ims.core.vo.beans.LocSiteLiteVoBean)vo.getCCA().getBean(map);
		this.excludequickregistrationpatients = vo.getExcludeQuickRegistrationPatients();
		this.excludedeceasedpatients = vo.getExcludeDeceasedPatients();
		this.postcode = vo.getPostCode();
	}

	public ims.core.vo.PatientFilter buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.PatientFilter buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.PatientFilter vo = null;
		if(map != null)
			vo = (ims.core.vo.PatientFilter)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.PatientFilter();
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
	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String value)
	{
		this.surname = value;
	}
	public String getForename()
	{
		return this.forename;
	}
	public void setForename(String value)
	{
		this.forename = value;
	}
	public String getForename2()
	{
		return this.forename2;
	}
	public void setForename2(String value)
	{
		this.forename2 = value;
	}
	public ims.vo.LookupInstanceBean getSex()
	{
		return this.sex;
	}
	public void setSex(ims.vo.LookupInstanceBean value)
	{
		this.sex = value;
	}
	public ims.framework.utils.beans.PartialDateBean getDob()
	{
		return this.dob;
	}
	public void setDob(ims.framework.utils.beans.PartialDateBean value)
	{
		this.dob = value;
	}
	public ims.vo.LookupInstanceBean getCounty()
	{
		return this.county;
	}
	public void setCounty(ims.vo.LookupInstanceBean value)
	{
		this.county = value;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String value)
	{
		this.address = value;
	}
	public ims.core.vo.beans.PatientIdBean getPersId()
	{
		return this.persid;
	}
	public void setPersId(ims.core.vo.beans.PatientIdBean value)
	{
		this.persid = value;
	}
	public ims.core.vo.beans.LocSiteLiteVoBean getCCA()
	{
		return this.cca;
	}
	public void setCCA(ims.core.vo.beans.LocSiteLiteVoBean value)
	{
		this.cca = value;
	}
	public Boolean getExcludeQuickRegistrationPatients()
	{
		return this.excludequickregistrationpatients;
	}
	public void setExcludeQuickRegistrationPatients(Boolean value)
	{
		this.excludequickregistrationpatients = value;
	}
	public Boolean getExcludeDeceasedPatients()
	{
		return this.excludedeceasedpatients;
	}
	public void setExcludeDeceasedPatients(Boolean value)
	{
		this.excludedeceasedpatients = value;
	}
	public String getPostCode()
	{
		return this.postcode;
	}
	public void setPostCode(String value)
	{
		this.postcode = value;
	}

	private Integer id;
	private int version;
	private String surname;
	private String forename;
	private String forename2;
	private ims.vo.LookupInstanceBean sex;
	private ims.framework.utils.beans.PartialDateBean dob;
	private ims.vo.LookupInstanceBean county;
	private String address;
	private ims.core.vo.beans.PatientIdBean persid;
	private ims.core.vo.beans.LocSiteLiteVoBean cca;
	private Boolean excludequickregistrationpatients;
	private Boolean excludedeceasedpatients;
	private String postcode;
}
