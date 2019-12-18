/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.quotes.model.MImagesAPI;
import com.quotes.model.MQuotesAPI;
import com.quotes.model.Results;
import java.util.ArrayList;
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

    public static Results imagesJsonToList(String rpta) {
        //Batuzai the machete master
        GsonBuilder builder = new GsonBuilder();
        Object o = builder.create().fromJson(rpta, Object.class);
        List<Object> d = new ArrayList<Object>();
        d = (List<Object>) o;
        LinkedTreeMap ax = (LinkedTreeMap) d.get(0);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(ax);
        Results rsx = builder.create().fromJson(jsonString, Results.class);
        return rsx;
    }
}
