package dao;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class MyConnection {
private MyConnection() {}
	private static Connection con;
	static Connection getConnection() throws ClassNotFoundException,SQLException,IOException
	{
			if(con==null) 
			{
				FileReader fr = new FileReader("D:\\JDBC\\MyConn.properties");
				Properties p = new Properties();
				p.load(fr);
				
				
				String drivername=p.getProperty("drivername");
				String url =p.getProperty("url");
				String uname=p.getProperty("uname");
				String upass=p.getProperty("upass");
			
				Class.forName(drivername);
				con=DriverManager.getConnection(url,uname,upass);
			}
			return con;
	}
	}