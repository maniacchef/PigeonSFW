package com.hoshinoite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//getter,setter自動生成
@NoArgsConstructor
@AllArgsConstructor
@Table(name="htmlcategory")
public class HtmlCategory {
	@Id
    private Integer categoryId;
    private String categoryName;	
    private String description;
}
