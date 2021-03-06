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

package ims.core.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.patient.Patient business object (ID: 1001100000).
 */
public class PatientLiteSTHKEdischargeListVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PatientLiteSTHKEdischargeListVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PatientLiteSTHKEdischargeListVo> col = new ArrayList<PatientLiteSTHKEdischargeListVo>();
	public String getBoClassName()
	{
		return "ims.core.patient.domain.objects.Patient";
	}
	public boolean add(PatientLiteSTHKEdischargeListVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PatientLiteSTHKEdischargeListVo value)
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
	public int indexOf(PatientLiteSTHKEdischargeListVo instance)
	{
		return col.indexOf(instance);
	}
	public PatientLiteSTHKEdischargeListVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PatientLiteSTHKEdischargeListVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PatientLiteSTHKEdischargeListVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PatientLiteSTHKEdischargeListVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PatientLiteSTHKEdischargeListVoCollection clone = new PatientLiteSTHKEdischargeListVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PatientLiteSTHKEdischargeListVo)this.col.get(x).clone());
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
	public PatientLiteSTHKEdischargeListVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PatientLiteSTHKEdischargeListVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PatientLiteSTHKEdischargeListVoCollection sort(SortOrder order)
	{
		return sort(new PatientLiteSTHKEdischargeListVoComparator(order));
	}
	public PatientLiteSTHKEdischargeListVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PatientLiteSTHKEdischargeListVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PatientLiteSTHKEdischargeListVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.patient.vo.PatientRefVoCollection toRefVoCollection()
	{
		ims.core.patient.vo.PatientRefVoCollection result = new ims.core.patient.vo.PatientRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PatientLiteSTHKEdischargeListVo[] toArray()
	{
		PatientLiteSTHKEdischargeListVo[] arr = new PatientLiteSTHKEdischargeListVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PatientLiteSTHKEdischargeListVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PatientLiteSTHKEdischargeListVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PatientLiteSTHKEdischargeListVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PatientLiteSTHKEdischargeListVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PatientLiteSTHKEdischargeListVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PatientLiteSTHKEdischargeListVo voObj1 = (PatientLiteSTHKEdischargeListVo)obj1;
			PatientLiteSTHKEdischargeListVo voObj2 = (PatientLiteSTHKEdischargeListVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean[] getBeanCollectionArray()
	{
		ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean[] result = new ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PatientLiteSTHKEdischargeListVo vo = ((PatientLiteSTHKEdischargeListVo)col.get(i));
			result[i] = (ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean)vo.getBean();
		}
		return result;
	}
	public static PatientLiteSTHKEdischargeListVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PatientLiteSTHKEdischargeListVoCollection coll = new PatientLiteSTHKEdischargeListVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PatientLiteSTHKEdischargeListVoCollection buildFromBeanCollection(ims.core.vo.beans.PatientLiteSTHKEdischargeListVoBean[] beans)
	{
		PatientLiteSTHKEdischargeListVoCollection coll = new PatientLiteSTHKEdischargeListVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
