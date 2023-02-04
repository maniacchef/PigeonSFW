package com.hoshinoite.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//多対多の関係であるhtmltagとhtmlcategoryの紐づけを実現するための中間テーブル用のエンティティ
@Data				//getter,setter自動生成
@NoArgsConstructor
@AllArgsConstructor
@Table(name="htmltag_htmlcategory")
public class HtmlCategoryRef {
    private Integer categoryId;
}
