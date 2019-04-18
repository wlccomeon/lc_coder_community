package com.cc.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 问答中间表
 * @author wlc
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {

	@Id
	private String problemid;

	@Id
	private String labelid;

	public String getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	public String getLabelid() {
		return labelid;
	}

	public void setLabelid(String labelid) {
		this.labelid = labelid;
	}
}
