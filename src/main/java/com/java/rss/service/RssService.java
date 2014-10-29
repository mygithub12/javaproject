package com.java.rss.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.java.model.Item;
import com.java.rss.exception.RssException;
import com.java.rssclasses.ObjectFactory;
import com.java.rssclasses.TRss;
import com.java.rssclasses.TRssChannel;
import com.java.rssclasses.TRssItem;



@Service
public class RssService {
	
	public List<Item> findAll(File file) throws RssException{
		
		return findAll(new StreamSource(file));
		
	}
	public List<Item> findAll(String url) throws RssException{
		
		return findAll(new StreamSource(url));
	}
	
	private List<Item> findAll(Source source) throws RssException{
		
		ArrayList<Item>itemList=new ArrayList<Item>();
		try {
			JAXBContext jaxb=JAXBContext.newInstance(ObjectFactory.class);
			
			Unmarshaller unmarshal= jaxb.createUnmarshaller();
			JAXBElement<TRss> jaxbElement=unmarshal.unmarshal(source,TRss.class);
			TRss rss=jaxbElement.getValue();
			List<TRssChannel>channels=rss.getChannel();
			for(TRssChannel channel:channels){
			List<TRssItem>items=channel.getItem();
			for(TRssItem item1 :items){
				Item item=new Item();
				item.setName(item1.getTitle());
				item.setDescription(item1.getDescription());
				item.setLink(item1.getLink());
				Date pubDate=new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z",Locale.ENGLISH).parse(item1.getPubDate());
				
				item.setDate(pubDate);
				itemList.add(item);
				
				
			}
			}
			
			
			
		} catch (JAXBException | ParseException e) {
			throw new RssException(e);
			
		}
		return itemList;
	}
	

}
