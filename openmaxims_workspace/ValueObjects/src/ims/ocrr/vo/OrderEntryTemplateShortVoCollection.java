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

package ims.ocrr.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.Configuration.OrderEntryTemplate business object (ID: 1061100005).
 */
public class OrderEntryTemplateShortVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<OrderEntryTemplateShortVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<OrderEntryTemplateShortVo> col = new ArrayList<OrderEntryTemplateShortVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.configuration.domain.objects.OrderEntryTemplate";
	}
	public boolean add(OrderEntryTemplateShortVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, OrderEntryTemplateShortVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(OrderEntryTemplateShortVo instance)
	{
		return col.indexOf(instance);
	}
	public OrderEntryTemplateShortVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, OrderEntryTemplateShortVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(OrderEntryTemplateShortVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(OrderEntryTemplateShortVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		OrderEntryTemplateShortVoCollection clone = new OrderEntryTemplateShortVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((OrderEntryTemplateShortVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public OrderEntryTemplateShortVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public OrderEntryTemplateShortVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public OrderEntryTemplateShortVoCollection sort(SortOrder order)
	{
		return sort(new OrderEntryTemplateShortVoComparator(order));
	}
	public OrderEntryTemplateShortVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new OrderEntryTemplateShortVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public OrderEntryTemplateShortVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.configuration.vo.OrderEntryTemplateRefVoCollection toRefVoCollection()
	{
		ims.ocrr.configuration.vo.OrderEntryTemplateRefVoCollection result = new ims.ocrr.configuration.vo.OrderEntryTemplateRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public OrderEntryTemplateShortVo[] toArray()
	{
		OrderEntryTemplateShortVo[] arr = new OrderEntryTemplateShortVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<OrderEntryTemplateShortVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class OrderEntryTemplateShortVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public OrderEntryTemplateShortVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public OrderEntryTemplateShortVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public OrderEntryTemplateShortVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			OrderEntryTemplateShortVo voObj1 = (OrderEntryTemplateShortVo)obj1;
			OrderEntryTemplateShortVo voObj2 = (OrderEntryTemplateShortVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean[] result = new ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			OrderEntryTemplateShortVo vo = ((OrderEntryTemplateShortVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean)vo.getBean();
		}
		return result;
	}
	public static OrderEntryTemplateShortVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		OrderEntryTemplateShortVoCollection coll = new OrderEntryTemplateShortVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static OrderEntryTemplateShortVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.OrderEntryTemplateShortVoBean[] beans)
	{
		OrderEntryTemplateShortVoCollection coll = new OrderEntryTemplateShortVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
