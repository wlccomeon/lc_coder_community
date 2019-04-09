package com.lc.entity;

/**
 * 接口返回结果实体
 * @author wlc
 */
public class Result {
	/**成功状态标识*/
	private boolean flag;
	/**状态吗*/
	private String code;
	/**返回页面的消息*/
	private String message;
	/**返回页面的数据*/
	private Object data;

	public Result() {
	}

	public Result(boolean flag, String code, String message, Object data) {
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result(boolean flag, String code, String message) {
		this.flag = flag;
		this.code = code;
		this.message = message;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
