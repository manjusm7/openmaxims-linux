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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.54 build 2706.27392)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.emergency.forms.attendancedetails;

import ims.admin.vo.EDAttendanceControlsConfigVoCollection;
import ims.admin.vo.lookups.EDAttendenceControlType;
import ims.configuration.gen.ConfigFlag;
import ims.core.helper.ResetPIDBarHelper;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.EDAttendanceformsConfigVo;
import ims.core.vo.EpisodeofCareLiteVo;
import ims.core.vo.LocSiteLiteVo;
import ims.core.vo.LocSiteShortVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.Patient;
import ims.core.vo.PatientShort;
import ims.core.vo.lookups.LocationType;
import ims.domain.exceptions.StaleObjectException;
import ims.emergency.forms.attendancedetails.GenForm.grdPreviousHistoryRow;
import ims.emergency.vo.AttendanceDetailsVo;
import ims.emergency.vo.EpisodeDetailsVo;
import ims.emergency.vo.EpisodeDetailsVoCollection;
import ims.emergency.vo.EpisodeOfcareLiteVo;
import ims.emergency.vo.TrackingSendToAreaVo;
import ims.emergency.vo.enums.EmergencyAttendanceEvent;
import ims.framework.Control;
import ims.framework.LayerBridge;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	//WDEV-16673
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.EmergencyNamespace.AttendanceDetails.NewEpisode:
				form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().newInstance();
				break;
			case GenForm.ContextMenus.EmergencyNamespace.AttendanceDetails.EditEpisode:
				form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().editInstance();
				break;
			case GenForm.ContextMenus.EmergencyNamespace.AttendanceDetails.AddAttendance:
				form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().newInstance();
				break;
			case GenForm.ContextMenus.EmergencyNamespace.AttendanceDetails.EditAttendance:
				form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().editInstance();
				break;			
		}
	}
	
	protected void onFormModeChanged() 
	{	
		//WDEV-16673
		updateControlState();
	}

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		EDAttendanceControlsConfigVoCollection attendanceControlsConfig = domain.getEDAttendanceControlsConfig(EDAttendenceControlType.ATTEND_CONTROLS);
		
		//WDEV-17804
		if (attendanceControlsConfig==null || attendanceControlsConfig.size()==0)
		{	
			throw new PresentationLogicException("The Script to populate EDConfig form should be run first !");
		}
		
		
		initialize();		//wdev-14420
		if(	getLoc() == null)
		{
			engine.showMessage(" The current location should be of type Emergency. ");
			
		}
		open();	
		form.getLocalContext().setOpenFirstTime(Boolean.TRUE); //wdev-14420
		
	}
	
	//WDEV-16673
	private void initialize() 
	{
		form.getLocalContext().setOpenFirstTime(Boolean.FALSE);
		
		form.getLocalContext().setIsPatientInEd(null);
		form.getLocalContext().setAttendanceOfPatientInEd(null);
	}

	private void open() throws PresentationLogicException 
	{	
		//WDEV-16673
		form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().clearAttendanceDetails();	
		//get PatientVo and put it in local context
		getPatient(form.getGlobalContext().Core.getPatientShort());
		
		patientIsRegisteredOnTheTrackingSystem();
	
		AttendanceDetailsVo attendVo = null;
		if(form.getGlobalContext().Core.getPatientShortIsNotNull())
		{
			attendVo = domain.getLastAttendance(form.getGlobalContext().Core.getPatientShort());
		}
		if(attendVo != null)
		{
			if(attendVo.getDischargeDateTimeIsNotNull())
			{
				int hours = hoursDiff(new DateTime(),attendVo.getDischargeDateTime() );
				if(hours > 48 && hours <= 72)
				{
					form.lbl24h().setValue("Patient has been departed in last 72 hrs");//WDEV-17920
					form.lbl24h().setVisible(true);
				}
				else if(hours > 24 && hours <= 48)
				{
					form.lbl24h().setValue("Patient has been departed in last 48 hrs");//WDEV-17920
					form.lbl24h().setVisible(true);
				}
				else if(hours <= 24)
				{
					form.lbl24h().setValue("Patient has been departed in last 24 hrs");//WDEV-17920
					form.lbl24h().setVisible(true);
				}
				else
				{
					form.lbl24h().setValue("");
					form.lbl24h().setVisible(false);
				}
			}
			else
			{
				form.lbl24h().setValue("");
				form.lbl24h().setVisible(false);
			}
			
			//WDEV-17008
			form.lblAttendingAsAdultPaediatric().setValue((attendVo.getAgeAtAttendanceIsNotNull() && attendVo.getAgeAtAttendance()<= ConfigFlag.GEN.PAEDIATRIC_AGE.getValue()) ? "Attending as Paediatric patient" : "Attending as Adult patient");
		}
		else
		{
			form.lbl24h().setValue("");	
			form.lbl24h().setVisible(false);
		}
		
		//is the patient currenlty in Emergency Department
		TrackingSendToAreaVo trackVo = isPatientCurrentlyInEmergencyDepartment();  //wdev-14420
		if( trackVo != null)  //wdev-14420
		{
			//wdev-14420
			form.getLocalContext().setAllowNewAttendance(Boolean.FALSE); 
			
			if(	Boolean.FALSE.equals(form.getLocalContext().getOpenFirstTime()))	
				form.getGlobalContext().Emergency.setCurrentEmergencyAttendance(trackVo.getAttendance());
			
			form.getLocalContext().setAttendanceOfPatientInEd(trackVo.getAttendance());
			form.getLocalContext().setIsPatientInEd(Boolean.TRUE);
		
			form.lblDischargeWarning().setVisible(true);	
			String nameOfArea = trackVo.getCurrentAreaIsNotNull() ? trackVo.getCurrentArea().getAreaDisplayName():"";
			form.lblDischargeWarning().setValue("Patient is currently in " + nameOfArea);							
		}
		else if(attendVo!=null && Boolean.TRUE.equals(attendVo.getIsExpectedArrival())) //WDEV-17278
		{
			//We need to also check here to see if the patient is a pending arrival.
			//if they are treat them as if they are in tracking already
			
			form.getLocalContext().setAllowNewAttendance(Boolean.FALSE);

			if(	Boolean.FALSE.equals(form.getLocalContext().getOpenFirstTime()))	
				form.getGlobalContext().Emergency.setCurrentEmergencyAttendance(attendVo);
			
			form.lblDischargeWarning().setVisible(true);		
			form.getLocalContext().setIsPatientInEd(Boolean.FALSE);
			form.getLocalContext().setAttendanceOfPatientInEd(attendVo);
			form.lblDischargeWarning().setValue("Patient is in Pending Arrivals List");
			
		}
		else
		{
				//hide Emergency Attendance Discharge Details
				form.getLocalContext().setAllowNewAttendance(Boolean.TRUE); //wdev-14420	
				form.lblDischargeWarning().setVisible(false);		
				form.getLocalContext().setIsPatientInEd(Boolean.FALSE);
				form.getLocalContext().setAttendanceOfPatientInEd(null);
		}
	
		if (Boolean.TRUE.equals(form.getLocalContext().getOpenFirstTime()) && form.getLocalContext().getSelectedRecord() == null) //check if it's a  new attendance was saved //wdev-14420
		{
			form.getGlobalContext().Emergency.setCurrentEmergencyAttendance(getLastAttendanceFromLastEpisode(form.getGlobalContext().Emergency.getSelectedEmergencyEpisode()));
		}
		
		populatePreviousHistoryGrid(form.getLocalContext().getEmergencyEpisodes());
		
		if( form.getLocalContext().getCountOfPreviousAttendances() > 0  && form.getLocalContext().getIsPatientInEd())//wdev-17989
		{
			Integer temp = form.getLocalContext().getCountOfPreviousAttendances() - 1;
			form.lbllblCountOfPreviousAttendance2().setValue(temp.toString());
		}
		//wdev-17989
		else if( form.getLocalContext().getCountOfPreviousAttendances() > 0  && !form.getLocalContext().getIsPatientInEd())
		{
			Integer temp = form.getLocalContext().getCountOfPreviousAttendances();
			form.lbllblCountOfPreviousAttendance2().setValue(temp.toString());
		} 
		
		if (form.getGlobalContext().Emergency.getCurrentEmergencyAttendanceIsNotNull())
		{
			form.grdPreviousHistory().setValue(form.getGlobalContext().Emergency.getCurrentEmergencyAttendance());
			onGrdPreviousHistorySelectionChanged();
		}

		form.setMode(FormMode.VIEW);
		updateControlState();
	
		if(getLoc() != null)
		{
			if(Boolean.TRUE.equals(form.getLocalContext().getAllowNewAttendance()) && Boolean.FALSE.equals(form.getLocalContext().getOpenFirstTime()))
			{	
				form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().newInstance();		
			}
		}
		else  
		{
			updateControlState();
		}

	}
	
	//wdev-14420
	private AttendanceDetailsVo getLastAttendanceFromLastEpisode(EpisodeDetailsVo emergencyEpisode)
	{
		if(emergencyEpisode == null )
			return null;
	
		emergencyEpisode.getEmergencyAttendances().sort(new ArrivalDateComparator(SortOrder.DESCENDING));
		if(emergencyEpisode.getEmergencyAttendancesIsNotNull() && emergencyEpisode.getEmergencyAttendances().size() > 0)
		{
					return emergencyEpisode.getEmergencyAttendances().get(0);
		}
		
		return null;
			
	}
	//wdev-14420
	private int hoursDiff(DateTime startDate, DateTime endDate)
	{
		if (startDate == null)
			throw new IllegalArgumentException("No start date specified");
		if (endDate == null)
			throw new IllegalArgumentException("No end date specified");
		
			
		long endInMillis = endDate.getJavaDate().getTime();
		long startInMillis = startDate.getJavaDate().getTime();
		
		return (int)((((endInMillis < startInMillis ? startInMillis - endInMillis : endInMillis - startInMillis)/1000)/60)/60);
	}

	//----------
	private void populatePreviousHistoryGrid(EpisodeDetailsVoCollection emergencyEpisodes) 
	{
		form.getLocalContext().setCountOfPreviousAttendances(0);
		if (emergencyEpisodes == null)
			return;

		form.grdPreviousHistory().getRows().clear();		
		grdPreviousHistoryRow  episodeDetailsRow = null, emergencyAttendancesRow = null;
		//emergencyEpisodes.sort(new InjuryDateComparator(SortOrder.DESCENDING));  //wdev-14420
		for (int i = 0; i < emergencyEpisodes.size(); i++)
		{	
			EpisodeDetailsVo voEpisodeDetails = emergencyEpisodes.get(i);
	
			episodeDetailsRow = form.grdPreviousHistory().getRows().newRow();
			
			EpisodeOfcareLiteVo tempVo = domain.getEpisodeOfCareLite(voEpisodeDetails.getEpisodeOfCare());	//wdev-16070
			episodeDetailsRow.setcolDateTime(tempVo != null ? tempVo.getStartDate():null);					//wdev-16070
			
			episodeDetailsRow.setcolPatCategory((voEpisodeDetails.getCategoryIsNotNull() ? voEpisodeDetails.getCategory().getText() + " - ":"") + (voEpisodeDetails.getPresentingComplaintIsNotNull()? voEpisodeDetails.getPresentingComplaint().toString():""));
			
			episodeDetailsRow.setcolEpisodeNo(voEpisodeDetails.getID_EmergencyEpisode().toString());
			
			//episodeDetailsRow.setCollapsedImage(form.getImages().Core.CareSpell);
			//episodeDetailsRow.setExpandedImage(form.getImages().Core.CareSpell);
			//----------- wdev-14420
			if( Boolean.TRUE.equals(form.getLocalContext().getIsPatientInEd()) && form.getLocalContext().getAttendanceOfPatientInEdIsNotNull() && form.getLocalContext().getAttendanceOfPatientInEd().getEpisode().equals(voEpisodeDetails)) 
				episodeDetailsRow.setBackColor(Color.LightGreen);
			//------
			episodeDetailsRow.setBold(true);
			episodeDetailsRow.setValue(voEpisodeDetails);
			episodeDetailsRow.setTooltip("DateTime : <b>" + (voEpisodeDetails.getInjuryDateTime()!=null ? voEpisodeDetails.getInjuryDateTime() :"" )+ (voEpisodeDetails.getCategoryIsNotNull() ? "</b><br>Category : <b>" + voEpisodeDetails.getCategory().getText() : "") + (voEpisodeDetails.getID_EmergencyEpisodeIsNotNull() ? "</b><br>Emergency Episode Number: <b>" + voEpisodeDetails.getID_EmergencyEpisode().toString() + "</b>" : ""));//WDEV-14420 //WDEV-17160 //wdev-18230
			
			if (voEpisodeDetails.getEmergencyAttendancesIsNotNull())
			{
				episodeDetailsRow.setExpanded(true);
				voEpisodeDetails.getEmergencyAttendances().sort(new ArrivalDateComparator(SortOrder.DESCENDING));   //wdev-14420
				for (int j = 0; j < voEpisodeDetails.getEmergencyAttendances().size(); j++)
				{
					AttendanceDetailsVo voEmergencyAttendances = voEpisodeDetails.getEmergencyAttendances().get(j);
					
					emergencyAttendancesRow = episodeDetailsRow.getRows().newRow();
					
					if (voEmergencyAttendances.getDischargeDateTimeIsNotNull())
					{							
						emergencyAttendancesRow.setcolDateTime(voEmergencyAttendances.getRegistrationDateTime() + " - " + voEmergencyAttendances.getDischargeDateTime());
						emergencyAttendancesRow.setcolPatCategory(voEmergencyAttendances.getOutcome() != null ? voEmergencyAttendances.getOutcome().getText() :  null);
						emergencyAttendancesRow.setcolEpisodeNo(voEmergencyAttendances.getID_EmergencyAttendance().toString());
						
						
						emergencyAttendancesRow.setcolContext((voEmergencyAttendances.getCareContextIsNotNull() && voEmergencyAttendances.getCareContext().getContextIsNotNull())? voEmergencyAttendances.getCareContext().getContext().toString():"");
						
						//emergencyAttendancesRow.setCollapsedImage(form.getImages().Core.BookOpenEnabled);
						if( Boolean.TRUE.equals(form.getLocalContext().getIsPatientInEd()) && form.getLocalContext().getAttendanceOfPatientInEdIsNotNull() && form.getLocalContext().getAttendanceOfPatientInEd().equals(voEmergencyAttendances))  //wdev-14420
							emergencyAttendancesRow.setBackColor(Color.LightBlue);
						emergencyAttendancesRow.setValue(voEmergencyAttendances);
						emergencyAttendancesRow.setTooltip("DateTime : <b>" + (voEmergencyAttendances.getRegistrationDateTime()!=null ? voEmergencyAttendances.getRegistrationDateTime() : "") + " - " + (voEmergencyAttendances.getDischargeDateTime()!=null ? voEmergencyAttendances.getDischargeDateTime() : "") + (voEmergencyAttendances.getOutcomeIsNotNull() ? "</b><br>Outcome : <b>" + voEmergencyAttendances.getOutcome() : "") + (voEmergencyAttendances.getID_EmergencyAttendanceIsNotNull() ? "</b><br>Emergency Attendance Number: <b>" + voEmergencyAttendances.getID_EmergencyAttendance().toString() + "</b><br>Context Type : <b>" + voEmergencyAttendances.getCareContext().getContext().toString() : ""));//WDEV-17160 //wdev-18230
					}
					else
					{
						emergencyAttendancesRow.setcolDateTime(voEmergencyAttendances.getArrivalDateTime());
						emergencyAttendancesRow.setcolPatCategory(voEmergencyAttendances.getOutcome() != null ? voEmergencyAttendances.getOutcome().getText() :  null);
						emergencyAttendancesRow.setcolEpisodeNo(voEmergencyAttendances.getID_EmergencyAttendance().toString());
						emergencyAttendancesRow.setcolContext((voEmergencyAttendances.getCareContextIsNotNull() && voEmergencyAttendances.getCareContext().getContextIsNotNull()) ? voEmergencyAttendances.getCareContext().getContext().toString():"");
						//emergencyAttendancesRow.setCollapsedImage(form.getImages().Core.Alert_RedTriangle2);
						
						if( Boolean.TRUE.equals(form.getLocalContext().getIsPatientInEd()) && form.getLocalContext().getAttendanceOfPatientInEdIsNotNull() && form.getLocalContext().getAttendanceOfPatientInEd().equals(voEmergencyAttendances))  //wdev-14420
							emergencyAttendancesRow.setBackColor(Color.LightBlue);
						
						emergencyAttendancesRow.setValue(voEmergencyAttendances);
						emergencyAttendancesRow.setTooltip("DateTime : <b>" + (voEmergencyAttendances.getRegistrationDateTime()!=null ? voEmergencyAttendances.getRegistrationDateTime():"") + (voEmergencyAttendances.getOutcomeIsNotNull() ? "</b><br>Outcome : <b>" + voEmergencyAttendances.getOutcome() : "") + (voEmergencyAttendances.getID_EmergencyAttendanceIsNotNull() ? "</b><br>Emergency Attendance Number: <b>" + voEmergencyAttendances.getID_EmergencyAttendance().toString() + "</b><br>Context Type : <b>" + voEmergencyAttendances.getCareContext().getContext().toString() : ""));//WDEV-17160 \\wdev-18230
					}
					//wdev-16070
					if( form.getLocalContext().getCountOfPreviousAttendancesIsNotNull() )
					{
						int nr = form.getLocalContext().getCountOfPreviousAttendances();
						nr = nr+1;
						form.getLocalContext().setCountOfPreviousAttendances(nr);
					}
					else
					{
						form.getLocalContext().setCountOfPreviousAttendances(0);
						int nr = form.getLocalContext().getCountOfPreviousAttendances();
						nr = nr+1;
						form.getLocalContext().setCountOfPreviousAttendances(nr);
					}
					//-----------
					
						
				}
			}
		}
		
	}
	
	private void getPatient(PatientShort patient) throws FormOpenException
	{
		Patient voPatient;
		try
		{
			voPatient = domain.getPatient(patient);
		}
		catch (StaleObjectException e)
		{
			// Try a second time. Only then fail.
			try
			{
				voPatient = domain.getPatient(patient);
			}
			catch (StaleObjectException e1)
			{
				throw new FormOpenException("Failed to retrieve Patient due to StaleObjectException");
			}
		}
		if (voPatient == null)
		{
			throw new FormOpenException("Data has been changed, Please perform another Patient Search");
		}
	
		form.getLocalContext().setPatient(voPatient);
	}
	
	private EpisodeDetailsVoCollection patientIsRegisteredOnTheTrackingSystem() 
	{
		EpisodeDetailsVoCollection voCollEpisodeDetails = domain.listEmergencyEpisodeByPatient
								(form.getGlobalContext().Core.getPatientShort(), new Integer(200),null,null,null);//wdev-18015 - changed value from 20 to 200
		
		if (voCollEpisodeDetails == null &
				(voCollEpisodeDetails != null &&
						voCollEpisodeDetails.size() == 0))
		{
			form.getLocalContext().setEmergencyEpisodes(null);
			return null;
		}
		
		form.getLocalContext().setEmergencyEpisodes(voCollEpisodeDetails);
		return voCollEpisodeDetails;
	}
	
	//wdev-14420
	private TrackingSendToAreaVo isPatientCurrentlyInEmergencyDepartment()
	{
		return domain.isPatientCurrentlyinED(form.getGlobalContext().Core.getPatientShort());
	}
	
	protected void onGrdPreviousHistorySelectionChanged() throws PresentationLogicException  
	{
		//WDEV-16673
		grdPreviousHistoryRow selectedRow = form.grdPreviousHistory().getSelectedRow();
		
		if (selectedRow != null && selectedRow.getValue() != null)
		{
			
			form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().initialize();
			form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().setValue(selectedRow.getValue());
			
			if (selectedRow.getValue() instanceof AttendanceDetailsVo)
			{
				form.getGlobalContext().Core.setCurrentCareContext(((AttendanceDetailsVo) selectedRow.getValue()).getCareContext());
				form.getGlobalContext().Emergency.setCurrentEmergencyAttendance((AttendanceDetailsVo) selectedRow.getValue());
				form.getLocalContext().setSelectedRecord((AttendanceDetailsVo) selectedRow.getValue());
				form.getGlobalContext().Emergency.setSelectedEmergencyEpisode((EpisodeDetailsVo) selectedRow.getParentRow().getValue());
				
				AttendanceDetailsVo selectedAttendance = form.getGlobalContext().Emergency.getCurrentEmergencyAttendance();
				CareContextShortVo careContext = form.getGlobalContext().Core.getCurrentCareContext();
				EpisodeofCareLiteVo episodeOfCare = careContext.getEpisodeOfCare();
				PatientShort patient = form.getGlobalContext().Core.getPatientShort();
				
				form.lyrEmergencyAttendance().tabChart().ccChatRequested().initialize(selectedAttendance, patient, careContext, episodeOfCare);
				form.lyrEmergencyAttendance().tabChart().ccChatRequested().setValue(domain.getChartRequestedByEmergencyAttendance(selectedAttendance));
				
				form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().initialize(selectedAttendance, patient, episodeOfCare, careContext);
				form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().setValue(domain.getAttendanceBillingByEmergencyAttendance(selectedAttendance));
				
				refreshPIDBarText();//WDEV-17332
			}
			else //WDEV-17332
			{
				
				ResetPIDBar(engine, form.getGlobalContext().Core.getPatientShort());//WDEV-17332
			}
			
			
		}	
		updateControlState();
	}

	//WDEV-17332
	private void refreshPIDBarText()
	{
		if (form.getGlobalContext().Core.getPatientShort() == null	
				|| form.getGlobalContext().Core.getEpisodeofCareShort()==null
				|| form.getGlobalContext().Core.getCurrentCareContext()==null)
				return;

			new ResetPIDBarHelper(engine, form.getGlobalContext().Core.getPatientShort() , domain.getPIDDiagnosisInfo(form.getGlobalContext().Core.getCurrentCareContext(), form.getGlobalContext().Core.getEpisodeofCareShort()));
	}
	
	//WDEV-17332
	public void ResetPIDBar(ims.framework.UIEngine paramEngine, PatientShort paramPatient)
	{
		if (paramPatient == null)
			return;
		
		StringBuffer sb = new StringBuffer();
		sb.append(paramPatient.getPatientInfo());
		
		if (paramPatient.getIsDead() != null 
			&& paramPatient.getIsDead().booleanValue())
			paramEngine.setPatientInfo(sb.toString(), ims.configuration.gen.ConfigFlag.UI.RIP_INFO_COLOUR.getValue());
		else
			paramEngine.setPatientInfo(sb.toString());
	}
	
	
	private void updateControlState()
	{			
		//WDEV-16673
		form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().setMode(form.getMode());
		form.lyrEmergencyAttendance().tabChart().ccChatRequested().setMode(form.getMode());
		form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().setMode(form.getMode());
		
		EDAttendanceformsConfigVo formsConfig = domain.getEDAttendanceformsConfig();
	
		grdPreviousHistoryRow selectedRow = form.grdPreviousHistory().getSelectedRow();
		
		if (form.getMode().equals(FormMode.VIEW))
		{
			if (selectedRow != null && selectedRow.getValue() != null)
			{
				if (selectedRow.getValue() instanceof AttendanceDetailsVo)
				{			
					form.getContextMenus().Emergency.getAttendanceDetailsEditAttendanceItem().setVisible(true);
				}
				else
				{
					form.getContextMenus().Emergency.getAttendanceDetailsEditEpisodeItem().setVisible(false);			
					form.getContextMenus().Emergency.getAttendanceDetailsEditAttendanceItem().setVisible(false);
				}				
			}
			else
			{
				form.getContextMenus().Emergency.getAttendanceDetailsEditEpisodeItem().setVisible(false);			
				form.getContextMenus().Emergency.getAttendanceDetailsEditAttendanceItem().setVisible(false);
				
			}
			
			form.getContextMenus().Emergency.getAttendanceDetailsAddAttendanceItem().setVisible(Boolean.TRUE.equals(form.getLocalContext().getAllowNewAttendance()) && form.grdPreviousHistory().getSelectedRow() != null );
	
			form.lyrEmergencyAttendance().tabAttDet().setHeaderVisible(true);
			form.lyrEmergencyAttendance().tabAttDet().setHeaderEnabled(true);
			
			form.lyrEmergencyAttendance().tabChart().setHeaderVisible((form.grdPreviousHistory().getValue() instanceof AttendanceDetailsVo) && formsConfig!=null && Boolean.TRUE.equals(formsConfig.getChartRequestedTabVisible()));
			form.lyrEmergencyAttendance().tabChart().setHeaderEnabled((form.grdPreviousHistory().getValue() instanceof AttendanceDetailsVo));
			
			form.lyrEmergencyAttendance().tabInvoices().setHeaderVisible((form.grdPreviousHistory().getValue() instanceof AttendanceDetailsVo) && formsConfig!=null && Boolean.TRUE.equals(formsConfig.getInvoicesBillingTabVisible()));
			form.lyrEmergencyAttendance().tabInvoices().setHeaderEnabled((form.grdPreviousHistory().getValue() instanceof AttendanceDetailsVo));
			
			if (selectedRow!=null && selectedRow.getValue() instanceof EpisodeDetailsVo)
			{
				form.lyrEmergencyAttendance().showtabAttDet();
			}

		}
		else
		{
			form.lyrEmergencyAttendance().tabAttDet().setHeaderEnabled(form.lyrEmergencyAttendance().tabAttDet().isVisible());
			form.lyrEmergencyAttendance().tabChart().setHeaderEnabled(form.lyrEmergencyAttendance().tabChart().isVisible());
			form.lyrEmergencyAttendance().tabInvoices().setHeaderEnabled(form.lyrEmergencyAttendance().tabInvoices().isVisible());
		}
		
		form.lblAttendingAsAdultPaediatric().setVisible(form.grdPreviousHistory().getValue()!=null && form.grdPreviousHistory().getValue() instanceof AttendanceDetailsVo);
	}
	
	public class ArrivalDateComparator implements Comparator
	{
		private int direction = 1;
		
		public ArrivalDateComparator()
		{
			this(SortOrder.ASCENDING);
		}
		
		public ArrivalDateComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
			
		}
		public int compare(Object ob1, Object ob2) 
		{
			DateTime date1 = null;
			DateTime date2 = null;
			if(ob1 instanceof AttendanceDetailsVo )
			{
				AttendanceDetailsVo ps1 = (AttendanceDetailsVo)ob1;
				date1 = ps1.getArrivalDateTime();
			}
			if(ob2 instanceof AttendanceDetailsVo)
			{
				AttendanceDetailsVo ps2 = (AttendanceDetailsVo)ob2;
				date2 = ps2.getArrivalDateTime();
			}
			if(date1 != null )
				return  date1.compareTo(date2)*direction;
			if(date2 != null)
				return (-1)*direction;
			
			return 0;
		}
	
	}
	
	private LocationLiteVo getLoc()
	{
		LocationLiteVo loc = null;
		LocSiteLiteVo locsite = null;
		if(domain.getCurrentLocation() instanceof LocationLiteVo)
		{
			loc = (LocationLiteVo) domain.getCurrentLocation();
			
		}
		else if(domain.getCurrentLocation() instanceof LocSiteLiteVo)
		{
			locsite = (LocSiteLiteVo) domain.getCurrentLocation();
			if(locsite != null)
			{
				loc = new LocationLiteVo(locsite.getID_Location(),locsite.getVersion_Location());
				LocSiteShortVo locShortVo = domain.getTypeOfLocSite(loc);
				loc.setType(locShortVo.getType());
				
			}
			
		}
		if( loc != null && loc.getTypeIsNotNull() && loc.getType().equals(LocationType.ANE))
			return loc;
		else
			return null;
				
	}

	@Override
	//WDEV-16673
	protected void onlyrEmergencyAttendanceTabChanged(LayerBridge tab)
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			grdPreviousHistoryRow selectedRow = form.grdPreviousHistory().getSelectedRow();
			
			if (selectedRow != null && selectedRow.getValue() != null && selectedRow.getValue() instanceof AttendanceDetailsVo)
			{
				form.getGlobalContext().Core.setCurrentCareContext(selectedRow.getValue()!=null ? ((AttendanceDetailsVo) selectedRow.getValue()).getCareContext():null);
				form.getGlobalContext().Emergency.setCurrentEmergencyAttendance(domain.getAttendanceDetails((AttendanceDetailsVo) selectedRow.getValue()));
				
				AttendanceDetailsVo selectedAttendance = form.getGlobalContext().Emergency.getCurrentEmergencyAttendance();
				CareContextShortVo careContext = form.getGlobalContext().Core.getCurrentCareContext();
				EpisodeofCareLiteVo episodeOfCare = careContext.getEpisodeOfCare();
				PatientShort patient = form.getGlobalContext().Core.getPatientShort();
				
				if (tab.equals(form.lyrEmergencyAttendance().tabAttDet()))
				{
					form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().setValue(selectedRow.getValue());
				}
				else if (tab.equals(form.lyrEmergencyAttendance().tabChart()) && selectedRow.getValue() instanceof AttendanceDetailsVo)
				{
					form.lyrEmergencyAttendance().tabChart().ccChatRequested().initialize(selectedAttendance, patient, careContext, episodeOfCare);
					form.lyrEmergencyAttendance().tabChart().ccChatRequested().setValue(domain.getChartRequestedByEmergencyAttendance(selectedAttendance));
					
				}
				else if (tab.equals(form.lyrEmergencyAttendance().tabInvoices()) && selectedRow.getValue() instanceof AttendanceDetailsVo)
				{
					form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().initialize(selectedAttendance, patient, episodeOfCare, careContext);
					form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().setValue(domain.getAttendanceBillingByEmergencyAttendance(selectedAttendance));
					
				}
			}	
		}
		updateControlState();	
	}

	@Override
	//WDEV-16673
	protected void onCcAttendanceDetailsValueChanged() throws PresentationLogicException
	{
		if (EmergencyAttendanceEvent.SAVE.equals(form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().getSelectedEvent()) || EmergencyAttendanceEvent.CANCEL.equals(form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().getSelectedEvent()))
		{
			form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().resetSelectedEvent();
			open();
			return;
		}
		
		if (EmergencyAttendanceEvent.NEW.equals(form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().getSelectedEvent()))
		{
			form.grdPreviousHistory().setValue(null);
		}
		
		form.lyrEmergencyAttendance().showtabAttDet();
		form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().resetSelectedEvent();
		FormMode attDetMode = form.lyrEmergencyAttendance().tabAttDet().ccAttendanceDetails().getMode();	
		form.setMode(attDetMode);
	}

	@Override
	//WDEV-16673
	protected void onCcChatRequestedValueChanged() throws PresentationLogicException
	{
		if (EmergencyAttendanceEvent.SAVE.equals(form.lyrEmergencyAttendance().tabChart().ccChatRequested().getSelectedEvent()) || EmergencyAttendanceEvent.CANCEL.equals(form.lyrEmergencyAttendance().tabChart().ccChatRequested().getSelectedEvent()))
		{
			form.lyrEmergencyAttendance().tabChart().ccChatRequested().resetSelectedEvent();
			open();
			return;
		}
		
		form.lyrEmergencyAttendance().tabChart().ccChatRequested().resetSelectedEvent();
		FormMode chartReqMode = form.lyrEmergencyAttendance().tabChart().ccChatRequested().getMode();	
		form.setMode(chartReqMode);
	}

	@Override
	//WDEV-16673
	protected void onCcInvoicesBillingValueChanged() throws PresentationLogicException
	{
		if (EmergencyAttendanceEvent.SAVE.equals(form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().getSelectedEvent()) || EmergencyAttendanceEvent.CANCEL.equals(form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().getSelectedEvent()))
		{
			form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().resetSelectedEvent();
			open();
			return;
		}
		
		form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().resetSelectedEvent();
		FormMode invoiceBillingMode = form.lyrEmergencyAttendance().tabInvoices().ccInvoicesBilling().getMode();	
		form.setMode(invoiceBillingMode);
	}

}
