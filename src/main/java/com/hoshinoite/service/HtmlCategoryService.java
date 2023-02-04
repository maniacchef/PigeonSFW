package com.hoshinoite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoshinoite.model.HtmlCategory;
import com.hoshinoite.repository.HtmlCategoryRepository;

@Service
@Transactional
public class HtmlCategoryService {
    @Autowired
    private HtmlCategoryRepository repository;

    public Iterable<HtmlCategory> SelectAll() {
    	return repository.findAll();
    }
}
