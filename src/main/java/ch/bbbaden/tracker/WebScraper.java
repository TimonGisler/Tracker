/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tracker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author timon
 */
public class WebScraper {

    Document d = null;

    public String getName(String url) {
        String name = null;

        //If url changed get new html file, if it remained the same, just use safed file.
            try {
                d = Jsoup.connect(url).get();
                name = d.getElementsByClass("productHeaderTitle__Name-jqo5ci-1").text();

            } catch (Exception e) {
                e.printStackTrace();
            }


        return name;
    }

    public double getCurrentPrice(String url) {
        double doublePrice = -1;
        
        try {
            d = Jsoup.connect(url).get();
            String price = d.getElementsByClass("ZZhz").text();
            price = removeFromString(price, ".–");

            doublePrice = convertStringToDouble(price);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return doublePrice;
    }

    public double convertStringToDouble(String stringPrice) {
        double doublePrice = -1;
        try {
            doublePrice = Double.parseDouble(stringPrice);
        } catch (Exception e) {
            System.out.println("Failed converting");
            System.out.println("INPUT WAS: " + stringPrice);
        }

        return doublePrice;
    }

    public String removeFromString(String originalString, String remove) {
        String r = originalString.replace(remove, "");

        return r;
    }

}
