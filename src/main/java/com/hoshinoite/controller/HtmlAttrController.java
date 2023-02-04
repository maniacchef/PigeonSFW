package com.hoshinoite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoshinoite.model.HtmlAttr;
import com.hoshinoite.service.HtmlAttrService;
/**
 *  HTML属性に関するリクエストを制御するコントローラーです。
 *  対応するモデルクラスはHtmlAttrクラスとなります。
 *  @version 1.0.0
 */
@CrossOrigin
@RestController
public class HtmlAttrController {

	//@Autowiredは、DI（依存性注入）を実現したい時に指定する。
	//使用するインスタンスがインターフェースだった場合付加。
	//ネスト先がインターフェースだった場合も指定する必要があるようで、
	//したがって以下のserviceは設定が必要。
	@Autowired
    private HtmlAttrService service;

    /**
     * すべてのグローバル属性を返却する。
     * URL例：GET http://localhost/htmlattr
     *
     * @return JSON配列のHTML属性
     */
    @GetMapping("htmlattr")
    public List<HtmlAttr> GetAllGlobalAttr() {
        return service.GetAllGlobalAttr();
    }
}
