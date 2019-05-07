package com.cc.durid.monitor.controller;

import com.cc.durid.monitor.service.TestService;
import com.lc.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin
public class TestController {

	@Autowired
	private TestService testService;

	/**
	 * 为文章添加点赞数量
	 * @param id 点赞的文章id
	 * @return
	 */
	@RequestMapping(value = "/thumbup/{id}",method = RequestMethod.PUT)
	public Result addThumbsup(@PathVariable String id){
		testService.addTumbup();
		return Result.createBySuccessMsg("点赞成功");
	}
}
