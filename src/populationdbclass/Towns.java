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
public class Towns {
    private final ArrayList<Town> TOWNS = new ArrayList<>();
    
    public void add(Town town){
        TOWNS.add(town);
    }
    
    public Town get(int i){
        return TOWNS.get(i);
    }
    
    public int size(){
        return TOWNS.size();
    }
    
    public void sort(){
        TOWNS.sort(null);
    }
}
