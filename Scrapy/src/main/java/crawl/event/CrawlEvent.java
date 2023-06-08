package crawl.event;

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

public class CrawlEvent {
	public static void main(String[] args) throws IOException {
		String url = "https://nguoikesu.com/tu-lieu/quan-su?filter_tag[0]";
		Document doc = null;
		Document doc1 = null;
		
//		try {
//		    doc = Jsoup.connect(url).get();
//		} catch (HttpStatusException e) {
//		    System.out.println("Could not find the web page: " + url);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		Elements readmore = doc.select(".readmore");
		
		List <Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = new HashMap<String, String>();
		String time = null;
		String location = null;
		String result = null;
		String reason = null;
		
		for(int i=0; i<=14 ; i++) {
			try {
			    doc = Jsoup.connect(url + "=&start=" + (5*i)).get();
			} catch (HttpStatusException e) {
			    System.out.println("Could not find the web page: " + url);
			} catch (IOException e) {
			    e.printStackTrace();
			}
			Elements readmore = doc.select(".readmore");
			for(int j=0; j<readmore.size(); j++) {
				String regexLink = readmore.select("a[href]").attr("abs:href");
				String regex = "\\b(https?|ftp|file):\\/\\/[\\-A-Za-z0-9+&@#\\/\\%?=~_|!:,.;]*[\\-A-Za-z0-9+&@#\\/%=~_|]";
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(regexLink);
		        while(matcher.find()) {
		            String Link = matcher.group();
		            Link = URLDecoder.decode(Link, "UTF-8");
		            try {
		                doc1 = Jsoup.connect(Link).get();
		                Element table = doc1.selectFirst("table[cellpadding='0'][cellspacing='0'][width='100%']");
		                Elements rows = table.select("td");
		                System.out.println(rows.size());
		                Elements columns = rows.get(1).select("tr");
//		                System.out.println(columns.size());
		                if(columns.size() == 4) {
		                	time = columns.get(0).text();
		                	location = columns.get(1).text();
		                	reason = columns.get(2).text();
		                	result = columns.get(3).text();
		                }
		                if(columns.size() == 3) {
		                	time = columns.get(0).text();
		                	location = columns.get(1).text();
		                	result = columns.get(2).text();
		                }
		                
		            } catch (HttpStatusException e) {
		                if (e.getStatusCode() == 404) {
		                } else {
		                    System.out.println("A different HTTP error occurred: " + e.getStatusCode());
		                    // Handle other HTTP errors as needed.
		                }
		            } catch (IOException e) {
		                System.out.println("An error occurred while connecting to the website: " + e.getMessage());
		                // Handle other types of IOExceptions as needed.
		            }
		        }
		        if(time == null) data.put("time", "Chưa rõ");
		        else data.put("time", time);
		        if(location == null) data.put("location", "Chưa rõ");
		        else data.put("location", location);
		        if(reason == null) data.put("reason", "Chưa rõ");
		        else data.put("reason", reason);
		        if(result == null) data.put("result", "Chưa rõ");
		        else data.put("result", result);
		        dataList.add(data);
			}
			
		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		for (int i = 0; i < dataList.size(); i++) {
            String jsonData = objectMapper.writeValueAsString(dataList.get(i));

            String fileName = "data" + (i+1) + ".json";
            String directory = "C:/Users/vx/Desktop/JAVAPROJECTS/Scrapy/src/Json/Events/";
            FileWriter fileWriter = new FileWriter(new File(directory, fileName));
            fileWriter.write(jsonData);
            fileWriter.close();
		}
	}
}
