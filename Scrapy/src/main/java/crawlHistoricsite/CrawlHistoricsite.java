package crawlHistoricsite;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.io.File;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CrawlHistoricsite {

	public static void main(String[] args) throws IOException {
		String url = "https://vi.wikipedia.org/wiki/Danh_sách_Di_tích_quốc_gia_Việt_Nam";
		Document doc = null;
		Document doc1 = null;
		try {
			doc = Jsoup.connect(url).timeout(1200000).get();
		} catch (Exception e) {
			System.out.println("Can not connect url!");
		}
//Add data to arraylist of Hashmap		
		List <Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = new HashMap<String, String>();
		Elements tables = doc.select("table.wikitable.sortable");
		System.out.println(tables.size());
		
		for(int i=0; i<tables.size(); i++) {
			Element table = tables.get(i);
			Elements rows = table.select("tr");
			for(int j=1; j<rows.size(); j++) {
				Element row = rows.get(j);
				Elements columns = row.select("td");
//				System.out.println(columns.size());
				
				String historicsite = columns.get(0).text();
				String location = columns.get(1).text();
				String type = columns.get(2).text();
				String recognizeYear;
				if(columns.size() < 4) recognizeYear = null;
				else recognizeYear = columns.get(3).text();
				
				String note = null;
				String regexLink = columns.get(0).select("a[href]").attr("abs:href");
				String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(regexLink);
		        while(matcher.find()) {
		            String Link = matcher.group();
		            Link = URLDecoder.decode(Link, "UTF-8");
	        
		            try {
		                doc1 = Jsoup.connect(Link).get();
		                Element firstPara = doc1.select("p").first();
		                String textPara = firstPara.text();
		                note = textPara.split("\\.\\s+")[0];
		                System.out.println("tuan");
		            } catch (HttpStatusException e) {
		                if (e.getStatusCode() == 404) {
		                    note = null;
		                    System.out.println(Link);
		                   break;
		                } else {
		                    System.out.println("A different HTTP error occurred: " + e.getStatusCode());
		                    // Handle other HTTP errors as needed.
		                }
		            } catch (IOException e) {
		                System.out.println("An error occurred while connecting to the website: " + e.getMessage());
		                // Handle other types of IOExceptions as needed.
		            }

		        }
		        data.put("Di tich", historicsite);
		        data.put("Vi tri", location);
		        data.put("Loai di tich", type);
		        data.put("Nam cong nhan", recognizeYear);
		        if(note == null) data.put("Ghi chu", "Không có");
		        else data.put("Ghi chu", note);
		        dataList.add(data);
			}
		}
//Write arraylist of hashmap to json file		
				ObjectMapper objectMapper = new ObjectMapper();
						
						for (int i = 0; i < dataList.size(); i++) {
				            String jsonData = objectMapper.writeValueAsString(dataList.get(i));
				
				            String fileName = "data" + (i+1) + ".json";
				            String directory = "C:/Users/vx/Desktop/JAVAPROJECTS/Scrapy/src/Json/Historicsite/";
				            FileWriter fileWriter = new FileWriter(new File(directory, fileName));
				            fileWriter.write(jsonData);
				            fileWriter.close();
						}

	}

}
