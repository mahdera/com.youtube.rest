/**
 * 
 */
package com.youtube.rest.inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
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
@Path("/v2/inventory")
public class V2_inventory {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrandParts(@QueryParam("brand") String brand){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		ToJSON toJSON = new ToJSON();
		try{
			if(brand == null){
				return Response.status(400).entity("Hey, plz specify a brand!!").build();
			}
			
			String sqlQuery = "select * from PC_PARTS where upper(PC_PARTS_MAKER) = ?";
			PreparedStatement pStmt = MySQLConnection.getPreparedStatement(sqlQuery);
			pStmt.setString(1, brand.toUpperCase());			
			ResultSet rSet = MySQLConnection.readFromDatabase(pStmt);
			jsonArray = toJSON.toJSONArray(rSet);
			returnString = jsonArray.toString();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		return Response.ok(returnString).build();
	}
	
	@GET
	@Path("/{brand}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrand(@PathParam("brand") String brand){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		ToJSON toJSON = new ToJSON();
		try{
			if(brand == null){
				return Response.status(400).entity("Hey, plz specify a brand!!").build();
			}
			
			String sqlQuery = "select * from PC_PARTS where upper(PC_PARTS_MAKER) = ?";
			PreparedStatement pStmt = MySQLConnection.getPreparedStatement(sqlQuery);
			pStmt.setString(1, brand.toUpperCase());			
			ResultSet rSet = MySQLConnection.readFromDatabase(pStmt);
			jsonArray = toJSON.toJSONArray(rSet);
			returnString = jsonArray.toString();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		return Response.ok(returnString).build();
	}
	
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
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})//the {} helps us to specify more than one inputs for this method 
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPcParts(String incomingData){
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		ToJSON toJSON = new ToJSON();
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			System.out.println(incomingData);
			PcPart pcPart = objectMapper.readValue(incomingData, PcPart.class);
			String sqlStr = "insert into PC_PARTS values(?,?,?,?,?,?)";
			PreparedStatement pStmt = MySQLConnection.getPreparedStatement(sqlStr);
			pStmt.setInt(1, 0);
			pStmt.setString(2, pcPart.getPcPartsTitle());
			pStmt.setString(3, pcPart.getPcPartsCode());
			pStmt.setString(4, pcPart.getPcPartsMaker());
			pStmt.setInt(5, pcPart.getPcPartsAvail());
			pStmt.setString(6, pcPart.getPcPartsDesc());
			MySQLConnection.writeToDatabase(pStmt);
			returnString = "PcParts Saved Successfully!";
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("The server was unable to process your request!").build();
		}
		return Response.ok(returnString).build();
	}
	
}//end class
