/**
 * 
 */
package com.youtube.rest.inventory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

/**
 * @author Mahder on macbook Pro
 *
 */
@Path("v2/inventory")
public class V2_inventory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrandParts(@QueryParam("brand") String brand){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		return Response.ok(returnString).build();
	}
}//end class
