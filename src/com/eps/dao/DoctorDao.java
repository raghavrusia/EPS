package com.eps.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.eps.pojo.DoctorPojo;

public class DoctorDao {
	Connection con = null;
	DbConn dbcon = new DbConn();


public ArrayList<DoctorPojo> Fetch() throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	ArrayList<DoctorPojo> data = new ArrayList<DoctorPojo>();
	ResultSet rs = stmt.executeQuery("select * from doctor");
	
	while(rs.next())//(rs.next() != null)
	{
		DoctorPojo obj = new DoctorPojo();
		obj.setDoctorId(rs.getInt(1));
		obj.setFirstName(rs.getString(2));
		obj.setLastName(rs.getString(3));
		obj.setDeaNumber(rs.getInt(4));
		obj.setContactNo(rs.getInt(5));
		obj.setEmail(rs.getString(6));
		obj.setPassword(rs.getString(7));
		
		data.add(obj);
	}
	return data;
}


public int Add(String ... data) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	DoctorPojo pojo = new DoctorPojo();
	pojo.setDoctorId(Integer.parseInt(data[0]));
	pojo.setFirstName(data[1]);
	pojo.setLastName(data[2]);
	pojo.setDeaNumber(Integer.parseInt(data[3]));
	pojo.setContactNo(Integer.parseInt(data[4]));
	pojo.setEmail(data[5]);
	pojo.setPassword(data[6]);
	
	
	int i = stmt.executeUpdate("insert into doctor(doctor_id,doctor_f_name, doctor_l_name, doctor_dea_num, doctor_contact,doctor_email,doctor_pass) values "
			+ "('"+pojo.getDoctorId()+"','"+pojo.getFirstName()+"','"+pojo.getLastName()+"','"+pojo.getDeaNumber()+"','"+pojo.getContactNo()+"','"+pojo.getEmail()+"','"+pojo.getPassword()+"')"); 
	return i;
}

public int Remove(int doctorId) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	int i = stmt.executeUpdate("delete from doctor where doctor_id = '"+doctorId+"'");
	return i;
	
}


public ArrayList<DoctorPojo> Edit(int doctorId) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	ArrayList<DoctorPojo> pojo = new ArrayList<DoctorPojo>();
	ResultSet rs = stmt.executeQuery("select * from doctor where doctor_id = '"+doctorId+"'");
	rs.next();
	DoctorPojo obj = new DoctorPojo();
	obj.setDoctorId(rs.getInt(1));
	obj.setFirstName(rs.getString(2));
	obj.setLastName(rs.getString(3));
	obj.setDeaNumber(rs.getInt(4));
	obj.setContactNo(rs.getInt(5));
	obj.setEmail(rs.getString(6));
	obj.setPassword(rs.getString(7));
	
	pojo.add(obj);
	return pojo;
}

public int Update(String... data) throws Exception
{
	con = dbcon.getConnect();
	Statement stmt = con.createStatement();
	DoctorPojo pojo = new DoctorPojo();
	pojo.setDoctorId(Integer.parseInt(data[0]));
	pojo.setFirstName(data[1]);
	pojo.setLastName(data[2]);
	pojo.setDeaNumber(Integer.parseInt(data[3]));
	pojo.setContactNo(Integer.parseInt(data[4]));
	pojo.setEmail(data[5]);
	pojo.setPassword(data[6]);
	
	int i = stmt.executeUpdate("update doctor set doctor_f_name = '"+pojo.getFirstName()+"',doctor_l_name = '"+pojo.getLastName()+"', doctor_dea_num = '"+pojo.getDeaNumber()+"',"
			+ " doctor_contact='"+pojo.getContactNo()+"'"+ "doctor_email = '"+pojo.getEmail()+"'" +"doctor_pass = '"+pojo.getPassword()+"'"+" where doctor_id = '"+pojo.getDoctorId()+"'");
	return i;
			
	
}
}
