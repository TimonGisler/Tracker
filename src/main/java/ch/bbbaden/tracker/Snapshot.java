/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tracker;

import java.io.Serializable;

/**
 *
 * @author timon
 */
public class Snapshot implements Serializable{
    double price;
    long time;

    public Snapshot(double price, long time) {
        this.price = price;
        this.time = time;
    }
    
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    

    
}
