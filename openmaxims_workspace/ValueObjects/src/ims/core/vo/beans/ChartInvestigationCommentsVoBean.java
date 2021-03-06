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

public class ChartInvestigationCommentsVoBean extends ims.vo.ValueObjectBean
{
	public ChartInvestigationCommentsVoBean()
	{
	}
	public ChartInvestigationCommentsVoBean(ims.core.vo.ChartInvestigationCommentsVo vo)
	{
		this.investigationname = vo.getInvestigationName();
		this.laborderno = vo.getLabOrderNo();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDate().getBean();
		this.investigationcomments = vo.getInvestigationComments() == null ? null : vo.getInvestigationComments().getBeanCollection();
		this.displayflag = vo.getDisplayFlag();
		this.investigationid = vo.getInvestigationID();
		this.isdft = vo.getIsDFT();
		this.pathologyresultid = vo.getPathologyResultId();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.ChartInvestigationCommentsVo vo)
	{
		this.investigationname = vo.getInvestigationName();
		this.laborderno = vo.getLabOrderNo();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDate().getBean();
		this.investigationcomments = vo.getInvestigationComments() == null ? null : vo.getInvestigationComments().getBeanCollection();
		this.displayflag = vo.getDisplayFlag();
		this.investigationid = vo.getInvestigationID();
		this.isdft = vo.getIsDFT();
		this.pathologyresultid = vo.getPathologyResultId();
	}

	public ims.core.vo.ChartInvestigationCommentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.ChartInvestigationCommentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.ChartInvestigationCommentsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.ChartInvestigationCommentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.ChartInvestigationCommentsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public String getInvestigationName()
	{
		return this.investigationname;
	}
	public void setInvestigationName(String value)
	{
		this.investigationname = value;
	}
	public String getLabOrderNo()
	{
		return this.laborderno;
	}
	public void setLabOrderNo(String value)
	{
		this.laborderno = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.date = value;
	}
	public ims.core.vo.beans.ChartValueCommentVoBean[] getInvestigationComments()
	{
		return this.investigationcomments;
	}
	public void setInvestigationComments(ims.core.vo.beans.ChartValueCommentVoBean[] value)
	{
		this.investigationcomments = value;
	}
	public String getDisplayFlag()
	{
		return this.displayflag;
	}
	public void setDisplayFlag(String value)
	{
		this.displayflag = value;
	}
	public Integer getInvestigationID()
	{
		return this.investigationid;
	}
	public void setInvestigationID(Integer value)
	{
		this.investigationid = value;
	}
	public Boolean getIsDFT()
	{
		return this.isdft;
	}
	public void setIsDFT(Boolean value)
	{
		this.isdft = value;
	}
	public Integer getPathologyResultId()
	{
		return this.pathologyresultid;
	}
	public void setPathologyResultId(Integer value)
	{
		this.pathologyresultid = value;
	}

	private String investigationname;
	private String laborderno;
	private ims.framework.utils.beans.DateTimeBean date;
	private ims.core.vo.beans.ChartValueCommentVoBean[] investigationcomments;
	private String displayflag;
	private Integer investigationid;
	private Boolean isdft;
	private Integer pathologyresultid;
}
