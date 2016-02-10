package com.arahansa.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.arahansa.domain.Article;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONGenerator {

	ObjectMapper mapper = new ObjectMapper();

	public void generateJSONFile(List<Article> articles) {
		try {
			String jsonValue = mapper.writeValueAsString(articles);
			System.out.println("result JSON :: " + jsonValue);
			File file = new File("output.json");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(jsonValue);

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
