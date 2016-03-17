package com.xml;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathExpression;

public class XmlMergeDemo {
	
	
	public static void main(String[] args) {
		
		
		
		
		try {
			XmlMergeDemo obj = new XmlMergeDemo();
			
			// This does not work in main method
			//URL url = obj.getClass().getResource("resources/xml/test.xml");
			
			URL strawBerryMenuURL = ClassLoader.getSystemResource("xml/hotelMenu/hotel_Strawberry.xml");
			URL blueBerryMenuURL = ClassLoader.getSystemResource("xml/hotelMenu/hotel_Blueberry.xml");
			
			strawBerryMenuURL.getPath();
			
			File strawBerryMenuXml= new File(strawBerryMenuURL.getPath());
			File blueBerryMenuXml= new File(blueBerryMenuURL.getPath());
			
			
			SAXBuilder jdomBuilder = new SAXBuilder();
			
			//strawBerryMenu.xml is the first xml to merge so taking it as destination xml document.
			Document strawBerryDocument = jdomBuilder.build(strawBerryMenuXml);
			
			//blueBerry Foods will be merge into mergeDocument which has all the food selections from strawBerry Hotel
			Document blueBerryDocument = jdomBuilder.build(blueBerryMenuXml);
			
			
			XPathFactory xFactory = XPathFactory.instance();
			
			//xpath to select all the food elements 
			XPathExpression<Element> foodXPath = xFactory.compile("//food", Filters.element());
			
			//Give all the food from BlueBerry Hotel
			List<Element> blueBerryFoods = foodXPath.evaluate(blueBerryDocument);
			
			//xpath to select all the category 
			XPathExpression<Element> categoryXPath = xFactory.compile("//category", Filters.element());
					
			//give us handle to category nodes where in we want to merge the food.
			List<Element> strawBerryCategory = categoryXPath.evaluate(strawBerryDocument);
			
			//Assuming both hotels has same number of food category
			for(int i=0; i < blueBerryFoods.size(); i++){
				
				strawBerryCategory.get(i).addContent(blueBerryFoods.get(i).detach());
			}
			
			XMLOutputter outXml = new XMLOutputter();
			
			System.out.println(outXml.outputString(strawBerryDocument));
			
			//INCLUDE JAXEN Dependency to avoid below error
			//java.lang.NoClassDefFoundError: org/jaxen/NamespaceContext
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
				
		
	}

}
