/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationretrievedbclass;

/**
 *
 * @author 55colessa31
 */
public class PopulationRetrieveDBClass {
    
    public static void main(String[] args) {
        String dbDirectory = "C:/Users/55colessa31/Documents/GitHub/PopulationRetrieveDBClass/";
        String dbName = "PopulationDB"; // Database Name.
        
        PopulationDatabaseOperations.setConnection(dbDirectory, dbName);
        Towns towns = PopulationDatabaseOperations.retrieveAllTowns();
        printTowns(towns);
        
        System.out.println("Database Operation is Complete.");
    }
    
    public static void printTowns(Towns towns){
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
