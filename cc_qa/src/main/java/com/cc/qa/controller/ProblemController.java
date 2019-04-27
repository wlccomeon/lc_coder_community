package com.cc.qa.controller;
import java.util.List;
import java.util.Map;

import com.cc.qa.client.LabelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.cc.qa.pojo.Problem;
import com.cc.qa.service.ProblemService;

import com.lc.entity.PageResult;
import com.lc.entity.Result;

/**
 * 控制器层
 * @author lc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;
	@Autowired
	private LabelClient labelClient;

	@RequestMapping(value = "/label/{labelid}")
	public Result findLabelById(@PathVariable String labelid){
		Result result = labelClient.findById(labelid);
		return result;
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return Result.createBySuccess("查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.createBySuccess("查询成功",problemService.findById(id));
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
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  Result.createBySuccess("查询成功",  new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return Result.createBySuccess("查询成功",problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return Result.createBySuccessMsg("增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return Result.createBySuccessMsg("修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return Result.createBySuccessMsg("删除成功");
	}

	/**
	 * 查询最新问答
	 * @return
	 */
	@RequestMapping(value = "/hotlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
	public Result findHotListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> pageList = problemService.findHotListByLabelId(page,size,labelid);
		return Result.createBySuccess("查询成功",new PageResult<Problem>(pageList.getTotalElements(),pageList.getContent()));
	}

	/**
	 * 查询热门问答
	 * @return
	 */
	@RequestMapping(value = "/waitlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
	public Result findWaitListByLableId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> pageList = problemService.findWaitListByLabelId(page,size,labelid);
		return Result.createBySuccess("查询成功",new PageResult<Problem>(pageList.getTotalElements(),pageList.getContent()));
	}

	/**
	 * 查询待解答问题
	 * @return
	 */
	@RequestMapping(value = "/newlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
	public Result findNewListByLableId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> pageList = problemService.findNewListByLableId(page,size,labelid);
		return Result.createBySuccess("查询成功",new PageResult<Problem>(pageList.getTotalElements(),pageList.getContent()));
	}
	
}
