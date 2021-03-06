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
 * Generated on 16/04/2014, 12:32
 *
 */
package ims.careuk.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Rory Fitzpatrick
 */
public class ReferralCodingItemVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.careuk.vo.ReferralCodingItemVo copy(ims.careuk.vo.ReferralCodingItemVo valueObjectDest, ims.careuk.vo.ReferralCodingItemVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ReferralCodingItem(valueObjectSrc.getID_ReferralCodingItem());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// PatientProcedure
		valueObjectDest.setPatientProcedure(valueObjectSrc.getPatientProcedure());
		// PatientDiagnosis
		valueObjectDest.setPatientDiagnosis(valueObjectSrc.getPatientDiagnosis());
		// OPCS4
		valueObjectDest.setOPCS4(valueObjectSrc.getOPCS4());
		// ICD10
		valueObjectDest.setICD10(valueObjectSrc.getICD10());
		// ProcLaterality
		valueObjectDest.setProcLaterality(valueObjectSrc.getProcLaterality());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createReferralCodingItemVoCollectionFromReferralCodingItem(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralCodingItem objects.
	 */
	public static ims.careuk.vo.ReferralCodingItemVoCollection createReferralCodingItemVoCollectionFromReferralCodingItem(java.util.Set domainObjectSet)	
	{
		return createReferralCodingItemVoCollectionFromReferralCodingItem(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.careuk.domain.objects.ReferralCodingItem objects.
	 */
	public static ims.careuk.vo.ReferralCodingItemVoCollection createReferralCodingItemVoCollectionFromReferralCodingItem(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.careuk.vo.ReferralCodingItemVoCollection voList = new ims.careuk.vo.ReferralCodingItemVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.careuk.domain.objects.ReferralCodingItem domainObject = (ims.careuk.domain.objects.ReferralCodingItem) iterator.next();
			ims.careuk.vo.ReferralCodingItemVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralCodingItem objects.
	 */
	public static ims.careuk.vo.ReferralCodingItemVoCollection createReferralCodingItemVoCollectionFromReferralCodingItem(java.util.List domainObjectList) 
	{
		return createReferralCodingItemVoCollectionFromReferralCodingItem(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.careuk.domain.objects.ReferralCodingItem objects.
	 */
	public static ims.careuk.vo.ReferralCodingItemVoCollection createReferralCodingItemVoCollectionFromReferralCodingItem(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.careuk.vo.ReferralCodingItemVoCollection voList = new ims.careuk.vo.ReferralCodingItemVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.careuk.domain.objects.ReferralCodingItem domainObject = (ims.careuk.domain.objects.ReferralCodingItem) domainObjectList.get(i);
			ims.careuk.vo.ReferralCodingItemVo vo = create(map, domainObject);

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
	 * Create the ims.careuk.domain.objects.ReferralCodingItem set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractReferralCodingItemSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVoCollection voCollection) 
	 {
	 	return extractReferralCodingItemSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractReferralCodingItemSet(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralCodingItemVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralCodingItem domainObject = ReferralCodingItemVoAssembler.extractReferralCodingItem(domainFactory, vo, domMap);

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
	 * Create the ims.careuk.domain.objects.ReferralCodingItem list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractReferralCodingItemList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVoCollection voCollection) 
	 {
	 	return extractReferralCodingItemList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractReferralCodingItemList(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.careuk.vo.ReferralCodingItemVo vo = voCollection.get(i);
			ims.careuk.domain.objects.ReferralCodingItem domainObject = ReferralCodingItemVoAssembler.extractReferralCodingItem(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.careuk.domain.objects.ReferralCodingItem object.
	 * @param domainObject ims.careuk.domain.objects.ReferralCodingItem
	 */
	 public static ims.careuk.vo.ReferralCodingItemVo create(ims.careuk.domain.objects.ReferralCodingItem domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.careuk.domain.objects.ReferralCodingItem object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.careuk.vo.ReferralCodingItemVo create(DomainObjectMap map, ims.careuk.domain.objects.ReferralCodingItem domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.careuk.vo.ReferralCodingItemVo valueObject = (ims.careuk.vo.ReferralCodingItemVo) map.getValueObject(domainObject, ims.careuk.vo.ReferralCodingItemVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.careuk.vo.ReferralCodingItemVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.careuk.domain.objects.ReferralCodingItem
	 */
	 public static ims.careuk.vo.ReferralCodingItemVo insert(ims.careuk.vo.ReferralCodingItemVo valueObject, ims.careuk.domain.objects.ReferralCodingItem domainObject) 
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
	 * @param domainObject ims.careuk.domain.objects.ReferralCodingItem
	 */
	 public static ims.careuk.vo.ReferralCodingItemVo insert(DomainObjectMap map, ims.careuk.vo.ReferralCodingItemVo valueObject, ims.careuk.domain.objects.ReferralCodingItem domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ReferralCodingItem(domainObject.getId());
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
			
		// PatientProcedure
		valueObject.setPatientProcedure(ims.core.vo.domain.PatientProcedureShortWithCareIntraOperativeVoAssembler.create(map, domainObject.getPatientProcedure()) );
		// PatientDiagnosis
		valueObject.setPatientDiagnosis(ims.core.vo.domain.PatientDiagnosisShortVoAssembler.create(map, domainObject.getPatientDiagnosis()) );
		// OPCS4
		valueObject.setOPCS4(domainObject.getOPCS4());
		// ICD10
		valueObject.setICD10(domainObject.getICD10());
		// ProcLaterality
		ims.domain.lookups.LookupInstance instance5 = domainObject.getProcLaterality();
		if ( null != instance5 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance5.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance5.getImage().getImageId(), instance5.getImage().getImagePath());
			}
			color = instance5.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.LateralityLRB voLookup5 = new ims.core.vo.lookups.LateralityLRB(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.core.vo.lookups.LateralityLRB parentVoLookup5 = voLookup5;
			ims.domain.lookups.LookupInstance parent5 = instance5.getParent();
			while (parent5 != null)
			{
				if (parent5.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent5.getImage().getImageId(), parent5.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent5.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup5.setParent(new ims.core.vo.lookups.LateralityLRB(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setProcLaterality(voLookup5);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.careuk.domain.objects.ReferralCodingItem extractReferralCodingItem(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVo valueObject) 
	{
		return 	extractReferralCodingItem(domainFactory, valueObject, new HashMap());
	}

	public static ims.careuk.domain.objects.ReferralCodingItem extractReferralCodingItem(ims.domain.ILightweightDomainFactory domainFactory, ims.careuk.vo.ReferralCodingItemVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ReferralCodingItem();
		ims.careuk.domain.objects.ReferralCodingItem domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.careuk.domain.objects.ReferralCodingItem)domMap.get(valueObject);
			}
			// ims.careuk.vo.ReferralCodingItemVo ID_ReferralCodingItem field is unknown
			domainObject = new ims.careuk.domain.objects.ReferralCodingItem();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ReferralCodingItem());
			if (domMap.get(key) != null)
			{
				return (ims.careuk.domain.objects.ReferralCodingItem)domMap.get(key);
			}
			domainObject = (ims.careuk.domain.objects.ReferralCodingItem) domainFactory.getDomainObject(ims.careuk.domain.objects.ReferralCodingItem.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ReferralCodingItem());

	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.PatientProcedure value1 = null;
		if ( null != valueObject.getPatientProcedure() ) 
		{
			if (valueObject.getPatientProcedure().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatientProcedure()) != null)
				{
					value1 = (ims.core.clinical.domain.objects.PatientProcedure)domMap.get(valueObject.getPatientProcedure());
				}
			}
			else
			{
				value1 = (ims.core.clinical.domain.objects.PatientProcedure)domainFactory.getDomainObject(ims.core.clinical.domain.objects.PatientProcedure.class, valueObject.getPatientProcedure().getBoId());
			}
		}
		domainObject.setPatientProcedure(value1);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.clinical.domain.objects.PatientDiagnosis value2 = null;
		if ( null != valueObject.getPatientDiagnosis() ) 
		{
			if (valueObject.getPatientDiagnosis().getBoId() == null)
			{
				if (domMap.get(valueObject.getPatientDiagnosis()) != null)
				{
					value2 = (ims.core.clinical.domain.objects.PatientDiagnosis)domMap.get(valueObject.getPatientDiagnosis());
				}
			}
			else
			{
				value2 = (ims.core.clinical.domain.objects.PatientDiagnosis)domainFactory.getDomainObject(ims.core.clinical.domain.objects.PatientDiagnosis.class, valueObject.getPatientDiagnosis().getBoId());
			}
		}
		domainObject.setPatientDiagnosis(value2);
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getOPCS4() != null && valueObject.getOPCS4().equals(""))
		{
			valueObject.setOPCS4(null);
		}
		domainObject.setOPCS4(valueObject.getOPCS4());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getICD10() != null && valueObject.getICD10().equals(""))
		{
			valueObject.setICD10(null);
		}
		domainObject.setICD10(valueObject.getICD10());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getProcLaterality() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getProcLaterality().getID());
		}
		domainObject.setProcLaterality(value5);

		return domainObject;
	}

}
