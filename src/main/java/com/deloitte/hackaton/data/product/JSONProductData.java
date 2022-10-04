package com.deloitte.hackaton.data.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jpackage.internal.Log;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Getter
@Setter
public class JSONProductData {

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("available")
    private Boolean available;

    @JsonProperty("id")
    private Integer id;

    @Override
    public String toString() {
        return "Product " + this.name;
    }
}