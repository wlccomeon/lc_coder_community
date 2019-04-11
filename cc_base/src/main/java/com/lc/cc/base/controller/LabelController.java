package com.lc.cc.base.controller;

import com.lc.cc.base.entity.Label;
import com.lc.cc.base.service.LabelService;
import com.lc.entity.Result;
import com.lc.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 标签Controller，测试
 * @crossOrigin：允许跨域访问
 * @author wlc
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	/**
	 * 查询所有标签
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
	}

	/**
	 * 根据id查询标签
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
	}

	/**
	 * 接收页面的json数据，添加标签
	 * @param label
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Label label){
		labelService.add(label);
		return new Result(true,StatusCode.OK,"添加成功");
	}

	/**
	 * 根据id更新数据
	 * @param id
	 * @param label
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public Result update(@PathVariable String id,@RequestBody Label label){
		label.setId(id);
		labelService.update(label);
		return new Result(true,StatusCode.OK,"更新成功");
	}

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Result delById(@PathVariable String id){
		labelService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

}
