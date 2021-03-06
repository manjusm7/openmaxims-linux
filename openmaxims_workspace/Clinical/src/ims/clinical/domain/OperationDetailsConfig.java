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

package ims.clinical.domain;

// Generated from form domain impl
public interface OperationDetailsConfig extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.HcpLiteVoCollection listHCP(String filter) throws ims.domain.exceptions.DomainInterfaceException;

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureLiteVoCollection listProcedures(ims.core.vo.HcpLiteVo hcp, String text);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo getSUrgicalOperationDetailsConfig(ims.core.resource.people.vo.HcpRefVo hcp, ims.core.clinical.vo.ProcedureRefVo procedure);

	// Generated from form domain interface definition
	public ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo saveSurgicalOperationDetailConfig(ims.clinicaladmin.vo.SurgicalOperationDetailsConfigVo surrgicalOpDetailConfig) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException, ims.domain.exceptions.UniqueKeyViolationException;

	// Generated from form domain interface definition
	public ims.core.vo.ProcedureLiteVoCollection listAllProcedures(String text);
}
