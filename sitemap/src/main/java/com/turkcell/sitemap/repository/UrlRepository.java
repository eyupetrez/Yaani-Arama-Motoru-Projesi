package com.turkcell.sitemap.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.sitemap.model.URLEntity;


public interface UrlRepository extends JpaRepository<URLEntity, Long>{

}
