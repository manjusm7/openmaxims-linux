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

package ims.clinical.vo;


public class SurgicalAuditTheatreWorklistSearchCriteriaVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SurgicalAuditTheatreWorklistSearchCriteriaVo()
	{
	}
	public SurgicalAuditTheatreWorklistSearchCriteriaVo(ims.clinical.vo.beans.SurgicalAuditTheatreWorklistSearchCriteriaVoBean bean)
	{
		this.idtype = bean.getIdType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIdType());
		this.idvalue = bean.getIdValue();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo();
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus.buildLookup(bean.getStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.SurgicalAuditTheatreWorklistSearchCriteriaVoBean bean)
	{
		this.idtype = bean.getIdType() == null ? null : ims.core.vo.lookups.PatIdType.buildLookup(bean.getIdType());
		this.idvalue = bean.getIdValue();
		this.surname = bean.getSurname();
		this.forename = bean.getForename();
		this.theatre = bean.getTheatre() == null ? null : bean.getTheatre().buildVo(map);
		this.status = bean.getStatus() == null ? null : ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus.buildLookup(bean.getStatus());
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDate();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDate();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.SurgicalAuditTheatreWorklistSearchCriteriaVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.SurgicalAuditTheatreWorklistSearchCriteriaVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.SurgicalAuditTheatreWorklistSearchCriteriaVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getIdTypeIsNotNull()
	{
		return this.idtype != null;
	}
	public ims.core.vo.lookups.PatIdType getIdType()
	{
		return this.idtype;
	}
	public void setIdType(ims.core.vo.lookups.PatIdType value)
	{
		this.isValidated = false;
		this.idtype = value;
	}
	public boolean getIdValueIsNotNull()
	{
		return this.idvalue != null;
	}
	public String getIdValue()
	{
		return this.idvalue;
	}
	public static int getIdValueMaxLength()
	{
		return 255;
	}
	public void setIdValue(String value)
	{
		this.isValidated = false;
		this.idvalue = value;
	}
	public boolean getSurnameIsNotNull()
	{
		return this.surname != null;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public static int getSurnameMaxLength()
	{
		return 255;
	}
	public void setSurname(String value)
	{
		this.isValidated = false;
		this.surname = value;
	}
	public boolean getForenameIsNotNull()
	{
		return this.forename != null;
	}
	public String getForename()
	{
		return this.forename;
	}
	public static int getForenameMaxLength()
	{
		return 255;
	}
	public void setForename(String value)
	{
		this.isValidated = false;
		this.forename = value;
	}
	public boolean getTheatreIsNotNull()
	{
		return this.theatre != null;
	}
	public ims.core.vo.LocationLiteVo getTheatre()
	{
		return this.theatre;
	}
	public void setTheatre(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.theatre = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.Date getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.Date getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof SurgicalAuditTheatreWorklistSearchCriteriaVo))
			return false;
		SurgicalAuditTheatreWorklistSearchCriteriaVo compareObj = (SurgicalAuditTheatreWorklistSearchCriteriaVo)obj;
		if(this.getSurname() == null && compareObj.getSurname() != null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() == null)
			return false;
		if(this.getSurname() != null && compareObj.getSurname() != null)
			return this.getSurname().equals(compareObj.getSurname());
		return super.equals(obj);
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
		if(this.theatre != null)
		{
			if(!this.theatre.isValidated())
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
		if(this.theatre != null)
		{
			String[] listOfOtherErrors = this.theatre.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		SurgicalAuditTheatreWorklistSearchCriteriaVo clone = new SurgicalAuditTheatreWorklistSearchCriteriaVo();
		
		if(this.idtype == null)
			clone.idtype = null;
		else
			clone.idtype = (ims.core.vo.lookups.PatIdType)this.idtype.clone();
		clone.idvalue = this.idvalue;
		clone.surname = this.surname;
		clone.forename = this.forename;
		if(this.theatre == null)
			clone.theatre = null;
		else
			clone.theatre = (ims.core.vo.LocationLiteVo)this.theatre.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus)this.status.clone();
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.Date)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.Date)this.dateto.clone();
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
		if (!(SurgicalAuditTheatreWorklistSearchCriteriaVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SurgicalAuditTheatreWorklistSearchCriteriaVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SurgicalAuditTheatreWorklistSearchCriteriaVo compareObj = (SurgicalAuditTheatreWorklistSearchCriteriaVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSurname() == null && compareObj.getSurname() != null)
				return -1;
			if(this.getSurname() != null && compareObj.getSurname() == null)
				return 1;
			if(this.getSurname() != null && compareObj.getSurname() != null)
			{
				if(caseInsensitive)
					retVal = this.getSurname().toLowerCase().compareTo(compareObj.getSurname().toLowerCase());
				else
					retVal = this.getSurname().compareTo(compareObj.getSurname());
			}
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
		if(this.idtype != null)
			count++;
		if(this.idvalue != null)
			count++;
		if(this.surname != null)
			count++;
		if(this.forename != null)
			count++;
		if(this.theatre != null)
			count++;
		if(this.status != null)
			count++;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.lookups.PatIdType idtype;
	protected String idvalue;
	protected String surname;
	protected String forename;
	protected ims.core.vo.LocationLiteVo theatre;
	protected ims.clinical.vo.lookups.SurgicalAuditOperationDetailStatus status;
	protected ims.framework.utils.Date datefrom;
	protected ims.framework.utils.Date dateto;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
