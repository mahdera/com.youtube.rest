/**
 * 
 */
package com.youtube.rest.inventory;

import com.youtube.dao.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.*;
import org.codehaus.jettison.json.*;
import com.youtube.util.*;
/**
 * @author Mahder on macbook Pro
 *
 */

@Path("v1/inventory/")
public class V1_inventory {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllPcParts(){//if you want to create a custom made Response 
		String returnString = null;
		Response responseBody = null;
		
		try{
			String query = "select * from PC_PARTS";
			ResultSet rSet = MySQLConnection.readFromDatabase(query);
			ToJSON toJSONConvertor = new ToJSON();
			JSONArray jsonArray = new JSONArray();
			
			jsonArray = toJSONConvertor.toJSONArray(rSet);
			returnString = jsonArray.toString();
			responseBody = Response.ok(returnString).build();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MySQLConnection.disconnectDatabase();
		}
		return responseBody;
	}
}//end class
