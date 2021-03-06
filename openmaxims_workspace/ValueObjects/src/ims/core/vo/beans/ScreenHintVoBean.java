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

public class ScreenHintVoBean extends ims.vo.ValueObjectBean
{
	public ScreenHintVoBean()
	{
	}
	public ScreenHintVoBean(ims.core.vo.ScreenHintVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.imsid = vo.getImsId();
		this.formid = vo.getFormId();
		this.usagedescription = vo.getUsageDescription();
		this.userhinttext = vo.getUserHintText();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ScreenHintVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.imsid = vo.getImsId();
		this.formid = vo.getFormId();
		this.usagedescription = vo.getUsageDescription();
		this.userhinttext = vo.getUserHintText();
	}

	public ims.core.vo.ScreenHintVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ScreenHintVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ScreenHintVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ScreenHintVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ScreenHintVo();
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
	public String getImsId()
	{
		return this.imsid;
	}
	public void setImsId(String value)
	{
		this.imsid = value;
	}
	public Integer getFormId()
	{
		return this.formid;
	}
	public void setFormId(Integer value)
	{
		this.formid = value;
	}
	public String getUsageDescription()
	{
		return this.usagedescription;
	}
	public void setUsageDescription(String value)
	{
		this.usagedescription = value;
	}
	public String getUserHintText()
	{
		return this.userhinttext;
	}
	public void setUserHintText(String value)
	{
		this.userhinttext = value;
	}

	private Integer id;
	private int version;
	private String imsid;
	private Integer formid;
	private String usagedescription;
	private String userhinttext;
}
