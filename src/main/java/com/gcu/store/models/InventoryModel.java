package com.gcu.store.models;

import java.util.ArrayList;
import java.util.List;

public class InventoryModel {

    private List<ItemModel> inventory = new ArrayList<ItemModel>();

    public List<ItemModel> getItems() {return this.inventory;}

    public void setItems(List<ItemModel> items) {this.inventory = inventory;}
}
