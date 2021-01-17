package dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
public class EmployeeDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public EmployeeDao() throws ClassNotFoundException,SQLException,IOException
	{
		con=MyConnection.getConnection();
	}
	public Integer addRecord(Employee employee) throws SQLException
	{
		sql="insert into employee values(?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1, employee.getEno());
		ps.setString(2, employee.getEname());
		ps.setInt(3, employee.getEsal());
		return ps.executeUpdate();
	}
	public Integer updateRecord(Employee employee) throws SQLException
	{
		sql="update employee set ename=?,esal=? where eno=?";
		ps=con.prepareStatement(sql);
		ps.setInt(3, employee.getEno());
		ps.setString(1, employee.getEname());
		ps.setInt(2, employee.getEsal());
		return ps.executeUpdate();
		
	}
	public Integer deleteRecord(Employee employee) throws SQLException
	{
		sql="delete from employee where eno=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, employee.getEno());
		return ps.executeUpdate();
		
	}
	public Employee findRecord(Integer eno) throws SQLException
	{
		sql="select*from employee where eno=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1, eno);
		rs=ps.executeQuery();
		Employee employee = new Employee();
		if(rs.next()==true)
		{
			employee.setEno(rs.getInt(1));
			employee.setEname(rs.getString(2));
			employee.setEsal(rs.getInt(3));
		}
		return employee;
	}
	public List<Employee> findAllRecord() throws SQLException
	{
		sql="select*from employee";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		List<Employee> store = new ArrayList<Employee>();
		while(rs.next()==true)
		{
			Employee employee= new Employee();
			employee.setEno(rs.getInt(1));
			employee.setEname(rs.getString(2));
			employee.setEsal(rs.getInt(3));
			
			store.add(employee);
		}
		return store;
	}
}
