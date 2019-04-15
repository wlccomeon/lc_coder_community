package com.lc.entity;

/**
 * 接口返回结果实体
 * @author wlc
 */
public class Result {
	/**成功状态标识*/
	private boolean flag;
	/**状态吗*/
	private int code;
	/**返回页面的消息*/
	private String message;
	/**返回页面的数据*/
	private Object data;

	public Result() {
	}

	public Result(boolean flag, int code, String message, Object data) {
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result(boolean flag, int code, String message) {
		this.flag = flag;
		this.code = code;
		this.message = message;
	}

	public Result(boolean flag, int code) {
		this.flag = flag;
		this.code = code;
	}

	/**
	 * 默认操作成功，不带message
	 * @return
	 */
	public static Result createBySuccess(){
		return new Result(true,StatusCode.OK);
	}

	/**
	 * 操作成功，带自定义message
	 * @param msg
	 * @return
	 */
	public static Result createBySuccessMsg(String msg){
		return new Result(true,StatusCode.OK,msg);
	}

	/**
	 * 操作成功，带自定义message和返回的数据
	 * @param msg
	 * @param data
	 * @return
	 */
	public static Result createBySuccess(String msg,Object data){
		return new Result(true,StatusCode.OK,msg,data);
	}

	/**
	 * 操作成功，带返回的数据
	 * @param data
	 * @return
	 */
	public static Result createBySuccess(Object data){
		return new Result(true,StatusCode.OK,"操作成功",data);
	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
