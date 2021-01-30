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
    ArrayList<Snapshot> productSnapshot = new ArrayList<Snapshot>();

    public Product(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Snapshot> getCars() {
        return productSnapshot;
    }

    public void setCars(ArrayList<Snapshot> cars) {
        this.productSnapshot = cars;
    }
    
    
}
