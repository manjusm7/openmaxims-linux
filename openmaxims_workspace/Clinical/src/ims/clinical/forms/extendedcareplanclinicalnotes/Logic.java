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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.extendedcareplanclinicalnotes;

import ims.clinical.forms.extendedcareplanclinicalnotes.GenForm.gridCarePlanRow;
import ims.clinical.vo.lookups.ClinicalNoteClassification;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.ClinicalNoteStatusVo;
import ims.core.vo.ClinicalNoteStatusVoCollection;
import ims.core.vo.ClinicalNotesVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MedicVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.lookups.ClinicalNotesStatus;
import ims.core.vo.lookups.ClinicalNotingMode;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.nursing.vo.CarePlanTitle;
import ims.nursing.vo.CarePlanTitleCollection;
import ims.nursing.vo.NursingClinicalNotesVo;
import ims.vo.LookupInstVo;
import ims.vo.LookupMappingVo;
import ims.vo.LookupMappingVoCollection;
import ims.vo.interfaces.IMos;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialise();
		open();
	//	checkForDiscipline();
	}

	private void initialise()
	{
		form.getLocalContext().setCarePlans(domain.listCarePlans(form.getGlobalContext().Core.getCurrentCareContext()));

		form.btnUpdateActions().setVisible(ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"));
		form.btnUpdateActions().setEnabled(areCarePlansSelected());

		form.chkConfirmed().setEnabled(false);
		
		if (form.getGlobalContext().Core.getClinicalNotingModeIsNotNull()
			&& (form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.NEW)
				|| form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.UPDATE) ) )
		{
			if(engine.hasRight(AppRight.CAN_CONFIRM_NURSING_DOCUMENTATION))
				form.chkConfirmed().setEnabled(true);
		}
		form.gridCarePlan().setReadOnly(false);
		form.gridCarePlan().setEnabled(true);

		form.ccAuthoredBy().setIsRequiredPropertyToControls(ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO") ? false : true);
		
		
		form.ccConfirmedBYMOS().setEnabled(form.chkConfirmed().getValue());
		form.dtimConfirmedBY().setEnabled(form.chkConfirmed().getValue());

		form.lblCorrection().setVisible(false);
		form.txtCorrection().setVisible(false);
		form.ccConfirmedBYMOS().isRequired(true);
	}

	private void open()
	{
		if (form.getGlobalContext().Core.getClinicalNotingMode() == null)
		{
			loadCarePlans(false);
			openClinicalNote();
			removeUncheckedCarePlans();
			form.setMode(FormMode.VIEW);
		}
		else if (form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.NEW))
		{
			newClinicalNote();
			loadCarePlans(true);
			form.setMode(FormMode.EDIT);
		}
		else if (form.getGlobalContext().Core.getClinicalNotingMode().equals(ClinicalNotingMode.UPDATE))
		{
			loadCarePlans(false);
			openClinicalNote();
			removeUncheckedCarePlans();
			form.setMode(FormMode.EDIT);
			form.cmbNoteType().setEnabled(false);
			form.gridCarePlan().setReadOnly(true);
		}
	}

	private void removeUncheckedCarePlans()
	{
		boolean removed = true;
		while(removed)
		{
			removed = false;
			GenForm.gridCarePlanRow row;
			for (int i = 0; i < form.gridCarePlan().getRows().size(); i++)
			{
				row = form.gridCarePlan().getRows().get(i);
				if ( ! row.getcolSelect())
				{
					form.gridCarePlan().getRows().remove(i);
					removed = true;
					break;
				}
			}
		}

	}

	private void openClinicalNote()
	{
		//WDEV-14428
		if (form.getGlobalContext().Clinical.getCurrentClinicalNote()==null)
			return;
		
		NursingClinicalNotesVo notes = domain.getClinicalNotes(form.getGlobalContext().Clinical.getCurrentClinicalNote());
		if (notes != null)
		{
			form.cmbNoteType().setValue(notes.getNoteClassification());
			
			if (notes.getAuthoringInfoIsNotNull())
			{
				form.ccAuthoredBy().setValue(notes.getAuthoringInfo());
				form.ccAuthoredBy().setEnabledAuthoringHCP(false);
				form.ccAuthoredBy().setEnabledDateTime(false);
			}
			
			form.ccRecordingUser().setValue(notes.getRecordingUser());
			form.dtimRecordingDateTime().setValue(notes.getRecordingDateTime());
			
			form.chkConfirmed().setValue(false);
			form.ccConfirmedBYMOS().setValue(null);		
			form.dtimConfirmedBY().setValue(null);		
			ClinicalNoteStatusVo voStat = findConfirmedInfo(notes.getStatusHistory());
			if (voStat != null)
			{
				form.chkConfirmed().setValue(true);
				
				form.ccConfirmedBYMOS().setValue(voStat.getMOS());
				form.dtimConfirmedBY().setValue(voStat.getDateTime());		
			}

			form.txtNOte().setValue(notes.getClinicalNote());
			
			form.getLocalContext().setSelectedClinicalNote(notes);
			populateCarePlans();
			
			if (notes.getIsCorrectedIsNotNull()
				&& notes.getIsCorrected())
			{
				form.lblCorrection().setVisible(true);
				form.txtCorrection().setVisible(true);
				form.txtCorrection().setEnabled(false);//form.getMode().equals(FormMode.EDIT));
					
				form.txtCorrection().setValue(notes.getCurrentStatusIsNotNull() ? notes.getCurrentStatus().getCorrectionReason() : "");
			}
			
			if (notes.getCurrentStatusIsNotNull() && notes.getCurrentStatus().getStatusIsNotNull()) //WDEV-14458
			{
				form.txtStatus().setValue(notes.getCurrentStatus().getStatus().toString());
			}
		}
	}

	private void newClinicalNote() 
	{
		form.setMode(FormMode.EDIT);

		clearScreen();
		
		form.getLocalContext().setSelectedClinicalNote(null);
		
		form.ccRecordingUser().setValue((IMos) domain.getMosUser());
		form.dtimRecordingDateTime().setValue(new DateTime());

		AuthoringInformationVo voAuth = new AuthoringInformationVo();
		if (domain.getHcpUser() != null)
			voAuth.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		voAuth.setAuthoringDateTime(new DateTime());
		form.ccAuthoredBy().setValue(voAuth);
		
		if(engine.hasRight(AppRight.CAN_CONFIRM_NURSING_DOCUMENTATION))
			form.chkConfirmed().setEnabled(true);
		else
			form.chkConfirmed().setEnabled(false);

		form.ccConfirmedBYMOS().setEnabled(false);
		form.dtimConfirmedBY().setEnabled(false);

		form.btnUpdateActions().setEnabled(false);
	}

	private void clearScreen()
	{
		form.cmbNoteType().setValue(null);
		form.ccRecordingUser().setValue(null);
		form.dtimRecordingDateTime().setValue(null);
		form.ccAuthoredBy().setValue(null);
		form.chkConfirmed().setValue(null);
		form.ccConfirmedBYMOS().setValue(null);
		form.dtimConfirmedBY().setValue(null);
		
		form.txtNOte().setValue(null);
		form.txtStatus().setValue(null); //WDEV-14458
	}

	private void loadCarePlans(boolean bActiveOnly)
	{
		CarePlanTitleCollection coll = form.getLocalContext().getCarePlans();

		if (coll != null)
		{
			form.gridCarePlan().getRows().clear();
			GenForm.gridCarePlanRow row;
			for (int i = 0; i < coll.size(); i++)
			{
				CarePlanTitle title = coll.get(i);

				if ( bActiveOnly
					&& (title.getCurrentCarePlanStatusIsNotNull() 
							&& title.getCurrentCarePlanStatus().getStatusIsNotNull()
							&& ! title.getCurrentCarePlanStatus().getStatus().equals(ims.nursing.vo.lookups.CarePlanStatus.ACTIVE)) )
					continue;
				
				row = form.gridCarePlan().getRows().newRow();
				row.setcolCarePlan(title.getTitle());
				row.setcolStatus(title.getCurrentCarePlanStatusIsNotNull() && title.getCurrentCarePlanStatus().getStatusIsNotNull() ? title.getCurrentCarePlanStatus().getStatus().getText() : "");
				row.setValue(title);
			}

		}
	}

	private void populateCarePlans()
	{
		if (form.getLocalContext().getSelectedClinicalNoteIsNotNull()
			&& form.getLocalContext().getSelectedClinicalNote().getCarePlans() != null)
		{
			CarePlanTitleCollection dataColl = form.getLocalContext().getSelectedClinicalNote().getCarePlans();
			if (dataColl != null)
			{
				GenForm.gridCarePlanRow row;
				for (int i = 0; i < dataColl.size(); i++)
				{
					CarePlanTitle title = dataColl.get(i);
					row = form.gridCarePlan().getRowByValue(title);
					if (row != null)
						row.setcolSelect(true);
				}
			}
		}
	}

	private MemberOfStaffShortVo getDisciplineForLoggedInUser(ClinicalNotesVo clinicalNotesVo)
	{
		MemberOfStaffVo fullVo = null;
		MemberOfStaffShortVo mos = (MemberOfStaffShortVo)domain.getMosUser();
		if (mos != null)
			fullVo = domain.getMemberOfStaff(mos);

		if (fullVo != null)
		{
			if (fullVo.getHcpIsNotNull() && fullVo.getHcp() instanceof MedicVo)
			{
				MedicVo voMedic = (MedicVo)fullVo.getHcp();
				if (voMedic.getHcpTypeIsNotNull())
					clinicalNotesVo.setDiscipline(voMedic.getHcpType());
				else
				{
					engine.showMessage("Please select a Discipline type for the logged in user.");
					return null;	
				}
			}
			else
			{
				if (form.ccAuthoredBy().getValue()!=null && form.ccAuthoredBy().getValue().getAuthoringHcpIsNotNull()
					&& form.ccAuthoredBy().getValue().getAuthoringHcp().getHcpTypeIsNotNull())
					clinicalNotesVo.setDiscipline(form.ccAuthoredBy().getValue().getAuthoringHcp().getHcpType());
				else
				{
					engine.showMessage("No Discipline is available. Please choose an authoring user.");
					return null;
				}
			}
		}
		else
		{
			engine.showMessage("Member of Staff is Null.");
			return null;
		}
		return mos;
	}
	
	private void checkForDiscipline()
	{
		if (form.getGlobalContext().Clinical.getCurrentClinicalNoteIsNotNull())
		{
			MemberOfStaffShortVo mos = null;
			if (getDisciplineForLoggedInUser(form.getGlobalContext().Clinical.getCurrentClinicalNote()) != null)
				mos = getDisciplineForLoggedInUser(form.getGlobalContext().Clinical.getCurrentClinicalNote());
			else
			{
				engine.showMessage("No Discipline is available. Please choose an authoring user.");
				return;
			}
					
		}
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if ( ! validateFields())
			return;
		
		NursingClinicalNotesVo notes = form.getLocalContext().getSelectedClinicalNote();
		if (notes == null)
		{
			notes = new NursingClinicalNotesVo();
			notes.setAuthoringInfo(form.ccAuthoredBy().getValue());
		}
		if (ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO")
			&& notes.getID_ClinicalNotesIsNotNull())//added to get around the fact that authoring info is mandatory in BO.
			notes.setAuthoringInfo(form.ccAuthoredBy().getValue());//if fields are blank a AuthoringInfo object will be put in here and get around the non-null.
		
		notes.setClinicalNote(form.txtNOte().getValue());

		if (form.getGlobalContext().Core.getPatientShortIsNotNull())
			notes.setWard(form.getGlobalContext().Core.getPatientShort().getWard());
		
		if (notes.getClinicalContact() == null)
			notes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (notes.getCareContext() == null)
			notes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());

		notes.setDiscipline(form.ccAuthoredBy().getValue().getAuthoringHcpIsNotNull() && form.ccAuthoredBy().getValue().getAuthoringHcp().getHcpTypeIsNotNull() ? form.ccAuthoredBy().getValue().getAuthoringHcp().getHcpType() : null);
		
		ClinicalNoteStatusVo voStatus = new ClinicalNoteStatusVo();
		if (notes.getCurrentStatus() == null
			|| (notPreviouslyConfirmed(notes.getStatusHistory()) 
				&& form.chkConfirmed().getValue() ) )
		{
			voStatus.setStatus(ClinicalNotesStatus.DRAFT);
			voStatus.setDateTime(new DateTime());
			voStatus.setMOS((MemberOfStaffShortVo)domain.getMosUser());

			if (form.chkConfirmed().getValue()
				&& form.ccConfirmedBYMOS().getValue() != null
				&& form.dtimConfirmedBY().getValue() != null)
			{
				voStatus.setStatus(ClinicalNotesStatus.CONFIRMED);
				voStatus.setDateTime(form.dtimConfirmedBY().getValue());
				voStatus.setMOS((MemberOfStaffLiteVo)form.ccConfirmedBYMOS().getValue());
			}
			notes.setCurrentStatus(voStatus);
			notes.setStatusHistory(addStatusToCollection(notes.getStatusHistory(), voStatus));
		}

		notes.setNoteClassification(form.cmbNoteType().getValue());

		// Save the Careplans too
		CarePlanTitleCollection cpColl = null;
		GenForm.gridCarePlanRow row;
		cpColl = new CarePlanTitleCollection();
		for (int i = 0; i < form.gridCarePlan().getRows().size(); i++)
		{
			row = form.gridCarePlan().getRows().get(i);
			if (row.getcolSelect())
			{
				cpColl.add(row.getValue());
			}
		}
		
		notes.setCarePlans(cpColl);
		notes.setNoteType(null);//form.cmbNoteType().getValue());	

		if (notes.getClinicalContact() == null)
			notes.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		if (notes.getCareContext() == null)
			notes.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		notes.setIsDerivedNote(Boolean.FALSE);
		
		notes.setRecordingUser((MemberOfStaffLiteVo)form.ccRecordingUser().getValue());
		notes.setRecordingDateTime(form.dtimRecordingDateTime().getValue());

		String[] errors = notes.validate();
		if (errors != null)
		{
			engine.showErrors(errors);
			return;
		}

		try
		{
			domain.saveClinicalNotes(notes);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			if(	Boolean.TRUE.equals(form.chkConfirmed().getValue()))   //wdev-14614
			{
				form.setMode(FormMode.VIEW);
				form.chkConfirmed().setEnabled(false);
				form.txtCorrection().setEnabled(false);
				
			}
			else if (ClinicalNotingMode.UPDATE.equals(form.getGlobalContext().Core.getClinicalNotingMode()) && form.getLocalContext().getSelectedClinicalNoteIsNotNull() && form.getLocalContext().getSelectedClinicalNote().getCurrentStatusIsNotNull() && form.getLocalContext().getSelectedClinicalNote().getCurrentStatus().getStatusIsNotNull()) //wdev-14614
			{
				if (ClinicalNotesStatus.CORRECTED.equals(form.getLocalContext().getSelectedClinicalNote().getCurrentStatus().getStatus()))
				{
				form.setMode(FormMode.VIEW);
				form.chkConfirmed().setEnabled(false);
				form.txtCorrection().setEnabled(false);
				}
				else
				{
					onChkConfirmedValueChanged(); //WDEV-15239
				}
			}
			
			return;
		}
		
		form.setMode(FormMode.VIEW);

		engine.close(DialogResult.OK);
	}

	private boolean validateFields()
	{
		ArrayList<String> uiErrors = new ArrayList<String>();
		
		if (form.cmbNoteType().getValue() == null)
			uiErrors.add("Note Type is required.");
		
		if (form.ccRecordingUser().getValue() == null)
			uiErrors.add("Recording User is required.");
		
		if (form.dtimRecordingDateTime().getValue() == null)
			uiErrors.add("Recording Date/Time is required.");
		
		if ( !ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO"))
		{
			if (form.ccAuthoredBy().getValue() == null)
				uiErrors.add("Authoring Information is required.");
		}
		
		if (form.txtNOte().getValue() == null)
			uiErrors.add("Clinical Note is required.");
		
		if (form.chkConfirmed().getValue()
			&& (form.ccConfirmedBYMOS().getValue() == null
				|| form.dtimConfirmedBY().getValue() == null) )
			uiErrors.add("Confirmed Information is required.");

		if (uiErrors.size() > 0)
		{
			engine.showErrors(uiErrors.toArray(new String[uiErrors.size()]));
			return false;
		}
		
		return true;
	}

	private boolean notPreviouslyConfirmed(ClinicalNoteStatusVoCollection clinicalNoteStatusVoCollection)
	{
		for (int i = 0 ; clinicalNoteStatusVoCollection != null && i < clinicalNoteStatusVoCollection.size() ; i++)
		{
			if (clinicalNoteStatusVoCollection.get(i).getStatusIsNotNull()
				&& clinicalNoteStatusVoCollection.get(i).getStatus().equals(ClinicalNotesStatus.CONFIRMED))
				return false;
		}
		
		return true;
	}

	private ClinicalNoteStatusVo findConfirmedInfo(ClinicalNoteStatusVoCollection clinicalNoteStatusVoCollection)
	{
		for (int i = 0 ; clinicalNoteStatusVoCollection != null && i < clinicalNoteStatusVoCollection.size() ; i++)
		{
			if (clinicalNoteStatusVoCollection.get(i).getStatusIsNotNull()
				&& clinicalNoteStatusVoCollection.get(i).getStatus().equals(ClinicalNotesStatus.CONFIRMED))
				return clinicalNoteStatusVoCollection.get(i);
		}
		
		return null;
	}

	private ClinicalNoteStatusVoCollection addStatusToCollection(ClinicalNoteStatusVoCollection statusHistory, ClinicalNoteStatusVo voStat) 
	{
		ClinicalNoteStatusVoCollection voColl = statusHistory;
		if (voColl == null)
			voColl = new ClinicalNoteStatusVoCollection();
		voColl.add(voStat);
		
		return voColl;
	}

	@Override
	protected void onBtnUpdateActionsClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (areCarePlansSelected())
			engine.open(form.getForms().Nursing.ClinicalNotesUpdateActionsDialog,new Object[]{listCarePlans()});
	}

	@Override
	protected void onChkConfirmedValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.ccConfirmedBYMOS().setEnabled(form.chkConfirmed().getValue());
		form.dtimConfirmedBY().setEnabled(form.chkConfirmed().getValue());
		
		if (form.chkConfirmed().getValue())
		{
			form.ccConfirmedBYMOS().setValue((MemberOfStaffShortVo)domain.getMosUser());
			form.dtimConfirmedBY().setValue(new DateTime());
		}
		else
		{
			form.ccConfirmedBYMOS().setValue(null);
			form.dtimConfirmedBY().setValue(null);
		}
	}
	
	private CarePlanTitleCollection listCarePlans() 
	{
		CarePlanTitleCollection voColl = new CarePlanTitleCollection();
		
		for (int i = 0 ; i < form.gridCarePlan().getRows().size() ; i++)
		{
			if (form.gridCarePlan().getRows().get(i).getcolSelect())
				voColl.add(form.gridCarePlan().getRows().get(i).getValue());
		}
		return voColl;
	}

	private boolean areCarePlansSelected() 
	{
		boolean bSelected = false;
		
		for (int i = 0 ; i < form.gridCarePlan().getRows().size() ; i++)
		{
			if (form.gridCarePlan().getRows().get(i).getcolSelect())
				bSelected = true;
		}
		return bSelected;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.VIEW);

		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onGridCarePlanSelectionChanged() throws PresentationLogicException
	{
		//enableUpdateActionsButton();//WDEV-14555
	}

	@Override
	protected void onGridCarePlanGridCheckBoxClicked(int column, gridCarePlanRow row, boolean isChecked) throws PresentationLogicException
	{
		enableUpdateActionsButton();
	}

	@Override
	protected void onCmbNoteTypeValueChanged() throws PresentationLogicException
	{
		enableUpdateActionsButton();
	}

	private void enableUpdateActionsButton()
	{
		if (ConfigFlag.GEN.CARE_PLAN_FUNCTIONALITY_TYPE.getValue().toString().equals("CCO")
			&& ! form.getGlobalContext().Clinical.getReturnToFormMode().equals(FormMode.VIEW) )
		{
			form.btnUpdateActions().setVisible(true);
			form.btnUpdateActions().setEnabled(areCarePlansSelected() && form.cmbNoteType().getValue() != null && isCarePlanMapping(form.cmbNoteType().getValue()));
		}
	}

	private boolean isCarePlanMapping(ClinicalNoteClassification value)
	{
		LookupInstVo instMap = domain.getMappings(value);
		LookupMappingVoCollection mapColl = instMap.getMappings();
		for (int j = 0; j < mapColl.size(); j++)
		{
			LookupMappingVo valueObject = mapColl.get(j);
		
			if(valueObject.getExtCode()!=null && valueObject.getExtCode().equals("CAREPLANNOTE"))
				return true;
		}
		return false;
	}
}
