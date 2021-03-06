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

package ims.admin.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to core.clinical.coding.snomed_concept business object (ID: 1065100006).
 */
public class TaxonomySnomedConceptVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<TaxonomySnomedConceptVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<TaxonomySnomedConceptVo> col = new ArrayList<TaxonomySnomedConceptVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.coding.domain.objects.snomed_concept";
	}
	public boolean add(TaxonomySnomedConceptVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, TaxonomySnomedConceptVo value)
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
	public int indexOf(TaxonomySnomedConceptVo instance)
	{
		return col.indexOf(instance);
	}
	public TaxonomySnomedConceptVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, TaxonomySnomedConceptVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(TaxonomySnomedConceptVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(TaxonomySnomedConceptVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		TaxonomySnomedConceptVoCollection clone = new TaxonomySnomedConceptVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((TaxonomySnomedConceptVo)this.col.get(x).clone());
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
	public TaxonomySnomedConceptVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public TaxonomySnomedConceptVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public TaxonomySnomedConceptVoCollection sort(SortOrder order)
	{
		return sort(new TaxonomySnomedConceptVoComparator(order));
	}
	public TaxonomySnomedConceptVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new TaxonomySnomedConceptVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public TaxonomySnomedConceptVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.coding.vo.snomed_conceptRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.coding.vo.snomed_conceptRefVoCollection result = new ims.core.clinical.coding.vo.snomed_conceptRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public TaxonomySnomedConceptVo[] toArray()
	{
		TaxonomySnomedConceptVo[] arr = new TaxonomySnomedConceptVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<TaxonomySnomedConceptVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class TaxonomySnomedConceptVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public TaxonomySnomedConceptVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public TaxonomySnomedConceptVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public TaxonomySnomedConceptVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			TaxonomySnomedConceptVo voObj1 = (TaxonomySnomedConceptVo)obj1;
			TaxonomySnomedConceptVo voObj2 = (TaxonomySnomedConceptVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.admin.vo.beans.TaxonomySnomedConceptVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.admin.vo.beans.TaxonomySnomedConceptVoBean[] getBeanCollectionArray()
	{
		ims.admin.vo.beans.TaxonomySnomedConceptVoBean[] result = new ims.admin.vo.beans.TaxonomySnomedConceptVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			TaxonomySnomedConceptVo vo = ((TaxonomySnomedConceptVo)col.get(i));
			result[i] = (ims.admin.vo.beans.TaxonomySnomedConceptVoBean)vo.getBean();
		}
		return result;
	}
	public static TaxonomySnomedConceptVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		TaxonomySnomedConceptVoCollection coll = new TaxonomySnomedConceptVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.admin.vo.beans.TaxonomySnomedConceptVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static TaxonomySnomedConceptVoCollection buildFromBeanCollection(ims.admin.vo.beans.TaxonomySnomedConceptVoBean[] beans)
	{
		TaxonomySnomedConceptVoCollection coll = new TaxonomySnomedConceptVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
