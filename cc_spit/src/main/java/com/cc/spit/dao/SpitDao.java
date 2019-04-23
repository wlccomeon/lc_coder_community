package com.cc.spit.dao;

import com.cc.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽数据访问层
 * @author wlc
 */
public interface SpitDao extends MongoRepository<Spit,String> {


	Page<Spit> findByParentid(String parentId, Pageable pageable);

}
