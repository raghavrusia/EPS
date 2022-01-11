package com.eps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.eps.pojo.DrugPojo;

public class DrugDao {

Connection con = null;
DbConn dbcon = new DbConn();

public ArrayList<DrugPojo> Fetch() throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	ArrayList<DrugPojo> data = new ArrayList<DrugPojo>();
	ResultSet rs = stmt.executeQuery("select * from drug");
	
	while(rs.next())//(rs.next() != null)
	{
		DrugPojo obj = new DrugPojo();
		obj.setDrugId(rs.getInt(1));
		obj.setDrugName(rs.getString(2));
		obj.setDrugNdc(rs.getInt(3));
		obj.setDrugQty(rs.getInt(4));
		data.add(obj);
	}
	return data;
}


public int Add(String ... data) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	DrugPojo pojo = new DrugPojo();
	pojo.setDrugId(Integer.parseInt(data[0]));
	pojo.setDrugName(data[1]);
	pojo.setDrugNdc(Integer.parseInt(data[2]));
	pojo.setDrugQty(Integer.parseInt(data[3]));
	
	int i = stmt.executeUpdate("insert into drug(drug_id, drug_name, drug_ndc, drug_qty) values "
			+ "('"+pojo.getDrugId()+"','"+pojo.getDrugName()+"','"+pojo.getDrugNdc()+"','"+pojo.getDrugQty()+"')"); 
	return i;
}

public int Remove(int drugId) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	int i = stmt.executeUpdate("delete from drug where drug_id = '"+drugId+"'");
	return i;
	
}


public ArrayList<DrugPojo> Edit(int drugId) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	ArrayList<DrugPojo> pojo = new ArrayList<DrugPojo>();
	ResultSet rs = stmt.executeQuery("select * from drug where drug_id = '"+drugId+"'");
	rs.next();
	DrugPojo obj = new DrugPojo();
	obj.setDrugId(rs.getInt(1));
	obj.setDrugName(rs.getString(2));
	obj.setDrugNdc(rs.getInt(3));
	obj.setDrugQty(rs.getInt(4));
	pojo.add(obj);
	return pojo;
}

public int Update(String... data) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	DrugPojo pojo = new DrugPojo();
	pojo.setDrugId(Integer.parseInt(data[0]));
	pojo.setDrugName(data[1]);
	pojo.setDrugNdc(Integer.parseInt(data[2]));
	pojo.setDrugQty(Integer.parseInt(data[3]));
	
	int i = stmt.executeUpdate("update drug set drug_name = '"+pojo.getDrugName()+"',drug_ndc = '"+pojo.getDrugNdc()+"', drug_qty = '"+pojo.getDrugQty()+"'"+" where drug_id = '"+pojo.getDrugId()+"'");
	return i;
			
	
}
}
