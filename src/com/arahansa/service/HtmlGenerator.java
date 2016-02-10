package com.arahansa.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.arahansa.domain.Article;

public class HtmlGenerator {


	String header ="<html><head><title>테스트 HTML </title><meta charset='utf-8'></head><body><h3>테스트 HTML </h3>\n" +
			"<table>\n" +
			"\t<tr>\n" +
			"\t\t<td>기사</td>\n" +
			"\t\t<td>언론사</td>\n" +
			"\t\t<td>시간</td>\n" +
			"\t\t<td>설명</td>\n" +
			"\t</tr>";
	String footer ="</table></body></html>";

	public void htmlGenerate(List<Article> articleList) throws IOException {

		File file = new File("filename.html");
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(Article article : articleList){
			String content = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", article.getaLink(), article.getPress(), article.getTime(), article.getDesc());
			bw.write(content);
		}
		bw.close();
	}
	
}
