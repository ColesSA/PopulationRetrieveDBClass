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
public class PopulationRetrieveAddDBClass {
    
    public static void run() {
        
        int townNumberIn = 19;
        String townNameIn = "Pittsburgh";
        int countyNumberIn = 7;
        int regionNumberIn = 5;
        int populationIn = 303625;
        
        Town townNew = fillTown(townNumberIn, townNameIn, countyNumberIn, regionNumberIn, populationIn);
        
        PopulationDatabaseOperations.insertTown(townNew);
    }
    
    public static Town fillTown(int townNumberIn, String townNameIn, int countyNumberIn, int regionNumberIn, int populationIn){
        Town townNew = new Town();
        townNew.setTownNumber(townNumberIn);
        townNew.setTownName(townNameIn);
        townNew.setCountyNumber(countyNumberIn);
        townNew.setRegionNumber(regionNumberIn);
        townNew.setPopulation(populationIn);
        return townNew;
    }
}
