package com.hoshinoite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoshinoite.model.HtmlCategory;
import com.hoshinoite.service.HtmlCategoryService;
/**
 *  HTMLカテゴリに関するリクエストを制御するコントローラーです。
 *  対応するモデルクラスはHtmlCategoryクラスとなります。
 *  @version 1.0.0
 */
@CrossOrigin
@RestController
public class HtmlCategoryController {
    @Autowired
    private HtmlCategoryService service;

    /**
     * すべてのHTMLカテゴリを返却する。
     * URL例：GET http://localhost/htmlcategory
     *
     * @return JSON配列のHTMLカテゴリ
     */
    @GetMapping("htmlcategory")
    public Iterable<HtmlCategory> GetAllHtmlCategory() {
        return service.SelectAll();
    }
}
