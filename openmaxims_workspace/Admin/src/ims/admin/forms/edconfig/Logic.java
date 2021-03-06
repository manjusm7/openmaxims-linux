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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4785.23502)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.forms.edconfig;

import ims.admin.forms.edconfig.GenForm.lyrEDLayer.tabPageAttendanceDetConfigContainer.lyrAttendanceDetailsLayer.tabPageAttendanceDetalisContainer.grdAttendanceDetailsControlConfigRow;
import ims.admin.forms.edconfig.GenForm.lyrEDLayer.tabPageAttendanceDetConfigContainer.lyrAttendanceDetailsLayer.tabPageChartRequestedContainer.grdChartRequestRow;
import ims.admin.forms.edconfig.GenForm.lyrEDLayer.tabPageAttendanceDetConfigContainer.lyrAttendanceDetailsLayer.tabPageInvoicesBillingContainer.grdInvoicesBillRow;
import ims.admin.vo.EDAttendanceControlsConfigVo;
import ims.admin.vo.EDAttendanceControlsConfigVoCollection;
import ims.admin.vo.lookups.EDAttendenceControlType;
import ims.core.vo.EDAttendanceformsConfigVo;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int	COLUMN_VISIBLE = 1;

	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if( save())
			open();
		
	}
	
	private EDAttendanceformsConfigVo populateDataFromScreen(EDAttendanceformsConfigVo record)
	{
		if( record == null )
			record = new EDAttendanceformsConfigVo(); 
		
		record.setChartRequestedTabVisible(form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().getValue());
		record.setInvoicesBillingTabVisible(form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().getValue());
		
		EDAttendanceControlsConfigVoCollection tempColl = new EDAttendanceControlsConfigVoCollection();
		
		for( int i = 0; i < form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().size();i++)
		{
			EDAttendanceControlsConfigVo attendanceVo = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().get(i).getValue();
			
			attendanceVo.setIsEditable(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().get(i).getColumnEditable());
			attendanceVo.setIsVisible(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().get(i).getColumnVisible());
			attendanceVo.setIsRequired(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().get(i).getColumnRequired());
			tempColl.add(attendanceVo);
			
		}
		
		for(int j = 0; j < form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().size();j++)
		{
			EDAttendanceControlsConfigVo attendanceVo = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().get(j).getValue();
			
			if( Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().getValue()))
			{
    			attendanceVo.setIsEditable(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().get(j).getColumnEditable());
    			attendanceVo.setIsVisible(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().get(j).getColumnVisible());
    			attendanceVo.setIsRequired(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().get(j).getColumnRequired());
			}
			else
			{
				attendanceVo.setIsEditable(Boolean.FALSE);
    			attendanceVo.setIsVisible(Boolean.FALSE);
    			attendanceVo.setIsRequired(Boolean.FALSE);
			}
			tempColl.add(attendanceVo);
			
		}
		for(int k = 0; k < form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().size();k++)
		{
			EDAttendanceControlsConfigVo attendanceVo = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().get(k).getValue();
			
			if( Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().getValue()))
			{
			
				attendanceVo.setIsEditable(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().get(k).getColumnEditable());
				attendanceVo.setIsVisible(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().get(k).getColumnVisible());
				attendanceVo.setIsRequired(form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().get(k).getColumnRequired());
			}
			else
			{
				attendanceVo.setIsEditable(Boolean.FALSE);
				attendanceVo.setIsVisible(Boolean.FALSE);
				attendanceVo.setIsRequired(Boolean.FALSE);
			}
			tempColl.add(attendanceVo);
			
		}
		record.setControlsConfigItems(tempColl);
		
		return record;
		
		
	}
	private boolean save()
	{
		EDAttendanceformsConfigVo record = populateDataFromScreen(form.getLocalContext().getCurrentEDAttendanceformsConfig());
		
		String[] arrErrors = record.validate();
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		
		try
		{
			form.getLocalContext().setCurrentEDAttendanceformsConfig(domain.saveEDAttandanceformsConfigVo(record));
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return true;
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		
		return true;
		
	}
	
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	
	protected void onFormModeChanged()
	{
		updateControlsState();
		
	}

	
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
		open();
		
				
	}
	private void initialize()
	{
		form.lyrED().tabPageOther().setHeaderVisible(false); //WDEV-16721
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().setCaption("Attendance Details");
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().setCaption("Chart requested");
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().setCaption("Invoices/Billing");
	}
	
	private void updateControlsState()
	{
		if( form.getMode().equals(FormMode.VIEW))
		{
			form.lyrED().tabPageAttendanceDetConfig().btnEdit().setVisible(form.getLocalContext().getCurrentEDAttendanceformsConfigIsNotNull());
		}
		
		
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().setHeaderVisible(Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().getValue()));
		//form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().setVisible(Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().getValue()));
		
		
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().setHeaderVisible(Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().getValue()));
		//form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().setVisible(Boolean.TRUE.equals(form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().getValue()));
		
		
		
	}
	private void open()
	{
		clearScreen();
		EDAttendanceformsConfigVo tempVo = domain.getEDAttandanceformsConfigVo();
		form.getLocalContext().setCurrentEDAttendanceformsConfig(tempVo);
		populateScreenFromData(tempVo);
		form.setMode(FormMode.VIEW);
		
	}
	private void clearScreen()
	{
		form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().setValue(null);
		form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().setValue(null);
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().clear();
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().clear();
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().clear();
		
	}
	private void populateScreenFromData(EDAttendanceformsConfigVo record)
	{
		if( record == null )
			return;
		
		form.lyrED().tabPageAttendanceDetConfig().chkChartRequest().setValue(record.getChartRequestedTabVisible());
		form.lyrED().tabPageAttendanceDetConfig().chkInvoiceBill().setValue(record.getInvoicesBillingTabVisible());
		
		if( record.getControlsConfigItemsIsNotNull() && record.getControlsConfigItems().size() > 0)
		{
			for(int i = 0; i < record.getControlsConfigItems().size();i++)
			{
				EDAttendanceControlsConfigVo tempVo = record.getControlsConfigItems().get(i);
				if( tempVo != null )
				{
					if( tempVo.getControlTypeIsNotNull() && tempVo.getControlType().equals(EDAttendenceControlType.ATTEND_CONTROLS))
					{
						populateAttendanceDetailsControlConfigGrid(tempVo);
					}
					else if( tempVo.getControlTypeIsNotNull() && tempVo.getControlType().equals(EDAttendenceControlType.CHART_CONTROLS) )
					{
						populateChartRequestGrid( tempVo );
					}
					else if( tempVo.getControlTypeIsNotNull() && tempVo.getControlType().equals(EDAttendenceControlType.INV_BILL_CONTROLS))
					{
						populateInvoicesBillGrid( tempVo);
					}
				}
			}
		}
		
	}
	
	private void populateAttendanceDetailsControlConfigGrid( EDAttendanceControlsConfigVo record)
	{
		if( record == null )
			return;
		
		grdAttendanceDetailsControlConfigRow row = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageAttendanceDetalis().grdAttendanceDetailsControlConfig().getRows().newRow();
		row.setColumnScreenControl(record.getControlDescriptionOnForm());
		row.setColumnVisible(record.getIsVisible());
		row.setColumnEditable(record.getIsEditable());
		row.setColumnRequired(record.getIsRequired());
		row.setValue(record);
			
	}
	
	private void populateChartRequestGrid( EDAttendanceControlsConfigVo record)
	{
		if( record == null )
			return;
		
		grdChartRequestRow row = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageChartRequested().grdChartRequest().getRows().newRow();
		row.setColumnScreenControl(record.getControlDescriptionOnForm());
		row.setColumnVisible(record.getIsVisible());
		row.setColumnEditable(record.getIsEditable());
		row.setColumnRequired(record.getIsRequired());
		row.setValue(record);
			
	}
	
	private void populateInvoicesBillGrid( EDAttendanceControlsConfigVo record)
	{
		if( record == null )
			return;
		
		grdInvoicesBillRow row = form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().tabPageInvoicesBilling().grdInvoicesBill().getRows().newRow();
		row.setColumnScreenControl(record.getControlDescriptionOnForm());
		row.setColumnVisible(record.getIsVisible());
		row.setColumnEditable(record.getIsEditable());
		row.setColumnRequired(record.getIsRequired());
		row.setValue(record);
			
	}

	
	protected void onChkInvoiceBillValueChanged() throws PresentationLogicException
	{
		updateControlsState();
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().showtabPageAttendanceDetalis();
		
	}

	
	protected void onChkChartRequestValueChanged() throws PresentationLogicException
	{
		updateControlsState();
		form.lyrED().tabPageAttendanceDetConfig().lyrAttendanceDetails().showtabPageAttendanceDetalis();
		
	}

	
	protected void onGrdAttendanceDetailsControlConfigGridCheckBoxClicked(
			int column, grdAttendanceDetailsControlConfigRow row,
			boolean isChecked) throws PresentationLogicException 
	{
		if( column == COLUMN_VISIBLE && row.getColumnVisible() == false)
		{
			row.setColumnEditable(false);
			row.setColumnRequired(false);
		}
		
	}

	
	protected void onGrdChartRequestGridCheckBoxClicked(int column,
			grdChartRequestRow row, boolean isChecked)
			throws PresentationLogicException 
	{
		if( column == COLUMN_VISIBLE && row.getColumnVisible() == false)
		{
			row.setColumnEditable(false);
			row.setColumnRequired(false);
		}
		
	}

	
	protected void onGrdInvoicesBillGridCheckBoxClicked(int column,
			grdInvoicesBillRow row, boolean isChecked)
			throws PresentationLogicException 
	{
		if( column == COLUMN_VISIBLE && row.getColumnVisible() == false)
		{
			row.setColumnEditable(false);
			row.setColumnRequired(false);
		}
		
	}
}
