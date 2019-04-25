package com.cc.search.dao;

import com.cc.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 文章搜索dao
 * @author wlc
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {
	/**
	 * 根据title或content搜索
	 * @param title
	 * @param content
	 * @param pageable
	 * @return
	 */
	 Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
