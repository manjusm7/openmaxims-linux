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

public class MedicationFullVoBean extends ims.vo.ValueObjectBean
{
	public MedicationFullVoBean()
	{
	}
	public MedicationFullVoBean(ims.core.vo.MedicationFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medicationname = vo.getMedicationName();
		this.isactive = vo.getIsActive();
		this.iscontrolleddrug = vo.getIsControlledDrug();
		this.frequencydefault = vo.getFrequencyDefault() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequencyDefault().getBean();
		this.noofdayssupplydefault = vo.getNoOfDaysSupplyDefault();
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
		this.keywords = vo.getKeywords() == null ? null : vo.getKeywords().getBeanCollection();
		this.forms = vo.getForms() == null ? null : vo.getForms().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.MedicationFullVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.medicationname = vo.getMedicationName();
		this.isactive = vo.getIsActive();
		this.iscontrolleddrug = vo.getIsControlledDrug();
		this.frequencydefault = vo.getFrequencyDefault() == null ? null : (ims.vo.LookupInstanceBean)vo.getFrequencyDefault().getBean();
		this.noofdayssupplydefault = vo.getNoOfDaysSupplyDefault();
		this.taxonomymap = vo.getTaxonomyMap() == null ? null : vo.getTaxonomyMap().getBeanCollection();
		this.keywords = vo.getKeywords() == null ? null : vo.getKeywords().getBeanCollection();
		this.forms = vo.getForms() == null ? null : vo.getForms().getBeanCollection();
	}

	public ims.core.vo.MedicationFullVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.MedicationFullVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.MedicationFullVo vo = null;
		if(map != null)
			vo = (ims.core.vo.MedicationFullVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.MedicationFullVo();
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
	public String getMedicationName()
	{
		return this.medicationname;
	}
	public void setMedicationName(String value)
	{
		this.medicationname = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public Boolean getIsControlledDrug()
	{
		return this.iscontrolleddrug;
	}
	public void setIsControlledDrug(Boolean value)
	{
		this.iscontrolleddrug = value;
	}
	public ims.vo.LookupInstanceBean getFrequencyDefault()
	{
		return this.frequencydefault;
	}
	public void setFrequencyDefault(ims.vo.LookupInstanceBean value)
	{
		this.frequencydefault = value;
	}
	public Integer getNoOfDaysSupplyDefault()
	{
		return this.noofdayssupplydefault;
	}
	public void setNoOfDaysSupplyDefault(Integer value)
	{
		this.noofdayssupplydefault = value;
	}
	public ims.core.vo.beans.TaxonomyMapBean[] getTaxonomyMap()
	{
		return this.taxonomymap;
	}
	public void setTaxonomyMap(ims.core.vo.beans.TaxonomyMapBean[] value)
	{
		this.taxonomymap = value;
	}
	public ims.core.vo.beans.KeywordVoBean[] getKeywords()
	{
		return this.keywords;
	}
	public void setKeywords(ims.core.vo.beans.KeywordVoBean[] value)
	{
		this.keywords = value;
	}
	public ims.core.vo.beans.MedicationFormVoBean[] getForms()
	{
		return this.forms;
	}
	public void setForms(ims.core.vo.beans.MedicationFormVoBean[] value)
	{
		this.forms = value;
	}

	private Integer id;
	private int version;
	private String medicationname;
	private Boolean isactive;
	private Boolean iscontrolleddrug;
	private ims.vo.LookupInstanceBean frequencydefault;
	private Integer noofdayssupplydefault;
	private ims.core.vo.beans.TaxonomyMapBean[] taxonomymap;
	private ims.core.vo.beans.KeywordVoBean[] keywords;
	private ims.core.vo.beans.MedicationFormVoBean[] forms;
}
