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

/**
 * Linked to clinical.RACPPlanAdvice business object (ID: 1072100077).
 */
public class RACPPlanAdviceVo extends ims.clinical.vo.RACPPlanAdviceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public RACPPlanAdviceVo()
	{
	}
	public RACPPlanAdviceVo(Integer id, int version)
	{
		super(id, version);
	}
	public RACPPlanAdviceVo(ims.clinical.vo.beans.RACPPlanAdviceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.primaryplan = bean.getPrimaryPlan() == null ? null : ims.core.vo.lookups.PlanOfAction.buildLookup(bean.getPrimaryPlan());
		this.overallimpression = bean.getOverallImpression() == null ? null : ims.core.vo.lookups.OverallImpression.buildLookup(bean.getOverallImpression());
		this.otherdetails = bean.getOtherDetails();
		this.secondaryplans = ims.core.vo.lookups.PlanOfActionCollection.buildFromBeanCollection(bean.getSecondaryPlans());
		this.advicegivenpatient = ims.core.vo.lookups.AdviceToPatientCollection.buildFromBeanCollection(bean.getAdviceGivenPatient());
		this.advicegiventogp = ims.core.vo.lookups.AdviceToGPCollection.buildFromBeanCollection(bean.getAdviceGivenToGP());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.RACPPlanAdviceVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.primaryplan = bean.getPrimaryPlan() == null ? null : ims.core.vo.lookups.PlanOfAction.buildLookup(bean.getPrimaryPlan());
		this.overallimpression = bean.getOverallImpression() == null ? null : ims.core.vo.lookups.OverallImpression.buildLookup(bean.getOverallImpression());
		this.otherdetails = bean.getOtherDetails();
		this.secondaryplans = ims.core.vo.lookups.PlanOfActionCollection.buildFromBeanCollection(bean.getSecondaryPlans());
		this.advicegivenpatient = ims.core.vo.lookups.AdviceToPatientCollection.buildFromBeanCollection(bean.getAdviceGivenPatient());
		this.advicegiventogp = ims.core.vo.lookups.AdviceToGPCollection.buildFromBeanCollection(bean.getAdviceGivenToGP());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.RACPPlanAdviceVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.RACPPlanAdviceVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.RACPPlanAdviceVoBean();
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
		if(fieldName.equals("PRIMARYPLAN"))
			return getPrimaryPlan();
		if(fieldName.equals("OVERALLIMPRESSION"))
			return getOverallImpression();
		if(fieldName.equals("OTHERDETAILS"))
			return getOtherDetails();
		if(fieldName.equals("SECONDARYPLANS"))
			return getSecondaryPlans();
		if(fieldName.equals("ADVICEGIVENPATIENT"))
			return getAdviceGivenPatient();
		if(fieldName.equals("ADVICEGIVENTOGP"))
			return getAdviceGivenToGP();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPrimaryPlanIsNotNull()
	{
		return this.primaryplan != null;
	}
	public ims.core.vo.lookups.PlanOfAction getPrimaryPlan()
	{
		return this.primaryplan;
	}
	public void setPrimaryPlan(ims.core.vo.lookups.PlanOfAction value)
	{
		this.isValidated = false;
		this.primaryplan = value;
	}
	public boolean getOverallImpressionIsNotNull()
	{
		return this.overallimpression != null;
	}
	public ims.core.vo.lookups.OverallImpression getOverallImpression()
	{
		return this.overallimpression;
	}
	public void setOverallImpression(ims.core.vo.lookups.OverallImpression value)
	{
		this.isValidated = false;
		this.overallimpression = value;
	}
	public boolean getOtherDetailsIsNotNull()
	{
		return this.otherdetails != null;
	}
	public String getOtherDetails()
	{
		return this.otherdetails;
	}
	public static int getOtherDetailsMaxLength()
	{
		return 1500;
	}
	public void setOtherDetails(String value)
	{
		this.isValidated = false;
		this.otherdetails = value;
	}
	public boolean getSecondaryPlansIsNotNull()
	{
		return this.secondaryplans != null;
	}
	public ims.core.vo.lookups.PlanOfActionCollection getSecondaryPlans()
	{
		return this.secondaryplans;
	}
	public void setSecondaryPlans(ims.core.vo.lookups.PlanOfActionCollection value)
	{
		this.isValidated = false;
		this.secondaryplans = value;
	}
	public boolean getAdviceGivenPatientIsNotNull()
	{
		return this.advicegivenpatient != null;
	}
	public ims.core.vo.lookups.AdviceToPatientCollection getAdviceGivenPatient()
	{
		return this.advicegivenpatient;
	}
	public void setAdviceGivenPatient(ims.core.vo.lookups.AdviceToPatientCollection value)
	{
		this.isValidated = false;
		this.advicegivenpatient = value;
	}
	public boolean getAdviceGivenToGPIsNotNull()
	{
		return this.advicegiventogp != null;
	}
	public ims.core.vo.lookups.AdviceToGPCollection getAdviceGivenToGP()
	{
		return this.advicegiventogp;
	}
	public void setAdviceGivenToGP(ims.core.vo.lookups.AdviceToGPCollection value)
	{
		this.isValidated = false;
		this.advicegiventogp = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(this.otherdetails != null)
			if(this.otherdetails.length() > 1500)
				listOfErrors.add("The length of the field [otherdetails] in the value object [ims.clinical.vo.RACPPlanAdviceVo] is too big. It should be less or equal to 1500");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.countFieldsWithValue() < 1)
		{
			listOfErrors.add("A minimum of 1 data fields must be entered");
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
	
		RACPPlanAdviceVo clone = new RACPPlanAdviceVo(this.id, this.version);
		
		if(this.primaryplan == null)
			clone.primaryplan = null;
		else
			clone.primaryplan = (ims.core.vo.lookups.PlanOfAction)this.primaryplan.clone();
		if(this.overallimpression == null)
			clone.overallimpression = null;
		else
			clone.overallimpression = (ims.core.vo.lookups.OverallImpression)this.overallimpression.clone();
		clone.otherdetails = this.otherdetails;
		if(this.secondaryplans == null)
			clone.secondaryplans = null;
		else
			clone.secondaryplans = (ims.core.vo.lookups.PlanOfActionCollection)this.secondaryplans.clone();
		if(this.advicegivenpatient == null)
			clone.advicegivenpatient = null;
		else
			clone.advicegivenpatient = (ims.core.vo.lookups.AdviceToPatientCollection)this.advicegivenpatient.clone();
		if(this.advicegiventogp == null)
			clone.advicegiventogp = null;
		else
			clone.advicegiventogp = (ims.core.vo.lookups.AdviceToGPCollection)this.advicegiventogp.clone();
		clone.carecontext = this.carecontext;
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
		if (!(RACPPlanAdviceVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A RACPPlanAdviceVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((RACPPlanAdviceVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((RACPPlanAdviceVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.primaryplan != null)
			count++;
		if(this.overallimpression != null)
			count++;
		if(this.otherdetails != null)
			count++;
		if(this.secondaryplans != null)
			count++;
		if(this.advicegivenpatient != null)
			count++;
		if(this.advicegiventogp != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected ims.core.vo.lookups.PlanOfAction primaryplan;
	protected ims.core.vo.lookups.OverallImpression overallimpression;
	protected String otherdetails;
	protected ims.core.vo.lookups.PlanOfActionCollection secondaryplans;
	protected ims.core.vo.lookups.AdviceToPatientCollection advicegivenpatient;
	protected ims.core.vo.lookups.AdviceToGPCollection advicegiventogp;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
