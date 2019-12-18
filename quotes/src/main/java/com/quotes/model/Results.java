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
public class Results {
    String id;
    String created_at;
    String updated_at;
    String promoted_at;
    int width;
    int height;
    String color;
    String description;
    String alt_description;
    Urls urls;
    Links links;
    Object[] categories;
    int likes;
    boolean liked_by_user;
    Object current_user_collections;
    Object user;
    Object[] tags;
}
