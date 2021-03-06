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
package ims.icp.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author George Cristian Josan
 */
public class ICPPhaseShortVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.icp.vo.ICPPhaseShortVo copy(ims.icp.vo.ICPPhaseShortVo valueObjectDest, ims.icp.vo.ICPPhaseShortVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ICPPhase(valueObjectSrc.getID_ICPPhase());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
		// isActivatedOnInitiation
		valueObjectDest.setIsActivatedOnInitiation(valueObjectSrc.getIsActivatedOnInitiation());
		// Actions
		valueObjectDest.setActions(valueObjectSrc.getActions());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Goals
		valueObjectDest.setGoals(valueObjectSrc.getGoals());
		// HelpURL
		valueObjectDest.setHelpURL(valueObjectSrc.getHelpURL());
		// Sequence
		valueObjectDest.setSequence(valueObjectSrc.getSequence());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createICPPhaseShortVoCollectionFromICPPhase(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPPhase objects.
	 */
	public static ims.icp.vo.ICPPhaseShortVoCollection createICPPhaseShortVoCollectionFromICPPhase(java.util.Set domainObjectSet)	
	{
		return createICPPhaseShortVoCollectionFromICPPhase(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPPhase objects.
	 */
	public static ims.icp.vo.ICPPhaseShortVoCollection createICPPhaseShortVoCollectionFromICPPhase(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.icp.vo.ICPPhaseShortVoCollection voList = new ims.icp.vo.ICPPhaseShortVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.icps.configuration.domain.objects.ICPPhase domainObject = (ims.icps.configuration.domain.objects.ICPPhase) iterator.next();
			ims.icp.vo.ICPPhaseShortVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPPhase objects.
	 */
	public static ims.icp.vo.ICPPhaseShortVoCollection createICPPhaseShortVoCollectionFromICPPhase(java.util.List domainObjectList) 
	{
		return createICPPhaseShortVoCollectionFromICPPhase(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPPhase objects.
	 */
	public static ims.icp.vo.ICPPhaseShortVoCollection createICPPhaseShortVoCollectionFromICPPhase(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.icp.vo.ICPPhaseShortVoCollection voList = new ims.icp.vo.ICPPhaseShortVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.icps.configuration.domain.objects.ICPPhase domainObject = (ims.icps.configuration.domain.objects.ICPPhase) domainObjectList.get(i);
			ims.icp.vo.ICPPhaseShortVo vo = create(map, domainObject);

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
	 * Create the ims.icps.configuration.domain.objects.ICPPhase set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractICPPhaseSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVoCollection voCollection) 
	 {
	 	return extractICPPhaseSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractICPPhaseSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPPhaseShortVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPPhase domainObject = ICPPhaseShortVoAssembler.extractICPPhase(domainFactory, vo, domMap);

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
	 * Create the ims.icps.configuration.domain.objects.ICPPhase list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractICPPhaseList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVoCollection voCollection) 
	 {
	 	return extractICPPhaseList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractICPPhaseList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPPhaseShortVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPPhase domainObject = ICPPhaseShortVoAssembler.extractICPPhase(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPPhase object.
	 * @param domainObject ims.icps.configuration.domain.objects.ICPPhase
	 */
	 public static ims.icp.vo.ICPPhaseShortVo create(ims.icps.configuration.domain.objects.ICPPhase domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPPhase object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.icp.vo.ICPPhaseShortVo create(DomainObjectMap map, ims.icps.configuration.domain.objects.ICPPhase domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.icp.vo.ICPPhaseShortVo valueObject = (ims.icp.vo.ICPPhaseShortVo) map.getValueObject(domainObject, ims.icp.vo.ICPPhaseShortVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.icp.vo.ICPPhaseShortVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.configuration.domain.objects.ICPPhase
	 */
	 public static ims.icp.vo.ICPPhaseShortVo insert(ims.icp.vo.ICPPhaseShortVo valueObject, ims.icps.configuration.domain.objects.ICPPhase domainObject) 
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
	 * @param domainObject ims.icps.configuration.domain.objects.ICPPhase
	 */
	 public static ims.icp.vo.ICPPhaseShortVo insert(DomainObjectMap map, ims.icp.vo.ICPPhaseShortVo valueObject, ims.icps.configuration.domain.objects.ICPPhase domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ICPPhase(domainObject.getId());
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
			
		// Description
		valueObject.setDescription(domainObject.getDescription());
		// isActivatedOnInitiation
		valueObject.setIsActivatedOnInitiation( domainObject.isIsActivatedOnInitiation() );
		// Actions
		valueObject.setActions(ims.icp.vo.domain.ICPActionLiteVoAssembler.createICPActionLiteVoCollectionFromICPAction(map, domainObject.getActions()) );
		// Name
		valueObject.setName(domainObject.getName());
		// Goals
		valueObject.setGoals(ims.icp.vo.domain.IcpPhaseGoalVoAssembler.createIcpPhaseGoalVoCollectionFromICPPhaseGoal(map, domainObject.getGoals()) );
		// HelpURL
		valueObject.setHelpURL(domainObject.getHelpURL());
		// Sequence
		valueObject.setSequence(domainObject.getSequence());
		// Status
		ims.domain.lookups.LookupInstance instance8 = domainObject.getStatus();
		if ( null != instance8 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance8.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance8.getImage().getImageId(), instance8.getImage().getImagePath());
			}
			color = instance8.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup8 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance8.getId(),instance8.getText(), instance8.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup8 = voLookup8;
			ims.domain.lookups.LookupInstance parent8 = instance8.getParent();
			while (parent8 != null)
			{
				if (parent8.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent8.getImage().getImageId(), parent8.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent8.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup8.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent8.getId(),parent8.getText(), parent8.isActive(), null, img, color));
				parentVoLookup8 = parentVoLookup8.getParent();
								parent8 = parent8.getParent();
			}			
			valueObject.setStatus(voLookup8);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.icps.configuration.domain.objects.ICPPhase extractICPPhase(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVo valueObject) 
	{
		return 	extractICPPhase(domainFactory, valueObject, new HashMap());
	}

	public static ims.icps.configuration.domain.objects.ICPPhase extractICPPhase(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPPhaseShortVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ICPPhase();
		ims.icps.configuration.domain.objects.ICPPhase domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPPhase)domMap.get(valueObject);
			}
			// ims.icp.vo.ICPPhaseShortVo ID_ICPPhase field is unknown
			domainObject = new ims.icps.configuration.domain.objects.ICPPhase();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ICPPhase());
			if (domMap.get(key) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPPhase)domMap.get(key);
			}
			domainObject = (ims.icps.configuration.domain.objects.ICPPhase) domainFactory.getDomainObject(ims.icps.configuration.domain.objects.ICPPhase.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ICPPhase());

		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());
		domainObject.setIsActivatedOnInitiation(valueObject.getIsActivatedOnInitiation());

		// SaveAsRefVO treated as RefValueObject
		ims.icps.configuration.vo.ICPActionRefVoCollection refCollection3 = new ims.icps.configuration.vo.ICPActionRefVoCollection();
		if (valueObject.getActions() != null)
		{
			for (int i3=0; i3<valueObject.getActions().size(); i3++)
			{
				ims.icps.configuration.vo.ICPActionRefVo ref3 = (ims.icps.configuration.vo.ICPActionRefVo)valueObject.getActions().get(i3);
				refCollection3.add(ref3);
			}
		}
		int size3 = (null == refCollection3) ? 0 : refCollection3.size();		
		java.util.Set domainActions3 = domainObject.getActions();
		if (domainActions3 == null)
		{
			domainActions3 = new java.util.HashSet();
		}
		java.util.Set newSet3  = new java.util.HashSet();
		for(int i=0; i<size3; i++) 
		{
			ims.icps.configuration.vo.ICPActionRefVo vo = refCollection3.get(i);					
			ims.icps.configuration.domain.objects.ICPAction dom = null;
			if ( null != vo ) 
			{
				if (vo.getBoId() == null)
				{
					if (domMap.get(vo) != null)
					{
						dom = (ims.icps.configuration.domain.objects.ICPAction)domMap.get(vo);
					}
				}
				else
				{
					dom = (ims.icps.configuration.domain.objects.ICPAction)domainFactory.getDomainObject( ims.icps.configuration.domain.objects.ICPAction.class, vo.getBoId());
				}
			}

			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainActions3.contains(dom))
			{
				domainActions3.add(dom);
			}
			newSet3.add(dom);			
		}
		java.util.Set removedSet3 = new java.util.HashSet();
		java.util.Iterator iter3 = domainActions3.iterator();
		//Find out which objects need to be removed
		while (iter3.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter3.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet3.contains(o))
			{
				removedSet3.add(o);
			}
		}
		iter3 = removedSet3.iterator();
		//Remove the unwanted objects
		while (iter3.hasNext())
		{
			domainActions3.remove(iter3.next());
		}		
		
		domainObject.setActions(domainActions3);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		domainObject.setGoals(ims.icp.vo.domain.IcpPhaseGoalVoAssembler.extractICPPhaseGoalSet(domainFactory, valueObject.getGoals(), domainObject.getGoals(), domMap));		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHelpURL() != null && valueObject.getHelpURL().equals(""))
		{
			valueObject.setHelpURL(null);
		}
		domainObject.setHelpURL(valueObject.getHelpURL());
		domainObject.setSequence(valueObject.getSequence());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value8 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value8 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value8);

		return domainObject;
	}

}
