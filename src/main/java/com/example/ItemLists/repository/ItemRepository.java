package com.example.ItemLists.repository;

import com.example.ItemLists.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository  extends CrudRepository<Item, Long> {

}