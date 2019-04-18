package com.cc.recruit.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.cc.recruit.pojo.Recruit;
import com.cc.recruit.service.RecruitService;

import com.lc.entity.PageResult;
import com.lc.entity.Result;

/**
 * 控制器层
 * @author lc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return Result.createBySuccess("查询成功",recruitService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.createBySuccess("查询成功",recruitService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
		return  Result.createBySuccess("查询成功",  new PageResult<Recruit>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return Result.createBySuccess("查询成功",recruitService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param recruit
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Recruit recruit  ){
		recruitService.add(recruit);
		return Result.createBySuccessMsg("增加成功");
	}
	
	/**
	 * 修改
	 * @param recruit
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Recruit recruit, @PathVariable String id ){
		recruit.setId(id);
		recruitService.update(recruit);		
		return Result.createBySuccessMsg("修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		recruitService.deleteById(id);
		return Result.createBySuccessMsg("删除成功");
	}

	/**
	 * 查询状态为2并以创建日期降序排序，查询前4条记录:推荐记录。代码写的low。。
	 * @return
	 */
	@RequestMapping(value = "/search/recommend",method = RequestMethod.GET)
	public Result recommend(){
		List<Recruit> recruits = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
		return Result.createBySuccess("查询成功",recruits);
	}

	/**
	 * 查询最新职位：需求分析：查询状态不为0并以创建日期降序排序，查询前12条记录
	 * @return
	 */
	@RequestMapping(value = "/search/newlist",method = RequestMethod.GET)
	public Result newList(){
		return Result.createBySuccess(recruitService.findNewList("0"));
	}
}
