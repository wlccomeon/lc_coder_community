package com.lc.cc.base.service;

import com.lc.cc.base.dao.LabelDao;
import com.lc.cc.base.entity.Label;
import com.lc.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签业务类
 * @author wlc
 */
@Service
public class LabelService {

	@Autowired
	private LabelDao labelDao;
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部数据
	 * @return
	 */
	public List<Label> findAll(){
		return labelDao.findAll();
	}

	/**
	 * 根据id查找标签数据
	 * @param id
	 * @return
	 */
	public Label findById(String id){
		return labelDao.findById(id).get();
	}

	/**
	 * 添加方法，需要手动添加twitter的雪花算法得到的Id
	 * @param label
	 */
	public void add(Label label){
		label.setId(idWorker.nextId()+"");
		labelDao.save(label);
	}

	/**
	 * 根据id删除标签
	 * @param id
	 */
	public void deleteById(String id){
		labelDao.deleteById(id);
	}

	/**
	 * 更新标签数据
	 */
	public void update(Label label){
		labelDao.save(label);
	}

}
