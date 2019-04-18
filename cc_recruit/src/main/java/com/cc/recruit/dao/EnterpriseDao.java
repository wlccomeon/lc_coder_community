package com.cc.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.recruit.pojo.Enterprise;

import java.util.List;

/**
 * 数据访问接口
 * @author lc
 *
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
	/**
	 * 根据是否是热门企业查询
	 * @param isHot 1：热门，0：非热门
	 * @return
	 */
	List<Enterprise> findByIshot(String isHot);
}
