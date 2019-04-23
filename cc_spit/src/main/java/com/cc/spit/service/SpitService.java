package com.cc.spit.service;

import com.cc.spit.dao.SpitDao;
import com.cc.spit.pojo.Spit;
import com.lc.entity.PageResult;
import com.lc.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 吐槽业务实现类
 * @author wlc
 */
@Service
public class SpitService {

	@Autowired
	private MongoTemplate mongoTemplate;

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
		//发布日期
		spit.setPublishtime(new Date());
		//浏览量
		spit.setVisits(0);
		//分享数
		spit.setShare(0);
		//点赞数
		spit.setThumbup(0);
		//回复数
		spit.setComment(0);
		//状态
		spit.setState("1");

		//判断是否具有父节点，如果有，则父节点的回复数量+1
		if (StringUtils.isNotBlank(spit.getParentid())){

			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
			Update update = new Update();
			update.inc("comment",1);
			mongoTemplate.updateFirst(query,update,"spit");
		}
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

	/**
	 * 根据上级id查询吐槽分页数据
	 * @return
	 */
	public Page<Spit> findByParentId(String parentId,int page,int size){
		PageRequest pageRequest = PageRequest.of(page,size);
		return spitDao.findByParentid(parentId,pageRequest);
	}

	/**
	 * 增加吐槽点赞数量
	 */
	public void addThumbsup(String id){
		//方式一：效率有问题
//		Spit spit = spitDao.findById(id).get();
//		spit.setThumbup((spit.getThumbup()==null?0:spit.getThumbup())+1);
//		spitDao.save(spit);

		//方式二：使用mongo原生的命令实现自增 db.spit.update({"_id":"1"},{$inc:{thumpup:NumberInt(1)}})
		//查询
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		//增加1
		update.inc("thumbup",1);
		//第3个参数为文档集合name
		mongoTemplate.updateFirst(query,update,"spit");
	}
}
