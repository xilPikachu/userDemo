package com.example.demo.dao;

import com.example.demo.model.PO.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao {
    @Insert("insert into goods(goodsname,price,createTime,updateTime,createUserId,updateUserId,deleteFlag) values(#{goodsname},#{price},#{createTime},#{updateTime},#{createUserId},#{updateUserId},#{deleteFlag})")
    void addGoods(Goods goods);

    @Select("select * from goods where goodsname=#{goodsname}")
    Goods getPriceByName(String goodsname);

    @Delete("delete from goods where goodsname=#{goodsname}")
    void deleteGoods(String goodsname);

    @Update("update goods set price=#{password} where goodsname=#{goodsname}")
    void updateGoods(Goods goods);
}
