package com.turkcell.sitemap.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.sitemap.model.URLEntity;
import com.turkcell.sitemap.repository.UrlRepository;

@Service
public class UrlServiceImp implements UrlService{
	
	private final UrlRepository urlRepository;

	public UrlServiceImp(UrlRepository urlRepository) {
	
		this.urlRepository = urlRepository;
	}

	@Override
	public List<URLEntity> saveAll(List<URLEntity> urlEntities) {
		
		return urlRepository.saveAll(urlEntities);
	}



	
	

	
	
	
	
	

}
	
