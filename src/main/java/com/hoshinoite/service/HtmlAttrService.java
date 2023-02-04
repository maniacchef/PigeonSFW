package com.hoshinoite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoshinoite.model.HtmlAttr;
import com.hoshinoite.repository.HtmlAttrRepository;

@Service
@Transactional
public class HtmlAttrService {
    @Autowired
    private HtmlAttrRepository repository;

    public List<HtmlAttr> GetAllGlobalAttr() {
        return repository.findByRemarksLike("%グローバル属性%");
    }
}
