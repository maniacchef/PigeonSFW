package com.hoshinoite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoshinoite.model.HtmlAttr;
import com.hoshinoite.model.HtmlCategory;
import com.hoshinoite.model.HtmlTag;
import com.hoshinoite.repository.HtmlAttrRepository;
import com.hoshinoite.repository.HtmlCategoryRepository;
import com.hoshinoite.repository.HtmlTagRepository;

@Service
@Transactional
public class HtmlTagService {
    @Autowired
    private HtmlTagRepository tagRepository;
    @Autowired
    private HtmlCategoryRepository categoryRepository;
    @Autowired
    private HtmlAttrRepository attrRepository;

    public Iterable<HtmlTag> SelectAll() {
    	
    	Iterable<HtmlTag> workTags = tagRepository.findAll();
    	
    	//タグの総数分回るループ
    	for(HtmlTag tag : workTags) {
    		
    		//tagRepository.findAll()で、各タグと同じ頭文字の属性が結びつくバグ？があるので、
    		//一度属性をクリアする。
    		//例：aタグのidはa01, accept属性のidはa01。おそらくidの文字列が全く同じであるため、
    		//accept属性はaタグと関連がないにもかかわらず、結びつけられてしまう。
    		tag.clearAttr();
    		
    		//デバッグ用
    		//System.out.println(tag.getAttrs());
    		
    		//タグ名を抽出
    		String tagName = tag.getTagName();
    		
    		//タグ名に紐づくカテゴリ一覧抽出
    		List<HtmlCategory> categories = categoryRepository.findByTag(tagName);
    		
    		//タグ名に紐づくカテゴリ各要素に対するループ
    		//紐づくカテゴリ一覧についてEntity単体を抽出
    		for(HtmlCategory category : categories) {
	    		//HtmlTag.addCategory()呼び出しにより、HtmlCategoryを紐づけ
        		tag.addCategory(category);
    		}
    		
    		//タグ名に紐づく属性一覧抽出
    		List<HtmlAttr> attrs = attrRepository.findByTag(tagName);
    		
    		//タグ名に紐づく属性各要素に対するループ
    		//紐づく属性一覧についてEntity単体を抽出
    		for(HtmlAttr attr : attrs) {
	    		//HtmlTag.addAttr()呼び出しにより、HtmlAttrを紐づけ
        		tag.addAttr(attr);
    		}
    		//デバッグ用 テスト。新eclipseから。
    		//System.out.println(tagName);
    		//System.out.println(tag.getCategories());
    		//System.out.println(tag.getAttrs());
    	}    	
    	
    	return workTags;
    }
}
