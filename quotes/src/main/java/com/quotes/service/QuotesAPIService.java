/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.service;

import com.quotes.model.MQuotesAPI;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import com.quotes.utils.Utils;
import java.util.List;

/**
 *
 * @author jufeg
 */
public class QuotesAPIService {

    public List<MQuotesAPI> getQuote() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://andruxnet-random-famous-quotes.p.rapidapi.com/?count=10")
                .get()
                .addHeader("x-rapidapi-host", "andruxnet-random-famous-quotes.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "SFtwCM9uebmshQXC1eMMUn4V3E3Dp1z7kJVjsnhNY0KcNkerbA")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String rpta = response.body().string();

            return Utils.quotesJsonToList(rpta);
        } catch (Exception e) {
            return null;
        }
    }
}
