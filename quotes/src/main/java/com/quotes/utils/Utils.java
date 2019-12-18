/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.utils;

import com.google.gson.Gson;
import com.quotes.model.MQuotesAPI;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jufeg
 */
public class Utils {
    public static List<MQuotesAPI> quotesJsonToList(String rpta) {
        Gson gson = new Gson();
        MQuotesAPI[] arl = gson.fromJson(rpta, MQuotesAPI[].class);
        List<MQuotesAPI> quoteList = Arrays.asList(arl);
        return quoteList;
    }
/*
    public static void imagesJsonToList(String rpta) {
    
        GsonBuilder builder = new GsonBuilder();
        Object o = builder.create().fromJson(rpta, Object.class);
        
        System.out.println(o);
    }*/
}
