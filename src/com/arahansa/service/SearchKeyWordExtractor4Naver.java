package com.arahansa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.arahansa.domain.Article;
import com.arahansa.domain.Query4Naver;

public class SearchKeyWordExtractor4Naver {

	ArticleExtract4OnePageService articleExtract4OnePageService = new ArticleExtract4OnePageService();
	
	public List<Article> getArticleListWithPages(Query4Naver query4Naver){
		List<Article> articleList = new ArrayList<>();
		for(String address : query4Naver.getAddressList()){
			try {
				articleList.addAll(articleExtract4OnePageService.getArticles4Address(address));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return articleList;
	}
	
}
