/*package com.java.initdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.model.Blog;
import com.java.model.Item;
import com.java.model.Role;
import com.java.model.UserEntity;
import com.java.repositories.BlogRepository;
import com.java.repositories.ItemRepository;
import com.java.repositories.RoleRepository;
import com.java.repositories.UserRepository;


@Service
@Transactional
public class InitDb {
	
	@Autowired
 private UserRepository userRep;
	
	@Autowired
 private RoleRepository roleRep;
	
	@Autowired
 private BlogRepository blogRep;
	
	@Autowired
 private ItemRepository itemRep;
	
	
	@PostConstruct
	public void initDb(){
		
		Role roleAdmin=new Role();
		
	roleAdmin.setName("ROLE_ADMIN");
	roleRep.save(roleAdmin);
	
	Role roleUser=new Role();
	
	
	roleUser.setName("ROLE_USER");
	roleRep.save(roleUser);
	
	UserEntity user1=new UserEntity();
	user1.setEnabled(true);
	user1.setName("rahul");
	
	
	user1.setPassword("password");
	
	user1.setEmail("rahul@gmail.com");
	List<Role> roles=new ArrayList<Role>();
	roles.add(roleAdmin);
	user1.setRoles(roles);
	
	userRep.save(user1);
	
	Blog blog = new Blog();
	
	blog.setName("java");
	blog.setUrl("http://feeds.feedburner.com/javavids?format=xml/");
	blog.setUser(user1);
	blogRep.save(blog);
	
	
	Item items=new Item();
	
	items.setDate(new Date());
	items.setDescription("hello");
	items.setLink("link");
	items.setName("item name");
	items.setBlogs(blog);
	
	}

}
*/