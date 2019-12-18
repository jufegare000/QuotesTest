/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author jufeg
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Links {
    String self;
    String html;
    String download;
    String download_location;
}
