
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

public class CrawlFestivals {
	public static void main(String[] args) throws IOException {
		String url = "https://vi.wikipedia.org/wiki/Lễ_hội_Việt_Nam#Danh_sách_một_số_lễ_hội";
		Document doc = null;
		Document doc1 = null;

		try {
		    doc = Jsoup.connect(url).get();
		} catch (HttpStatusException e) {
		    System.out.println("Could not find the web page: " + url);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Elements table = doc.select("table[class^=prettytable wikitable]");
		Elements rows = table.select("tr");
		
		List <Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		
		for(int i=1; i<rows.size(); i++) {
			Element row = rows.get(i);
			Elements columns = row.select("td");
			Map<String, String> data = new HashMap<String, String>();
			
			String day = columns.get(0).text();
			String location = columns.get(1).text();
			String name = columns.get(2).text();
			String firstTime = columns.get(3).text();
			String relatedFigure = columns.get(4).text();
			
			String note = null;
			String regexLink = columns.get(2).select("a[href]").attr("abs:href");
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
	        
				
			String[] splittedChars = relatedFigure.split(", ");
            ArrayList<String> relateChars = new ArrayList<String>();
            for (String relateChar : splittedChars) {
                relateChars.add(relateChar);
            }
			
			if(columns.get(0).text() == "")
				data.put("Ngày bắt đầu(âm lịch)", "Chưa rõ");
			else
				data.put("Ngày bắt đầu(âm lịch)", day);
			if(columns.get(1).text() == "")
				data.put("Vị trí", "Chưa rõ");
			else
				data.put("Vị trí", location);
			if(columns.get(2).text() == "")
				data.put("Lễ hội truyền thống", "Chưa rõ");
			else
				data.put("Lễ hội truyền thống", name);
			if(columns.get(3).text() == "")
				data.put("Lần đầu tổ chức năm", "Chưa rõ");
			else
				data.put("Lần đầu tổ chức năm", firstTime);
			if(columns.get(4).text() == "")
				data.put("Nhân vật liên quan", "Chưa rõ");
//			else
//				data.put("Nhân vật liên quan", relateChars);
			if(note == null) data.put("Ghi chú", "Không có");
			else
			data.put("Ghi chú", note);
			
			dataList.add(data);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (int i = 0; i < dataList.size(); i++) {
            String jsonData = objectMapper.writeValueAsString(dataList.get(i));

            String fileName = "data" + (i+1) + ".json";
            String directory = "C:/Users/vx/Desktop/JAVAPROJECTS/Scrapy/src/Json/Festival/";
            FileWriter fileWriter = new FileWriter(new File(directory, fileName));
            fileWriter.write(jsonData);
            fileWriter.close();
        }
		
	}
}
