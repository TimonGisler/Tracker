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

    public String getName(String url, boolean urlChanged) {
        String name = null;

        //If url changed get new html file, if it remained the same, just use safed file.
        if (urlChanged && !d.equals(null)) {
            try {
                d = Jsoup.connect(url).get();
                name = d.getElementsByClass("productHeaderTitle__Name-jqo5ci-1").text();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            name = d.getElementsByClass("productHeaderTitle__Name-jqo5ci-1").text();
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

            System.out.println(doublePrice);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
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
