package com.arahansa.view.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.arahansa.domain.Article;
import com.arahansa.domain.Query4Naver;
import com.arahansa.service.JSONGenerator;
import com.arahansa.service.SearchKeyWordExtractor4Naver;

public class MainUpperPanel extends JPanel  implements ActionListener{

	JLabel lb4address = new JLabel("Search Word : ");
	JTextField jtf4Query = new JTextField(30);
	JButton btnConfirm = new JButton("ok");
	
	JLabel lb4beginPage = new JLabel("beginPage");
	JTextField jtfStartPage = new JTextField(2);
	JLabel lb4EndPage = new JLabel("beginPage");
	JTextField jtfEndPage = new JTextField(2);
	
	SearchKeyWordExtractor4Naver searchKeyWord4Naver = new SearchKeyWordExtractor4Naver();
	JSONGenerator jsonGenerator = new JSONGenerator();
	
	public MainUpperPanel() {
		jtfStartPage.setText("1");
		jtfEndPage.setText("1");
		
		add(lb4address);
		add(jtf4Query);
		add(btnConfirm);
		add(lb4beginPage);
		add(jtfStartPage);
		add(lb4EndPage);
		add(jtfEndPage);
		
		btnConfirm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Query4Naver query4Naver = getQuery4Naver();
		System.out.println("만들어진 검색 객체 ::"+query4Naver);
		List<Article> articleListWithPages = searchKeyWord4Naver.getArticleListWithPages(query4Naver);
		System.out.println("결과 :"+articleListWithPages);
		
		jsonGenerator.generateJSONFile(articleListWithPages);
	}
	
	private Query4Naver getQuery4Naver(){
		String query = null;
		try {
			query = URLEncoder.encode(jtf4Query.getText(), "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Query4Naver query4Naver = new Query4Naver(query, jtfStartPage.getText(), jtfEndPage.getText());
		return query4Naver;
	}
	
	
}
