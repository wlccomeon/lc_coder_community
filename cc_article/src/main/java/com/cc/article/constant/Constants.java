package com.cc.article.constant;

/**
 * 文章常量类
 * @author  wlc
 */
public interface Constants {

	interface RedisKey{
		/**存储和读取redis中article的关键字*/
		String ARTICLE_KEY = "article_";
	}

}
