package com.cc.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author lc
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	/**
	 * 查询最新职位列表(按创建日期降序排序)
	 * @param state
	 * @return
	 */
	List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

	/**
	 * 查询状态不为0并以创建日期降序排序，查询前12条记录
	 * @param state
	 * @return
	 */
	List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
