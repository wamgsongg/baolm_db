package test;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import ctrl.ReadFile;

public class Manager {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
			ReadFile readFile=new ReadFile();
			File file = new File("shop.txt");
			List<String> list =readFile.txt2String(file);
			for(String s:list) {
				System.out.println(s);
			}
		
	}

}
