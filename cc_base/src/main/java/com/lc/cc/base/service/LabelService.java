package com.lc.cc.base.service;

import com.lc.cc.base.dao.LabelDao;
import com.lc.cc.base.entity.Label;
import com.lc.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 根据条件查询数据
	 * @return
	 */
	public List<Label> findBySearchCondition(Map<String,Object> searchMap){
		Specification specification = createSpecification(searchMap);
		return labelDao.findAll(specification);
	}

	/**
	 * 组装条件
	 * @param searchMap
	 * @return
	 */
	private Specification<Label> createSpecification(Map<String,Object> searchMap){
		return new Specification<Label>() {
			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

				List<Predicate> predicateList=new ArrayList<>();
				if (searchMap.containsKey(Label.LABEL_NAME) && StringUtils.isNotBlank((String)searchMap.get(Label.LABEL_NAME))){
					predicateList.add(criteriaBuilder.like(root.get(Label.LABEL_NAME).as(String.class),"%"+(String) searchMap.get(Label.LABEL_NAME)+"%"));
				}

				if (searchMap.containsKey(Label.STATE) && StringUtils.isNotBlank((String)searchMap.get(Label.STATE))){
					predicateList.add(criteriaBuilder.equal(root.get(Label.STATE).as(String.class),(String)searchMap.get(Label.STATE)));
				}

				if (searchMap.containsKey(Label.RECOMMEND) && StringUtils.isNotBlank((String)searchMap.get(Label.RECOMMEND))){
					predicateList.add(criteriaBuilder.equal(root.get(Label.RECOMMEND).as(String.class),(String)searchMap.get(Label.RECOMMEND)));
				}

				return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
	}

	/**
	 * 带分页的查询
	 * @return
	 */
	public Page<Label> findBySearchConditionPage(Map<String,Object> searchMap,int page,int size){
		Specification<Label> specification = createSpecification(searchMap);
		PageRequest pageRequest = PageRequest.of(page-1,size);
		return labelDao.findAll(specification,pageRequest);
	}
}
