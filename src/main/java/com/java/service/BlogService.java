package com.java.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Blog;
import com.java.model.Item;
import com.java.model.UserEntity;
import com.java.repositories.BlogRepository;
import com.java.repositories.ItemRepository;
import com.java.repositories.UserRepository;
import com.java.rss.exception.RssException;
import com.java.rss.service.RssService;

@Service
@Transactional
public class BlogService {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private BlogRepository blogRep;
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemRepository itemRep;
	
	
	public void itemSave(Blog blog) {
		
		
		try {
			List<Item>	items = rssService.findAll(blog.getUrl());
		
		
		for(Item item:items){
			
			
				item.setBlogs(blog);
				itemRep.save(item);
			}
		
	}catch (RssException e) {
		
		e.printStackTrace();
	}
	}

	public void saveBlog(Blog blog, String name) {

		UserEntity users=userRep.findByName(name);
		blog.setUser(users);

		blogRep.save(blog);
		itemSave(blog);
	}

	public void editBlog(Blog blog, String name) {

		
		blog.setUser(userRep.findByName(name));
		

		blogRep.save(blog);
	}

	
	public void deleteBlog(int id) {

		Blog blog = blogRep.findOne(id);
		blogRep.delete(blog);
	}
	
	public List<Blog> findAll(){
		
		return blogRep.findAll();
	}

}
