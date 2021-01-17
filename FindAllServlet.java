import java.io.*;
import java.net.http.HttpRequest;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

public class FindAllServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.print("<h1>Find All Servlet</h1>");
		
		try
		{
			EmployeeDao employeeDao = new EmployeeDao();
			java.util.List<Employee> l = employeeDao.findAllRecord();
			Iterator<Employee> itr = l.iterator();
					
			out.println("<table border='1' align='center'>");
			out.println("<tr>");
			out.println("<td>No</td><td>Name</td><td>Sal</td>");
			out.println("</tr>");
			while(itr.hasNext())
			{
			Employee e =itr.next();
			out.println("<tr>");
			out.println("<td>"+e.getEno()+"</td>");
			out.println("<td>"+e.getEname()+"</td>");
			out.println("<td>"+e.getEsal()+"</td>");
			out.println("</tr>");
			}
			out.println("</table>");
			
		}catch(Exception e)
		{
			System.out.print(e);
		}
		out.println("<a href='index.html'>HOME</a>|");
	}
}
