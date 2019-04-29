package com.lc.cc.base.controller;

import com.lc.cc.base.entity.Label;
import com.lc.cc.base.service.LabelService;
import com.lc.entity.PageResult;
import com.lc.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 标签Controller，测试
 * @CrossOrigin：允许跨域访问
 * @RefreshScope: 允许动态刷新获取配置文件中自定义的key-value
 * @author wlc
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/label")
@RefreshScope
public class LabelController {

	@Autowired
	private LabelService labelService;

	@Value("${test.ip}")
	private String ip;

	/**
	 * 测试获取自定义的key-value
	 * @return
	 */
	@GetMapping(value = "/getIp")
	public Result testGetCustomizeKey(){
		System.out.println("ip:"+ip);
		return null;
	}

	/**
	 * 查询所有标签
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll(){
		return Result.createBySuccess("查询成功",labelService.findAll());
	}

	/**
	 * 根据id查询标签
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.createBySuccess("查询成功",labelService.findById(id));
	}

	/**
	 * 接收页面的json数据，添加标签
	 * @param label
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Label label){
		labelService.add(label);
		return Result.createBySuccessMsg("添加成功");
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
		return Result.createBySuccessMsg("更新成功");
	}

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Result delById(@PathVariable String id){
		labelService.deleteById(id);
		return Result.createBySuccessMsg("删除成功");
	}

	/**
	 * 根据条件查询结果
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public Result findBySearchCondition(@RequestBody Map<String,Object> searchMap){
		return Result.createBySuccess("查询成功",labelService.findBySearchCondition(searchMap));
	}

	/**
	 * 分页查询结果
	 * @return
	 */
	@RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
	public Result findBySearchCondition(@RequestBody Map<String,Object> searchaMap,@PathVariable int page,@PathVariable int size){
		Page pageList = labelService.findBySearchConditionPage(searchaMap,page,size);
		return Result.createBySuccess("分页查询成功",new PageResult<>(pageList.getTotalElements(),pageList.getContent()));
	}
}
