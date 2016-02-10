package com.arahansa.testutil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.arahansa.domain.Article;

public class JsoupTest {

	private static List<Article> articleList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Document document = Jsoup.connect("http://news.naver.com/main/search/search.nhn?query=hello").get();
		Elements articles = document.select(".ct");
		for(Element e: articles){
			Article article = new Article();
			article.setaLink(e.select("a.tit").toString());
			article.setPress(e.select("span.press").get(0).ownText());
			article.setDesc(e.select("p.dsc").get(0).ownText());
			article.setTime(e.select("span.time").get(0).ownText());
			articleList.add(article);
		}
		System.out.println("기사 리스트 :"+articleList);
	}
}
