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
package ims.ocrr.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Marius Mihalec
 */
public class PathologyResultListShortVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.ocrr.vo.PathologyResultListShortVo copy(ims.ocrr.vo.PathologyResultListShortVo valueObjectDest, ims.ocrr.vo.PathologyResultListShortVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_OrderInvestigation(valueObjectSrc.getID_OrderInvestigation());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Investigation
		valueObjectDest.setInvestigation(valueObjectSrc.getInvestigation());
		// OrderDetails
		valueObjectDest.setOrderDetails(valueObjectSrc.getOrderDetails());
		// ResultDemographics
		valueObjectDest.setResultDemographics(valueObjectSrc.getResultDemographics());
		// DisplayDateTime
		valueObjectDest.setDisplayDateTime(valueObjectSrc.getDisplayDateTime());
		// ResultStatus
		valueObjectDest.setResultStatus(valueObjectSrc.getResultStatus());
		// DisplayFlag
		valueObjectDest.setDisplayFlag(valueObjectSrc.getDisplayFlag());
		// OrdInvCurrentStatus
		valueObjectDest.setOrdInvCurrentStatus(valueObjectSrc.getOrdInvCurrentStatus());
		// Specimen
		valueObjectDest.setSpecimen(valueObjectSrc.getSpecimen());
		// RepDateTime
		valueObjectDest.setRepDateTime(valueObjectSrc.getRepDateTime());
		// DisplayTimeSupplied
		valueObjectDest.setDisplayTimeSupplied(valueObjectSrc.getDisplayTimeSupplied());
		// ResultSpecimenType
		valueObjectDest.setResultSpecimenType(valueObjectSrc.getResultSpecimenType());
		// ResultDetails
		valueObjectDest.setResultDetails(valueObjectSrc.getResultDetails());
		// PlacerOrdNum
		valueObjectDest.setPlacerOrdNum(valueObjectSrc.getPlacerOrdNum());
		// AllocatedHCPforReview
		valueObjectDest.setAllocatedHCPforReview(valueObjectSrc.getAllocatedHCPforReview());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createPathologyResultListShortVoCollectionFromOrderInvestigation(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.PathologyResultListShortVoCollection createPathologyResultListShortVoCollectionFromOrderInvestigation(java.util.Set domainObjectSet)	
	{
		return createPathologyResultListShortVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.PathologyResultListShortVoCollection createPathologyResultListShortVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.ocrr.vo.PathologyResultListShortVoCollection voList = new ims.ocrr.vo.PathologyResultListShortVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) iterator.next();
			ims.ocrr.vo.PathologyResultListShortVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.PathologyResultListShortVoCollection createPathologyResultListShortVoCollectionFromOrderInvestigation(java.util.List domainObjectList) 
	{
		return createPathologyResultListShortVoCollectionFromOrderInvestigation(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.ocrr.orderingresults.domain.objects.OrderInvestigation objects.
	 */
	public static ims.ocrr.vo.PathologyResultListShortVoCollection createPathologyResultListShortVoCollectionFromOrderInvestigation(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.ocrr.vo.PathologyResultListShortVoCollection voList = new ims.ocrr.vo.PathologyResultListShortVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainObjectList.get(i);
			ims.ocrr.vo.PathologyResultListShortVo vo = create(map, domainObject);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractOrderInvestigationSet(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.PathologyResultListShortVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = PathologyResultListShortVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ims.ocrr.orderingresults.domain.objects.OrderInvestigation list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVoCollection voCollection) 
	 {
	 	return extractOrderInvestigationList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractOrderInvestigationList(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.ocrr.vo.PathologyResultListShortVo vo = voCollection.get(i);
			ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = PathologyResultListShortVoAssembler.extractOrderInvestigation(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.PathologyResultListShortVo create(ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.ocrr.orderingresults.domain.objects.OrderInvestigation object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.ocrr.vo.PathologyResultListShortVo create(DomainObjectMap map, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.ocrr.vo.PathologyResultListShortVo valueObject = (ims.ocrr.vo.PathologyResultListShortVo) map.getValueObject(domainObject, ims.ocrr.vo.PathologyResultListShortVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.ocrr.vo.PathologyResultListShortVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.PathologyResultListShortVo insert(ims.ocrr.vo.PathologyResultListShortVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
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
	 * @param domainObject ims.ocrr.orderingresults.domain.objects.OrderInvestigation
	 */
	 public static ims.ocrr.vo.PathologyResultListShortVo insert(DomainObjectMap map, ims.ocrr.vo.PathologyResultListShortVo valueObject, ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_OrderInvestigation(domainObject.getId());
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
			
		// Investigation
		valueObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.create(map, domainObject.getInvestigation()) );
		// OrderDetails
		valueObject.setOrderDetails(ims.ocrr.vo.domain.OcsOrderShortVoAssembler.create(map, domainObject.getOrderDetails()) );
		// ResultDemographics
		valueObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.create(map, domainObject.getResultDemographics()) );
		// DisplayDateTime
		java.util.Date DisplayDateTime = domainObject.getDisplayDateTime();
		if ( null != DisplayDateTime ) 
		{
			valueObject.setDisplayDateTime(new ims.framework.utils.DateTime(DisplayDateTime) );
		}
		// ResultStatus
		ims.domain.lookups.LookupInstance instance5 = domainObject.getResultStatus();
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

			ims.ocrr.vo.lookups.ResultStatus voLookup5 = new ims.ocrr.vo.lookups.ResultStatus(instance5.getId(),instance5.getText(), instance5.isActive(), null, img, color);
			ims.ocrr.vo.lookups.ResultStatus parentVoLookup5 = voLookup5;
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
								parentVoLookup5.setParent(new ims.ocrr.vo.lookups.ResultStatus(parent5.getId(),parent5.getText(), parent5.isActive(), null, img, color));
				parentVoLookup5 = parentVoLookup5.getParent();
								parent5 = parent5.getParent();
			}			
			valueObject.setResultStatus(voLookup5);
		}
				// DisplayFlag
		ims.domain.lookups.LookupInstance instance6 = domainObject.getDisplayFlag();
		if ( null != instance6 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance6.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance6.getImage().getImageId(), instance6.getImage().getImagePath());
			}
			color = instance6.getColor();
			if (color != null) 
				color.getValue();

			ims.ocrr.vo.lookups.OcsDisplayFlag voLookup6 = new ims.ocrr.vo.lookups.OcsDisplayFlag(instance6.getId(),instance6.getText(), instance6.isActive(), null, img, color);
			ims.ocrr.vo.lookups.OcsDisplayFlag parentVoLookup6 = voLookup6;
			ims.domain.lookups.LookupInstance parent6 = instance6.getParent();
			while (parent6 != null)
			{
				if (parent6.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent6.getImage().getImageId(), parent6.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent6.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup6.setParent(new ims.ocrr.vo.lookups.OcsDisplayFlag(parent6.getId(),parent6.getText(), parent6.isActive(), null, img, color));
				parentVoLookup6 = parentVoLookup6.getParent();
								parent6 = parent6.getParent();
			}			
			valueObject.setDisplayFlag(voLookup6);
		}
				// OrdInvCurrentStatus
		valueObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusVoAssembler.create(map, domainObject.getOrdInvCurrentStatus()) );
		// Specimen
		valueObject.setSpecimen(ims.ocrr.vo.domain.PathologySpecimenLiteVoAssembler.createPathologySpecimenLiteVoCollectionFromOrderSpecimen(map, domainObject.getSpecimen()) );
		// RepDateTime
		java.util.Date RepDateTime = domainObject.getRepDateTime();
		if ( null != RepDateTime ) 
		{
			valueObject.setRepDateTime(new ims.framework.utils.DateTime(RepDateTime) );
		}
		// DisplayTimeSupplied
		valueObject.setDisplayTimeSupplied( domainObject.isDisplayTimeSupplied() );
		// ResultSpecimenType
		ims.domain.lookups.LookupInstance instance11 = domainObject.getResultSpecimenType();
		if ( null != instance11 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance11.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance11.getImage().getImageId(), instance11.getImage().getImagePath());
			}
			color = instance11.getColor();
			if (color != null) 
				color.getValue();

			ims.vo.LookupInstVo voLookup11 = new ims.vo.LookupInstVo(instance11.getId(),instance11.getText(), instance11.isActive(), null, img, color);
			ims.vo.LookupInstVo parentVoLookup11 = voLookup11;
			ims.domain.lookups.LookupInstance parent11 = instance11.getParent();
			while (parent11 != null)
			{
				if (parent11.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent11.getImage().getImageId(), parent11.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent11.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup11.setParentInstance(new ims.vo.LookupInstVo(parent11.getId(),parent11.getText(), parent11.isActive(), null, img, color));
				parentVoLookup11 = parentVoLookup11.getParentInstance();
								parent11 = parent11.getParent();
			}			
			valueObject.setResultSpecimenType(voLookup11);
		}
				// ResultDetails
		valueObject.setResultDetails(ims.ocrr.vo.domain.ResultDetailsForPathologyResultListShortVoAssembler.create(map, domainObject.getResultDetails()) );
		// PlacerOrdNum
		valueObject.setPlacerOrdNum(domainObject.getPlacerOrdNum());
		// AllocatedHCPforReview
		valueObject.setAllocatedHCPforReview(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getAllocatedHCPforReview()) );
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVo valueObject) 
	{
		return 	extractOrderInvestigation(domainFactory, valueObject, new HashMap());
	}

	public static ims.ocrr.orderingresults.domain.objects.OrderInvestigation extractOrderInvestigation(ims.domain.ILightweightDomainFactory domainFactory, ims.ocrr.vo.PathologyResultListShortVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_OrderInvestigation();
		ims.ocrr.orderingresults.domain.objects.OrderInvestigation domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(valueObject);
			}
			// ims.ocrr.vo.PathologyResultListShortVo ID_OrderInvestigation field is unknown
			domainObject = new ims.ocrr.orderingresults.domain.objects.OrderInvestigation();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_OrderInvestigation());
			if (domMap.get(key) != null)
			{
				return (ims.ocrr.orderingresults.domain.objects.OrderInvestigation)domMap.get(key);
			}
			domainObject = (ims.ocrr.orderingresults.domain.objects.OrderInvestigation) domainFactory.getDomainObject(ims.ocrr.orderingresults.domain.objects.OrderInvestigation.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_OrderInvestigation());

		domainObject.setInvestigation(ims.ocrr.vo.domain.NewResultInvestigationVoAssembler.extractInvestigation(domainFactory, valueObject.getInvestigation(), domMap));
		domainObject.setOrderDetails(ims.ocrr.vo.domain.OcsOrderShortVoAssembler.extractOcsOrderSession(domainFactory, valueObject.getOrderDetails(), domMap));
		domainObject.setResultDemographics(ims.ocrr.vo.domain.ResultDemographicsVoAssembler.extractMinDemographics(domainFactory, valueObject.getResultDemographics(), domMap));
		ims.framework.utils.DateTime dateTime4 = valueObject.getDisplayDateTime();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setDisplayDateTime(value4);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value5 = null;
		if ( null != valueObject.getResultStatus() ) 
		{
			value5 =
				domainFactory.getLookupInstance(valueObject.getResultStatus().getID());
		}
		domainObject.setResultStatus(value5);
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value6 = null;
		if ( null != valueObject.getDisplayFlag() ) 
		{
			value6 =
				domainFactory.getLookupInstance(valueObject.getDisplayFlag().getID());
		}
		domainObject.setDisplayFlag(value6);
		domainObject.setOrdInvCurrentStatus(ims.ocrr.vo.domain.OrderedInvestigationStatusVoAssembler.extractOrderedInvestigationStatus(domainFactory, valueObject.getOrdInvCurrentStatus(), domMap));
		domainObject.setSpecimen(ims.ocrr.vo.domain.PathologySpecimenLiteVoAssembler.extractOrderSpecimenList(domainFactory, valueObject.getSpecimen(), domainObject.getSpecimen(), domMap));		
		ims.framework.utils.DateTime dateTime9 = valueObject.getRepDateTime();
		java.util.Date value9 = null;
		if ( dateTime9 != null ) 
		{
			value9 = dateTime9.getJavaDate();
		}
		domainObject.setRepDateTime(value9);
		domainObject.setDisplayTimeSupplied(valueObject.getDisplayTimeSupplied());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value11 = null;
		if ( null != valueObject.getResultSpecimenType() ) 
		{
			value11 =
				domainFactory.getLookupInstance(valueObject.getResultSpecimenType().getID());
		}
		domainObject.setResultSpecimenType(value11);
		domainObject.setResultDetails(ims.ocrr.vo.domain.ResultDetailsForPathologyResultListShortVoAssembler.extractResultDetails(domainFactory, valueObject.getResultDetails(), domMap));
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getPlacerOrdNum() != null && valueObject.getPlacerOrdNum().equals(""))
		{
			valueObject.setPlacerOrdNum(null);
		}
		domainObject.setPlacerOrdNum(valueObject.getPlacerOrdNum());
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value14 = null;
		if ( null != valueObject.getAllocatedHCPforReview() ) 
		{
			if (valueObject.getAllocatedHCPforReview().getBoId() == null)
			{
				if (domMap.get(valueObject.getAllocatedHCPforReview()) != null)
				{
					value14 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getAllocatedHCPforReview());
				}
			}
			else
			{
				value14 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getAllocatedHCPforReview().getBoId());
			}
		}
		domainObject.setAllocatedHCPforReview(value14);

		return domainObject;
	}

}
