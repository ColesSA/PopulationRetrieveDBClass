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
public class PopulationDatabaseOperationsCustomException {
    public static void run(){
        final int townNumber = 71;
        final int populaiton = 356000;
        
        PopulationDatabaseOperations.modifyPopulation(townNumber, populaiton);
    }
}
