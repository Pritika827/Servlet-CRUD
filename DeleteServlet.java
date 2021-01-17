import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

public class DeleteServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.println("<h1>Delete Servlet</h1>");
		
		Integer eno=Integer.parseInt(req.getParameter("eno"));
		Employee employee=new Employee();
		employee.setEno(eno);
		try
		{
			EmployeeDao employeeDao =new EmployeeDao();
			Integer i= employeeDao.deleteRecord(employee);
			out.println(i+"Reccord deleted in a table");
		}catch (Exception e) {
			// TODO: handle exception
		}
		out.println("<a href='index.html'>HOME</a>");
		out.println("<a href='delete.html'>Delete More Records</a>");
	}
}
