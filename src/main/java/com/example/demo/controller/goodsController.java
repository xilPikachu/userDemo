package com.example.demo.controller;

import com.example.demo.dao.GoodsDao;
import com.example.demo.model.PO.Goods;
import com.example.demo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class goodsController {
    @Autowired
    private IGoodsService iGoodsService;
    private GoodsDao goodsDao;

    @PostMapping("/registergoods")
    public String gooddsVefify(Goods goods){

        String addGoods = iGoodsService.addGoods(goods);
        return addGoods;

        /*Date date = new Date();
        goods.setCreateTime(date);
        goods.setUpdateTime(date);
        goods.setDeleteFlag(0);

//        String encryptPassword = MD5Util.computeMD5(String.valueOf(goods.getPrice()));
//        goods.setPrice(encryptPassword);

        goodsDao.addGoods(goods);
        System.out.println("user = [" + goods + "]");
        return "{\"status\":\"ok\"}";*/

    }

    @GetMapping("/selectgoods")
    public Goods selectGoods(String goodsname){
        if (goodsname == null){
            return null;
        }else {
            Goods goods=goodsDao.getPriceByName(goodsname);
            return goods;
        }
    }

    @DeleteMapping("/deletegoods")
    public String deleteGoods(String goodsname){
        goodsDao.deleteGoods(goodsname);
        return "{\"status\":\"ok\"}";
    }

    @PostMapping("/updategoods")
    public String updateGoods(Goods goods){
        goodsDao.updateGoods(goods);
        return "{\"status\":\"ok\"}";
    }
}
