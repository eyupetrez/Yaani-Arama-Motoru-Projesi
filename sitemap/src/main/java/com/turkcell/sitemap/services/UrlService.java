package com.turkcell.sitemap.services;

import java.util.List;

import com.turkcell.sitemap.model.URLEntity;

public interface UrlService {

	List<URLEntity> saveAll(List<URLEntity> urlEntities);
}
