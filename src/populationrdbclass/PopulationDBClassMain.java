/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationrdbclass;

/**
 *
 * @author 55colessa31
 */
public class PopulationDBClassMain {
    public static Towns towns;
    
    public static void main(String[] args){
        
        String dbDirectory = "C:/Users/55colessa31/Documents/GitHub/PopulationDBClass/";
        String dbName = "PopulationDB";
        
        PopulationDatabaseOperations.setConnection(dbDirectory, dbName);
        
        printTowns();
        
        PopulationModifyDeleteDBClass.run();
        
        printTowns();
        
        System.out.println("Database Operation Complete.");
    }
    
    public static void printTowns(){
        towns = PopulationDatabaseOperations.retrieveAllTowns();
        
        for(int i = 0; i<towns.size();i++){
            System.out.println("Town Number: "+(towns.get(i)).getTownNumber());
            System.out.println("Town Name: "+(towns.get(i)).getTownName());
            System.out.println("Town County Number: "+(towns.get(i)).getCountyNumber());
            System.out.println("Town Region Number: "+(towns.get(i)).getRegionNumber());
            System.out.println("Town Population: "+(towns.get(i)).getPopulation());
            System.out.println();
        }
    }
}
