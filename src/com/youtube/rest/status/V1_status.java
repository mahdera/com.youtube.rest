/**
 * 
 */
package com.youtube.rest.status;

import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.youtube.dao.MySQLConnection;

/**
 * @author Mahder on macbook Pro
 *
 */

@Path("/v1/status")
public class V1_status {
	private static final String api_version = "00.02.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Services</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version: </p>" + api_version;
	}
	
	@Path("/database")
	@GET
	@Produces("text/html")
	public String returnDatabaseStatus(){
		String statusTime = null;
		try{
			String query = "select * from tbl_advance where id = 1";
			ResultSet rSet = MySQLConnection.readFromDatabase(query);
			while(rSet.next()){
				statusTime = rSet.getDate("modification_date").toString();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MySQLConnection.disconnectDatabase();
		}
		return "<p>Database Status is : </p>" + statusTime;
	}
}//end class
