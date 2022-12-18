package com.gcu.store.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gcu.store.StoreApplication;
import com.gcu.store.data.entity.ItemEntity;
import com.gcu.store.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoreDataService implements DataAccessInterface<ItemEntity>{

    @Autowired
    private ItemRepository itemRepository;

    public StoreDataService(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

   @Override
    public List <ItemEntity> findAll()
   {
       List<ItemEntity> items = new ArrayList<ItemEntity>();

       try
       {
           Iterable<ItemEntity> itemIterable = itemRepository.findAll();

           itemIterable.forEach(items::add);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       return items;
   }

   @Override
    public ItemEntity findById(int id)
   {
       Optional<ItemEntity> item = itemRepository.findById((long) id);

       return item.get();
   }

   @Override
    public boolean create(ItemEntity item)
   {
       try
       {
           itemRepository.save(item);
       }
       catch (Exception e)
       {
           e.printStackTrace();
           return false;
       }
       return true;
   }

   @Override
    public boolean update(ItemEntity item)
   {
       try
       {
           itemRepository.save(item);
       }
       catch (Exception e)
       {
           e.printStackTrace();
           return false;
       }
       return true;
   }

   @Override
   public boolean delete(ItemEntity item)
   {
       try
       {
           itemRepository.delete(item);
       }
       catch (Exception e)
       {
           e.printStackTrace();
           return false;
       }
       return true;
   }







}
