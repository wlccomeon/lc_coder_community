package com.cc.spit.pojo;

import javax.persistence.Id;
import java.util.Date;

/**
 * 吐槽实体类
 * @author wlc
 */
public class Spit {

	@Id
	private String _id;
	/**吐槽内容*/
	private String content;
	/**发布时间*/
	private Date publishtime;
	/**发布人ID*/
	private String userid;
	/**发布人昵称*/
	private String nickname;
	/**访问量*/
	private Integer visits;
	/**点赞数量*/
	private Integer thumbup;
	/**分享数量*/
	private Integer share;
	/**回复数量*/
	private Integer comment;
	/**是否可见*/
	private String state;
	/**上级ID*/
	private String parentid;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getVisits() {
		return visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public Integer getThumbup() {
		return thumbup;
	}

	public void setThumbup(Integer thumbup) {
		this.thumbup = thumbup;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
}
