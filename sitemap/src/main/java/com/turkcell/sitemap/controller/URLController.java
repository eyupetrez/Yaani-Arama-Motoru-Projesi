package com.turkcell.sitemap.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import com.turkcell.sitemap.model.URLEntity;
import com.turkcell.sitemap.services.UrlService;


import java.net.URL;

@RestController
@RequestMapping("/api")
public class URLController {

	
	private final UrlService urlService;
			

	public URLController(UrlService urlService) {
		this.urlService = urlService;
	}

	@GetMapping()
	@RequestMapping(value = "/url", method = RequestMethod.GET)
	public List<URLEntity> findAllURLs(String url){
		
		HttpClient client = new DefaultHttpClient();  
        HttpGet request = new HttpGet(url);  
        StringBuffer result = new StringBuffer();  
        try {  
        	
            HttpResponse response = client.execute(request);  
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
            String line = "";  
            while ((line = rd.readLine()) != null) {  
                result.append(line);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        String url_tag = result.toString();
        
        List<URLEntity> urlEntities = new ArrayList<URLEntity>();
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            StringBuilder xmlStringBuilder = new StringBuilder();
            xmlStringBuilder.append(url_tag);
            ByteArrayInputStream input = new ByteArrayInputStream(
            xmlStringBuilder.toString().getBytes("UTF-8"));
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("url");
          
            for (int i = 0; i < nList.getLength(); i++) {
               URLEntity urlEntity = new URLEntity();
               URL domain_name = new URL(url);
               Node nNode = nList.item(i);
               System.out.println("\nCurrent Element :" + nNode.getNodeName());
               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  urlEntity.setLoc(eElement.getElementsByTagName("loc").item(0).getTextContent());
                  urlEntity.setId((long)(i+1));
                  urlEntity.setDomain_name(domain_name.getHost()); 
                  urlEntity.setDate(java.time.LocalDateTime.now().toString());
                  urlEntity.setUrl(url);
                  urlEntities.add(urlEntity);
                  System.out.println("LOC : " + eElement.getElementsByTagName("loc").item(0).getTextContent());
               }
            }
           
            
         } catch (Exception e) {
            e.printStackTrace();
         }
        
        
        urlService.saveAll(urlEntities);
        
		return urlEntities;
	}
	
	
}

