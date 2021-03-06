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
public class ICPActionCloneVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.icp.vo.ICPActionCloneVo copy(ims.icp.vo.ICPActionCloneVo valueObjectDest, ims.icp.vo.ICPActionCloneVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_ICPAction(valueObjectSrc.getID_ICPAction());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// LinkedForm
		valueObjectDest.setLinkedForm(valueObjectSrc.getLinkedForm());
		// LinkedAssessment
		valueObjectDest.setLinkedAssessment(valueObjectSrc.getLinkedAssessment());
		// LinkedGraphicAssessment
		valueObjectDest.setLinkedGraphicAssessment(valueObjectSrc.getLinkedGraphicAssessment());
		// LinkedOrderEntryTemplate
		valueObjectDest.setLinkedOrderEntryTemplate(valueObjectSrc.getLinkedOrderEntryTemplate());
		// requiresCounterSignature
		valueObjectDest.setRequiresCounterSignature(valueObjectSrc.getRequiresCounterSignature());
		// Name
		valueObjectDest.setName(valueObjectSrc.getName());
		// Description
		valueObjectDest.setDescription(valueObjectSrc.getDescription());
		// Sequence
		valueObjectDest.setSequence(valueObjectSrc.getSequence());
		// Discipline
		valueObjectDest.setDiscipline(valueObjectSrc.getDiscipline());
		// Status
		valueObjectDest.setStatus(valueObjectSrc.getStatus());
		// isMandatory
		valueObjectDest.setIsMandatory(valueObjectSrc.getIsMandatory());
		// IsActivatedOnInitiation
		valueObjectDest.setIsActivatedOnInitiation(valueObjectSrc.getIsActivatedOnInitiation());
		// HelpURL
		valueObjectDest.setHelpURL(valueObjectSrc.getHelpURL());
		// LinkedType
		valueObjectDest.setLinkedType(valueObjectSrc.getLinkedType());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createICPActionCloneVoCollectionFromICPAction(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPAction objects.
	 */
	public static ims.icp.vo.ICPActionCloneVoCollection createICPActionCloneVoCollectionFromICPAction(java.util.Set domainObjectSet)	
	{
		return createICPActionCloneVoCollectionFromICPAction(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.icps.configuration.domain.objects.ICPAction objects.
	 */
	public static ims.icp.vo.ICPActionCloneVoCollection createICPActionCloneVoCollectionFromICPAction(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.icp.vo.ICPActionCloneVoCollection voList = new ims.icp.vo.ICPActionCloneVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.icps.configuration.domain.objects.ICPAction domainObject = (ims.icps.configuration.domain.objects.ICPAction) iterator.next();
			ims.icp.vo.ICPActionCloneVo vo = create(map, domainObject);
			
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
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPAction objects.
	 */
	public static ims.icp.vo.ICPActionCloneVoCollection createICPActionCloneVoCollectionFromICPAction(java.util.List domainObjectList) 
	{
		return createICPActionCloneVoCollectionFromICPAction(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.icps.configuration.domain.objects.ICPAction objects.
	 */
	public static ims.icp.vo.ICPActionCloneVoCollection createICPActionCloneVoCollectionFromICPAction(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.icp.vo.ICPActionCloneVoCollection voList = new ims.icp.vo.ICPActionCloneVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.icps.configuration.domain.objects.ICPAction domainObject = (ims.icps.configuration.domain.objects.ICPAction) domainObjectList.get(i);
			ims.icp.vo.ICPActionCloneVo vo = create(map, domainObject);

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
	 * Create the ims.icps.configuration.domain.objects.ICPAction set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractICPActionSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVoCollection voCollection) 
	 {
	 	return extractICPActionSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractICPActionSet(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPActionCloneVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPAction domainObject = ICPActionCloneVoAssembler.extractICPAction(domainFactory, vo, domMap);

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
	 * Create the ims.icps.configuration.domain.objects.ICPAction list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractICPActionList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVoCollection voCollection) 
	 {
	 	return extractICPActionList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractICPActionList(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.icp.vo.ICPActionCloneVo vo = voCollection.get(i);
			ims.icps.configuration.domain.objects.ICPAction domainObject = ICPActionCloneVoAssembler.extractICPAction(domainFactory, vo, domMap);

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
	 * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPAction object.
	 * @param domainObject ims.icps.configuration.domain.objects.ICPAction
	 */
	 public static ims.icp.vo.ICPActionCloneVo create(ims.icps.configuration.domain.objects.ICPAction domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.icps.configuration.domain.objects.ICPAction object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.icp.vo.ICPActionCloneVo create(DomainObjectMap map, ims.icps.configuration.domain.objects.ICPAction domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.icp.vo.ICPActionCloneVo valueObject = (ims.icp.vo.ICPActionCloneVo) map.getValueObject(domainObject, ims.icp.vo.ICPActionCloneVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.icp.vo.ICPActionCloneVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.icps.configuration.domain.objects.ICPAction
	 */
	 public static ims.icp.vo.ICPActionCloneVo insert(ims.icp.vo.ICPActionCloneVo valueObject, ims.icps.configuration.domain.objects.ICPAction domainObject) 
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
	 * @param domainObject ims.icps.configuration.domain.objects.ICPAction
	 */
	 public static ims.icp.vo.ICPActionCloneVo insert(DomainObjectMap map, ims.icp.vo.ICPActionCloneVo valueObject, ims.icps.configuration.domain.objects.ICPAction domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_ICPAction(domainObject.getId());
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
			
		// LinkedForm
		valueObject.setLinkedForm(ims.core.vo.domain.AppFormLiteVoAssembler.create(map, domainObject.getLinkedForm()) );
		// LinkedAssessment
		valueObject.setLinkedAssessment(ims.assessment.vo.domain.UserAssessmentLiteVoAssembler.create(map, domainObject.getLinkedAssessment()) );
		// LinkedGraphicAssessment
		valueObject.setLinkedGraphicAssessment(ims.assessment.vo.domain.GraphicAssessmentLiteVoAssembler.create(map, domainObject.getLinkedGraphicAssessment()) );
		// LinkedOrderEntryTemplate
		valueObject.setLinkedOrderEntryTemplate(ims.ocrr.vo.domain.OrderEntryTemplateLiteVoAssembler.create(map, domainObject.getLinkedOrderEntryTemplate()) );
		// requiresCounterSignature
		valueObject.setRequiresCounterSignature( domainObject.isRequiresCounterSignature() );
		// Name
		valueObject.setName(domainObject.getName());
		// Description
		valueObject.setDescription(domainObject.getDescription());
		// Sequence
		valueObject.setSequence(domainObject.getSequence());
		// Discipline
		java.util.List listDiscipline = domainObject.getDiscipline();
		ims.core.vo.lookups.HcpDisTypeCollection Discipline = new ims.core.vo.lookups.HcpDisTypeCollection();
		for(java.util.Iterator iterator = listDiscipline.iterator(); iterator.hasNext(); ) 
		{
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;
		
			ims.domain.lookups.LookupInstance instance = 
				(ims.domain.lookups.LookupInstance) iterator.next();
			if (instance.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
			}
			else 
			{
				img = null;
			}
			color = instance.getColor();
			if (color != null) 
				color.getValue();
			ims.core.vo.lookups.HcpDisType voInstance = new ims.core.vo.lookups.HcpDisType(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.core.vo.lookups.HcpDisType parentVoInstance = voInstance;
			ims.domain.lookups.LookupInstance parent = instance.getParent();
			while (parent != null)
			{
				if (parent.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent.getImage().getImageId(), parent.getImage().getImagePath());
				}
				else 
				{
					img = null;
				}
				color = parent.getColor();
				if (color != null) 
					color.getValue();
								parentVoInstance.setParent(new ims.core.vo.lookups.HcpDisType(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			Discipline.add(voInstance);
		}
		valueObject.setDiscipline( Discipline );
		// Status
		ims.domain.lookups.LookupInstance instance10 = domainObject.getStatus();
		if ( null != instance10 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance10.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance10.getImage().getImageId(), instance10.getImage().getImagePath());
			}
			color = instance10.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.PreActiveActiveInactiveStatus voLookup10 = new ims.core.vo.lookups.PreActiveActiveInactiveStatus(instance10.getId(),instance10.getText(), instance10.isActive(), null, img, color);
			ims.core.vo.lookups.PreActiveActiveInactiveStatus parentVoLookup10 = voLookup10;
			ims.domain.lookups.LookupInstance parent10 = instance10.getParent();
			while (parent10 != null)
			{
				if (parent10.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent10.getImage().getImageId(), parent10.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent10.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup10.setParent(new ims.core.vo.lookups.PreActiveActiveInactiveStatus(parent10.getId(),parent10.getText(), parent10.isActive(), null, img, color));
				parentVoLookup10 = parentVoLookup10.getParent();
								parent10 = parent10.getParent();
			}			
			valueObject.setStatus(voLookup10);
		}
				// isMandatory
		valueObject.setIsMandatory( domainObject.isIsMandatory() );
		// IsActivatedOnInitiation
		valueObject.setIsActivatedOnInitiation( domainObject.isIsActivatedOnInitiation() );
		// HelpURL
		valueObject.setHelpURL(domainObject.getHelpURL());
		// LinkedType
		ims.domain.lookups.LookupInstance instance14 = domainObject.getLinkedType();
		if ( null != instance14 ) {
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;		
			img = null;
			if (instance14.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance14.getImage().getImageId(), instance14.getImage().getImagePath());
			}
			color = instance14.getColor();
			if (color != null) 
				color.getValue();

			ims.core.vo.lookups.ICPCompLinkedType voLookup14 = new ims.core.vo.lookups.ICPCompLinkedType(instance14.getId(),instance14.getText(), instance14.isActive(), null, img, color);
			ims.core.vo.lookups.ICPCompLinkedType parentVoLookup14 = voLookup14;
			ims.domain.lookups.LookupInstance parent14 = instance14.getParent();
			while (parent14 != null)
			{
				if (parent14.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent14.getImage().getImageId(), parent14.getImage().getImagePath() );
				}
				else 
				{
					img = null;
				}
				color = parent14.getColor();
    			if (color != null) 
    				color.getValue();
								parentVoLookup14.setParent(new ims.core.vo.lookups.ICPCompLinkedType(parent14.getId(),parent14.getText(), parent14.isActive(), null, img, color));
				parentVoLookup14 = parentVoLookup14.getParent();
								parent14 = parent14.getParent();
			}			
			valueObject.setLinkedType(voLookup14);
		}
		 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.icps.configuration.domain.objects.ICPAction extractICPAction(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVo valueObject) 
	{
		return 	extractICPAction(domainFactory, valueObject, new HashMap());
	}

	public static ims.icps.configuration.domain.objects.ICPAction extractICPAction(ims.domain.ILightweightDomainFactory domainFactory, ims.icp.vo.ICPActionCloneVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_ICPAction();
		ims.icps.configuration.domain.objects.ICPAction domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPAction)domMap.get(valueObject);
			}
			// ims.icp.vo.ICPActionCloneVo ID_ICPAction field is unknown
			domainObject = new ims.icps.configuration.domain.objects.ICPAction();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_ICPAction());
			if (domMap.get(key) != null)
			{
				return (ims.icps.configuration.domain.objects.ICPAction)domMap.get(key);
			}
			domainObject = (ims.icps.configuration.domain.objects.ICPAction) domainFactory.getDomainObject(ims.icps.configuration.domain.objects.ICPAction.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_ICPAction());

		domainObject.setLinkedForm(ims.core.vo.domain.AppFormLiteVoAssembler.extractAppForm(domainFactory, valueObject.getLinkedForm(), domMap));
		domainObject.setLinkedAssessment(ims.assessment.vo.domain.UserAssessmentLiteVoAssembler.extractUserAssessment(domainFactory, valueObject.getLinkedAssessment(), domMap));
		domainObject.setLinkedGraphicAssessment(ims.assessment.vo.domain.GraphicAssessmentLiteVoAssembler.extractGraphicAssessment(domainFactory, valueObject.getLinkedGraphicAssessment(), domMap));
		domainObject.setLinkedOrderEntryTemplate(ims.ocrr.vo.domain.OrderEntryTemplateLiteVoAssembler.extractOrderEntryTemplate(domainFactory, valueObject.getLinkedOrderEntryTemplate(), domMap));
		domainObject.setRequiresCounterSignature(valueObject.getRequiresCounterSignature());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getName() != null && valueObject.getName().equals(""))
		{
			valueObject.setName(null);
		}
		domainObject.setName(valueObject.getName());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDescription() != null && valueObject.getDescription().equals(""))
		{
			valueObject.setDescription(null);
		}
		domainObject.setDescription(valueObject.getDescription());
		domainObject.setSequence(valueObject.getSequence());
		ims.core.vo.lookups.HcpDisTypeCollection collection9 =
	valueObject.getDiscipline();
	    java.util.List domainDiscipline = domainObject.getDiscipline();;			
	    int collection9Size=0;
		if (collection9 == null)
		{
			domainDiscipline = new java.util.ArrayList(0);
		}
		else
		{
			collection9Size = collection9.size();
		}
		
		for(int i=0; i<collection9Size; i++) 
		{
			int instanceId = collection9.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainDiscipline.indexOf(dom);
			if (domIdx == -1)
			{
				domainDiscipline.add(i, dom);
			}
			else if (i != domIdx && i < domainDiscipline.size())
			{
				Object tmp = domainDiscipline.get(i);
				domainDiscipline.set(i, domainDiscipline.get(domIdx));
				domainDiscipline.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j9 = domainDiscipline.size();
		while (j9 > collection9Size)
		{
			domainDiscipline.remove(j9-1);
			j9 = domainDiscipline.size();
		}

		domainObject.setDiscipline(domainDiscipline);		
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value10 = null;
		if ( null != valueObject.getStatus() ) 
		{
			value10 =
				domainFactory.getLookupInstance(valueObject.getStatus().getID());
		}
		domainObject.setStatus(value10);
		domainObject.setIsMandatory(valueObject.getIsMandatory());
		domainObject.setIsActivatedOnInitiation(valueObject.getIsActivatedOnInitiation());
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getHelpURL() != null && valueObject.getHelpURL().equals(""))
		{
			valueObject.setHelpURL(null);
		}
		domainObject.setHelpURL(valueObject.getHelpURL());
		// create LookupInstance from vo LookupType
		ims.domain.lookups.LookupInstance value14 = null;
		if ( null != valueObject.getLinkedType() ) 
		{
			value14 =
				domainFactory.getLookupInstance(valueObject.getLinkedType().getID());
		}
		domainObject.setLinkedType(value14);

		return domainObject;
	}

}
