package com.cc.search.service;

import com.cc.search.dao.ArticleSearchDao;
import com.cc.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章搜索实现类
 * @author wlc
 */
@Service
public class ArticleSearchService {
	@Autowired
	private ArticleSearchDao articleSearchDao;

	/**
	 * 增加文章
	 * @param article
	 */
	public void add(Article article){
		articleSearchDao.save(article);
	}

	/**
	 * 根据关键字分页模糊查询title和content
	 * @param keyWords 输入的关键字
	 * @return
	 */
	public Page<Article> findByTitleOrContent(String keyWords, int page, int size){
		PageRequest pageRequest = PageRequest.of(page,size);
		return articleSearchDao.findByTitleOrContentLike(keyWords,keyWords,pageRequest);
	}

}
