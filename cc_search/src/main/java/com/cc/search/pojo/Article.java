package com.cc.search.pojo;

import com.cc.search.constant.SearchConstant;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;

import static com.cc.search.constant.SearchConstant.analyzer.IK_MAX_WORD_STR;

/**
 * 文章实体类
 * @author wlc
 */
@Document(indexName = "cc",type = "article")
public class Article {
	@Id
	private String id;
	//是否索引，就是看该域是否能被搜索。
	//是否分词，就表示搜索的时候是整体匹配还是单词匹配
	//是否存储，就是是否在页面上显示
	/**文章标题*/
	@Field(index = true,analyzer = IK_MAX_WORD_STR,searchAnalyzer = IK_MAX_WORD_STR)
	private String title;
	/**文章内容*/
	@Field(index = true,analyzer = IK_MAX_WORD_STR,searchAnalyzer = IK_MAX_WORD_STR)
	private String content;
	/**审核状态*/
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
