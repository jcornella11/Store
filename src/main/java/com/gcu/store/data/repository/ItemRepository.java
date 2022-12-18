package com.gcu.store.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.store.data.entity.ItemEntity;

public interface ItemRepository extends CrudRepository <ItemEntity, Long>{
}
