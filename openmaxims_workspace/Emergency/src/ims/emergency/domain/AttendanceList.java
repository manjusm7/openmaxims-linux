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

package ims.emergency.domain;

// Generated from form domain impl
public interface AttendanceList extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	/**
	* listEmergencyAttendance
	*/
	public ims.emergency.vo.EmergencyAttendanceListVoCollection listEmergencyAttendance(String surname, String forename, ims.emergency.vo.lookups.PatientCategory category, Boolean include24, Boolean includeUnCoded);

	// Generated from form domain interface definition
	/**
	* getCareContext
	*/
	public ims.core.vo.CareContextShortVo getCareContext(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef);

	// Generated from form domain interface definition
	/**
	* getPatient
	*/
	public ims.core.vo.PatientShort getPatient(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef);

	// Generated from form domain interface definition
	/**
	* getEmergencyAttendance
	*/
	public ims.emergency.vo.AttendanceDetailsVo getEmergencyAttendance(ims.core.admin.vo.EmergencyAttendanceRefVo emergencyAttendanceRef);
}
