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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.45 build 2336.15208)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.reporttemplateboref;

import ims.admin.forms.reporttemplateboref.GenForm.grdTemplatesRow;
import ims.admin.vo.ReportTemplateBoRefVo;
import ims.admin.vo.ReportTemplateBoRefVoCollection;
import ims.admin.vo.ReportTemplateVo;
import ims.admin.vo.ReportTemplateVoCollection;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.controls.TreeNode;
import ims.framework.controls.TreeNodeCollection;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	protected void onFormOpen() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	private void initialize(ReportTemplateBoRefVoCollection coll) 
	{
		form.treBOList().getNodes().clear();
		
		String[] boList = domain.listDomainObjectClasses();
		
		java.util.Arrays.sort(boList);
		
		for (int i = 0; i < boList.length; i++)
		{
			addBusinessObjectToTree(boList[i], boList[i], null, coll);
		}
		
		for (int i = 0; i < form.treBOList().getNodes().size(); i++)
		{
			form.treBOList().getNodes().get(i).setExpanded(true);
		}
		
		form.getLocalContext().setListBO(boList);
	}

	private void addBusinessObjectToTree(String fullBoName, String partialBoName, TreeNode parent, ReportTemplateBoRefVoCollection coll)
	{
		TreeNode node = null;
		String firstNode;
		String lastNodes;
		int nPos;
		
		if ((nPos = partialBoName.indexOf(".")) < 0)
		{
			//leaf
			if(parent == null)
			{
				node = form.treBOList().getNodes().add(fullBoName, partialBoName);
			}
			else
			{
				node = parent.getNodes().add(fullBoName, partialBoName);
			}
			
            node.setExpandedImage(form.getImages().Core.Object);
            node.setCollapsedImage(form.getImages().Core.Object);
            
            for (int i = 0; i < coll.size(); i++)
			{
				if(node.getValue() instanceof String && ((String)node.getValue()).equalsIgnoreCase(coll.get(i).getBusinessObj()))
				{
					TreeNode child = node.getNodes().add(coll.get(i), coll.get(i).getTemplate().getName());
					child.setExpandedImage(form.getImages().Core.Memo);
					child.setCollapsedImage(form.getImages().Core.Memo);
					
					node.setExpanded(true);
					node.setTextColor(Color.Blue);
					break;
				}
			}
		}
		else
		{
			//node
	        firstNode = partialBoName.substring(0, nPos);
	        lastNodes = partialBoName.substring(nPos + 1, partialBoName.length());
	        
	        TreeNode p = getNodeByText(parent, firstNode);
	        
	        if(p == null)
	        {
				if(parent == null)
				{
					node = form.treBOList().getNodes().add("", firstNode);
				}
				else
				{
					node = parent.getNodes().add("", firstNode);
				}

	            node.setExpandedImage(form.getImages().Core.ExpandAll);
	            node.setCollapsedImage(form.getImages().Core.ExpandAll);
				
				addBusinessObjectToTree(fullBoName, lastNodes, node, coll);
	        }
	        else
	        {
	        	addBusinessObjectToTree(fullBoName, lastNodes, p, coll);
	        }
		}
	}

	private TreeNode getNodeByText(TreeNode parent, String textNode)
	{
		TreeNodeCollection nodes = null;
		
		if(parent == null)
		{
			nodes = form.treBOList().getNodes();
		}
		else
		{
			nodes = parent.getNodes();
		}
		
		for (int i = 0; i < nodes.size(); i++)
		{
			if(nodes.get(i).getText().equals(textNode))
				return nodes.get(i); 
		}
		
		return null;
	}

	private void open()
	{
		ReportTemplateBoRefVoCollection coll = domain.listAssignedTemplates();
		initialize(coll);
		form.setMode(FormMode.VIEW);
		form.treBOList().setValue(form.getLocalContext().getLastNode());
		updateContextMenuStatus();
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(!(form.grdTemplates().getValue() instanceof ReportTemplateVo))
		{
			engine.showMessage("Please select a template !");
			return;
		}
		
		TreeNode node = form.treBOList().getSelectedNode();
		if(node == null)
		{
			engine.showMessage("Please select a business object !");
			return;
		}
		
		ReportTemplateBoRefVo boRef = null;
		
		if(node.getNodes().size() > 0)
			boRef = (ReportTemplateBoRefVo) node.getNodes().get(0).getValue(); 
		
		if (boRef == null)
			boRef = new ReportTemplateBoRefVo();
		
		boRef.setBusinessObj((String) form.treBOList().getValue());
		boRef.setTemplate((ReportTemplateVo)form.grdTemplates().getValue());
		try {
			boRef = domain.saveAssignedTemplates(boRef);
		} 
		catch (StaleObjectException e) 
		{
			engine.showMessage("Data has been modified, data was not saved.  Please re-select.");
		}
		
		form.getLocalContext().setLastNode((String) node.getValue());
		
		open();
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	protected void onTreBOListTreeViewSelectionChanged(TreeNode node) throws PresentationLogicException 
	{
		/*
		// See if there is a template associated with this business object
		ReportTemplateBoRefVo boRef = domain.getAssignedTemplate((String) node.getValue());
		if (boRef != null)	
		{
			node.setValue(boRef);
			node.setText(node.getText() + " - " + boRef.getTemplate().getName());
		}
		form.getLocalContext().setTemplateBoRef(boRef);
		*/
		
		updateContextMenuStatus();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.ReportTemplateBoRefMenu.ASSIGN :
				assignTemplate();
				break;
			case GenForm.ContextMenus.ReportTemplateBoRefMenu.UNASSIGN :
				unassignTemplate();
				break;
			default :
				break;
		}
	}

	private void assignTemplate()
	{
		form.setMode(FormMode.EDIT);
	}

	private void unassignTemplate()
	{
		TreeNode node = form.treBOList().getSelectedNode();
		
		if(node != null && node.getParent() != null)
			form.getLocalContext().setLastNode((String) node.getParent().getValue());
		
		ReportTemplateBoRefVo item = (ReportTemplateBoRefVo) form.treBOList().getValue();
		
		try
		{
			domain.removeLink(item);
			open();
		}
		catch (ForeignKeyViolationException e)
		{
			engine.showMessage("Error unassigning the template: " + e.toString());
			return;
		}
	}
	
	private void updateContextMenuStatus()
	{
		form.getContextMenus().hideAllReportTemplateBoRefMenuMenuItems();
		
		if(form.treBOList().getValue() instanceof ReportTemplateBoRefVo)
		{
			form.getContextMenus().getReportTemplateBoRefMenuUNASSIGNItem().setVisible(true);
		}
		else if(form.treBOList().getValue() instanceof String)
		{
			String val = (String) form.treBOList().getValue();
			
			if(val != null && val.length() > 0)
			{
				form.getContextMenus().getReportTemplateBoRefMenuASSIGNItem().setVisible(true);
			}
		}
	}

	protected void onImbSearchClick() throws PresentationLogicException
	{
		ReportTemplateVoCollection coll = domain.listTemplates("%" + (form.txtSearch().getValue() == null || form.txtSearch().getValue().trim().length() == 0 ? "%" : form.txtSearch().getValue()) + "%");
		form.grdTemplates().getRows().clear();
		GenForm.grdTemplatesRow row;
		for (int i=0; i<coll.size(); i++)
		{
			ReportTemplateVo vo = coll.get(i);
			
			grdTemplatesRow parentRow = form.grdTemplates().getRowByValue(vo.getReport());
			
			if(parentRow == null)
			{
				parentRow = form.grdTemplates().getRows().newRow();
				parentRow.setValue(vo.getReport());
				parentRow.setTemplateName(vo.getReport().getReportName());
			}
			
			row = parentRow.getRows().newRow();
			row.setValue(vo);
			row.setTemplateName(vo.getName());
			row.setSelectedImage(form.getImages().Core.Memo);
			row.setCollapsedImage(form.getImages().Core.Memo);
			row.setExpandedImage(form.getImages().Core.Memo);
		}
		
		for (int i = 0; i < form.grdTemplates().getRows().size(); i++)
		{
			form.grdTemplates().getRows().get(i).setExpanded(true);
		}
	}

	protected void onImbFindBOClick() throws PresentationLogicException
	{
		if(form.txtFindBO().getValue() == null || form.txtFindBO().getValue().length() == 0)
			return;
		
		String[] boList = form.getLocalContext().getListBO();
		
		int index = 0;
		if(form.getLocalContext().getLastBOIndexIsNotNull())
			index = form.getLocalContext().getLastBOIndex().intValue();
		
		if(index >= boList.length)
			index = 0;

		int nPos;
		String shortName = null;
		boolean bFound = false;

		for (int i = index; i < boList.length; i++)
		{
			if ((nPos = boList[i].lastIndexOf(".")) >= 0)
			{
		        shortName = boList[i].substring(nPos + 1, boList[i].length());
			}
			else
			{
				shortName = boList[i];
			}

			if(shortName.toUpperCase().indexOf(form.txtFindBO().getValue().toUpperCase()) >= 0)
			{
				form.treBOList().setValue(boList[i]);
				form.getLocalContext().setLastBOIndex(new Integer(i+1));
				bFound = true;
				break;
			}
		}
		
		if(bFound == false)
		{
			for (int i = 0; i < index; i++)
			{
				if ((nPos = boList[i].lastIndexOf(".")) >= 0)
				{
			        shortName = boList[i].substring(nPos + 1, boList[i].length());
				}
				else
				{
					shortName = boList[i];
				}

				if(shortName.toUpperCase().indexOf(form.txtFindBO().getValue().toUpperCase()) >= 0)
				{
					form.treBOList().setValue(boList[i]);
					form.getLocalContext().setLastBOIndex(new Integer(i+1));
					bFound = true;
					break;
				}
			}
		}
		
		updateContextMenuStatus();
	}
}
