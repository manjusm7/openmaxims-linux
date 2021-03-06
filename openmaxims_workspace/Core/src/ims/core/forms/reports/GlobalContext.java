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

package ims.core.forms.reports;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getAutoOpenViewReportIsNotNull()
		{
			return !cx_CoreAutoOpenViewReport.getValueIsNull(context);
		}
		public Boolean getAutoOpenViewReport()
		{
			return (Boolean)cx_CoreAutoOpenViewReport.getValue(context);
		}
		public void setAutoOpenViewReport(Boolean value)
		{
			cx_CoreAutoOpenViewReport.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreAutoOpenViewReport = new ims.framework.ContextVariable("Core.AutoOpenViewReport", "_cv_Core.AutoOpenViewReport");
		public boolean getReportIDIsNotNull()
		{
			return !cx_CoreReportID.getValueIsNull(context);
		}
		public Integer getReportID()
		{
			return (Integer)cx_CoreReportID.getValue(context);
		}
		public void setReportID(Integer value)
		{
			cx_CoreReportID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreReportID = new ims.framework.ContextVariable("Core.ReportID", "_cv_Core.ReportID");
		public boolean getTemplateIDIsNotNull()
		{
			return !cx_CoreTemplateID.getValueIsNull(context);
		}
		public Integer getTemplateID()
		{
			return (Integer)cx_CoreTemplateID.getValue(context);
		}
		public void setTemplateID(Integer value)
		{
			cx_CoreTemplateID.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreTemplateID = new ims.framework.ContextVariable("Core.TemplateID", "_cv_Core.TemplateID");
		public boolean getCurrentFormNameIsNotNull()
		{
			return !cx_CoreCurrentFormName.getValueIsNull(context);
		}
		public ims.framework.FormName getCurrentFormName()
		{
			return (ims.framework.FormName)cx_CoreCurrentFormName.getValue(context);
		}
		public void setCurrentFormName(ims.framework.FormName value)
		{
			cx_CoreCurrentFormName.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentFormName = new ims.framework.ContextVariable("Core.CurrentFormName", "_cv_Core.CurrentFormName");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
