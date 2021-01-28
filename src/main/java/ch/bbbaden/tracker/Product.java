/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tracker;

import java.util.ArrayList;

/**
 *
 * @author timon
 */
public class Product {
    String name;
    ArrayList<OneInstance> cars = new ArrayList<OneInstance>();

    public Product(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OneInstance> getCars() {
        return cars;
    }

    public void setCars(ArrayList<OneInstance> cars) {
        this.cars = cars;
    }
    
    
}
