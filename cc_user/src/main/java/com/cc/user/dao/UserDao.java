package com.cc.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.user.pojo.User;
/**
 * 数据访问接口
 * @author lc
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{

	/**
	 * 根据手机号查找用户信息
	 * @param mobile
	 * @return
	 */
	User findByMobile(String mobile);

}
