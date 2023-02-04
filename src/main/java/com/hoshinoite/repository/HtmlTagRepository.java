package com.hoshinoite.repository;

import org.springframework.data.repository.CrudRepository;

import com.hoshinoite.model.HtmlTag;

//CrudRepositoryの第一引数は関連Entity、第二引数は関連Entityのidの型
public interface HtmlTagRepository extends CrudRepository<HtmlTag, String>{
}
