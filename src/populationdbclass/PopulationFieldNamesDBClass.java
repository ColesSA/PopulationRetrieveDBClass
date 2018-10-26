/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationdbclass;

import java.util.ArrayList;

/**
 *
 * @author 55colessa31
 */
public class PopulationFieldNamesDBClass {
    public static void run(){
        ArrayList<String> tableNames = PopulationDatabaseOperations.getTableNames();
        ArrayList<String> fieldNames = PopulationDatabaseOperations.getFieldNames();
        ArrayList<String> fieldNamesAlternate = PopulationDatabaseOperations.getFieldNamesAlternate();
        printList("--------METADATA--------\nTABLE NAMES:", tableNames, "");
        printList("FIELD NAMES:", fieldNames, "");
        printList("FIELD NAMES ALTERNATE:", fieldNamesAlternate, "");
    }
    
    public static void printList(String before, ArrayList<String> list, String after){
        System.out.println(before);
        for(int i=0;i<list.size();i++){
            System.out.println("   "+list.get(i));
        }
        System.out.println(after);
    }
}
