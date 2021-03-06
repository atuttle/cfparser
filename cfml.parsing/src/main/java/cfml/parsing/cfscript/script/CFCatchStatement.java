/* 
 *  Copyright (C) 2000 - 2010 TagServlet Ltd
 *
 *  This file is part of Open BlueDragon (OpenBD) CFML Server Engine.
 *  
 *  OpenBD is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  Free Software Foundation,version 3.
 *  
 *  OpenBD is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with OpenBD.  If not, see http://www.gnu.org/licenses/
 *  
 *  Additional permission under GNU GPL version 3 section 7
 *  
 *  If you modify this Program, or any covered work, by linking or combining 
 *  it with any of the JARS listed in the README.txt (or a modified version of 
 *  (that library), containing parts covered by the terms of that JAR, the 
 *  licensors of this Program grant you additional permission to convey the 
 *  resulting work. 
 *  README.txt @ http://www.openbluedragon.org/license/README.txt
 *  
 *  http://www.openbluedragon.org/
 */

package cfml.parsing.cfscript.script;

import cfml.parsing.cfscript.CFIdentifier;

public class CFCatchStatement extends CFCatchClause implements CFScriptStatement {
	
	private CFIdentifier var;
	private CFScriptStatement body;
	
	public CFCatchStatement(String _type, CFIdentifier _var, CFScriptStatement _body) {
		type = _type;
		var = _var;
		body = _body;
	}
	
	public CFCatchStatement(CFIdentifier _type, CFIdentifier _var, CFScriptStatement _body) {
		type = _type.Decompile(0);
		var = _var;
		body = _body;
	}
	
	public CFIdentifier getVariable() {
		return var;
	}
	
	public CFScriptStatement getCatchBody() {
		return body;
	}
	
	public void checkIndirectAssignments(String[] scriptSource) {
		body.checkIndirectAssignments(scriptSource);
	}
	
	public String Decompile(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append("catch( ");
		sb.append(type);
		sb.append(' ');
		sb.append(var.Decompile(0));
		sb.append(")\n");
		sb.append(body.Decompile(0));
		return sb.toString();
	}
	
}
