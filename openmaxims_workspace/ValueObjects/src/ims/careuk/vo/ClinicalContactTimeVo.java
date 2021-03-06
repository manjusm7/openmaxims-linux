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

package ims.careuk.vo;

/**
 * Linked to CAREUK.ClinicalContactTime business object (ID: 1096100012).
 */
public class ClinicalContactTimeVo extends ims.careuk.vo.ClinicalContactTimeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalContactTimeVo()
	{
	}
	public ClinicalContactTimeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalContactTimeVo(ims.careuk.vo.beans.ClinicalContactTimeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starthcp = bean.getStartHcp() == null ? null : bean.getStartHcp().buildVo();
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.endhcp = bean.getEndHcp() == null ? null : bean.getEndHcp().buildVo();
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.beans.ClinicalContactTimeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.starthcp = bean.getStartHcp() == null ? null : bean.getStartHcp().buildVo(map);
		this.startdatetime = bean.getStartDateTime() == null ? null : bean.getStartDateTime().buildDateTime();
		this.endhcp = bean.getEndHcp() == null ? null : bean.getEndHcp().buildVo(map);
		this.enddatetime = bean.getEndDateTime() == null ? null : bean.getEndDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.beans.ClinicalContactTimeVoBean bean = null;
		if(map != null)
			bean = (ims.careuk.vo.beans.ClinicalContactTimeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.careuk.vo.beans.ClinicalContactTimeVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("STARTHCP"))
			return getStartHcp();
		if(fieldName.equals("STARTDATETIME"))
			return getStartDateTime();
		if(fieldName.equals("ENDHCP"))
			return getEndHcp();
		if(fieldName.equals("ENDDATETIME"))
			return getEndDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getStartHcpIsNotNull()
	{
		return this.starthcp != null;
	}
	public ims.core.vo.HcpLiteVo getStartHcp()
	{
		return this.starthcp;
	}
	public void setStartHcp(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.starthcp = value;
	}
	public boolean getStartDateTimeIsNotNull()
	{
		return this.startdatetime != null;
	}
	public ims.framework.utils.DateTime getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.startdatetime = value;
	}
	public boolean getEndHcpIsNotNull()
	{
		return this.endhcp != null;
	}
	public ims.core.vo.HcpLiteVo getEndHcp()
	{
		return this.endhcp;
	}
	public void setEndHcp(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.endhcp = value;
	}
	public boolean getEndDateTimeIsNotNull()
	{
		return this.enddatetime != null;
	}
	public ims.framework.utils.DateTime getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.enddatetime = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.starthcp == null)
			listOfErrors.add("StartHcp is mandatory");
		if(this.startdatetime == null)
			listOfErrors.add("StartDateTime is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ClinicalContactTimeVo clone = new ClinicalContactTimeVo(this.id, this.version);
		
		if(this.starthcp == null)
			clone.starthcp = null;
		else
			clone.starthcp = (ims.core.vo.HcpLiteVo)this.starthcp.clone();
		if(this.startdatetime == null)
			clone.startdatetime = null;
		else
			clone.startdatetime = (ims.framework.utils.DateTime)this.startdatetime.clone();
		if(this.endhcp == null)
			clone.endhcp = null;
		else
			clone.endhcp = (ims.core.vo.HcpLiteVo)this.endhcp.clone();
		if(this.enddatetime == null)
			clone.enddatetime = null;
		else
			clone.enddatetime = (ims.framework.utils.DateTime)this.enddatetime.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ClinicalContactTimeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalContactTimeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ClinicalContactTimeVo compareObj = (ClinicalContactTimeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getStartDateTime() == null && compareObj.getStartDateTime() != null)
				return -1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() == null)
				return 1;
			if(this.getStartDateTime() != null && compareObj.getStartDateTime() != null)
				retVal = this.getStartDateTime().compareTo(compareObj.getStartDateTime());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.starthcp != null)
			count++;
		if(this.startdatetime != null)
			count++;
		if(this.endhcp != null)
			count++;
		if(this.enddatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.HcpLiteVo starthcp;
	protected ims.framework.utils.DateTime startdatetime;
	protected ims.core.vo.HcpLiteVo endhcp;
	protected ims.framework.utils.DateTime enddatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
