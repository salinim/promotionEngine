package com.demo.engine.promotion_engine.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SKU {
    private String id;
    private int price;
}
