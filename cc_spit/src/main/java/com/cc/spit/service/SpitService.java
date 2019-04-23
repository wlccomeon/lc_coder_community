package com.cc.spit.service;

import com.cc.spit.dao.SpitDao;
import com.cc.spit.pojo.Spit;
import com.lc.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 吐槽业务实现类
 * @author wlc
 */
@Service
public class SpitService {

	@Autowired
	private SpitDao spitDao;
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部数据
	 * @return
	 */
	public List<Spit> findAll(){
		return spitDao.findAll();
	}

	/**
	  * 根据主键查询实体
	  * @param id
	  * @return
  	*/
	public Spit findById(String id){
		Spit spit=spitDao.findById(id).get();
		return spit;
	}

	/**
	 * 增加
	 * @param spit
	 */
	public void add(Spit spit){
		spit.set_id(idWorker.nextId()+"");
		spitDao.save(spit);
	}

	/**
	 * 修改
	 */
	public void update(Spit spit){
		spitDao.save(spit);
	}

	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteById(String id){
		spitDao.deleteById(id);
	}

}
