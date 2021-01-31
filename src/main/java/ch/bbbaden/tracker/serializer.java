/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tracker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author timon
 */
public class serializer {

    public static void productSerializeDataOut(ObservableMap<String, Product> trackedProducts) {
        try {

            String fileName = "TrackedProducts.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new HashMap<String, Product>(trackedProducts));
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ObservableMap<String, Product> productSerializeDataIn() {
        try {
            String fileName = "TrackedProducts.txt";
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            HashMap<String, Product> list = (HashMap<String, Product>) ois.readObject();
            ois.close();
            System.out.println("HELLLLLOOO???'''");
            return FXCollections.observableMap(list);
        } catch (Exception e) {
            
            if (e.getMessage().contains("Das System kann die angegebene Datei nicht finden")) {
                System.out.println("Die Datei wurde nicht gefunden");
            }else{
                e.printStackTrace();
            }
            
            
            System.out.println(e.getMessage());
            
            
            return FXCollections.observableHashMap();
        }

    }

}
