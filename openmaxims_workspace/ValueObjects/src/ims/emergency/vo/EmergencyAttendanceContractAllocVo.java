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

package ims.emergency.vo;

/**
 * Linked to core.admin.EmergencyAttendance business object (ID: 1004100025).
 */
public class EmergencyAttendanceContractAllocVo extends ims.core.admin.vo.EmergencyAttendanceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EmergencyAttendanceContractAllocVo()
	{
	}
	public EmergencyAttendanceContractAllocVo(Integer id, int version)
	{
		super(id, version);
	}
	public EmergencyAttendanceContractAllocVo(ims.emergency.vo.beans.EmergencyAttendanceContractAllocVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.iscoded = bean.getIsCoded();
		this.mc = bean.getMC();
		this.cota = bean.getCOTA();
		this.pcg1 = bean.getPCG1();
		this.pcg2 = bean.getPCG2();
		this.har = bean.getHAR();
		this.purchaser = bean.getPurchaser();
		this.sequencenumber = bean.getSequenceNumber();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EmergencyAttendanceContractAllocVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.iscoded = bean.getIsCoded();
		this.mc = bean.getMC();
		this.cota = bean.getCOTA();
		this.pcg1 = bean.getPCG1();
		this.pcg2 = bean.getPCG2();
		this.har = bean.getHAR();
		this.purchaser = bean.getPurchaser();
		this.sequencenumber = bean.getSequenceNumber();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EmergencyAttendanceContractAllocVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EmergencyAttendanceContractAllocVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EmergencyAttendanceContractAllocVoBean();
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
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("ISCODED"))
			return getIsCoded();
		if(fieldName.equals("MC"))
			return getMC();
		if(fieldName.equals("COTA"))
			return getCOTA();
		if(fieldName.equals("PCG1"))
			return getPCG1();
		if(fieldName.equals("PCG2"))
			return getPCG2();
		if(fieldName.equals("HAR"))
			return getHAR();
		if(fieldName.equals("PURCHASER"))
			return getPurchaser();
		if(fieldName.equals("SEQUENCENUMBER"))
			return getSequenceNumber();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getIsCodedIsNotNull()
	{
		return this.iscoded != null;
	}
	public Boolean getIsCoded()
	{
		return this.iscoded;
	}
	public void setIsCoded(Boolean value)
	{
		this.isValidated = false;
		this.iscoded = value;
	}
	public boolean getMCIsNotNull()
	{
		return this.mc != null;
	}
	public String getMC()
	{
		return this.mc;
	}
	public static int getMCMaxLength()
	{
		return 5;
	}
	public void setMC(String value)
	{
		this.isValidated = false;
		this.mc = value;
	}
	public boolean getCOTAIsNotNull()
	{
		return this.cota != null;
	}
	public String getCOTA()
	{
		return this.cota;
	}
	public static int getCOTAMaxLength()
	{
		return 5;
	}
	public void setCOTA(String value)
	{
		this.isValidated = false;
		this.cota = value;
	}
	public boolean getPCG1IsNotNull()
	{
		return this.pcg1 != null;
	}
	public String getPCG1()
	{
		return this.pcg1;
	}
	public static int getPCG1MaxLength()
	{
		return 5;
	}
	public void setPCG1(String value)
	{
		this.isValidated = false;
		this.pcg1 = value;
	}
	public boolean getPCG2IsNotNull()
	{
		return this.pcg2 != null;
	}
	public String getPCG2()
	{
		return this.pcg2;
	}
	public static int getPCG2MaxLength()
	{
		return 5;
	}
	public void setPCG2(String value)
	{
		this.isValidated = false;
		this.pcg2 = value;
	}
	public boolean getHARIsNotNull()
	{
		return this.har != null;
	}
	public String getHAR()
	{
		return this.har;
	}
	public static int getHARMaxLength()
	{
		return 5;
	}
	public void setHAR(String value)
	{
		this.isValidated = false;
		this.har = value;
	}
	public boolean getPurchaserIsNotNull()
	{
		return this.purchaser != null;
	}
	public String getPurchaser()
	{
		return this.purchaser;
	}
	public static int getPurchaserMaxLength()
	{
		return 5;
	}
	public void setPurchaser(String value)
	{
		this.isValidated = false;
		this.purchaser = value;
	}
	public boolean getSequenceNumberIsNotNull()
	{
		return this.sequencenumber != null;
	}
	public String getSequenceNumber()
	{
		return this.sequencenumber;
	}
	public static int getSequenceNumberMaxLength()
	{
		return 6;
	}
	public void setSequenceNumber(String value)
	{
		this.isValidated = false;
		this.sequencenumber = value;
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.mc != null)
			if(this.mc.length() > 5)
				listOfErrors.add("The length of the field [mc] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.cota != null)
			if(this.cota.length() > 5)
				listOfErrors.add("The length of the field [cota] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.pcg1 != null)
			if(this.pcg1.length() > 5)
				listOfErrors.add("The length of the field [pcg1] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.pcg2 != null)
			if(this.pcg2.length() > 5)
				listOfErrors.add("The length of the field [pcg2] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.har != null)
			if(this.har.length() > 5)
				listOfErrors.add("The length of the field [har] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.purchaser != null)
			if(this.purchaser.length() > 5)
				listOfErrors.add("The length of the field [purchaser] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 5");
		if(this.sequencenumber != null)
			if(this.sequencenumber.length() > 6)
				listOfErrors.add("The length of the field [sequencenumber] in the value object [ims.emergency.vo.EmergencyAttendanceContractAllocVo] is too big. It should be less or equal to 6");
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
	
		EmergencyAttendanceContractAllocVo clone = new EmergencyAttendanceContractAllocVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.iscoded = this.iscoded;
		clone.mc = this.mc;
		clone.cota = this.cota;
		clone.pcg1 = this.pcg1;
		clone.pcg2 = this.pcg2;
		clone.har = this.har;
		clone.purchaser = this.purchaser;
		clone.sequencenumber = this.sequencenumber;
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
		if (!(EmergencyAttendanceContractAllocVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EmergencyAttendanceContractAllocVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EmergencyAttendanceContractAllocVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EmergencyAttendanceContractAllocVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.iscoded != null)
			count++;
		if(this.mc != null)
			count++;
		if(this.cota != null)
			count++;
		if(this.pcg1 != null)
			count++;
		if(this.pcg2 != null)
			count++;
		if(this.har != null)
			count++;
		if(this.purchaser != null)
			count++;
		if(this.sequencenumber != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected Boolean iscoded;
	protected String mc;
	protected String cota;
	protected String pcg1;
	protected String pcg2;
	protected String har;
	protected String purchaser;
	protected String sequencenumber;
	private boolean isValidated = false;
	private boolean isBusy = false;
}