package com.algo.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Page> pageMap;
	private List<Integer> pageList;
	int size;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.pageList = new LinkedList<>();
		this.pageMap = new HashMap<>();
	}

	public void accessPage(int pageNo) {
		Page page = new Page();
		//Look for page in map
		//if its available update page list
		//remove this page from list and insert it at front
		if (pageMap.containsKey(pageNo)) {
			page = pageMap.get(pageNo);
			updatePageList(page);

		} else {
			page = new Page(pageNo, "data");
			if (size < capacity) {

				pageMap.put(pageNo, page);
				pageList.add(0, pageNo);
				++size;
			} else {
				page = new Page(pageNo, "data");
				int lastPageNo = pageList.get(pageList.size() - 1);
				System.out.println("\nRemoving page = "+lastPageNo);
				pageList.remove(pageList.size() - 1);
				pageMap.remove(lastPageNo);
				pageMap.put(pageNo, page);
				pageList.add(0,pageNo);
			}
		}
		System.out.println();
		pageList.forEach(e->System.out.print(e+"  "));
	}

	private void updatePageList(Page page) {
		int index = pageList.indexOf(page.getPageNo());
		pageList.remove(index);
		pageList.add(0, page.getPageNo());

	}

}
