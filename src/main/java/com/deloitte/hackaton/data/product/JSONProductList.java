package com.deloitte.hackaton.data.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class JSONProductList {

    @JsonProperty("products")
    private List<JSONProductData> products;
}