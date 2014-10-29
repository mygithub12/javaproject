package com.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {



Page<Item> findAll(Pageable pageable);


Item findByName(String name);



	

}
