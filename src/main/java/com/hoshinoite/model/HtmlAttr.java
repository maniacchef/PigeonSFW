package com.hoshinoite.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//getter,setter自動生成
@NoArgsConstructor
@AllArgsConstructor
@Table(name="htmlattr")
public class HtmlAttr {
	@Id
    private String attrId;
    private String attrName;
    private String description;
    private String remarks;    
}
