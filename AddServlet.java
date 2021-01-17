import java.io.*;
import java.net.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

public class AddServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.print("<h1>Add Servlet</h1>");
		
		Integer eno=Integer.parseInt(req.getParameter("eno"));
		String ename=req.getParameter("ename");
		Integer esal =Integer.parseInt(req.getParameter("esal"));
		
		Employee employee=new Employee();
		employee.setEno(eno);
		employee.setEname(ename);
		employee.setEsal(esal);
		
		try
		{
			EmployeeDao employeeDao = new EmployeeDao();
			Integer i=employeeDao.addRecord(employee);
			out.print(i+"Record added in a table");
		}catch(Exception e)
		{
			System.out.print(e);
		}
		out.println("<a href='index.html'>HOME</a>|");
		out.println("<a href='add.html'>Add More Records</a>");
	}
}
