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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.referraltospecialty;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.enums.MosType;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.referraltospecialty.GenForm.grdCommentsRow;
import ims.emergency.vo.ReferralToSpecialtyCommentsVo;
import ims.emergency.vo.ReferralToSpecialtyCommentsVoCollection;
import ims.emergency.vo.ReferralToSpecialtyTeamVo;
import ims.emergency.vo.ReferralToSpecialtyTeamVoCollection;
import ims.emergency.vo.TrackingAttendanceStatusVo;
import ims.emergency.vo.TrackingForReferalToSpecialtyVo;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void updateControlsState()
	{
		if (form.getMode().equals(FormMode.VIEW))
		{
			form.dtimCompletion().setEnabled(false);
			form.dtimSeen().setEnabled(false);
			form.btnNew().setVisible(true);

			if (form.recbrReferralsForAttendance().getValue() == null)
			{
				form.btnEdit().setVisible(false);
			}
			else
			{
				form.btnEdit().setVisible(true);
				if (domain.isNewEnabled(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext()))
				{
					form.btnNew().setEnabled(true);
				}
				else
				{
					form.btnNew().setEnabled(false);
				}
			}
		}
		else
		{
			form.ccRefferedBy().isRequired(true);
			form.getContextMenus().Emergency.getReferralToSpecTeamAddItem().setEnabled(true);
			form.getContextMenus().Emergency.getReferralToSpecTeamAddItem().setVisible(true);

			if (form.getLocalContext().getSelectedCommentIsNotNull())
			{

				form.imbEdit().setEnabled(true);
				form.getContextMenus().Emergency.getReferralToSpecTeamEditItem().setEnabled(true);
				form.getContextMenus().Emergency.getReferralToSpecTeamEditItem().setVisible(true);
			}
			else
			{
				form.imbEdit().setEnabled(false);
				form.getContextMenus().Emergency.getReferralToSpecTeamEditItem().setEnabled(false);
				form.getContextMenus().Emergency.getReferralToSpecTeamEditItem().setVisible(false);
			}
		}
	}

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		open();
		//wdev-16015
		if(form.getLocalContext().getSelectedReferralToSpecialty() == null || form.getLocalContext().getSelectedReferralToSpecialty().getCompletionDateTimeIsNotNull() )
		{
			clearControls();
			newInstance();
			form.getLocalContext().setSelectedReferralToSpecialty(null);
			form.setMode(FormMode.EDIT);
		}
		//-------------
	}

	private void open()
	{
		initializeControls();
		PopulateRecordBrowser();
		getSelectedInstance();
		form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(form.getGlobalContext().Emergency.getTracking().getID_Tracking()));
		form.setMode(FormMode.VIEW);
		// form.grdComments().setValue(null);
	}

	private void getSelectedInstance()
	{
		if (!form.getLocalContext().getSelectedReferralToSpecialtyIsNotNull())
		{
			return;
		}

		ReferralToSpecialtyTeamVo voReferralToSpecialty = domain.getReferralToSpecialty(form.getLocalContext().getSelectedReferralToSpecialty().getID_ReferralToSpecTeam());

		if (voReferralToSpecialty == null)
		{
			return;
		}

		form.getLocalContext().setSelectedReferralToSpecialty(voReferralToSpecialty);
		clearControls();
		populateInstanceControls(voReferralToSpecialty);
		updateControlsState();

	}

	private void populateInstanceControls(ReferralToSpecialtyTeamVo voReferralToSpecialty)
	{

		form.ccRefferedBy().setValue(voReferralToSpecialty.getReferredBy());
		form.dtimReffered().setValue(voReferralToSpecialty.getReferredDateTime());
		form.cmbConsultantTeam().setValue(voReferralToSpecialty.getTeamConsultant());
		form.cmbSpecialty().setValue(voReferralToSpecialty.getSpecialty());
		form.dtimSeen().setValue(voReferralToSpecialty.getSeenDateTime());
		form.dtimCompletion().setValue(voReferralToSpecialty.getCompletionDateTime());

		//populateCommentGrid(voReferralToSpecialty.getComments());

	}

	private void populateCommentGrid(ReferralToSpecialtyCommentsVoCollection comments)
	{
		if (comments == null)
			return;

		for (int i = 0; i < comments.size(); i++)
		{
			addCommentToReferral(comments.get(i));
		}
	}

	private void PopulateRecordBrowser()
	{

		ReferralToSpecialtyTeamVoCollection allReferralsToSpec = domain.getAllReferralsToSpec(form.getGlobalContext().Core.getCurrentCareContext().getID_CareContext());

		form.recbrReferralsForAttendance().clear();

		if (allReferralsToSpec == null || allReferralsToSpec.size() == 0)
		{
			return;
		}

		for (int i = 0; i < allReferralsToSpec.size(); i++)
		{
			ReferralToSpecialtyTeamVo ReferralToSpec = allReferralsToSpec.get(i);

			if (ReferralToSpec == null)
				return;

			StringBuffer text = new StringBuffer();

			if (ReferralToSpec.getReferredDateTimeIsNotNull())
			{
				text.append("Date Time Referred: " + ReferralToSpec.getReferredDateTime().toString());
			}

			if (ReferralToSpec.getTeamConsultantIsNotNull())
			{
				text.append(" - ");
				text.append(ReferralToSpec.getTeamConsultant().toString());
			}

			if (ReferralToSpec.getSpecialtyIsNotNull())
			{
				text.append(" - ");
				text.append(ReferralToSpec.getSpecialty());
			}

			if (ReferralToSpec.getCompletionDateTimeIsNotNull())
			{
				text.append(" - ");
				text.append("Completed Date Time: " + ReferralToSpec.getCompletionDateTime());
			}

			form.recbrReferralsForAttendance().newRow(i, ReferralToSpec, text.toString());
		}

		if (!form.getLocalContext().getSelectedReferralToSpecialtyIsNotNull())
		{
			form.recbrReferralsForAttendance().setValue(allReferralsToSpec.get(0));
			form.getLocalContext().setSelectedReferralToSpecialty(allReferralsToSpec.get(0));
		}
		else
		{
			form.recbrReferralsForAttendance().setValue(form.getLocalContext().getSelectedReferralToSpecialty());
		}
	}

	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if (formName.equals(form.getForms().Emergency.ReferralToSpecialtyCommentsDialog) && result.equals(DialogResult.OK))
		{
			if (form.getLocalContext().getSelectedCommentIsNotNull() && (form.grdComments().getSelectedRow().getValue().getVersion_ReferralToSpecTeamComments() == form.getGlobalContext().Emergency.getReferralToSpecialtyComments().getVersion_ReferralToSpecTeamComments()))
			{
				updateCommentToReferral(form.getGlobalContext().Emergency.getReferralToSpecialtyComments());
				form.getLocalContext().setSelectedComment(form.getGlobalContext().Emergency.getReferralToSpecialtyComments());
			}
			else
			{
				form.getLocalContext().setSelectedComment(form.getGlobalContext().Emergency.getReferralToSpecialtyComments());
				addCommentToReferral(form.getLocalContext().getSelectedComment());
			}

			form.grdComments().setValue(form.getLocalContext().getSelectedComment());
			updateControlsState();
		}
	}

	private void updateCommentToReferral(ReferralToSpecialtyCommentsVo referralComment)
	{
		grdCommentsRow updateRow = form.grdComments().getSelectedRow();
		updateRow.setcolAuthoringHCP(referralComment.getAuthoringInformation().getAuthoringHcp().toString());
		updateRow.setcolDate(referralComment.getAuthoringInformation().getAuthoringDateTime().toString());
		updateRow.setcolComments(referralComment.getComments());
		updateRow.setValue(referralComment);
	}

	private void addCommentToReferral(ReferralToSpecialtyCommentsVo referralComment)
	{

		grdCommentsRow newrow = form.grdComments().getRows().newRow();

		newrow.setcolAuthoringHCP(referralComment.getAuthoringInformation().getAuthoringHcp().toString());
		newrow.setcolDate(referralComment.getAuthoringInformation().getAuthoringDateTime().toString());
		newrow.setcolComments(referralComment.getComments());
		newrow.setValue(referralComment);
	}

	@Override
	protected void onImbEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Emergency.setReferralToSpecialtyComments(form.getLocalContext().getSelectedComment());
		engine.open(form.getForms().Emergency.ReferralToSpecialtyCommentsDialog);
	}

	@Override
	protected void onImbAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Emergency.setReferralToSpecialtyComments(null);
		form.getLocalContext().setSelectedComment(null);
		engine.open(form.getForms().Emergency.ReferralToSpecialtyCommentsDialog);
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();	//wdev-15984
		open();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			//open();
			engine.close(DialogResult.CANCEL);		//wdev-16015
		}
	}

	private boolean save()
	{
		ReferralToSpecialtyTeamVo referralToSave = populateDataFromScreen(form.getLocalContext().getSelectedReferralToSpecialty());

		String[] errors = referralToSave.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		if (!validateUIRules())
			return false;

		// Check SOE
		if (referralToSave.getID_ReferralToSpecTeamIsNotNull() && domain.isStale(referralToSave))
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			if (form.getLocalContext().getSelectedReferralToSpecialtyIsNotNull())
			{
				form.getLocalContext().setSelectedReferralToSpecialty(domain.getReferralToSpecialty(form.getLocalContext().getSelectedReferralToSpecialty().getID_ReferralToSpecTeam()));
			}
			if (form.getLocalContext().getTrackingForReferralIsNotNull())
			{
				form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(form.getLocalContext().getTrackingForReferral().getID_Tracking()));
			}
			open();
			return false;
		}

		TrackingForReferalToSpecialtyVo trackingToSave = null;

		// for a new TrackingForReferalToSpecialty set the current referral in
		// tracking and set Tracking.CurrentStatus
		if (!referralToSave.getID_ReferralToSpecTeamIsNotNull() && form.getLocalContext().getTrackingForReferral().getCurrentAreaIsNotNull() && !Boolean.TRUE.equals(form.getLocalContext().getTrackingForReferral().getIsDischarged()))
		{
			TrackingAttendanceStatusVo trackingAttendanceToSave = new TrackingAttendanceStatusVo();
			trackingAttendanceToSave = populateTrackingAttendanceToSave();

			trackingToSave = form.getLocalContext().getTrackingForReferral();
			trackingToSave.setCurrentReferral(referralToSave);
			trackingToSave.setCurrentStatus(trackingAttendanceToSave);
		}
		// set the current referral to null if referral record is marked as
		// completed
		else if (referralToSave.getID_ReferralToSpecTeamIsNotNull() && referralToSave.getCompletionDateTimeIsNotNull() && form.getLocalContext().getTrackingForReferral().getCurrentAreaIsNotNull() && !Boolean.TRUE.equals(form.getLocalContext().getTrackingForReferral().getIsDischarged()))
		{
			trackingToSave = form.getLocalContext().getTrackingForReferral();
			trackingToSave.setCurrentReferral(null);
		}

		try
		{
			if (trackingToSave != null && !referralToSave.getCompletionDateTimeIsNotNull())
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				form.getLocalContext().setSelectedReferralToSpecialty(domain.save(null, trackingToSave));
				form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(trackingToSave.getID_Tracking()));
			}
			else if (trackingToSave != null && referralToSave.getCompletionDateTimeIsNotNull())
			{
				String[] errors1 = trackingToSave.validate();

				if (errors1 != null && errors1.length > 0)
				{
					engine.showErrors(errors1);
					return false;
				}
				form.getLocalContext().setSelectedReferralToSpecialty(domain.save(referralToSave, trackingToSave));
				form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(trackingToSave.getID_Tracking()));
			}
			else
				form.getLocalContext().setSelectedReferralToSpecialty(domain.save(referralToSave, null));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());

			if (form.getLocalContext().getSelectedReferralToSpecialtyIsNotNull())
			{
				form.getLocalContext().setSelectedReferralToSpecialty(domain.getReferralToSpecialty(form.getLocalContext().getSelectedReferralToSpecialty().getID_ReferralToSpecTeam()));
			}
			if (trackingToSave != null)
			{
				form.getLocalContext().setTrackingForReferral(domain.getTrackingForReferral(trackingToSave.getID_Tracking()));
			}
			open();
			return false;
		}

		return true;
	}

	private TrackingAttendanceStatusVo populateTrackingAttendanceToSave()
	{
		TrackingAttendanceStatusVo trackingAttendance = new TrackingAttendanceStatusVo();

		trackingAttendance.setPatient(form.getGlobalContext().Core.getPatientShort());
		trackingAttendance.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		trackingAttendance.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		trackingAttendance.setTrackingArea(form.getLocalContext().getTrackingForReferral().getCurrentArea());
		trackingAttendance.setStatusDatetime(new DateTime());

		Object mos = domain.getMosUser();
		if (mos instanceof MemberOfStaffLiteVo)
		{
			trackingAttendance.setCreatedBy((MemberOfStaffLiteVo) mos);
		}

		trackingAttendance.setStatus(ims.emergency.vo.lookups.TrackingStatus.REFERRED_TO_OTHER_SPECIALITY);
		//WDEV-16777
		trackingAttendance.setPrevStatus((form.getLocalContext().getTrackingForReferral()!=null && form.getLocalContext().getTrackingForReferral().getCurrentStatus()!=null  ) ? form.getLocalContext().getTrackingForReferral().getCurrentStatus().getStatus() : null);

		return trackingAttendance;
	}

	private boolean validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();

		if (form.dtimReffered().getValue() != null)
		{
			if (form.dtimReffered().getValue().isGreaterThan(new DateTime()))
			{
				listOfErrors.add("Reffered Date/Time cannot be in the future.");
			}
			DateTime registrationDateTime = domain.getAttendanceRegistrationDateTime(form.getGlobalContext().Core.getCurrentCareContext());

			if (registrationDateTime.isGreaterThan(form.dtimReffered().getValue()))
			{
				listOfErrors.add("Reffered Date/Time must be after Registration Date/Time for the selected attendance.");
			}
		}

		if (form.dtimSeen().getValue() != null)
		{
			if (form.dtimSeen().getValue().isGreaterThan(new DateTime()))
			{
				listOfErrors.add("Seen Date/Time cannot be in the future.");
			}

			if (form.dtimReffered().getValue() != null)
			{
				if (form.dtimReffered().getValue().getDate().isGreaterThan(form.dtimSeen().getValue().getDate()) || (form.dtimReffered().getValue().getDate().equals(form.dtimSeen().getValue().getDate()) && form.dtimReffered().getValue().getTime().isGreaterThan(form.dtimSeen().getValue().getTime())))
				{
					listOfErrors.add("Reffered Date/Time cannot be greater than Seen Date/Time.");
				}
			}

			if (form.dtimCompletion().getValue() != null)
			{
				if (form.dtimSeen().getValue().getDate().isGreaterThan(form.dtimCompletion().getValue().getDate()) || (form.dtimSeen().getValue().getDate().equals(form.dtimCompletion().getValue().getDate()) && form.dtimSeen().getValue().getTime().isGreaterThan(form.dtimCompletion().getValue().getTime())))
				{
					listOfErrors.add("Seen Date/Time cannot be greater than Completion Date/Time.");
				}
			}

		}

		if (form.dtimCompletion().getValue() != null && form.dtimCompletion().getValue().isGreaterThan(new DateTime()))
		{
			listOfErrors.add("Completion Date/Time cannot be in the future.");
		}
		
		if (form.getLocalContext().getSelectedReferralToSpecialty() != null && form.getLocalContext().getSelectedReferralToSpecialty().getID_ReferralToSpecTeam() != null)
		{
			if (form.dtimCompletion().getValue() == null && domain.isLastEntry(form.getGlobalContext().Core.getCurrentCareContext(), form.getLocalContext().getSelectedReferralToSpecialty()) == false)
			{
				listOfErrors.add("Completion Date/Time is mandatory for this record.");
			}
		}

		int errorCount = listOfErrors.size();
		String[] result = new String[errorCount];

		for (int x = 0; x < errorCount; x++)
			result[x] = (String) listOfErrors.get(x);

		if (result != null && result.length > 0)
		{
			engine.showErrors(result);
			return false;
		}

		return true;
	}

	private ReferralToSpecialtyTeamVo populateDataFromScreen(ReferralToSpecialtyTeamVo ReferralToSpecialty)
	{
		if (ReferralToSpecialty == null)
		{
			ReferralToSpecialty = new ReferralToSpecialtyTeamVo();
		}

		ReferralToSpecialty.setPatient(form.getGlobalContext().Core.getPatientShort());
		ReferralToSpecialty.setEpisode(form.getGlobalContext().Core.getEpisodeofCareShort());
		ReferralToSpecialty.setAttendance(form.getGlobalContext().Core.getCurrentCareContext());
		ReferralToSpecialty.setTrackingArea(form.getLocalContext().getTrackingForReferral().getCurrentArea());

		ReferralToSpecialty.setReferredBy((HcpLiteVo) form.ccRefferedBy().getValue());
		ReferralToSpecialty.setReferredDateTime(form.dtimReffered().getValue());
		ReferralToSpecialty.setTeamConsultant(form.cmbConsultantTeam().getValue());
		ReferralToSpecialty.setSpecialty(form.cmbSpecialty().getValue());
		ReferralToSpecialty.setSeenDateTime(form.dtimSeen().getValue());
		ReferralToSpecialty.setCompletionDateTime(form.dtimCompletion().getValue());
		//ReferralToSpecialty.setComments(ReferralComments());

		return ReferralToSpecialty;

	}

	private ReferralToSpecialtyCommentsVoCollection ReferralComments()
	{
		ReferralToSpecialtyCommentsVoCollection commentsCollection = new ReferralToSpecialtyCommentsVoCollection();

		for (int i = 0; i < form.grdComments().getRows().size(); i++)
		{
			commentsCollection.add(form.grdComments().getRows().get(i).getValue());
		}
		return commentsCollection;
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.dtimSeen().getValue() == null)
		{
			form.dtimSeen().setValue(new DateTime());
		}

		form.dtimCompletion().setEnabled(true);
		form.dtimSeen().setEnabled(true);

		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();
		newInstance();
		form.getLocalContext().setSelectedReferralToSpecialty(null);
		form.setMode(FormMode.EDIT);
	}

	private void clearControls()
	{
		form.dtimReffered().setValue(null);
		form.cmbConsultantTeam().setValue(null);
		form.cmbSpecialty().setValue(null);
		form.dtimCompletion().setValue(null);
		form.dtimSeen().setValue(null);
		form.grdComments().getRows().clear();
		form.ccRefferedBy().clear();
		form.getLocalContext().setSelectedComment(null);

	}

	private void initializeControls()
	{
		form.ccRefferedBy().initialize(MosType.HCP);
	}
	
	private void newInstance()
	{
		form.dtimReffered().setValue(new DateTime());
		form.dtimCompletion().setEnabled(false);
		form.dtimSeen().setEnabled(false);
		form.recbrReferralsForAttendance().clear();

		Object mos = domain.getHcpLiteUser();

		if (mos instanceof HcpLiteVo)
		{
			form.ccRefferedBy().setValue((HcpLiteVo) mos);
		}
	}

	@Override
	protected void onGrdCommentsSelectionChanged()
	{
		form.getLocalContext().setSelectedComment(form.grdComments().getSelectedRow().getValue());
		updateControlsState();
	}

	@Override
	protected void onRecbrReferralsForAttendanceValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedReferralToSpecialty(form.recbrReferralsForAttendance().getValue());
		getSelectedInstance();
		updateControlsState();
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.EmergencyNamespace.ReferralToSpecTeam.Add:

				form.getGlobalContext().Emergency.setReferralToSpecialtyComments(null);
				form.getLocalContext().setSelectedComment(null);
				engine.open(form.getForms().Emergency.ReferralToSpecialtyCommentsDialog);
				break;

			case GenForm.ContextMenus.EmergencyNamespace.ReferralToSpecTeam.Edit:

				form.getGlobalContext().Emergency.setReferralToSpecialtyComments(form.getLocalContext().getSelectedComment());
				engine.open(form.getForms().Emergency.ReferralToSpecialtyCommentsDialog);
				break;
		}
	}

	@Override
	protected void onBtnCloseClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
}
