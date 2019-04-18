package com.cc.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author lc
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

	/**
	 * 文章审核
	 */
	@Modifying
	@Query(value = "UPDATE tb_article a SET a.`state` = '1' WHERE id = ?;",nativeQuery = true)
	void articleAudit(String articleId);

	/**
	 * 文章点赞数量增加
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE tb_article a SET a.`thumbup` = a.`thumbup`+1 WHERE id = ?;",nativeQuery = true)
	int addThumbsup(String articleId);

}
