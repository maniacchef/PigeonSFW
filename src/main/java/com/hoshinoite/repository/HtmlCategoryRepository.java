package com.hoshinoite.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.hoshinoite.model.HtmlCategory;

//CrudRepositoryの第一引数は関連Entity、第二引数は関連Entityのidの型
public interface HtmlCategoryRepository extends CrudRepository<HtmlCategory, Integer> {
	
	//標準で用意されいないようなメソッドは、メソッドに@Queryアノテーションを付与し、
	//アノテーションの引数にSQLを記述して定義します。SQLに渡したいパラメータは:引数名で指定できます。
	//自作メソッドは自由な命名が可能
	//該当するタグに属する属性一覧を抽出するSQL
	@Query("select c.* from htmltag as t, htmlcategory as c, htmltag_htmlcategory as r "
			+ "where t.tag_id = r.tag_id and c.category_id = r.category_id and t.tag_name = :tagName order by t.tag_id, c.category_id")
	List<HtmlCategory> findByTag(String tagName);
}