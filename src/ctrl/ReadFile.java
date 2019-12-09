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
	            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
	            String s = null;
	            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
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
