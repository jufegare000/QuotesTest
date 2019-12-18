/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.external.service;

import com.quotes.utils.Utils;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/**
 *
 * @author jufeg
 */
public class ImageAPIService {
    public String getURL(String category) throws IOException {

        OkHttpClient client = new OkHttpClient();
        String clientID = "cfd94231516069e09a8066646618659ff0554bc3216dac0561525cecdbd8b0cc";
        Request request = new Request.Builder()
                .url("https://api.unsplash.com/photos?query="+ category + "&client_id="+clientID)
                .get()
                .build();
         try {
            Response response = client.newCall(request).execute();
            
            
             String rpta = response.body().string();
             System.out.println(rpta);
             System.out.println(response.body());
             Utils.imagesJsonToList(rpta);
             System.out.println(response.body());
             int linf = rpta.indexOf("\"raw=\"");
             
             int lims;
             String val = rpta.substring(linf);
             String val1 = "";
              
             String val2 = "";
             linf = rpta.indexOf("raw=");
             String val3 = "";
             String val4 = "";
             
             return rpta;
        } catch (Exception e) {
             return e.getMessage();
        }
    }
}
