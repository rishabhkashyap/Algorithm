package com.algo.lru;

public class Page {
	int pageNo;
	String data;
	
	public Page(int pageNo, String data) {
		super();
		this.pageNo = pageNo;
		this.data = data;
	}
	public Page() {}
	
	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	 

}
