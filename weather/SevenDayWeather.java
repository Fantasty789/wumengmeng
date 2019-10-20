package weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;



//定义“一日天气”类

class DayWeather {
	String day;// 日期
	String weather;// 天气
	String temperature;// 温度
	String wind;// 风
//构造
DayWeather(String d, String w, String t, String wi) {
        day = d;
        weather = w;
       temperature = t;
         wind = wi;
    }
 //打印数据
public String toString() {
	return new String(day + "\t" + weather + "\t" + temperature + "\t" + wind);
     }
 
}
//获取城市编码
public class SevenDayWeather {
// 从城市名称到城市代码的映射map，如 山东济宁->101120701
private static HashMap<String, String> cityMap = new HashMap<String, String>();
// 初始化cityMap
public static void initCityMap(String fileName) throws IOException {
	File file = new File(fileName);
	BufferedReader reader = null;
	try {
    reader = new BufferedReader(new FileReader(file));
	String tempString = null;
	//System.out.println(cityMap);
	while ((tempString = reader.readLine()) != null) {//将cities文件中的每一行读出存到tempString中
		String[] strs = tempString.split("\t");//将城市赋给strs[0],城市代码赋给strs[1]
		//System.out.println(strs[0]);
		//System.out.println(strs[1]);
		if (cityMap.get(strs[0]) == null) {
			cityMap.put(strs[0], strs[1]);	
	} //将strs[1]中的值赋给strs[0]
		else {
			System.out.println("城市键重复  " + strs[1]);
	}
}
	//System.out.println(cityMap);
	reader.close();
} 
	catch (IOException e) {
		e.printStackTrace();
		throw e;
	} 
	finally {
		if (reader != null) {
			try {
				reader.close();
			} 
			catch (IOException e1) {
				throw e1;
			}
		}
	}
}
		
// 输入城市名，返回城市代码
public String cityToCode(String cityName) {
	String code = cityMap.get(cityName);
	if (code == null) {
	  return null;
	}
	return code;
}
		 
// 输入城市代码，返回该城市的七日天气列表
public ArrayList<DayWeather> getSevenDayWeather(String cityCode) throws Exception {
	String urlString = "http://www.weather.com.cn/weather/" + cityCode + ".shtml";
	
	ArrayList<DayWeather> sevenDayWeather = new ArrayList<DayWeather>();
	Parser parser = new Parser((HttpURLConnection) (new URL(urlString)).openConnection());
	
	HasAttributeFilter t_clearfix = new HasAttributeFilter("class", "t clearfix");
	NodeIterator iterator = parser.extractAllNodesThatMatch(t_clearfix).elements();
	Node ul = iterator.nextNode();
	//System.out.println(ul.toHtml());
		/*
		 * String xml=ul.toHtml(); XMLSerializer xmlSerializer = new XMLSerializer();
		 * String result = xmlSerializer.read(xml).toString();
		 * System.out.println(result);
		 */
	NodeList lis = ul.getChildren();
	TagNameFilter li = new TagNameFilter("li");
	NodeList liList = lis.extractAllNodesThatMatch(li);
	
	for (int i = 0; i < liList.size(); i++) {
		NodeList children = liList.elementAt(i).getChildren();
		System.out.println(children);
		TagNameFilter p = new TagNameFilter("p");
	    NodeList ps = children.extractAllNodesThatMatch(p);
	    TagNameFilter h1 = new TagNameFilter("h1");
	    NodeList h = children.extractAllNodesThatMatch(h1);
	    String day = h.elementAt(0).toPlainTextString().trim();
	    String weather = ps.elementAt(0).toPlainTextString().trim();
	    String temperature = ps.elementAt(1).toPlainTextString().trim();
	    String wind = ps.elementAt(2).toPlainTextString().trim();
	    DayWeather dw = new DayWeather(day, weather, temperature, wind);
	    sevenDayWeather.add(dw);
	}
	
	return sevenDayWeather;
	}
		 
public static void main(String[] args) {
	SevenDayWeather w = new SevenDayWeather();
	try {
	SevenDayWeather.initCityMap("cities.txt");
	} catch (IOException e) {
	System.out.println("读文件错误");
	return;
	}
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入你的城市，例如'广东深圳' ：");
	String cityName = sc.nextLine();
	sc.close();
	String cityCode = w.cityToCode(cityName);
	if (cityCode == null) {
	System.out.println("该城市似乎不存在");
	} else {
	System.out.println("该城市代码为 " + cityCode);
	}
	ArrayList<DayWeather> sw = null;
	try {
	sw = w.getSevenDayWeather(cityCode);
	//System.out.println(sw);
	} catch (Exception e) {
	System.out.println("发生网络错误或解析错误");
	return;
	}
	System.out.println("=============== 七日天气 =====================");
	System.out.println("日期" + "\t\t" + "天气" + "\t" + "温度" + "\t" + "风");
	System.out.println("-----------------------------------------");
	for (int i = 0; i < sw.size(); i++) {
	System.out.println(sw.get(i));
	}
	}


}

