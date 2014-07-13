/**
 * 
 */
package com.youtube.dao;

import java.sql.*;

public class MySQLConnection {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rSet;
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:8889/db_REST";
    private static boolean connected;

    public MySQLConnection() {
        
    }

    private static void connect() throws Exception {
        Class.forName(DATABASE_DRIVER).newInstance();
        con = DriverManager.getConnection(DATABASE_URL, "root", "root");
        if(con != null){
        		stmt = con.createStatement();
        		connected = true;
        }else{
        		connected = false;
        }
    }

    public static Connection getDatabaseConnection() throws Exception
    {
        connect();
        Connection connection = getCon();
        return connection;
    }

    

    public static void disconnectDatabase() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } 
    }

    public static ResultSet readFromDatabase(String query) {
        try {
            connect();
            if(isConnected()){
            		rSet = stmt.executeQuery(query);
            }else{
            		System.out.println("MySQL is not running!");
            }
        } catch (Exception sqle) {
            sqle.printStackTrace();
        } 
        return rSet;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void writeToDatabase(String command) {
        try {
            connect();
            if(isConnected()){
            		int count = stmt.executeUpdate(command);
            }else{
            		System.out.println("MySQL is not running!");
            }
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static void writeToDatabase(PreparedStatement preparedStatement){
    		try{
    			preparedStatement.executeUpdate();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    }
    
    public static ResultSet readFromDatabase(PreparedStatement preparedStatement){
    		ResultSet rSet = null;
    		try{
    			rSet = preparedStatement.executeQuery();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return rSet;
    }
    
    public static PreparedStatement getPreparedStatement(String sqlString){
    		PreparedStatement preparedStatement = null;
    		try{
    			connect();
    			preparedStatement = getCon().prepareStatement(sqlString);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return preparedStatement;
    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        MySQLConnection.con = con;
    }

    
}//end class

