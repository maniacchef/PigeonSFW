package com.hoshinoite.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//getter,setter自動生成
@NoArgsConstructor
@AllArgsConstructor
@Table(name="htmltag")
public class HtmlTag {
	@Id
    private String tagId;
    private String tagName;
    private String origin;
    private String description;
    private String remarks;

    //下記はhtmltagテーブルにはないフィールドだが、定義できている。
    //@MappedCollectionアノテーションは必要。これを外すと、適当な文字列を主キーとみなすが、そんなものは定義されていないのでエラーになる
    //指定するidは該当テーブルの主キー名を指定
    //ちなみにSetをArrayListに替えると、適当な文字列を主キーとして探しに行きエラーになる。sfwのバグかも
    @MappedCollection(idColumn = "category_id")
    private Set<HtmlCategory> categories = new HashSet<>();
    
    @MappedCollection(idColumn = "attr_id")
    private Set<HtmlAttr> attrs = new HashSet<>();

    //タグに紐づくカテゴリ情報を追加
    //add()呼び出し時に改めてnew()してるのは、deep copyに相当しているものと思われる
    public void addCategory(HtmlCategory category) {
    	categories.add(new HtmlCategory(category.getCategoryId(),category.getCategoryName(),category.getDescription()));
    }

    //タグに紐づく属性情報を追加
    public void addAttr(HtmlAttr attr) {
    	attrs.add(new HtmlAttr(attr.getAttrId(),attr.getAttrName(),attr.getDescription(),attr.getRemarks()));
    }
    
    public void clearAttr() {
    	attrs.clear();
    }
}
