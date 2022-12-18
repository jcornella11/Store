package com.gcu.store.models;

import java.util.ArrayList;
import java.util.List;

public class CartModel {

    private List<ItemModel> cart = new ArrayList<ItemModel>();

    public List<ItemModel> getItems() {return this.cart;}

    public void setItems(List<ItemModel> items) {this.cart = cart;}

}
