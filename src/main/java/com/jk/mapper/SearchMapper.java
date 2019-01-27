package com.jk.mapper;

import com.jk.bean.Comment;
import com.jk.bean.Product;
import com.jk.bean.ShopCar;

import java.util.List;

public interface SearchMapper {

    public List<Comment> comment(Integer id);

    public void rules(Comment comment);


    public List<ShopCar>  shoppingcart();
}
