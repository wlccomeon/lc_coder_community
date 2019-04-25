package com.cc.search.controller;

import com.cc.search.pojo.Article;
import com.cc.search.service.ArticleSearchService;
import com.lc.entity.PageResult;
import com.lc.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 文章搜索服务controller
 * @author wlc
 */
@RestController
@CrossOrigin
@RequestMapping("/articleSearch")
public class ArticleSearchController {

	@Autowired
	private ArticleSearchService articleSearchService;

	/**
	 * 添加搜索
	 * @param article
	 * @return
	 */
	@PostMapping
	public Result save(@RequestBody Article article){
		articleSearchService.add(article);
		return Result.createBySuccessMsg("添加成功");
	}

	@GetMapping(value = "/search/{keywords}/{page}/{size}")
	public Result findByTitleOrContent(@PathVariable String keywords,@PathVariable int page,@PathVariable int size){
		Page<Article> articlePage = articleSearchService.findByTitleOrContent(keywords,page,size);
		PageResult<Article> pageResult = new PageResult<>(articlePage.getTotalElements(),articlePage.getContent());
		return Result.createBySuccess("查询成功",pageResult);
	}


}
