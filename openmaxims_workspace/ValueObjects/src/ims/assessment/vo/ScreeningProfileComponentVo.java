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

package ims.assessment.vo;

/**
 * Linked to Assessment.Configuration.ScreeningProfileComponent business object (ID: 1083100008).
 */
public class ScreeningProfileComponentVo extends ims.assessment.configuration.vo.ScreeningProfileComponentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ScreeningProfileComponentVo()
	{
	}
	public ScreeningProfileComponentVo(Integer id, int version)
	{
		super(id, version);
	}
	public ScreeningProfileComponentVo(ims.assessment.vo.beans.ScreeningProfileComponentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessment = bean.getUserAssessment() == null ? null : bean.getUserAssessment().buildVo();
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo();
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.ScreeningProfileComponentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessment = bean.getUserAssessment() == null ? null : bean.getUserAssessment().buildVo(map);
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo(map);
		this.activestatus = bean.getActiveStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getActiveStatus());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.ScreeningProfileComponentVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.ScreeningProfileComponentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.ScreeningProfileComponentVoBean();
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
		if(fieldName.equals("USERASSESSMENT"))
			return getUserAssessment();
		if(fieldName.equals("GRAPHIC"))
			return getGraphic();
		if(fieldName.equals("ACTIVESTATUS"))
			return getActiveStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUserAssessmentIsNotNull()
	{
		return this.userassessment != null;
	}
	public ims.assessment.vo.UserAssessmentShortVo getUserAssessment()
	{
		return this.userassessment;
	}
	public void setUserAssessment(ims.assessment.vo.UserAssessmentShortVo value)
	{
		this.isValidated = false;
		this.userassessment = value;
	}
	public boolean getGraphicIsNotNull()
	{
		return this.graphic != null;
	}
	public ims.assessment.vo.GraphicAssessmentShortVo getGraphic()
	{
		return this.graphic;
	}
	public void setGraphic(ims.assessment.vo.GraphicAssessmentShortVo value)
	{
		this.isValidated = false;
		this.graphic = value;
	}
	public boolean getActiveStatusIsNotNull()
	{
		return this.activestatus != null;
	}
	public ims.core.vo.lookups.PreActiveActiveInactiveStatus getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.core.vo.lookups.PreActiveActiveInactiveStatus value)
	{
		this.isValidated = false;
		this.activestatus = value;
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
		if(this.userassessment != null)
		{
			if(!this.userassessment.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.graphic != null)
		{
			if(!this.graphic.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.userassessment != null)
		{
			String[] listOfOtherErrors = this.userassessment.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.graphic != null)
		{
			String[] listOfOtherErrors = this.graphic.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.activestatus == null)
			listOfErrors.add("ActiveStatus is mandatory");
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
	
		ScreeningProfileComponentVo clone = new ScreeningProfileComponentVo(this.id, this.version);
		
		if(this.userassessment == null)
			clone.userassessment = null;
		else
			clone.userassessment = (ims.assessment.vo.UserAssessmentShortVo)this.userassessment.clone();
		if(this.graphic == null)
			clone.graphic = null;
		else
			clone.graphic = (ims.assessment.vo.GraphicAssessmentShortVo)this.graphic.clone();
		if(this.activestatus == null)
			clone.activestatus = null;
		else
			clone.activestatus = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.activestatus.clone();
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
		if (!(ScreeningProfileComponentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ScreeningProfileComponentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ScreeningProfileComponentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ScreeningProfileComponentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.userassessment != null)
			count++;
		if(this.graphic != null)
			count++;
		if(this.activestatus != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.assessment.vo.UserAssessmentShortVo userassessment;
	protected ims.assessment.vo.GraphicAssessmentShortVo graphic;
	protected ims.core.vo.lookups.PreActiveActiveInactiveStatus activestatus;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
