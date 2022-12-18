package com.gcu.store.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.store.StoreApplication;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.store.data.StoreDataService;
import com.gcu.store.data.entity.ItemEntity;
import com.gcu.store.models.ItemModel;


public class ItemBusinessService implements ItemBusinessInterface {

    @Autowired
    private StoreDataService service;

    public List<ItemModel> getItem()
    {
        List<ItemEntity> itemEntity = service.findAll();

        List<ItemModel> itemDomain = new ArrayList<ItemModel>();

        for (ItemEntity entity: itemEntity)
        {
            itemDomain.add(new ItemModel(entity.getId(),
                    entity.getName(), entity.getDescription(),
                    entity.getSku(), entity.getQuantity(),
                    entity.getPrice()));
        }
        return itemDomain;
    }

    public boolean addItem(ItemModel itemModel)
    {
        ItemEntity entity = new ItemEntity(null,
                itemModel.getName(),
                itemModel.getDescription(),
                itemModel.getSku(), itemModel.getQuantity(),
                itemModel.getPrice());

        return service.create(entity);
    }

    @Override
    public ItemModel getItemById(int id)
    {
        ItemEntity entity = service.findById(id);

        return new ItemModel(entity.getId(), entity.getName(),
                entity.getDescription(), entity.getSku(),
                entity.getQuantity(), entity.getPrice());
    }

    @Override
    public boolean deleteItem(ItemModel itemModel)
    {
        ItemEntity entity = new ItemEntity(itemModel.getId(),
                itemModel.getName(), itemModel.getDescription(),
                itemModel.getSku(), itemModel.getQuantity(), itemModel.getPrice()
                );
        return service.delete(entity);
    }

    public boolean updateItem(ItemModel itemModel)
    {
        ItemEntity entity = new ItemEntity(itemModel.getId(),
                itemModel.getName(), itemModel.getDescription(),
                itemModel.getSku(), itemModel.getQuantity(), itemModel.getPrice());
        return service.update(entity);
    }
}
