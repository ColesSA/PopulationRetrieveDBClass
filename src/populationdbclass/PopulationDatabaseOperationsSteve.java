/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationdbclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 55colessa31
 */
public class PopulationDatabaseOperationsSteve {
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
    
    public static void insertTown(Town town){
        String insertStatementTown = "INSERT INTO Population"
                +" (TownNumber, TownName, CountyNumber, RegionNumber, Population)"
                +"VALUES(?, ?, ?, ?, ?)";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(insertStatementTown);
            statement.setInt(1, town.getTownNumber());
            statement.setString(2, town.getTownName());
            statement.setInt(3, town.getCountyNumber());
            statement.setInt(4, town.getRegionNumber());
            statement.setInt(5, town.getPopulation());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteTown(int townNumberIn){
        String deleteStatementTown = "DELETE FROM Population WHERE TownNumber = ? ";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(deleteStatementTown);
            statement.setInt(1, townNumberIn);
            int statementResult = statement.executeUpdate();
            if(statementResult == 0){
                throw new NoUpdateException("Town Not Found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void modifyTownName(String modifyFieldValue, int conditionFieldValue){
        String modifyStatement = "UPDATE Population SET TownName = ? "
                + "WHERE TownNumber = ?";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setString(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);            
            int statementResult = statement.executeUpdate();
            if(statementResult == 0){
                throw new NoUpdateException("Town Not Found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void modifyCountyNumber(int modifyFieldValue, int conditionFieldValue){
        String modifyStatement = "UPDATE Population SET CountyNumber = ? "
                + "WHERE TownNumber = ?";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setInt(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);            
            int statementResult = statement.executeUpdate();
            if(statementResult == 0){
                throw new NoUpdateException("Town Not Found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void modifyRegionNumber(int modifyFieldValue, int conditionFieldValue){
        String modifyStatement = "UPDATE Population SET RegionNumber = ? "
                + "WHERE TownNumber = ?";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setInt(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);            
            int statementResult = statement.executeUpdate();
            if(statementResult == 0){
                throw new NoUpdateException("Town Not Found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void modifyPopulation(int modifyFieldValue, int conditionFieldValue){
        String modifyStatement = "UPDATE Population SET Population = ? "
                + "WHERE TownNumber = ?";
        try(Connection connection1 = openConnection()){
            PreparedStatement statement = connection1.prepareStatement(modifyStatement);
            statement.setInt(1, modifyFieldValue);
            statement.setInt(2, conditionFieldValue);            
            int statementResult = statement.executeUpdate();
            if(statementResult == 0){
                throw new NoUpdateException("Town Not Found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<String> getTableNames(){
        ArrayList<String> tableNames = new ArrayList<>();
        String[] tableTypes = {"TABLE"};
        try(Connection connection1 = openConnection()){
            ResultSet rs1 = (connection1.getMetaData()).getTables(null, null, "%", tableTypes);
            while(rs1.next()){
                tableNames.add(rs1.getString(3)); 
                // The 3rd position in the result set is the table name.
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tableNames;
    }
    
    public static ArrayList<String> getFieldNames(){
        ArrayList<String> columnNames = new ArrayList<>(),
                          tableNames = getTableNames();
        try(Connection connection1 = openConnection()){
            for(int i=0;i<tableNames.size();i++){
                ResultSet rs1 = (connection1.getMetaData()).getColumns(null, null, tableNames.get(i), "%");
                while(rs1.next()){
                    columnNames.add(rs1.getString(4)); 
                    // The 4th position in the result set is the column name.
                }
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return columnNames;
    }
    
    public static ArrayList<String> getFieldNamesAlternate(){
        String query1 = "SELECT * FROM Population";
        // This assumes we know the table name is Population.
        ArrayList<String> columnNames = new ArrayList<>();
        try(Connection connection1 = openConnection()){
            Statement statement = connection1.createStatement();
            ResultSet rs1 = statement.executeQuery(query1);
            ResultSetMetaData rsm1 = rs1.getMetaData();
            for(int columnNumber = 1; columnNumber <= rsm1.getColumnCount(); columnNumber++){
                columnNames.add(rsm1.getColumnName(columnNumber));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return columnNames;
    }
}
