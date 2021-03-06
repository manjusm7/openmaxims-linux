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

package ims.careuk.vo.beans;

public class ReviewPatientElectiveListVoBean extends ims.vo.ValueObjectBean
{
	public ReviewPatientElectiveListVoBean()
	{
	}
	public ReviewPatientElectiveListVoBean(ims.careuk.vo.ReviewPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reviewtype = vo.getReviewType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReviewType().getBean();
		this.reviewnotes = vo.getReviewNotes();
		this.revieweddate = vo.getReviewedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewedDate().getBean();
		this.reviewedby = vo.getReviewedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getReviewedBy().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.careuk.vo.ReviewPatientElectiveListVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.reviewtype = vo.getReviewType() == null ? null : (ims.vo.LookupInstanceBean)vo.getReviewType().getBean();
		this.reviewnotes = vo.getReviewNotes();
		this.revieweddate = vo.getReviewedDate() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReviewedDate().getBean();
		this.reviewedby = vo.getReviewedBy() == null ? null : (ims.core.vo.beans.MemberOfStaffLiteVoBean)vo.getReviewedBy().getBean(map);
	}

	public ims.careuk.vo.ReviewPatientElectiveListVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.careuk.vo.ReviewPatientElectiveListVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.careuk.vo.ReviewPatientElectiveListVo vo = null;
		if(map != null)
			vo = (ims.careuk.vo.ReviewPatientElectiveListVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.careuk.vo.ReviewPatientElectiveListVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getReviewType()
	{
		return this.reviewtype;
	}
	public void setReviewType(ims.vo.LookupInstanceBean value)
	{
		this.reviewtype = value;
	}
	public String getReviewNotes()
	{
		return this.reviewnotes;
	}
	public void setReviewNotes(String value)
	{
		this.reviewnotes = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReviewedDate()
	{
		return this.revieweddate;
	}
	public void setReviewedDate(ims.framework.utils.beans.DateTimeBean value)
	{
		this.revieweddate = value;
	}
	public ims.core.vo.beans.MemberOfStaffLiteVoBean getReviewedBy()
	{
		return this.reviewedby;
	}
	public void setReviewedBy(ims.core.vo.beans.MemberOfStaffLiteVoBean value)
	{
		this.reviewedby = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean reviewtype;
	private String reviewnotes;
	private ims.framework.utils.beans.DateTimeBean revieweddate;
	private ims.core.vo.beans.MemberOfStaffLiteVoBean reviewedby;
}
