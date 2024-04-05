package com.javaconnectivity;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbcprogram {

	public static void main(String[] args) {
		 
		String db_url="jdbc:mysql://localhost:3306";
		String user="root";
		String password="root";
		
		try {
			Connection connection=DriverManager.getConnection(db_url,user,password);
		
		if(connection!=null) {
			System.out.println("The  database connection is successfull.");
			
		}else
		{
			System.out.println("The  database connection is not successfull.");
		}
		
		Statement statement=connection.createStatement();
		
		String create="create database testdb";
		String use="use testdb";
		String createtable="create table employee(empcode int,empname varchar(20),empage int,empsalary int)";
		String select="select * from employee";
		
		String insert=" insert into employee values (101,'Ramya',25,50000),"+"(102,'Velu',33,80000),"+"(103,'Rithu',20,30000),"+"(104,'Hari',28,70000),"+"(105,'Shan',50,80000)";
		 
		statement.execute(create);
		statement.execute(use);
		statement.execute(createtable);
		statement.execute(insert);
		
		ResultSet rs=statement.executeQuery(select);
		
		while(rs.next()) {
			System.out.println(rs.getInt("empcode")+rs.getString("empname")+rs.getInt("empage")+rs.getInt("empsalary"));
		}
		connection.close();

		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

} 
 