package com.lc.entity;

import java.util.List;

/**
 * 分页结果类
 * @author  wlc
 * @param <T> 泛型
 */
public class PageResult<T> {

	private long total;

	private List<T> rows;

	public PageResult() {
	}

	public PageResult(long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
