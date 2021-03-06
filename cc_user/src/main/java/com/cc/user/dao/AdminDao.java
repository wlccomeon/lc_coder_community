package com.cc.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.user.pojo.Admin;
/**
 * 数据访问接口
 * @author lc
 *
 */
public interface AdminDao extends JpaRepository<Admin,String>,JpaSpecificationExecutor<Admin>{
	/**
	 * 根据登录名查找用户信息
	 * @param loginname
	 * @return
	 */
	Admin findByLoginname(String loginname);
}
