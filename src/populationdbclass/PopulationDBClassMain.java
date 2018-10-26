/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationdbclass;

/**
 *
 * @author 55colessa31
 */
public class PopulationDBClassMain {
    
    public static void main(String[] args){
        
        String dbDirectory = "C:/Users/55colessa31/Documents/GitHub/PopulationDBClass/";
        String dbName = "PopulationDB";
        
        PopulationDatabaseOperations.setConnection(dbDirectory, dbName);
        
        //printTowns();
        
        PopulationDatabaseOperationsCustomException.run();
        
        //printTowns();
        
        System.out.println("Database Operation Complete.");
    }
    
    public static void printTowns(){
        Towns towns = PopulationDatabaseOperations.retrieveAllTowns();
        
        for(int i = 0; i<towns.size();i++){
            System.out.println("Town Number: "+(towns.get(i)).getTownNumber());
            System.out.println("Town Name: "+(towns.get(i)).getTownName());
            System.out.println("Town County Number: "+(towns.get(i)).getCountyNumber());
            System.out.println("Town Region Number: "+(towns.get(i)).getRegionNumber());
            System.out.println("Town Population: "+(towns.get(i)).getPopulation());
            System.out.println();
        }
    }
    
    public static void printTown(int townNumberIn){
        Town town = PopulationDatabaseOperations.retrieveTown(townNumberIn);

        System.out.println("Town Number: "+town.getTownNumber());
        System.out.println("Town Name: "+town.getTownName());
        System.out.println("Town County Number: "+town.getCountyNumber());
        System.out.println("Town Region Number: "+town.getRegionNumber());
        System.out.println("Town Population: "+town.getPopulation());
        System.out.println();
    }
}
