package com.cc.spit.controller;

import com.cc.spit.pojo.Spit;
import com.cc.spit.service.SpitService;
import com.lc.entity.PageResult;
import com.lc.entity.Result;
import com.lc.entity.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
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
	@Autowired
	private RedisTemplate redisTemplate;

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

	/**
	 * 查询成功
	 * @param parentId
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping(value = "/comment/{parentId}/{page}/{size}")
	public Result findByParentid(@PathVariable String parentId,@PathVariable int page,@PathVariable int size){
		Page<Spit> pageList = spitService.findByParentId(parentId,page,size);
		PageResult<Spit> pageResult = new PageResult<>(pageList.getTotalElements(),pageList.getContent());
		return Result.createBySuccess("查询成功",pageResult);
	}

	/**
	 * 吐槽增加点赞
	 * @return
	 */
	@PutMapping(value = "/thumbup/{id}")
	public Result addThumbsUp(@PathVariable String id){
		//todo:判断用户是否点赞过，这里测试功能，暂时写死了userId
		String userid = "1013";
		String key = "thumbup_" + userid + "_" + id;
		String thumpResult = (String)redisTemplate.opsForValue().get(key);
		if (StringUtils.isNotBlank(thumpResult)){
			return Result.createByError(StatusCode.REPERROR,"不能重复点赞哦");
		}
		spitService.addThumbsup(id);
		redisTemplate.opsForValue().set(key,"1");
		return Result.createBySuccessMsg("点赞成功");
	}
}
