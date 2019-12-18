/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.bl;

import com.quotes.external.service.ImageAPIService;
import com.quotes.model.MQuotesAPI;
import com.quotes.quotes.Quote;
import com.quotes.external.service.QuotesAPIService;
import java.io.IOException;

/**
 *
 * @author jufeg
 */
public class QuotesBL {
    
     private static QuotesBL singletonInstance = new QuotesBL();
    
     public static QuotesBL getInstance() {
        synchronized (QuotesBL.class) {
            if (singletonInstance == null) {
                singletonInstance = new QuotesBL();
            }
        }
        return singletonInstance;
    }
     
     public Quote createQuote() throws IOException{
         MQuotesAPI qapi = new MQuotesAPI();
         QuotesAPIService srv = new QuotesAPIService();
         ImageAPIService isrv = new ImageAPIService();
         qapi = srv.getQuote().get(0);
         String url = isrv.getURL(qapi.getCategory());
         Quote current = new Quote();
         current.setText(qapi.getQuote());
         current.setUrl(url);
         return current;
     }
    
}
