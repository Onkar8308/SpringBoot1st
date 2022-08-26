package com.finzly.demo1st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oper")
public class Operations {
	
	
	
	//to insert the record in table
	
	@GetMapping("/check")
	public List<String> get() {
		List<String> str=new ArrayList<>();
		str.add("ram");
		str.add("mohan");
		return str;
	}
	
	@RequestMapping("insert")
	public String insert() throws ClassNotFoundException, SQLException {
		int book_id = 335;
		String Name = "wAR_PEACE";
		String price = "450";
		
	//	System.out.println("starting...");
		Class.forName("com.mysql.jdbc.Driver");
	//	System.out.println("Driver loaded succefully...");
				
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	//	System.out.println("Connection established succesfully");
			
		PreparedStatement ps = con.prepareStatement("insert into bookcounter (id,Name,price) values(?,?,?)");

		ps.setInt(1,book_id);
		ps.setString(2, Name);
		ps.setString(3, price);

		int insert1 = ps.executeUpdate();
		
		if(insert1==1)
		return "record inserted";
		else
			return "failed to insert record";
		

	  }
	
	//to delete the record in table
	
	@RequestMapping("delete")
	public String delete() throws ClassNotFoundException, SQLException {
		
	//	System.out.println("starting...");
		Class.forName("com.mysql.jdbc.Driver");
	//	System.out.println("driver loaded suceessfully...");
				
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	//	System.out.println("Connection established succesfully...");
			
		PreparedStatement ps = con.prepareStatement("delete from bookcounter where id = ?");
		
		ps.setInt(1,331);
		
		
		int i = ps.executeUpdate();  
		if(i==1)
			return "record deleted succefully";
		else
			return "failed to delete the record";
		}
	
	
	@RequestMapping("fetch")
	public List<Abc> fetch() throws ClassNotFoundException, SQLException {
		
		
	//	System.out.println("starting...");
		Class.forName("com.mysql.jdbc.Driver");
	//	System.out.println("driver loaded succefully...");
				
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	//	System.out.println("Connection Succesfully");
			
		PreparedStatement ps = con.prepareStatement("select * from bookcounter");
		ResultSet rs=ps.executeQuery();  
		//ArrayList<ResultSet> a1=new ArrayList<>();
		ArrayList<Abc> a2=new ArrayList<>();
		
		System.out.println("id name result");
		while(rs.next()){  
			Abc a1=new Abc();
			a1.setId(rs.getInt(1));
			a1.setName(rs.getString(2));
			a1.setPrice(rs.getString(3));
			a2.add(a1);
			
		//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));  
		}  
		return a2;
		
	}
	
	@RequestMapping("update")
	public String update() throws ClassNotFoundException, SQLException {
	//	System.out.println("starting");
		Class.forName("com.mysql.jdbc.Driver");
	//	System.out.println("driver loaded succesfully");
				
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	//	System.out.println("Connection Succesfull");
			
		PreparedStatement ps = con.prepareStatement("UPDATE student SET student_id = ?  WHERE  Name = ?");
		
		ps.setInt(1,50);
		ps.setString(2,"jaya");
		//ps.setString(3,"fail");
		
		
		int i = ps.executeUpdate();
		//System.out.println("Update Succesfully " + i);
		
		if(i==1)return "updated Successfully";
		else
			return "failed to update record";
	}
	}
