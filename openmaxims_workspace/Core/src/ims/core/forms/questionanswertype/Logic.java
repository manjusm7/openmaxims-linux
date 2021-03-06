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
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.34 build 2083.24984)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.
//-- Screen Functionality -----
//When having a Lookup as an Answer Type then the sceen implements a CACHE MECHANISM 
//and manage the pair LookupType - LookupInstances for the added/removed lookups 
//which are not saved yet but which might be used by other Answer Type instance
//When saving the questions only the LookupInstances of the Lookup Types that will be saved
//(including the inactive and previously saved ones) are going to be saved from the cache

package ims.core.forms.questionanswertype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



import ims.core.forms.questionanswertype.GenForm.grdAnswerOptionRow;
import ims.core.vo.AnswerOptionVo;
import ims.core.vo.AnswerOptionVoCollection;
import ims.core.vo.NonUniqueTaxonomyMapVo;
import ims.core.vo.NonUniqueTaxonomyMapVoCollection;
import ims.core.vo.QuestionAnswerTypeVo;
import ims.core.vo.lookups.QuestionAnswerType;
import ims.core.vo.lookups.QuestionType;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initializeScreen();
		open();
	}

	private void initializeScreen()
	{
		setContextMenu();
		clearScreenControls();
		loadColourCombo();
	}

	protected void onGrdAnswerOptionSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		enableContextMenu();
	}

	protected void onGrdAnswerOptionGridButtonClicked(int column, grdAnswerOptionRow row) throws PresentationLogicException
	{
		form.getLocalContext().setTaxonomyRowIndex(getRowIndex(row));
		engine.open(form.getForms().Core.TaxonomySearch);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (formName.equals(form.getForms().Core.TaxonomySearch) && result.equals(DialogResult.OK))
		{
			Integer taxonomyRowIndex = form.getLocalContext().getTaxonomyRowIndex();
			int rowIndex = taxonomyRowIndex != null ? taxonomyRowIndex.intValue() : form.grdAnswerOption().getSelectedRowIndex();
			if (rowIndex >= 0)
			{
				setColTaxonomy(form.grdAnswerOption().getRows().get(rowIndex), getNonUniqueTaxonomyMap(form.getGlobalContext().Core.getTaxonomyMap()));
			}

			form.getLocalContext().setTaxonomyRowIndex(null);
		}
	}

	protected void onCmbAnswerTypeValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		cmbAnswerTypeValueChanged();
		enableContextMenu();
	}

	private void cmbAnswerTypeValueChanged()
	{
		setControlsStatus();
		enableLkpControls();
		enableSeparatorText();
		enableChkMultiselect();
		enableMultiselect();
		enableChkCustomWidth();
		enableCustomWidth();
		hideColourColumn();
		
		form.chkIsMandatory().setEnabled(!(form.cmbAnswerType().getValue() instanceof QuestionAnswerType && form.cmbAnswerType().getValue().equals(QuestionAnswerType.SEPARATOR)));
		//WDEV-13768
		form.txtValidationMsg().setEnabled(!QuestionAnswerType.SEPARATOR.equals(form.cmbAnswerType().getValue()) && form.chkIsMandatory().getValue());
		
		if(form.cmbAnswerType().getValue() instanceof QuestionAnswerType && form.cmbAnswerType().getValue().equals(QuestionAnswerType.SEPARATOR))
		{
			form.chkIsMandatory().setValue(false);
			form.txtValidationMsg().setValue(null);
			
		}
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add :
				addAnswerOption();
			break;
			case GenForm.ContextMenus.GenericGrid.Remove :
				removeAnswerOption();
			break;
			case GenForm.ContextMenus.GenericGrid.MoveUp :
				moveUp();
			break;
			case GenForm.ContextMenus.GenericGrid.MoveDown :
				moveDown();
			break;
		}
	}

	protected void onBtnOkClick() throws PresentationLogicException
	{
		QuestionAnswerTypeVo voQAnswerType=null;
		
		if (form.getGlobalContext().Core.getQuestionAnswerTypeIsNotNull())
		{
			voQAnswerType = this.copy(form.getGlobalContext().Core.getQuestionAnswerType());	
		}
		for (int i=0;i<form.grdAnswerOption().getRows().size();i++)
		{
			if ((form.grdAnswerOption().getRows().get(i).getcolExtCodeType()!=null && (form.grdAnswerOption().getRows().get(i).getcolCode() == null || form.grdAnswerOption().getRows().get(i).getcolCode().length() == 0))
					|| (form.grdAnswerOption().getRows().get(i).getcolExtCodeType()==null && form.grdAnswerOption().getRows().get(i).getcolCode() != null && form.grdAnswerOption().getRows().get(i).getcolCode().length() != 0))
			{
				String errors[]={"Both fields of Taxonomy Mappings are Mandatory"};
				engine.showErrors(errors);
				return;
			}
		}
		populateDataFromScreen(voQAnswerType);
		populateDataFromAnswerOptions(voQAnswerType);
		if (isDataValid(voQAnswerType) == false)
		{
			return;
		}

		form.getGlobalContext().Core.setQuestionAnswerType(voQAnswerType);
		engine.close(DialogResult.OK);
	}
	protected QuestionAnswerTypeVo copy(QuestionAnswerTypeVo answer) { 
        try 
        { 
            ByteArrayOutputStream baostream = new ByteArrayOutputStream(); 
            ObjectOutputStream oostream = new ObjectOutputStream(baostream); 
            oostream.writeObject(answer); 
            oostream.flush(); 
            oostream.close(); 
            ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray()); 
            ObjectInputStream oistream = new ObjectInputStream(baistream); 
            QuestionAnswerTypeVo auxAnswer = (QuestionAnswerTypeVo)oistream.readObject(); 
            oistream.close();            
            return auxAnswer; 
        } 
        catch(Throwable t) 
        { 
        	String error[]={t.getMessage()};
            engine.showErrors(error);
            return null;
        } 
    } 

	protected void onFormModeChanged()
	{
		setValidationMsgState();
		enableLkpControls();
		enableSeparatorText();
		enableCustomWidth();
		enableMultiselect();
		enableAnswerType();
	}

	protected void onChkIsMandatoryValueChanged() throws PresentationLogicException
	{
		setValidationMsgState();
	}

	protected void onChkMaxMultiselectValueChanged() throws PresentationLogicException
	{
		enableMultiselect();
	}

	protected void onChkCustomWidthValueChanged() throws PresentationLogicException
	{
		enableCustomWidth();
	}

	// End Protected Methods

	// ----------------------- Private methods --------------------------
	private void populateDataFromAnswerOptions(QuestionAnswerTypeVo voQAnswerType)
	{
		AnswerOptionVoCollection voColl = new AnswerOptionVoCollection();
		for (int i = 0; i < form.grdAnswerOption().getRows().size(); i++)
		{
			grdAnswerOptionRow row = form.grdAnswerOption().getRows().get(i);
			AnswerOptionVo voAnswerOption = row.getValue() != null ? row.getValue() : new AnswerOptionVo();
			voAnswerOption.setOptionText(row.getcolOptionText());
			voAnswerOption.setOptionDescription(row.getcolOptionDesc());
			voAnswerOption.setScore(row.getcolScore());
			Object objCol = row.getcolColour();
			if (objCol instanceof Color)
				voAnswerOption.setColour((Color) objCol);
			else
				voAnswerOption.setColour(null);
			
			NonUniqueTaxonomyMapVoCollection voTaxonomyColl = new NonUniqueTaxonomyMapVoCollection();
			NonUniqueTaxonomyMapVo voTaxonomyMap = new NonUniqueTaxonomyMapVo();
			if (row.getcolExtCodeType()==null&&(row.getcolCode()==null||row.getcolCode().equals("")))
				voAnswerOption.setTaxonomyMappings(null);
			else
			{
				voTaxonomyMap.setTaxonomyName(row.getcolExtCodeType());
				voTaxonomyMap.setTaxonomyCode(row.getcolCode());
				voTaxonomyColl.add(voTaxonomyMap);
				voAnswerOption.setTaxonomyMappings(voTaxonomyColl);
			}
						
			voColl.add(voAnswerOption);
		}
		voQAnswerType.setOptions(voColl);
	}

	private NonUniqueTaxonomyMapVo getNonUniqueTaxonomyMap(ims.core.vo.TaxonomyMap map)
	{
		if(map != null)
		{
			NonUniqueTaxonomyMapVo voNonUniqueTaxonomyMap = new NonUniqueTaxonomyMapVo();
			voNonUniqueTaxonomyMap.setTaxonomyCode(map.getTaxonomyCode());
			voNonUniqueTaxonomyMap.setTaxonomyName(map.getTaxonomyName());
			return voNonUniqueTaxonomyMap;
		}
		return null;
	}

	private void clearScreenControls()
	{
		super.clearScreen();
		form.grdAnswerOption().getRows().clear();
		form.chkCustomWidth().setValue(false);
		form.chkMaxMultiselect().setValue(false);
	}

	private void open()
	{
		QuestionAnswerTypeVo voQAnswerType = form.getGlobalContext().Core.getQuestionAnswerType();

		if (voQAnswerType != null)
		{
			populateScreenFromData(voQAnswerType);
			populateAnswerOptions(voQAnswerType);
		}
		
		setAnswerTypeInitialValue();
		
		form.setMode(isDialogViewMode() ? FormMode.VIEW : FormMode.EDIT);
		cmbAnswerTypeValueChanged();
		setGridAnswerOptionStat();
		customizeScoringAssessment();
		enableContextMenu();
	}

	private void setRowData(AnswerOptionVo voAnswerOption, GenForm.grdAnswerOptionRow newRow)
	{
		if (voAnswerOption != null)
		{
			newRow.setcolOptionText(voAnswerOption.getOptionText());
			newRow.setcolOptionDesc(voAnswerOption.getOptionDescription());
			newRow.setcolScore(voAnswerOption.getScore());
			newRow.setcolColour(voAnswerOption.getColour());
			if (voAnswerOption.getTaxonomyMappingsIsNotNull() && voAnswerOption.getTaxonomyMappings().size() > 0)
			{
				setColTaxonomy(newRow, voAnswerOption.getTaxonomyMappings().get(0));
			}
			newRow.setValue(voAnswerOption);
		}
	}

	/**
	 * @param newRow
	 * @param voAnswerOption
	 */
	private void setColTaxonomy(GenForm.grdAnswerOptionRow newRow, NonUniqueTaxonomyMapVo voTaxonomyMap)
	{
		if (newRow != null && voTaxonomyMap != null)
		{
			newRow.setcolExtCodeType(voTaxonomyMap.getTaxonomyName());
			newRow.setcolCode(voTaxonomyMap.getTaxonomyCode());
			AnswerOptionVo voAnswerOption = newRow.getValue() != null ? newRow.getValue() : new AnswerOptionVo();
			NonUniqueTaxonomyMapVoCollection voTaxonomyColl = new NonUniqueTaxonomyMapVoCollection();
			voTaxonomyColl.add(voTaxonomyMap);
			voAnswerOption.setTaxonomyMappings(voTaxonomyColl);
			newRow.setValue(voAnswerOption);
		}
	}

	/**
	 * @param voTaxonomyMap
	 * @return
	 */
	private String getTaxonomyName(NonUniqueTaxonomyMapVo voTaxonomyMap)
	{
		StringBuffer name = new StringBuffer();
		if (voTaxonomyMap != null)
		{
			if (voTaxonomyMap.getTaxonomyNameIsNotNull())
			{
				name.append(voTaxonomyMap.getTaxonomyName().toString());
				name.append(voTaxonomyMap.getTaxonomyCodeIsNotNull() ? " - " : "");
			}

			if (voTaxonomyMap.getTaxonomyCodeIsNotNull())
			{
				name.append(voTaxonomyMap.getTaxonomyCode());
			}
		}
		return name.toString();
	}

	private void setContextMenu()
	{
		form.getContextMenus().getGenericGridAddItem().setText("Add Answer Option");
		form.getContextMenus().getGenericGridRemoveItem().setText("Remove Answer Option");
	}

	private void addAnswerOption()
	{
		addNewAnswerOption();
		enableContextMenu();
	}

	private void addNewAnswerOption()
	{
		GenForm.grdAnswerOptionRow row = form.grdAnswerOption().getRows().newRow(true);
		row.setReadOnly(false);
		row.setcolScoreReadOnly(!isScoringAssessmentQuestion());
		row.setcolColourReadOnly(!isColorColumnVisible());
		row.setValue(new AnswerOptionVo());
	}

	private void removeAnswerOption()
	{
		form.grdAnswerOption().removeSelectedRow();
		enableContextMenu();
	}

	private void moveDown()
	{
		form.grdAnswerOption().moveDown();
		enableContextMenu();
	}

	private void moveUp()
	{
		form.grdAnswerOption().moveUp();
		enableContextMenu();
	}

	private void enableContextMenu()
	{
		boolean editMode = form.getMode().equals(FormMode.EDIT);
		form.getContextMenus().getGenericGridAddItem().setVisible(isSingleOrMultiSelect());
		form.getContextMenus().getGenericGridRemoveItem().setVisible(editMode && form.grdAnswerOption().getSelectedRowIndex() >= 0);
		form.getContextMenus().getGenericGridMoveUpItem().setVisible(editMode && form.grdAnswerOption().canMoveCurrentUp());
		form.getContextMenus().getGenericGridMoveDownItem().setVisible(editMode && form.grdAnswerOption().canMoveCurrentDown());
	}

	private void populateAnswerOptions(QuestionAnswerTypeVo voQAnswerType)
	{
		form.grdAnswerOption().getRows().clear();
		for (int i = 0; voQAnswerType.getOptionsIsNotNull() && i < voQAnswerType.getOptions().size(); i++)
		{
			grdAnswerOptionRow row = form.grdAnswerOption().getRows().newRow();
			if (isScoringAssessmentQuestion() == false)
				row.setcolScoreReadOnly(true);
			setRowData(voQAnswerType.getOptions().get(i), row);
		}
	}

	private void setControlsStatus()
	{
		form.cmbAnswerType().setEnabled(form.getMode().equals(FormMode.EDIT));
		setGridAnswerOptionStat();
	}

	private void setGridAnswerOptionStat()
	{
		boolean gridIsEnabled = isSingleOrMultiSelect();
		form.grdAnswerOption().setReadOnly(!gridIsEnabled);
		form.grdAnswerOption().setEnabled(gridIsEnabled);
	}

	private boolean isSingleOrMultiSelect()
	{
		QuestionAnswerType answerType = form.cmbAnswerType().getValue();
		return answerType != null && (answerType.equals(QuestionAnswerType.PICKLIST) || answerType.equals(QuestionAnswerType.MULTISELECT));
	}

	private boolean isDialogViewMode()
	{
		return form.getGlobalContext().Core.getQuestionEditViewModeIsNotNull() && form.getGlobalContext().Core.getQuestionEditViewMode().booleanValue();
	}

	private void setValidationMsgState()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			boolean mandatory = form.chkIsMandatory().getValue();
			form.txtValidationMsg().setEnabled(mandatory);
			if (mandatory)
				form.txtValidationMsg().setFocus();
			else
				form.txtValidationMsg().setValue("");
		}
	}

	private void enableLkpControls()
	{
		QuestionAnswerType type = form.cmbAnswerType().getValue();
		if (type != null && (type.equals(QuestionAnswerType.PICKLIST) == true || type.equals(QuestionAnswerType.MULTISELECT)))
		{
			/*
			 * form.qmbLookupType().setEnabled(true);
			 * form.qmbLookupType().setFocus();
			 */
		}
		else
		{
			form.grdAnswerOption().getRows().clear();
		}
	}

	private void enableSeparatorText()
	{
		QuestionAnswerType type = form.cmbAnswerType().getValue();
		if (type != null && type.equals(QuestionAnswerType.SEPARATOR))
		{
			form.txtSeparator().setEnabled(form.getMode().equals(FormMode.EDIT));
			form.txtSeparator().setFocus();
		}
		else
		{
			if (form.getMode().equals(FormMode.EDIT))
				form.txtSeparator().setEnabled(false);
			form.txtSeparator().setValue("");
		}
	}

	private boolean isDataValid(QuestionAnswerTypeVo voQAnswerType)
	{
		String[] uiErrors = getUiErrors();
		String[] errors = voQAnswerType.validate(uiErrors);
		ArrayList <String> errorss=new ArrayList<String>();
		
		if (errors != null)
		{
			if (errors.length>1)
			{
				for (int i=0;i<errors.length;i++)
				{
					errorss.add(errors[i]);
				}
				for (int j=0;j<errorss.size();j++)
				{
					if (errorss.get(j).equals("TaxonomyName is mandatory")||errorss.get(j).equals("TaxonomyCode is mandatory"))
					{
						errorss.remove(j);
						j--;
					}
				}	
					
				if (errorss.size()==0)
					return true;
				else
				{
					engine.showErrors(errorss.toArray(new String[0]));
					return false;
				}
			}
			else
			{
				engine.showErrors(errors);
				return false;
			}
		}

		return true;
	}

	private String[] getUiErrors()
	{
		ArrayList errors = new ArrayList();

		Integer maxMultiSelect = form.intMaxMultiselect().getValue();
		// Max. Multiselect
		if (maxMultiSelect != null)
		{
			int answerOptionsSize = form.grdAnswerOption().getRows().size();
			if (maxMultiSelect.intValue() > answerOptionsSize)
			{
				errors.add("Max. Multiselect has an invalid value. The maximum value should be less or equal than " + answerOptionsSize + " which is the total number of Answer Options");
			}
		}

		// Separator Text
		QuestionAnswerType answerType = form.cmbAnswerType().getValue();
		if (answerType != null && answerType.equals(QuestionAnswerType.SEPARATOR))
		{
			String separatorTxt = form.txtSeparator().getValue();
			if (separatorTxt == null || separatorTxt.equals(""))
			{
				errors.add("Please enter Separator Text");
			}
		}
		
		//WDEV-1751 - if dpp is being configured and a score is associated with an answer option it's value should be 0, 1, 2. 
		if(isDpp())
		{
			for (int i = 0; i < form.grdAnswerOption().getRows().size(); i++)
			{
				grdAnswerOptionRow row = form.grdAnswerOption().getRows().get(i);
				//WDEV-3619Integer score = row.getcolScore();
				Float score = row.getcolScore();
				if(score == null || score.intValue() < 0 || score.intValue() > 2)
				{
					errors.add("Score values should be 0, 1 or 2");
				}
			}	
		}

		String[] uiErrors = new String[errors.size()];
		errors.toArray(uiErrors);
		return uiErrors;
	}

	boolean isScoringAssessmentQuestion()
	{
		QuestionType qType = form.getGlobalContext().Core.getQuestionType();
		return qType != null && qType.equals(QuestionType.SCORINGASSESSEMNTQUESTION) ? true : false;
	}

	private void customizeScoringAssessment()
	{
		if (isScoringAssessmentQuestion() == false)
		{
			// "Hide" the caption
			form.grdAnswerOption().setcolScoreCaption(" ");
		}
	}

	private void hideColourColumn()
	{
		QuestionType qType = form.getGlobalContext().Core.getQuestionType();
		if (qType != null)
		{
			QuestionAnswerType type = form.cmbAnswerType().getValue();

			if (type != null && isSingleOrMultiSelect(type))
			{
				form.grdAnswerOption().setcolColourCaption("Colour");
				setReadonlyColColour(false);
			}
			else
			{
				form.grdAnswerOption().setcolColourCaption(" ");
				setReadonlyColColour(true);
			}
		}
	}

	private void enableChkCustomWidth()
	{
		QuestionAnswerType type = form.cmbAnswerType().getValue();
		if (form.getMode().equals(FormMode.EDIT))
		{
			boolean chkCustomWidthEnable = type != null && (type.equals(QuestionAnswerType.PICKLIST) || type.equals(QuestionAnswerType.MULTISELECT) || type.equals(QuestionAnswerType.TEXT));
			form.chkCustomWidth().setEnabled(chkCustomWidthEnable);
			if (chkCustomWidthEnable == false)
				form.chkCustomWidth().setValue(false);
		}
	}

	private void enableChkMultiselect()
	{
		QuestionAnswerType type = form.cmbAnswerType().getValue();
		if (form.getMode().equals(FormMode.EDIT))
		{
			boolean chkMultiselectEnable = type != null && type.equals(QuestionAnswerType.MULTISELECT);
			form.chkMaxMultiselect().setEnabled(chkMultiselectEnable);
			if (chkMultiselectEnable == false)
				form.chkMaxMultiselect().setValue(false);
		}
	}

	private void enableCustomWidth()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			if (form.chkCustomWidth().getValue())
			{
				form.intCustomWidth().setEnabled(true);
			}
			else
			{
				form.intCustomWidth().setEnabled(false);
				form.intCustomWidth().setValue(null);
			}
		}
	}

	private void enableMultiselect()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			if (form.chkMaxMultiselect().getValue())
			{
				form.intMaxMultiselect().setEnabled(true);
			}
			else
			{
				form.intMaxMultiselect().setEnabled(false);
				form.intMaxMultiselect().setValue(null);
			}
		}
	}

	private boolean isColorColumnVisible()
	{
		QuestionAnswerType type = form.cmbAnswerType().getValue();
		if (type != null && (type.equals(QuestionAnswerType.MULTISELECT) || type.equals(QuestionAnswerType.PICKLIST)))
			return true;

		return false;
	}

	protected void populateScreenFromData(QuestionAnswerTypeVo voQAnswerType)
	{
		if (voQAnswerType.getMaxMultiselectAllowedIsNotNull())
			form.chkMaxMultiselect().setValue(true);
		if (voQAnswerType.getAnswerWidthIsNotNull())
			form.chkCustomWidth().setValue(true);
		super.populateScreenFromData(voQAnswerType);
	}

	private void setReadonlyColColour(boolean readonly)
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			for (int i = 0; i < form.grdAnswerOption().getRows().size(); i++)
			{
				form.grdAnswerOption().getRows().get(i).setcolColourReadOnly(readonly);
				if (readonly)
					form.grdAnswerOption().getRows().get(i).setcolColour(null);
			}
		}
	}

	private Integer getRowIndex(grdAnswerOptionRow row)
	{
		for (int i = 0; i < form.grdAnswerOption().getRows().size(); i++)
		{
			AnswerOptionVo voAnswerOption = form.grdAnswerOption().getRows().get(i).getValue();
			if (voAnswerOption != null && voAnswerOption.equals(row.getValue()))
				return new Integer(i);
		}
		return null;
	}

	/**
	 * @param type
	 * @return
	 */
	private boolean isSingleOrMultiSelect(QuestionAnswerType type)
	{
		return type.equals(QuestionAnswerType.MULTISELECT) || type.equals(QuestionAnswerType.PICKLIST);
	}

	private void loadColourCombo()
	{
		Color[] colours = Color.getColors();
		for (int i = 0; colours != null && i < colours.length; i++)
		{
			form.grdAnswerOption().colColourComboBox().newRow(colours[i], colours[i].getText(), colours[i].getImage());
		}
	}
	
	private boolean isDpp()
	{
		UserDefinedAssessmentType udfAssType = form.getGlobalContext().Core.getUserDefinedAssessmentType();
		return udfAssType != null && udfAssType.equals(UserDefinedAssessmentType.DPP);
	}
	
	//WDEV-1751 - looks like it's not applicable anymore. We should allow updating answer type 
	private void enableAnswerType()
	{
		/*if(isDpp())
		{
			if(form.getMode().equals(FormMode.EDIT))
				form.cmbAnswerType().setEnabled(false);
		}
		else
		{
			if(form.getMode().equals(FormMode.EDIT))
				form.cmbAnswerType().setEnabled(true);
		}*/
	}
	
	private void setAnswerTypeInitialValue()
	{
		/*if(isDpp())
		{
			QuestionAnswerTypeVo voQAnswerType = form.getGlobalContext().Core.getQuestionAnswerType();
			if(voQAnswerType == null || voQAnswerType.getID_QuestionAnswerType() == null || voQAnswerType.getAnswerType() == null)
				form.cmbAnswerType().setValue(QuestionAnswerType.MULTISELECT);
		}*/
	}
}
