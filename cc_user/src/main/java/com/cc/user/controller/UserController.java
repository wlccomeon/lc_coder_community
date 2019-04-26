package com.cc.user.controller;
import java.util.List;
import java.util.Map;

import com.lc.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.cc.user.pojo.User;
import com.cc.user.service.UserService;

import com.lc.entity.PageResult;
import com.lc.entity.Result;

/**
 * 控制器层
 * @author lc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return
	 */
	@PostMapping(value = "/login")
	public Result loginByMobile(@RequestParam(value = "mobile") String mobile,@RequestParam(value = "password") String password){

		User user = userService.findByMobileAndPwd(mobile,password);
		if (user!=null){
			return Result.createBySuccessMsg("登录成功");
		}else{
			return Result.createByError(StatusCode.LOGINERROR,"手机号或密码错误");
		}
	}

	/**
	 * 发送短信验证码
	 * @return
	 */
	@PostMapping(value = "/sendsms/{mobile}")
	public Result sendSms(@PathVariable String mobile){
		userService.sendSMSCode(mobile);
		return Result.createBySuccessMsg("发送成功");
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return Result.createBySuccess("查询成功",userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return Result.createBySuccess("查询成功",userService.findById(id));
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
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  Result.createBySuccess("查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return Result.createBySuccess("查询成功",userService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param user
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		userService.add(user);
		return Result.createBySuccessMsg("增加成功");
	}
	
	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);
		userService.update(user);		
		return Result.createBySuccessMsg("修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		userService.deleteById(id);
		return Result.createBySuccessMsg("删除成功");
	}

	/**
	 * 用户注册
	 * @return
	 */
	@PostMapping(value = "/register/{code}")
	public Result register(@RequestBody User user,@PathVariable String code){
		userService.add(user,code);
		return Result.createBySuccessMsg("注册成功");
	}
	
}
