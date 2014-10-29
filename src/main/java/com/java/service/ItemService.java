package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.java.model.Item;
import com.java.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRep;
	
	public List<Item>findAll(){
		
		return itemRep.findAll(new PageRequest(0, 50, Direction.DESC, "date")).getContent();
	}


	public Item searchByName(String name) {
		
		return itemRep.findByName(name);
	}

	
	
}
