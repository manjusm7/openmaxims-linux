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

package ims.core.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class YesNoUnknown extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public YesNoUnknown()
	{
		super();
	}
	public YesNoUnknown(int id)
	{
		super(id, "", true);
	}
	public YesNoUnknown(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public YesNoUnknown(int id, String text, boolean active, YesNoUnknown parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public YesNoUnknown(int id, String text, boolean active, YesNoUnknown parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public YesNoUnknown(int id, String text, boolean active, YesNoUnknown parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static YesNoUnknown buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new YesNoUnknown(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (YesNoUnknown)super.getParentInstance();
	}
	public YesNoUnknown getParent()
	{
		return (YesNoUnknown)super.getParentInstance();
	}
	public void setParent(YesNoUnknown parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		YesNoUnknown[] typedChildren = new YesNoUnknown[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (YesNoUnknown)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof YesNoUnknown)
		{
			super.addChild((YesNoUnknown)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof YesNoUnknown)
		{
			super.removeChild((YesNoUnknown)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		YesNoUnknownCollection result = new YesNoUnknownCollection();
		result.add(YES);
		result.add(NO);
		result.add(UNKNOWN);
		return result;
	}
	public static YesNoUnknown[] getNegativeInstances()
	{
		YesNoUnknown[] instances = new YesNoUnknown[3];
		instances[0] = YES;
		instances[1] = NO;
		instances[2] = UNKNOWN;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "YES";
		negativeInstances[1] = "NO";
		negativeInstances[2] = "UNKNOWN";
		return negativeInstances;
	}
	public static YesNoUnknown getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static YesNoUnknown getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		YesNoUnknown[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1021014;
	public static final YesNoUnknown YES = new YesNoUnknown(-12, "Yes", true, null, new ims.framework.utils.ImagePath(102101, "Images/Core/answer_yes.png"), Color.Black);
	public static final YesNoUnknown NO = new YesNoUnknown(-127, "No", true, null, new ims.framework.utils.ImagePath(102100, "Images/Core/answer_no.png"), Color.Black);
	public static final YesNoUnknown UNKNOWN = new YesNoUnknown(-13, "Unknown", true, null, new ims.framework.utils.ImagePath(102102, "Images/Core/AnswerBox_Unknown.gif"), Color.Black);
}
