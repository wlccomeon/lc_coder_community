package com.cc.durid.monitor.dao;

import com.cc.durid.monitor.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface TestDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {
	/**
	 * 文章点赞数量增加
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE tb_article a SET a.`thumbup` = a.`thumbup`+1 WHERE id = ?;",nativeQuery = true)
	int addThumbsup(String articleId);
}
