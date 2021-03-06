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

package ims.core.vo.beans;

public class ChartSpecimenCommentsVoBean extends ims.vo.ValueObjectBean
{
	public ChartSpecimenCommentsVoBean()
	{
	}
	public ChartSpecimenCommentsVoBean(ims.core.vo.ChartSpecimenCommentsVo vo)
	{
		this.specimentype = vo.getSpecimenType();
		this.specimencomments = vo.getSpecimenComments() == null ? null : vo.getSpecimenComments().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ChartSpecimenCommentsVo vo)
	{
		this.specimentype = vo.getSpecimenType();
		this.specimencomments = vo.getSpecimenComments() == null ? null : vo.getSpecimenComments().getBeanCollection();
	}

	public ims.core.vo.ChartSpecimenCommentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ChartSpecimenCommentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ChartSpecimenCommentsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ChartSpecimenCommentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ChartSpecimenCommentsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getSpecimenType()
	{
		return this.specimentype;
	}
	public void setSpecimenType(String value)
	{
		this.specimentype = value;
	}
	public ims.core.vo.beans.ChartValueCommentVoBean[] getSpecimenComments()
	{
		return this.specimencomments;
	}
	public void setSpecimenComments(ims.core.vo.beans.ChartValueCommentVoBean[] value)
	{
		this.specimencomments = value;
	}

	private String specimentype;
	private ims.core.vo.beans.ChartValueCommentVoBean[] specimencomments;
}
