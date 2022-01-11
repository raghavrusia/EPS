package com.eps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.eps.pojo.StorePojo;

public class StoreDao {
	Connection con = null;
	DbConn dbcon = new DbConn();

	public ArrayList<StorePojo> Fetch() throws Exception
	{
		con = dbcon.getConnect();
		Statement stmt = con.createStatement();
		ArrayList<StorePojo> data = new ArrayList<StorePojo>();
		ResultSet rs = stmt.executeQuery("select * from drug");
		
		while(rs.next())//(rs.next() != null)
		{
			StorePojo obj = new StorePojo();
			obj.setStoreId(rs.getInt(1));
			obj.setStoreName(rs.getString(2));
			obj.setNcpdpNo(rs.getString(3));
			data.add(obj);
		}
		return data;
	}


	public int Add(String ... data) throws Exception
	{
		con = dbcon.getConnect();
		Statement stmt = con.createStatement();
		StorePojo pojo = new StorePojo();
		pojo.setStoreId(Integer.parseInt(data[0]));
		pojo.setStoreName(data[1]);
		pojo.setNcpdpNo(data[2]);	
		int i = stmt.executeUpdate("insert into store(store_id, store_name, store_ncpdp) values "
				+ "('"+pojo.getStoreId()+"','"+pojo.getStoreName()+"','"+pojo.getNcpdpNo()+"')"); 
		return i;
	}

	public int Remove(int storeId) throws Exception
	{
		con = dbcon.getConnect();
		Statement stmt = con.createStatement();
		int i = stmt.executeUpdate("delete from store where store_id = '"+storeId+"'");
		return i;
		
	}


	public ArrayList<StorePojo> Edit(int storeId) throws Exception
	{
		con = dbcon.getConnect();
		Statement stmt = con.createStatement();
		ArrayList<StorePojo> pojo = new ArrayList<StorePojo>();
		ResultSet rs = stmt.executeQuery("select * from store where store_id = '"+storeId+"'");
		rs.next();
		StorePojo obj = new StorePojo();
		obj.setStoreId(rs.getInt(1));
		obj.setStoreName(rs.getString(2));
		obj.setNcpdpNo(rs.getString(3));
		pojo.add(obj);
		return pojo;
	}

	public int Update(String... data) throws Exception
	{
		con = dbcon.getConnect();
		Statement stmt = con.createStatement();
		StorePojo pojo = new StorePojo();
		pojo.setStoreId(Integer.parseInt(data[0]));
		pojo.setStoreName(data[1]);
		pojo.setNcpdpNo(data[2]);	
	
		
		int i = stmt.executeUpdate("update store set store_name = '"+pojo.getStoreName()+"',store_ncpdp = '"+pojo.getNcpdpNo()+"'"+" where store_id = '"+pojo.getStoreId()+"'");
		return i;
				
		
	}
}
