package com.arahansa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.arahansa.domain.Article;

public class ArticleExtract4OnePageService {

	public List<Article> getArticles4Address(String address) throws IOException{
		
		List<Article> articleList = new ArrayList<>();
		System.out.println("search Address :"+address);
		Document document = Jsoup.connect(address).get();
		Elements articles = document.select(".ct");
		
		for(Element e: articles){
			Article article = new Article();
			article.setaLink(e.select("a.tit").toString());
			article.setPress(e.select("span.press").get(0).ownText());
			article.setDesc(e.select("p.dsc").get(0).ownText());
			article.setTime(e.select("span.time").get(0).ownText());
			articleList.add(article);
		}
		return articleList;
	}
}
