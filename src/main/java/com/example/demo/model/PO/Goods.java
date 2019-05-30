package com.example.demo.model.PO;

import com.example.demo.model.PO.base.BaseEntity;
import lombok.Data;

@Data
public class Goods extends BaseEntity {
    private String goodsname;
    private float price;
}
