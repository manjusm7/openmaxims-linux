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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 16/04/2014, 12:31
 *
 */
package ims.generalmedical.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Kevin O'Carroll
 */
public class NeuroReflexPeripheralTestsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVo copy(ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObjectDest, ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_NeuroReflexesPeripheralFindings(valueObjectSrc.getID_NeuroReflexesPeripheralFindings());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// peripheralReflex
		valueObjectDest.setPeripheralReflex(valueObjectSrc.getPeripheralReflex());
		// rightFinding
		valueObjectDest.setRightFinding(valueObjectSrc.getRightFinding());
		// leftFinding
		valueObjectDest.setLeftFinding(valueObjectSrc.getLeftFinding());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.medical.domain.objects.NeuroReflexesPeripheralFindings objects.
	 */
	public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(java.util.Set domainObjectSet)	
	{
		return createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.medical.domain.objects.NeuroReflexesPeripheralFindings objects.
	 */
	public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voList = new ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject = (ims.medical.domain.objects.NeuroReflexesPeripheralFindings) iterator.next();
			ims.generalmedical.vo.NeuroReflexPeripheralTestsVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.medical.domain.objects.NeuroReflexesPeripheralFindings objects.
	 */
	public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(java.util.List domainObjectList) 
	{
		return createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.medical.domain.objects.NeuroReflexesPeripheralFindings objects.
	 */
	public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection createNeuroReflexPeripheralTestsVoCollectionFromNeuroReflexesPeripheralFindings(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voList = new ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject = (ims.medical.domain.objects.NeuroReflexesPeripheralFindings) domainObjectList.get(i);
			ims.generalmedical.vo.NeuroReflexPeripheralTestsVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.medical.domain.objects.NeuroReflexesPeripheralFindings set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractNeuroReflexesPeripheralFindingsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voCollection) 
	 {
	 	return extractNeuroReflexesPeripheralFindingsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractNeuroReflexesPeripheralFindingsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.generalmedical.vo.NeuroReflexPeripheralTestsVo vo = voCollection.get(i);
			ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject = NeuroReflexPeripheralTestsVoAssembler.extractNeuroReflexesPeripheralFindings(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.medical.domain.objects.NeuroReflexesPeripheralFindings list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractNeuroReflexesPeripheralFindingsList(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voCollection) 
	 {
	 	return extractNeuroReflexesPeripheralFindingsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractNeuroReflexesPeripheralFindingsList(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.generalmedical.vo.NeuroReflexPeripheralTestsVo vo = voCollection.get(i);
			ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject = NeuroReflexPeripheralTestsVoAssembler.extractNeuroReflexesPeripheralFindings(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.medical.domain.objects.NeuroReflexesPeripheralFindings object.
	 * @param domainObject ims.medical.domain.objects.NeuroReflexesPeripheralFindings
	 */
	 public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVo create(ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.medical.domain.objects.NeuroReflexesPeripheralFindings object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVo create(DomainObjectMap map, ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObject = (ims.generalmedical.vo.NeuroReflexPeripheralTestsVo) map.getValueObject(domainObject, ims.generalmedical.vo.NeuroReflexPeripheralTestsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.generalmedical.vo.NeuroReflexPeripheralTestsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.medical.domain.objects.NeuroReflexesPeripheralFindings
	 */
	 public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVo insert(ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObject, ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.medical.domain.objects.NeuroReflexesPeripheralFindings
	 */
	 public static ims.generalmedical.vo.NeuroReflexPeripheralTestsVo insert(DomainObjectMap map, ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObject, ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_NeuroReflexesPeripheralFindings(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// peripheralReflex
		ims.domain.lookups.LookupInstance instance1 = domainObject.getPeripheralReflex();
		if ( null != instance1 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance1.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance1.getImage().getImageId(), instance1.getImage().getImagePath());
			}
			color = instance1.getColor();
			if (color != null) 
				color.getValue();

			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests voLookup1 = new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(instance1.getId(),instance1.getText(), instance1.isActive(), null, img, color);
			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests parentVoLookup1 = voLookup1;
			ims.domain.lookups.LookupInstance parent1 = instance1.getParent();
			while (parent1 != null)
			{
				if (parent1.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent1.getImage().getImageId(), parent1.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent1.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup1.setParent(new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(parent1.getId(),parent1.getText(), parent1.isActive(), null, img, color));
				parentVoLookup1 = parentVoLookup1.getParent();
								parent1 = parent1.getParent();
			}			
			valueObject.setPeripheralReflex(voLookup1);
		}
				// rightFinding
		ims.domain.lookups.LookupInstance instance2 = domainObject.getRightFinding();
		if ( null != instance2 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance2.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance2.getImage().getImageId(), instance2.getImage().getImagePath());
			}
			color = instance2.getColor();
			if (color != null) 
				color.getValue();

			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests voLookup2 = new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(instance2.getId(),instance2.getText(), instance2.isActive(), null, img, color);
			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests parentVoLookup2 = voLookup2;
			ims.domain.lookups.LookupInstance parent2 = instance2.getParent();
			while (parent2 != null)
			{
				if (parent2.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent2.getImage().getImageId(), parent2.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent2.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup2.setParent(new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(parent2.getId(),parent2.getText(), parent2.isActive(), null, img, color));
				parentVoLookup2 = parentVoLookup2.getParent();
								parent2 = parent2.getParent();
			}			
			valueObject.setRightFinding(voLookup2);
		}
				// leftFinding
		ims.domain.lookups.LookupInstance instance3 = domainObject.getLeftFinding();
		if ( null != instance3 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance3.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance3.getImage().getImageId(), instance3.getImage().getImagePath());
			}
			color = instance3.getColor();
			if (color != null) 
				color.getValue();

			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests voLookup3 = new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(instance3.getId(),instance3.getText(), instance3.isActive(), null, img, color);
			ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests parentVoLookup3 = voLookup3;
			ims.domain.lookups.LookupInstance parent3 = instance3.getParent();
			while (parent3 != null)
			{
				if (parent3.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent3.getImage().getImageId(), parent3.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent3.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup3.setParent(new ims.spinalinjuries.vo.lookups.NeuroExamPeripheralTests(parent3.getId(),parent3.getText(), parent3.isActive(), null, img, color));
				parentVoLookup3 = parentVoLookup3.getParent();
								parent3 = parent3.getParent();
			}			
			valueObject.setLeftFinding(voLookup3);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.medical.domain.objects.NeuroReflexesPeripheralFindings extractNeuroReflexesPeripheralFindings(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObject) 
	{
		return 	extractNeuroReflexesPeripheralFindings(domainFactory, valueObject, new HashMap());
	}

	public static ims.medical.domain.objects.NeuroReflexesPeripheralFindings extractNeuroReflexesPeripheralFindings(ims.domain.ILightweightDomainFactory domainFactory, ims.generalmedical.vo.NeuroReflexPeripheralTestsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_NeuroReflexesPeripheralFindings();
		ims.medical.domain.objects.NeuroReflexesPeripheralFindings domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.medical.domain.objects.NeuroReflexesPeripheralFindings)domMap.get(valueObject);
			}
			// ims.generalmedical.vo.NeuroReflexPeripheralTestsVo ID_NeuroReflexesPeripheralFindings field is unknown
			domainObject = new ims.medical.domain.objects.NeuroReflexesPeripheralFindings();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_NeuroReflexesPeripheralFindings());
			if (domMap.get(key) != null)
			{
				return (ims.medical.domain.objects.NeuroReflexesPeripheralFindings)domMap.get(key);
			}
			domainObject = (ims.medical.domain.objects.NeuroReflexesPeripheralFindings) domainFactory.getDomainObject(ims.medical.domain.objects.NeuroReflexesPeripheralFindings.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_NeuroReflexesPeripheralFindings());

		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value1 = null;
		if ( null != valueObject.getPeripheralReflex() ) 
		{
			value1 =
				domainFactory.getLookupInstance(valueObject.getPeripheralReflex().getID());
		}
		domainObject.setPeripheralReflex(value1);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value2 = null;
		if ( null != valueObject.getRightFinding() ) 
		{
			value2 =
				domainFactory.getLookupInstance(valueObject.getRightFinding().getID());
		}
		domainObject.setRightFinding(value2);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value3 = null;
		if ( null != valueObject.getLeftFinding() ) 
		{
			value3 =
				domainFactory.getLookupInstance(valueObject.getLeftFinding().getID());
		}
		domainObject.setLeftFinding(value3);

		return domainObject;
	}

}
