/**
 * 
 */
package com.youtube.rest.inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;

import com.youtube.dao.MySQLConnection;
import com.youtube.model.PcPart;
import com.youtube.util.ToJSON;

/**
 * @author Mahder on macbook Pro
 *
 */
@Path("/v3/inventory")
public class V3_inventory {
	@GET
	@Path("/{brand}/{item_number}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSpecificBrandItem(@PathParam("brand") String brand,
			@PathParam("item_number") int itemNumber){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		ToJSON toJSON = new ToJSON();
		try{
			String sqlQuery = "select * from PC_PARTS where PC_PARTS_MAKER = ? and PC_PARTS_PK = ?";
			PreparedStatement pStmt = MySQLConnection.getPreparedStatement(sqlQuery);
			pStmt.setString(1, brand);
			pStmt.setInt(2, itemNumber);
			ResultSet rSet = MySQLConnection.readFromDatabase(pStmt);
			jsonArray = toJSON.toJSONArray(rSet);
			returnString = jsonArray.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Response.ok(returnString).build();
	}
	
	
	@PUT
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})//the {} helps us to specify more than one inputs for this method 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{item_number}")
	public Response updateItem(@PathParam("item_number") int itemNumber, String incomingData){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		ToJSON toJSON = new ToJSON();
		try{
			ObjectMapper objectMapper = new ObjectMapper();			
			PcPart pcPart = objectMapper.readValue(incomingData, PcPart.class);
			String sqlStr = "update PC_PARTS set PC_PARTS_TITLE = ?, PC_PARTS_CODE = ?, PC_PARTS_MAKER = ?, PC_PARTS_AVAIL = ?, PC_PARTS_DESC = ? where PC_PARTS_PK = ?";
			PreparedStatement pStmt = MySQLConnection.getPreparedStatement(sqlStr);
			pStmt.setString(1, pcPart.getPcPartsTitle());
			pStmt.setString(2, pcPart.getPcPartsCode());
			pStmt.setString(3, pcPart.getPcPartsMaker());
			pStmt.setInt(4, pcPart.getPcPartsAvail());
			pStmt.setString(5, pcPart.getPcPartsDesc());
			pStmt.setInt(6, pcPart.getPcPartsId());
			MySQLConnection.writeToDatabase(pStmt);
			returnString = "PcParts Updated Successfully!";
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("The server was unable to process your request!").build();
		}
		return Response.ok(returnString).build();
	}
}//end class
