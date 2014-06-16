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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.70 build 3544.19053)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.admin.forms.searchandselectpasuser;

import ims.admin.forms.searchandselectpasuser.GenForm.grdUsersRow;
import ims.admin.vo.UserDTOVo;
import ims.admin.vo.UserDTOVoCollection;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getGlobalContext().Admin.setHeartsUser(form.grdUsers().getValue());
		engine.close(DialogResult.OK);
	}

	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtUser().setValue(null);
		form.grdUsers().getRows().clear();
		updateControlsState();
	}
	
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.txtUser().getValue() == null || form.txtUser().getValue().equals(""))
		{
			engine.showErrors(new String[] {"Name is mandatory"});
			return;
		}
		
		form.grdUsers().getRows().clear();
		UserDTOVoCollection voCollUser = domain.listUserByName(form.txtUser().getValue());
		if(voCollUser != null && voCollUser.size() > 0)
		{
			for (int i = 0; i < voCollUser.size(); i++)
			{
				UserDTOVo voUser = voCollUser.get(i);
				
				grdUsersRow row = form.grdUsers().getRows().newRow();
				row.setColName(voUser.getUserName());
				row.setValue(voUser);
			}
		}
		else
			engine.showMessage("No matching records found");
		
		updateControlsState();
	}
	
	@Override
	protected void onGrdUsersSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.btnOK().setEnabled(form.grdUsers().getValue() != null);
	}
}