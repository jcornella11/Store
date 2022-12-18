package com.gcu.store.business;

import java.util.List;

import com.gcu.store.data.entity.ItemEntity;
import com.gcu.store.models.ItemModel;

public interface ItemBusinessInterface {

    public List<ItemModel> getItem();

    public boolean addItem(ItemModel itemModel);

    public ItemModel getItemById(int id);

    public boolean deleteItem(ItemModel itemModel);

    public boolean updateItem(ItemModel itemModel);

}
