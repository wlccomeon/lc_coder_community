package com.cc.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cc.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author lc
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

	/**
	 * 使用sql语句查询最新问答列表--结果分页
	 * @param labelId 标签id
	 * @return
	 */
	@Query(value = "SELECT * FROM tb_pl p1 ,tb_problem p2 WHERE p1.`problemid`=p2.`id` AND p1.`labelid`=? ORDER BY p2.`replytime` DESC ",nativeQuery = true)
	Page<Problem> findNewListByLableId(String labelId, Pageable pageable);

	/**
	 * 使用sql语句查询最热问答列表--结果分页
	 * @param labelId 标签id
	 * @return
	 */
	@Query(value = "SELECT * FROM tb_pl p1 ,tb_problem p2 WHERE p1.`problemid`=p2.`id` AND p1.`labelid`=? ORDER BY p2.`reply` DESC ",nativeQuery = true)
	Page<Problem> findHotListByLabelId(String labelId,Pageable pageable);

	/**
	 * 使用sql语句查询等待问答列表--结果分页
	 * @param labelId 标签id
	 * @return
	 */
	@Query(value = "SELECT * FROM tb_pl p1 ,tb_problem p2 WHERE p1.`problemid`=p2.`id` AND p1.`labelid`=? AND p2.`reply`=0 ORDER BY p2.`createtime` DESC ",nativeQuery = true)
	Page<Problem> findWaitListByLabelId(String labelId,Pageable pageable);

}
