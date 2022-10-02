package com.utility;
import java.sql.Connection;
import com.utility.DBUtil;

public class Demo {

	public static void main(String[] args) {

        Connection conn= DBUtil.provideConnection();
		
		
		System.out.println(conn);
		
		
	}

}
