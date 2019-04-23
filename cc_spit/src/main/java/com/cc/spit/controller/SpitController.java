package com.cc.spit.controller;

import com.cc.spit.pojo.Spit;
import com.cc.spit.service.SpitService;
import com.lc.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 吐槽controller类
 * @author wlc
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

	@Autowired
	private SpitService spitService;

	/**
	 * 查询全部数据
	 * @return
	 */
	@GetMapping
	public Result findAll(){
		return Result.createBySuccess("查询成功",spitService.findAll());
	}

	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Result findOne(@PathVariable String id){
		return Result.createBySuccess(spitService.findById(id));
	}

	/**
	 * 增加
	 * @param spit
	 * @return
	 */
	@PostMapping
	public Result add(@RequestBody Spit spit){
		spitService.add(spit);
		return Result.createBySuccessMsg("增加成功");
	}

	/**
	 * 修改
	 * @param spit
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public Result update(@RequestBody Spit spit,@PathVariable String id){
		spit.set_id(id);
		spitService.update(spit);
		return Result.createBySuccessMsg("更新成功");
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public Result deleteById(@PathVariable String id){
		spitService.deleteById(id);
		return Result.createBySuccessMsg("删除成功");
	}

}
