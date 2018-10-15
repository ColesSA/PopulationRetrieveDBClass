/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationretrievedbclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 55colessa31
 */
public class PopulationDatabaseOperations {
    private static String dbProtocol = "jdbc:derby:";
    private static String dbDirectory = "C:/Users/55colessa31/Documents/GitHub/PopulationRetrieveDBClass/";
    private static String dbName = "PopulationDB"; // Database Name.
    private static String dbExtra = ""; // Create the database schema.
    private static String username = "Admin";
    private static String password = "MuCis";
    
    public static void setConnection(String dbDirectoryIn, String dbNameIn){
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
    }
    
    public static void setConnection(String dbDirectoryIn, String dbNameIn, 
            String usernameIn, String passwordIn){
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
        username = usernameIn;
        password = passwordIn;
    }
    
    public static void setConnection(String dbProtocolIn, String dbDirectoryIn, 
            String dbNameIn, String dbExtraIn, String usernameIn, 
            String passwordIn){
        dbProtocol = dbProtocolIn;
        dbDirectory = dbDirectoryIn;
        dbName = dbNameIn;
        dbExtra = dbExtraIn;
        username = usernameIn;
        password = passwordIn;
    }
    
    private static Connection openConnection() throws SQLException{
        String connectionURL = dbProtocol + dbDirectory + dbName + dbExtra;
        Connection connection1 = DriverManager.getConnection(connectionURL, 
                username, password);
        return connection1;
    }
    
    public static Towns retrieveAllTowns(){
        String query1 = "SELECT * FROM Population";
        Towns towns = new Towns();
        try(Connection connection1 = openConnection()){
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            while(rs1.next()){
                Town townNext = new Town();
                townNext.setTownNumber(rs1.getInt(1));
                townNext.setTownName(rs1.getString(2));
                townNext.setCountyNumber(rs1.getInt(3));
                townNext.setRegionNumber(rs1.getInt(4));
                townNext.setPopulation(rs1.getInt(5));
                towns.add(townNext);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return towns;
    }
    
    public static Town retrieveTown(int townNumberIn){
        String query1 = "SELECT * FROM Population WHERE TownNumber = ? ";
        Town town = new Town();
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(query1);
            statement.setInt(1,townNumberIn);
            ResultSet rs1 = statement.executeQuery();
            if(rs1.next()){
                town.setTownNumber(rs1.getInt(1));
                town.setTownName(rs1.getString(2));
                town.setCountyNumber(rs1.getInt(3));
                town.setRegionNumber(rs1.getInt(4));
                town.setPopulation(rs1.getInt(5));
            } else throw new SQLException();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return town;
        
    }
}