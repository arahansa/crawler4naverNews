package com.arahansa.domain;

import java.util.ArrayList;
import java.util.List;

public class Query4Naver {

	String address4naverURL = "http://news.naver.com/main/search/search.nhn?query=";
	
	String query;
	int beginPage;
	int endPage;
	
	public Query4Naver() {
	}
	
	public Query4Naver(String query, String beginPage, String endPage){
		this.query = query;
		this.beginPage = Integer.parseInt(beginPage);
		this.endPage = Integer.parseInt(endPage);
	}
	
	public List<String> getAddressList(){
		List<String> address4naver = new ArrayList<>();
		for(int i=beginPage;i<=endPage;i++){
			String address = address4naverURL+query+"&page="+i;
			address4naver.add(address);
		}
		System.out.println("만들어진 검색 주소들 :"+address4naver);
		return address4naver;
	}
	@Override
	public String toString() {
		return "Query4Naver [address4naver=" + address4naverURL + ", query=" + query + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + "]";
	}
	
	
}
