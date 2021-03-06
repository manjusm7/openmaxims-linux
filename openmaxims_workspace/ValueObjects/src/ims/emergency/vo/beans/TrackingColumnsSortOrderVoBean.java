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

package ims.emergency.vo.beans;

public class TrackingColumnsSortOrderVoBean extends ims.vo.ValueObjectBean
{
	public TrackingColumnsSortOrderVoBean()
	{
	}
	public TrackingColumnsSortOrderVoBean(ims.emergency.vo.TrackingColumnsSortOrderVo vo)
	{
		this.sortorder = vo.getSortOrder();
		this.columntype = vo.getColumnType() == null ? null : (ims.vo.LookupInstanceBean)vo.getColumnType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TrackingColumnsSortOrderVo vo)
	{
		this.sortorder = vo.getSortOrder();
		this.columntype = vo.getColumnType() == null ? null : (ims.vo.LookupInstanceBean)vo.getColumnType().getBean();
	}

	public ims.emergency.vo.TrackingColumnsSortOrderVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TrackingColumnsSortOrderVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TrackingColumnsSortOrderVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TrackingColumnsSortOrderVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TrackingColumnsSortOrderVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Boolean getSortOrder()
	{
		return this.sortorder;
	}
	public void setSortOrder(Boolean value)
	{
		this.sortorder = value;
	}
	public ims.vo.LookupInstanceBean getColumnType()
	{
		return this.columntype;
	}
	public void setColumnType(ims.vo.LookupInstanceBean value)
	{
		this.columntype = value;
	}

	private Boolean sortorder;
	private ims.vo.LookupInstanceBean columntype;
}
