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

package ims.clinicaladmin.vo;

/**
 * Linked to Oncology.Configuration.TumourGroupHistopathologicGrade business object (ID: 1075100009).
 */
public class TumourGroupHistopathologyGradeVo extends ims.oncology.configuration.vo.TumourGroupHistopathologicGradeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TumourGroupHistopathologyGradeVo()
	{
	}
	public TumourGroupHistopathologyGradeVo(Integer id, int version)
	{
		super(id, version);
	}
	public TumourGroupHistopathologyGradeVo(ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tumourdifferentation = bean.getTumourDifferentation() == null ? null : bean.getTumourDifferentation().buildVo();
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.tumourdifferentation = bean.getTumourDifferentation() == null ? null : bean.getTumourDifferentation().buildVo(map);
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean bean = null;
		if(map != null)
			bean = (ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinicaladmin.vo.beans.TumourGroupHistopathologyGradeVoBean();
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
		if(fieldName.equals("TUMOURDIFFERENTATION"))
			return getTumourDifferentation();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTumourDifferentationIsNotNull()
	{
		return this.tumourdifferentation != null;
	}
	public ims.clinicaladmin.vo.HistopathologicGradeVo getTumourDifferentation()
	{
		return this.tumourdifferentation;
	}
	public void setTumourDifferentation(ims.clinicaladmin.vo.HistopathologicGradeVo value)
	{
		this.isValidated = false;
		this.tumourdifferentation = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
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
		if(this.tumourdifferentation == null)
			listOfErrors.add("TumourDifferentation is mandatory");
		if(this.isactive == null)
			listOfErrors.add("isActive is mandatory");
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
	
		TumourGroupHistopathologyGradeVo clone = new TumourGroupHistopathologyGradeVo(this.id, this.version);
		
		if(this.tumourdifferentation == null)
			clone.tumourdifferentation = null;
		else
			clone.tumourdifferentation = (ims.clinicaladmin.vo.HistopathologicGradeVo)this.tumourdifferentation.clone();
		clone.isactive = this.isactive;
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
		if (!(TumourGroupHistopathologyGradeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TumourGroupHistopathologyGradeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		TumourGroupHistopathologyGradeVo compareObj = (TumourGroupHistopathologyGradeVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getTumourDifferentation() == null && compareObj.getTumourDifferentation() != null)
				return -1;
			if(this.getTumourDifferentation() != null && compareObj.getTumourDifferentation() == null)
				return 1;
			if(this.getTumourDifferentation() != null && compareObj.getTumourDifferentation() != null)
				retVal = this.getTumourDifferentation().compareTo(compareObj.getTumourDifferentation());
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
		if(this.tumourdifferentation != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinicaladmin.vo.HistopathologicGradeVo tumourdifferentation;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
