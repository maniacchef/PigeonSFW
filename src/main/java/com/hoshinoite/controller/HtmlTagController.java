package com.hoshinoite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoshinoite.model.HtmlTag;
import com.hoshinoite.service.HtmlTagService;

/**
 *  HTMLタグに関するリクエストを制御するコントローラーです。
 *  対応するモデルクラスはHtmlTagクラスとなります。
 *  @version 1.0.0
 */
@CrossOrigin
@RestController
public class HtmlTagController {
    @Autowired
    private HtmlTagService service;
    
    /**
     * すべてのHTMLカテゴリを返却する。
     * URL例：GET http://localhost/htmlcategory
     *
     * @return JSON配列のHTMLカテゴリ
     */
    @GetMapping("htmltag")
    public Iterable<HtmlTag> GetAllHtmlTag() {
        return service.SelectAll();
    }
}
