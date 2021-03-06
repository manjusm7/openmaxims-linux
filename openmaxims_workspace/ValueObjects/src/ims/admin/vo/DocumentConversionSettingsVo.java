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

package ims.admin.vo;

/**
 * Linked to core.configuration.DocumentConversionSettings business object (ID: 1028100062).
 */
public class DocumentConversionSettingsVo extends ims.core.configuration.vo.DocumentConversionSettingsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public DocumentConversionSettingsVo()
	{
	}
	public DocumentConversionSettingsVo(Integer id, int version)
	{
		super(id, version);
	}
	public DocumentConversionSettingsVo(ims.admin.vo.beans.DocumentConversionSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuredjob = bean.getConfiguredJob() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJob().getId()), bean.getConfiguredJob().getVersion());
		this.server = bean.getServer();
		this.serverport = bean.getServerPort();
		this.databasename = bean.getDatabaseName();
		this.databaseusername = bean.getDatabaseUsername();
		this.databasepassword = bean.getDatabasePassword();
		this.filespath = bean.getFilesPath();
		this.allrecords = bean.getAllRecords();
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDateTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.DocumentConversionSettingsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.configuredjob = bean.getConfiguredJob() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJob().getId()), bean.getConfiguredJob().getVersion());
		this.server = bean.getServer();
		this.serverport = bean.getServerPort();
		this.databasename = bean.getDatabaseName();
		this.databaseusername = bean.getDatabaseUsername();
		this.databasepassword = bean.getDatabasePassword();
		this.filespath = bean.getFilesPath();
		this.allrecords = bean.getAllRecords();
		this.fromdate = bean.getFromDate() == null ? null : bean.getFromDate().buildDateTime();
		this.todate = bean.getToDate() == null ? null : bean.getToDate().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.DocumentConversionSettingsVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.DocumentConversionSettingsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.DocumentConversionSettingsVoBean();
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
		if(fieldName.equals("CONFIGUREDJOB"))
			return getConfiguredJob();
		if(fieldName.equals("SERVER"))
			return getServer();
		if(fieldName.equals("SERVERPORT"))
			return getServerPort();
		if(fieldName.equals("DATABASENAME"))
			return getDatabaseName();
		if(fieldName.equals("DATABASEUSERNAME"))
			return getDatabaseUsername();
		if(fieldName.equals("DATABASEPASSWORD"))
			return getDatabasePassword();
		if(fieldName.equals("FILESPATH"))
			return getFilesPath();
		if(fieldName.equals("ALLRECORDS"))
			return getAllRecords();
		if(fieldName.equals("FROMDATE"))
			return getFromDate();
		if(fieldName.equals("TODATE"))
			return getToDate();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getConfiguredJobIsNotNull()
	{
		return this.configuredjob != null;
	}
	public ims.core.configuration.vo.ConfiguredJobRefVo getConfiguredJob()
	{
		return this.configuredjob;
	}
	public void setConfiguredJob(ims.core.configuration.vo.ConfiguredJobRefVo value)
	{
		this.isValidated = false;
		this.configuredjob = value;
	}
	public boolean getServerIsNotNull()
	{
		return this.server != null;
	}
	public String getServer()
	{
		return this.server;
	}
	public static int getServerMaxLength()
	{
		return 255;
	}
	public void setServer(String value)
	{
		this.isValidated = false;
		this.server = value;
	}
	public boolean getServerPortIsNotNull()
	{
		return this.serverport != null;
	}
	public Integer getServerPort()
	{
		return this.serverport;
	}
	public void setServerPort(Integer value)
	{
		this.isValidated = false;
		this.serverport = value;
	}
	public boolean getDatabaseNameIsNotNull()
	{
		return this.databasename != null;
	}
	public String getDatabaseName()
	{
		return this.databasename;
	}
	public static int getDatabaseNameMaxLength()
	{
		return 255;
	}
	public void setDatabaseName(String value)
	{
		this.isValidated = false;
		this.databasename = value;
	}
	public boolean getDatabaseUsernameIsNotNull()
	{
		return this.databaseusername != null;
	}
	public String getDatabaseUsername()
	{
		return this.databaseusername;
	}
	public static int getDatabaseUsernameMaxLength()
	{
		return 255;
	}
	public void setDatabaseUsername(String value)
	{
		this.isValidated = false;
		this.databaseusername = value;
	}
	public boolean getDatabasePasswordIsNotNull()
	{
		return this.databasepassword != null;
	}
	public String getDatabasePassword()
	{
		return this.databasepassword;
	}
	public static int getDatabasePasswordMaxLength()
	{
		return 255;
	}
	public void setDatabasePassword(String value)
	{
		this.isValidated = false;
		this.databasepassword = value;
	}
	public boolean getFilesPathIsNotNull()
	{
		return this.filespath != null;
	}
	public String getFilesPath()
	{
		return this.filespath;
	}
	public static int getFilesPathMaxLength()
	{
		return 255;
	}
	public void setFilesPath(String value)
	{
		this.isValidated = false;
		this.filespath = value;
	}
	public boolean getAllRecordsIsNotNull()
	{
		return this.allrecords != null;
	}
	public Boolean getAllRecords()
	{
		return this.allrecords;
	}
	public void setAllRecords(Boolean value)
	{
		this.isValidated = false;
		this.allrecords = value;
	}
	public boolean getFromDateIsNotNull()
	{
		return this.fromdate != null;
	}
	public ims.framework.utils.DateTime getFromDate()
	{
		return this.fromdate;
	}
	public void setFromDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.fromdate = value;
	}
	public boolean getToDateIsNotNull()
	{
		return this.todate != null;
	}
	public ims.framework.utils.DateTime getToDate()
	{
		return this.todate;
	}
	public void setToDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.todate = value;
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
		if(this.configuredjob == null)
			listOfErrors.add("ConfiguredJob is mandatory");
		if(this.server == null || this.server.length() == 0)
			listOfErrors.add("Server is mandatory");
		else if(this.server.length() > 255)
			listOfErrors.add("The length of the field [server] in the value object [ims.admin.vo.DocumentConversionSettingsVo] is too big. It should be less or equal to 255");
		if(this.serverport == null)
			listOfErrors.add("ServerPort is mandatory");
		if(this.databasename == null || this.databasename.length() == 0)
			listOfErrors.add("DatabaseName is mandatory");
		else if(this.databasename.length() > 255)
			listOfErrors.add("The length of the field [databasename] in the value object [ims.admin.vo.DocumentConversionSettingsVo] is too big. It should be less or equal to 255");
		if(this.databaseusername == null || this.databaseusername.length() == 0)
			listOfErrors.add("DatabaseUsername is mandatory");
		else if(this.databaseusername.length() > 255)
			listOfErrors.add("The length of the field [databaseusername] in the value object [ims.admin.vo.DocumentConversionSettingsVo] is too big. It should be less or equal to 255");
		if(this.databasepassword == null || this.databasepassword.length() == 0)
			listOfErrors.add("DatabasePassword is mandatory");
		else if(this.databasepassword.length() > 255)
			listOfErrors.add("The length of the field [databasepassword] in the value object [ims.admin.vo.DocumentConversionSettingsVo] is too big. It should be less or equal to 255");
		if(this.filespath == null || this.filespath.length() == 0)
			listOfErrors.add("FilesPath is mandatory");
		else if(this.filespath.length() > 255)
			listOfErrors.add("The length of the field [filespath] in the value object [ims.admin.vo.DocumentConversionSettingsVo] is too big. It should be less or equal to 255");
		if(this.allrecords == null)
			listOfErrors.add("AllRecords is mandatory");
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
	
		DocumentConversionSettingsVo clone = new DocumentConversionSettingsVo(this.id, this.version);
		
		clone.configuredjob = this.configuredjob;
		clone.server = this.server;
		clone.serverport = this.serverport;
		clone.databasename = this.databasename;
		clone.databaseusername = this.databaseusername;
		clone.databasepassword = this.databasepassword;
		clone.filespath = this.filespath;
		clone.allrecords = this.allrecords;
		if(this.fromdate == null)
			clone.fromdate = null;
		else
			clone.fromdate = (ims.framework.utils.DateTime)this.fromdate.clone();
		if(this.todate == null)
			clone.todate = null;
		else
			clone.todate = (ims.framework.utils.DateTime)this.todate.clone();
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
		if (!(DocumentConversionSettingsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A DocumentConversionSettingsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((DocumentConversionSettingsVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((DocumentConversionSettingsVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.configuredjob != null)
			count++;
		if(this.server != null)
			count++;
		if(this.serverport != null)
			count++;
		if(this.databasename != null)
			count++;
		if(this.databaseusername != null)
			count++;
		if(this.databasepassword != null)
			count++;
		if(this.filespath != null)
			count++;
		if(this.allrecords != null)
			count++;
		if(this.fromdate != null)
			count++;
		if(this.todate != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.configuration.vo.ConfiguredJobRefVo configuredjob;
	protected String server;
	protected Integer serverport;
	protected String databasename;
	protected String databaseusername;
	protected String databasepassword;
	protected String filespath;
	protected Boolean allrecords;
	protected ims.framework.utils.DateTime fromdate;
	protected ims.framework.utils.DateTime todate;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
