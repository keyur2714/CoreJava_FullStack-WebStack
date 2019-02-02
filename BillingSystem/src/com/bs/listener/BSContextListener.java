package com.bs.listener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bs.dto.MenuItem;

@WebListener
public class BSContextListener implements ServletContextListener {

    public BSContextListener() {
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)  {
    	ServletContext context = servletContextEvent.getServletContext();
    	System.out.println(context.getContextPath()+" ===");
    	try {		
			Properties properties = new Properties();			
			InputStream input =  new FileInputStream(context.getRealPath("/WEB-INF/bs.properties"));			
	    	properties.load(input);
	    	System.out.println("File Loaded...");
	    	
	    	List<MenuItem> menuItemList = new ArrayList();
	    	
	    	MenuItem menuItem1 = new MenuItem();
	    	menuItem1.setDesc(properties.getProperty("menuItem1.desc"));
	    	menuItem1.setUrl(properties.getProperty("menuItem1.url"));
	    	
	    	MenuItem menuItem2 = new MenuItem();
	    	menuItem2.setDesc(properties.getProperty("menuItem2.desc"));
	    	menuItem2.setUrl(properties.getProperty("menuItem2.url"));
	    	
	    	MenuItem menuItem3 = new MenuItem();
	    	menuItem3.setDesc(properties.getProperty("menuItem3.desc"));
	    	menuItem3.setUrl(properties.getProperty("menuItem3.url"));
	    	
	    	MenuItem menuItem4 = new MenuItem();
	    	menuItem4.setDesc(properties.getProperty("menuItem4.desc"));
	    	menuItem4.setUrl(properties.getProperty("menuItem4.url"));
	    	
	    	MenuItem menuItem5 = new MenuItem();
	    	menuItem5.setDesc(properties.getProperty("menuItem5.desc"));
	    	menuItem5.setUrl(properties.getProperty("menuItem5.url"));
	    	
	    	MenuItem menuItem6 = new MenuItem();
	    	menuItem5.setDesc(properties.getProperty("menuItem6.desc"));
	    	menuItem5.setUrl(properties.getProperty("menuItem6.url"));
	    	
	    	menuItemList.add(menuItem1);
	    	menuItemList.add(menuItem2);
	    	menuItemList.add(menuItem3);
	    	menuItemList.add(menuItem4);
	    	menuItemList.add(menuItem5);
	    	menuItemList.add(menuItem6);
	    	
	    	context.setAttribute("menuItemList", menuItemList);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		} 
    	
    }
	
}
