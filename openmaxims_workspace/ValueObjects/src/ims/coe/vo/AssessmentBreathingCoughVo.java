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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Breathing Cough business object (ID: 1012100011).
 */
public class AssessmentBreathingCoughVo extends ims.nursing.assessment.vo.BreathingCoughRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentBreathingCoughVo()
	{
	}
	public AssessmentBreathingCoughVo(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentBreathingCoughVo(ims.coe.vo.beans.AssessmentBreathingCoughVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.anycough = bean.getAnyCough() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAnyCough());
		this.productiveofsputum = bean.getProductiveOfSputum() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getProductiveOfSputum());
		this.sputumamount = bean.getSputumAmount() == null ? null : ims.coe.vo.lookups.SputumAmount.buildLookup(bean.getSputumAmount());
		this.sputumtype = ims.coe.vo.lookups.SputumTypeCollection.buildFromBeanCollection(bean.getSputumType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.AssessmentBreathingCoughVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.anycough = bean.getAnyCough() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getAnyCough());
		this.productiveofsputum = bean.getProductiveOfSputum() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getProductiveOfSputum());
		this.sputumamount = bean.getSputumAmount() == null ? null : ims.coe.vo.lookups.SputumAmount.buildLookup(bean.getSputumAmount());
		this.sputumtype = ims.coe.vo.lookups.SputumTypeCollection.buildFromBeanCollection(bean.getSputumType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.AssessmentBreathingCoughVoBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.AssessmentBreathingCoughVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.AssessmentBreathingCoughVoBean();
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
		if(fieldName.equals("ANYCOUGH"))
			return getAnyCough();
		if(fieldName.equals("PRODUCTIVEOFSPUTUM"))
			return getProductiveOfSputum();
		if(fieldName.equals("SPUTUMAMOUNT"))
			return getSputumAmount();
		if(fieldName.equals("SPUTUMTYPE"))
			return getSputumType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAnyCoughIsNotNull()
	{
		return this.anycough != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getAnyCough()
	{
		return this.anycough;
	}
	public void setAnyCough(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.anycough = value;
	}
	public boolean getProductiveOfSputumIsNotNull()
	{
		return this.productiveofsputum != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getProductiveOfSputum()
	{
		return this.productiveofsputum;
	}
	public void setProductiveOfSputum(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.productiveofsputum = value;
	}
	public boolean getSputumAmountIsNotNull()
	{
		return this.sputumamount != null;
	}
	public ims.coe.vo.lookups.SputumAmount getSputumAmount()
	{
		return this.sputumamount;
	}
	public void setSputumAmount(ims.coe.vo.lookups.SputumAmount value)
	{
		this.isValidated = false;
		this.sputumamount = value;
	}
	public boolean getSputumTypeIsNotNull()
	{
		return this.sputumtype != null;
	}
	public ims.coe.vo.lookups.SputumTypeCollection getSputumType()
	{
		return this.sputumtype;
	}
	public void setSputumType(ims.coe.vo.lookups.SputumTypeCollection value)
	{
		this.isValidated = false;
		this.sputumtype = value;
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
	
		AssessmentBreathingCoughVo clone = new AssessmentBreathingCoughVo(this.id, this.version);
		
		if(this.anycough == null)
			clone.anycough = null;
		else
			clone.anycough = (ims.core.vo.lookups.YesNoUnknown)this.anycough.clone();
		if(this.productiveofsputum == null)
			clone.productiveofsputum = null;
		else
			clone.productiveofsputum = (ims.core.vo.lookups.YesNoUnknown)this.productiveofsputum.clone();
		if(this.sputumamount == null)
			clone.sputumamount = null;
		else
			clone.sputumamount = (ims.coe.vo.lookups.SputumAmount)this.sputumamount.clone();
		if(this.sputumtype == null)
			clone.sputumtype = null;
		else
			clone.sputumtype = (ims.coe.vo.lookups.SputumTypeCollection)this.sputumtype.clone();
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
		if (!(AssessmentBreathingCoughVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentBreathingCoughVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AssessmentBreathingCoughVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AssessmentBreathingCoughVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.anycough != null)
			count++;
		if(this.productiveofsputum != null)
			count++;
		if(this.sputumamount != null)
			count++;
		if(this.sputumtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.lookups.YesNoUnknown anycough;
	protected ims.core.vo.lookups.YesNoUnknown productiveofsputum;
	protected ims.coe.vo.lookups.SputumAmount sputumamount;
	protected ims.coe.vo.lookups.SputumTypeCollection sputumtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
