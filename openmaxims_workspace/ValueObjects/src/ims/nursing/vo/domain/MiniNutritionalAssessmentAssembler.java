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
package ims.nursing.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Sinead McDermott
 */
public class MiniNutritionalAssessmentAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.nursing.vo.MiniNutritionalAssessment copy(ims.nursing.vo.MiniNutritionalAssessment valueObjectDest, ims.nursing.vo.MiniNutritionalAssessment valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_Assessment(valueObjectSrc.getID_Assessment());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AssessmentDetails
		valueObjectDest.setAssessmentDetails(valueObjectSrc.getAssessmentDetails());
		// Metrics
		valueObjectDest.setMetrics(valueObjectSrc.getMetrics());
		// HcpInitiated
		valueObjectDest.setHcpInitiated(valueObjectSrc.getHcpInitiated());
		// DateTimeInitiated
		valueObjectDest.setDateTimeInitiated(valueObjectSrc.getDateTimeInitiated());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
		// CareContext
		valueObjectDest.setCareContext(valueObjectSrc.getCareContext());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment objects.
	 */
	public static ims.nursing.vo.MiniNutritionalAssessmentCollection createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(java.util.Set domainObjectSet)	
	{
		return createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment objects.
	 */
	public static ims.nursing.vo.MiniNutritionalAssessmentCollection createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.nursing.vo.MiniNutritionalAssessmentCollection voList = new ims.nursing.vo.MiniNutritionalAssessmentCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject = (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment) iterator.next();
			ims.nursing.vo.MiniNutritionalAssessment vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment objects.
	 */
	public static ims.nursing.vo.MiniNutritionalAssessmentCollection createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(java.util.List domainObjectList) 
	{
		return createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment objects.
	 */
	public static ims.nursing.vo.MiniNutritionalAssessmentCollection createMiniNutritionalAssessmentCollectionFromMiniNutritionalAssessment(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.nursing.vo.MiniNutritionalAssessmentCollection voList = new ims.nursing.vo.MiniNutritionalAssessmentCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject = (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment) domainObjectList.get(i);
			ims.nursing.vo.MiniNutritionalAssessment vo = create(map, domainObject);

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
	 * Create the ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractMiniNutritionalAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessmentCollection voCollection) 
	 {
	 	return extractMiniNutritionalAssessmentSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractMiniNutritionalAssessmentSet(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessmentCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.MiniNutritionalAssessment vo = voCollection.get(i);
			ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject = MiniNutritionalAssessmentAssembler.extractMiniNutritionalAssessment(domainFactory, vo, domMap);

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
	 * Create the ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractMiniNutritionalAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessmentCollection voCollection) 
	 {
	 	return extractMiniNutritionalAssessmentList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractMiniNutritionalAssessmentList(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessmentCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.nursing.vo.MiniNutritionalAssessment vo = voCollection.get(i);
			ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject = MiniNutritionalAssessmentAssembler.extractMiniNutritionalAssessment(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment object.
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment
	 */
	 public static ims.nursing.vo.MiniNutritionalAssessment create(ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.nursing.vo.MiniNutritionalAssessment create(DomainObjectMap map, ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.nursing.vo.MiniNutritionalAssessment valueObject = (ims.nursing.vo.MiniNutritionalAssessment) map.getValueObject(domainObject, ims.nursing.vo.MiniNutritionalAssessment.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.nursing.vo.MiniNutritionalAssessment(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment
	 */
	 public static ims.nursing.vo.MiniNutritionalAssessment insert(ims.nursing.vo.MiniNutritionalAssessment valueObject, ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject) 
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
	 * @param domainObject ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment
	 */
	 public static ims.nursing.vo.MiniNutritionalAssessment insert(DomainObjectMap map, ims.nursing.vo.MiniNutritionalAssessment valueObject, ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_Assessment(domainObject.getId());
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
			
		// AssessmentDetails
		valueObject.setAssessmentDetails(ims.nursing.vo.domain.MiniNutritionalAssessmentDetailsAssembler.createMiniNutritionalAssessmentDetailsCollectionFromMiniNutritionalAssessmentDetails(map, domainObject.getAssessmentDetails()) );
		// Metrics
		valueObject.setMetrics(ims.core.vo.domain.VSMetricsAssembler.create(map, domainObject.getMetrics()) );
		// HcpInitiated
		valueObject.setHcpInitiated(ims.core.vo.domain.HcpLiteVoAssembler.create(map, domainObject.getHcpInitiated()) );
		// DateTimeInitiated
		java.util.Date DateTimeInitiated = domainObject.getDateTimeInitiated();
		if ( null != DateTimeInitiated ) 
		{
			valueObject.setDateTimeInitiated(new ims.framework.utils.DateTime(DateTimeInitiated) );
		}
		// ClinicalContact
		if (domainObject.getClinicalContact() != null)
		{
			if(domainObject.getClinicalContact() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getClinicalContact();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(id, -1));				
			}
			else
			{
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(domainObject.getClinicalContact().getId(), domainObject.getClinicalContact().getVersion()));
			}
		}
		// CareContext
		if (domainObject.getCareContext() != null)
		{
			if(domainObject.getCareContext() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getCareContext();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(id, -1));				
			}
			else
			{
				valueObject.setCareContext(new ims.core.admin.vo.CareContextRefVo(domainObject.getCareContext().getId(), domainObject.getCareContext().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment extractMiniNutritionalAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessment valueObject) 
	{
		return 	extractMiniNutritionalAssessment(domainFactory, valueObject, new HashMap());
	}

	public static ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment extractMiniNutritionalAssessment(ims.domain.ILightweightDomainFactory domainFactory, ims.nursing.vo.MiniNutritionalAssessment valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_Assessment();
		ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment)domMap.get(valueObject);
			}
			// ims.nursing.vo.MiniNutritionalAssessment ID_MiniNutritionalAssessment field is unknown
			domainObject = new ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_Assessment());
			if (domMap.get(key) != null)
			{
				return (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment)domMap.get(key);
			}
			domainObject = (ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment) domainFactory.getDomainObject(ims.nursing.assessmenttools.domain.objects.MiniNutritionalAssessment.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_Assessment());

		domainObject.setAssessmentDetails(ims.nursing.vo.domain.MiniNutritionalAssessmentDetailsAssembler.extractMiniNutritionalAssessmentDetailsSet(domainFactory, valueObject.getAssessmentDetails(), domainObject.getAssessmentDetails(), domMap));		
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.vitals.domain.objects.Metrics value2 = null;
		if ( null != valueObject.getMetrics() ) 
		{
			if (valueObject.getMetrics().getBoId() == null)
			{
				if (domMap.get(valueObject.getMetrics()) != null)
				{
					value2 = (ims.core.vitals.domain.objects.Metrics)domMap.get(valueObject.getMetrics());
				}
			}
			else
			{
				value2 = (ims.core.vitals.domain.objects.Metrics)domainFactory.getDomainObject(ims.core.vitals.domain.objects.Metrics.class, valueObject.getMetrics().getBoId());
			}
		}
		domainObject.setMetrics(value2);
	// SaveAsRefVO - treated as a refVo in extract methods
	ims.core.resource.people.domain.objects.Hcp value3 = null;
		if ( null != valueObject.getHcpInitiated() ) 
		{
			if (valueObject.getHcpInitiated().getBoId() == null)
			{
				if (domMap.get(valueObject.getHcpInitiated()) != null)
				{
					value3 = (ims.core.resource.people.domain.objects.Hcp)domMap.get(valueObject.getHcpInitiated());
				}
			}
			else
			{
				value3 = (ims.core.resource.people.domain.objects.Hcp)domainFactory.getDomainObject(ims.core.resource.people.domain.objects.Hcp.class, valueObject.getHcpInitiated().getBoId());
			}
		}
		domainObject.setHcpInitiated(value3);
		ims.framework.utils.DateTime dateTime4 = valueObject.getDateTimeInitiated();
		java.util.Date value4 = null;
		if ( dateTime4 != null ) 
		{
			value4 = dateTime4.getJavaDate();
		}
		domainObject.setDateTimeInitiated(value4);
		ims.core.admin.domain.objects.ClinicalContact value5 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value5 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value5 = domainObject.getClinicalContact();	
			}
			else
			{
				value5 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value5);
		ims.core.admin.domain.objects.CareContext value6 = null;
		if ( null != valueObject.getCareContext() ) 
		{
			if (valueObject.getCareContext().getBoId() == null)
			{
				if (domMap.get(valueObject.getCareContext()) != null)
				{
					value6 = (ims.core.admin.domain.objects.CareContext)domMap.get(valueObject.getCareContext());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value6 = domainObject.getCareContext();	
			}
			else
			{
				value6 = (ims.core.admin.domain.objects.CareContext)domainFactory.getDomainObject(ims.core.admin.domain.objects.CareContext.class, valueObject.getCareContext().getBoId());
			}
		}
		domainObject.setCareContext(value6);

		return domainObject;
	}

}
