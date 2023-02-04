package com.hoshinoite.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.hoshinoite.model.HtmlAttr;

//CrudRepositoryの第一引数は関連Entity、第二引数は関連Entityのidの型
public interface HtmlAttrRepository extends CrudRepository<HtmlAttr, String> {
	
	//標準で用意されていないようなメソッドは、メソッドに@Queryアノテーションを付与し、
	//アノテーションの引数にSQLを記述して定義します。SQLに渡したいパラメータは:引数名で指定できます。
	//自作メソッドは自由な命名が可能
	@Query("SELECT * FROM htmlattr WHERE remarks LIKE :remarks")
	List<HtmlAttr> findByRemarksLike(String remarks);
	
	//該当するタグに属する属性一覧を抽出するSQL
	@Query("select a.* from htmltag as t, htmlattr as a, htmltag_htmlattr as r "
			+ "where t.tag_id = r.tag_id and a.attr_id = r.attr_id and t.tag_name = :tagName order by t.tag_id, a.attr_id")
	List<HtmlAttr> findByTag(String tagName);
}
