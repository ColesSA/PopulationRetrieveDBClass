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
public class PopulationAddDeleteDBClass {
    public static void run(){
        
        int townNumberIn = 19;
               
        PopulationDatabaseOperations.deleteTown(townNumberIn);
    }
}
