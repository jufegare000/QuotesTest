/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.quotes;

import com.quotes.bl.QuotesBL;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
@RequestMapping("/quotes")
@Api(value = "quote Management System", description = "Operations pertaining to quote "
        + "in quote Management System")
public class QuoteController {

    @Autowired
    private QuoteRepository repo;


    

    @ApiOperation(value = "Add an quote")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Quote create(@ApiParam(value = "Quote object store in database table", required = true) 
    @RequestBody Quote quote) throws IOException {
        //
        Quote current;
        current = new Quote();
        current = QuotesBL.getInstance().createQuote();
        return repo.save(current);
    }

    @ApiOperation(value = "Get a quote by Id")
    @RequestMapping(method = RequestMethod.GET, value = "/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Quote> get(@ApiParam(value = "Quote id from which quote object will retrieve",
            required = true) @PathVariable String quoteId) {

        return repo.findById(quoteId);
    }

    @ApiOperation(value = "View a list of available quote", response = List.class)
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved list"),
    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Quote> quote() {
                return repo.findAll();
    }
    
    @ApiOperation(value = "Update an quote by Id")
    @RequestMapping(method = RequestMethod.PUT, value = "/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Quote update(@ApiParam(value = "quote id from which quote object will retrieve",
            required = true) @PathVariable String quoteId, 
            @ApiParam(value = "quote object store in database table", required = true) 
            @RequestBody Quote quote) {
        Optional<Quote> e = repo.findById(quoteId);
        if(e.isPresent()){
            Quote currentQuote = e.get();
            currentQuote.setText(quote.getText());
            currentQuote.setUrl(quote.getUrl());
            return repo.save(currentQuote);
        }
        return null;
    }
    
    @ApiOperation(value = "Delete an quote")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{quoteId}")
    public void delete(@ApiParam(value = "quote id store in database table", required = true) 
    @PathVariable String quoteId) {        
        repo.deleteById(quoteId);
    }
    
}
