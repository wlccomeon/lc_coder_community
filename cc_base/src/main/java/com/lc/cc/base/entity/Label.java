package com.lc.cc.base.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签实体
 * @author wlc
 */
@Entity
@Table(name = "tb_label")
public class Label {

	@Id
	private String id;
	/**标签名称*/
	private String labelname;
	/**状态*/
	private String state;
	/**使用数量*/
	private Long count;
	/**关注数*/
	private Long fans;
	/**是否推荐*/
	private String recommend;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getFans() {
		return fans;
	}

	public void setFans(Long fans) {
		this.fans = fans;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
}
