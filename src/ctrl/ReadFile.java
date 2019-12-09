package ctrl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	
	 public static List<String> txt2String(File file){
	        List<String> list=new ArrayList<>();
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
	            String s = null;
	            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
	               list.add(s);
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	 
	 public static List<String> string2list(String s) {
		String[] strings=s.split(" ");
		List<String> list=new ArrayList<>();
		for(String string:strings) {
			list.add(string);
		}
		return list;
	}

}
