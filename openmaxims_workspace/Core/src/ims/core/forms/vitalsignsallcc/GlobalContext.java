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

package ims.core.forms.vitalsignsallcc;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Assessment = new AssessmentContext(context);
		Core = new CoreContext(context);
		Clinical = new ClinicalContext(context);
	}
	public final class AssessmentContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private AssessmentContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getForceCompletionIsNotNull()
		{
			return !cx_AssessmentForceCompletion.getValueIsNull(context);
		}
		public Boolean getForceCompletion()
		{
			return (Boolean)cx_AssessmentForceCompletion.getValue(context);
		}
		public void setForceCompletion(Boolean value)
		{
			cx_AssessmentForceCompletion.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentForceCompletion = new ims.framework.ContextVariable("Assessment.ForceCompletion", "_cv_Assessment.ForceCompletion");
		public boolean getIsDynamicAssessmentOpenedForPreviewIsNotNull()
		{
			return !cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValueIsNull(context);
		}
		public Boolean getIsDynamicAssessmentOpenedForPreview()
		{
			return (Boolean)cx_AssessmentIsDynamicAssessmentOpenedForPreview.getValue(context);
		}
		public void setIsDynamicAssessmentOpenedForPreview(Boolean value)
		{
			cx_AssessmentIsDynamicAssessmentOpenedForPreview.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentIsDynamicAssessmentOpenedForPreview = new ims.framework.ContextVariable("Assessment.IsDynamicAssessmentOpenedForPreview", "_cv_Assessment.IsDynamicAssessmentOpenedForPreview");
		public boolean getPatientAssessmentIsNotNull()
		{
			return !cx_AssessmentPatientAssessment.getValueIsNull(context);
		}
		public ims.assessment.instantiation.vo.PatientAssessmentRefVo getPatientAssessment()
		{
			return (ims.assessment.instantiation.vo.PatientAssessmentRefVo)cx_AssessmentPatientAssessment.getValue(context);
		}
		public void setPatientAssessment(ims.assessment.instantiation.vo.PatientAssessmentRefVo value)
		{
			cx_AssessmentPatientAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_AssessmentPatientAssessment = new ims.framework.ContextVariable("Assessment.PatientAssessment", "_cv_Assessment.PatientAssessment");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getPatient_AssessmentFullIsNotNull()
		{
			return !cx_CorePatient_AssessmentFull.getValueIsNull(context);
		}
		public ims.assessment.vo.Patient_AssessmentVo getPatient_AssessmentFull()
		{
			return (ims.assessment.vo.Patient_AssessmentVo)cx_CorePatient_AssessmentFull.getValue(context);
		}
		public void setPatient_AssessmentFull(ims.assessment.vo.Patient_AssessmentVo value)
		{
			cx_CorePatient_AssessmentFull.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatient_AssessmentFull = new ims.framework.ContextVariable("Core.Patient_AssessmentFull", "_cv_Core.Patient_AssessmentFull");
		public boolean getPatientAssessmentIsNotNull()
		{
			return !cx_CorePatientAssessment.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientAssessmentListVo getPatientAssessment()
		{
			return (ims.assessment.vo.PatientAssessmentListVo)cx_CorePatientAssessment.getValue(context);
		}
		public void setPatientAssessment(ims.assessment.vo.PatientAssessmentListVo value)
		{
			cx_CorePatientAssessment.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientAssessment = new ims.framework.ContextVariable("Core.PatientAssessment", "_cv_Core.PatientAssessment");
		public boolean getPatientAssessmentFullIsNotNull()
		{
			return !cx_CorePatientAssessmentFull.getValueIsNull(context);
		}
		public ims.assessment.vo.PatientAssessmentVo getPatientAssessmentFull()
		{
			return (ims.assessment.vo.PatientAssessmentVo)cx_CorePatientAssessmentFull.getValue(context);
		}
		public void setPatientAssessmentFull(ims.assessment.vo.PatientAssessmentVo value)
		{
			cx_CorePatientAssessmentFull.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientAssessmentFull = new ims.framework.ContextVariable("Core.PatientAssessmentFull", "_cv_Core.PatientAssessmentFull");
		public boolean getVitalSignIsNotNull()
		{
			return !cx_CoreVitalSign.getValueIsNull(context);
		}
		public ims.core.vo.VitalSignsVo getVitalSign()
		{
			return (ims.core.vo.VitalSignsVo)cx_CoreVitalSign.getValue(context);
		}
		public void setVitalSign(ims.core.vo.VitalSignsVo value)
		{
			cx_CoreVitalSign.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSign = new ims.framework.ContextVariable("Core.VitalSign", "_cv_Core.VitalSign");
		public boolean getVitalSignsEscalationScoreIsNotNull()
		{
			return !cx_CoreVitalSignsEscalationScore.getValueIsNull(context);
		}
		public String getVitalSignsEscalationScore()
		{
			return (String)cx_CoreVitalSignsEscalationScore.getValue(context);
		}
		public void setVitalSignsEscalationScore(String value)
		{
			cx_CoreVitalSignsEscalationScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSignsEscalationScore = new ims.framework.ContextVariable("Core.VitalSignsEscalationScore", "_cv_Core.VitalSignsEscalationScore");
		public boolean getVitalSignsEscalationTextIsNotNull()
		{
			return !cx_CoreVitalSignsEscalationText.getValueIsNull(context);
		}
		public String getVitalSignsEscalationText()
		{
			return (String)cx_CoreVitalSignsEscalationText.getValue(context);
		}
		public void setVitalSignsEscalationText(String value)
		{
			cx_CoreVitalSignsEscalationText.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSignsEscalationText = new ims.framework.ContextVariable("Core.VitalSignsEscalationText", "_cv_Core.VitalSignsEscalationText");
		public boolean getVitalSignsEWSScoreIsNotNull()
		{
			return !cx_CoreVitalSignsEWSScore.getValueIsNull(context);
		}
		public String getVitalSignsEWSScore()
		{
			return (String)cx_CoreVitalSignsEWSScore.getValue(context);
		}
		public void setVitalSignsEWSScore(String value)
		{
			cx_CoreVitalSignsEWSScore.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreVitalSignsEWSScore = new ims.framework.ContextVariable("Core.VitalSignsEWSScore", "_cv_Core.VitalSignsEWSScore");
		public boolean getCurrentCareContextIsNotNull()
		{
			return !cx_CoreCurrentCareContext.getValueIsNull(context);
		}
		public ims.core.vo.CareContextShortVo getCurrentCareContext()
		{
			return (ims.core.vo.CareContextShortVo)cx_CoreCurrentCareContext.getValue(context);
		}
		public void setCurrentCareContext(ims.core.vo.CareContextShortVo value)
		{
			cx_CoreCurrentCareContext.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentCareContext = new ims.framework.ContextVariable("Core.CurrentCareContext", "_cvp_Core.CurrentCareContext");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCurrentClinicalContactIsNotNull()
		{
			return !cx_CoreCurrentClinicalContact.getValueIsNull(context);
		}
		public ims.core.vo.ClinicalContactShortVo getCurrentClinicalContact()
		{
			return (ims.core.vo.ClinicalContactShortVo)cx_CoreCurrentClinicalContact.getValue(context);
		}
		public void setCurrentClinicalContact(ims.core.vo.ClinicalContactShortVo value)
		{
			cx_CoreCurrentClinicalContact.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCurrentClinicalContact = new ims.framework.ContextVariable("Core.CurrentClinicalContact", "_cvp_Core.CurrentClinicalContact");

		private ims.framework.Context context;
	}
	public final class ClinicalContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getSelectedDrugToxicologyItemIsNotNull()
		{
			return !cx_ClinicalSelectedDrugToxicologyItem.getValueIsNull(context);
		}
		public ims.emergency.vo.DrugToxicologyItemVo getSelectedDrugToxicologyItem()
		{
			return (ims.emergency.vo.DrugToxicologyItemVo)cx_ClinicalSelectedDrugToxicologyItem.getValue(context);
		}
		public void setSelectedDrugToxicologyItem(ims.emergency.vo.DrugToxicologyItemVo value)
		{
			cx_ClinicalSelectedDrugToxicologyItem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedDrugToxicologyItem = new ims.framework.ContextVariable("Clinical.SelectedDrugToxicologyItem", "_cv_Clinical.SelectedDrugToxicologyItem");
		public boolean getSelectedHCGTestItemIsNotNull()
		{
			return !cx_ClinicalSelectedHCGTestItem.getValueIsNull(context);
		}
		public ims.emergency.vo.HCGTestItemVo getSelectedHCGTestItem()
		{
			return (ims.emergency.vo.HCGTestItemVo)cx_ClinicalSelectedHCGTestItem.getValue(context);
		}
		public void setSelectedHCGTestItem(ims.emergency.vo.HCGTestItemVo value)
		{
			cx_ClinicalSelectedHCGTestItem.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalSelectedHCGTestItem = new ims.framework.ContextVariable("Clinical.SelectedHCGTestItem", "_cv_Clinical.SelectedHCGTestItem");

		private ims.framework.Context context;
	}

	public AssessmentContext Assessment;
	public CoreContext Core;
	public ClinicalContext Clinical;
}
