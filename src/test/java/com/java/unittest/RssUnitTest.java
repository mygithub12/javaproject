package com.java.unittest;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.model.Item;
import com.java.rss.exception.RssException;
import com.java.rss.service.RssService;

public class RssUnitTest {

	@Autowired
	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();

	}

	@Test
	public void testFindAllFile() throws RssException {
		List<Item> items = rssService.findAll(new File("RssTest/sample.xml"));

		Assert.assertEquals(10, items.size());
		Item firstItem=items.get(0);
		Assert.assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getName());
		

	}

}
