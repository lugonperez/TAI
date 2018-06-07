package es.tai;

import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

@WebServlet("/Programa1")
public class Programa1 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = -283811616015383717L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 

		PrintWriter pw=response.getWriter();               
		response.setContentType("text/html");               
		/* 1 */
		pw.println("<html>");               
		pw.println("<head>");               
		pw.println("<title>");               
		pw.println("PROGRAMA1");               
		pw.println("</title");               
		pw.println("</head>");               
		pw.println("<body>");               
		pw.println("<h1 align=center>Programa1</h1>");
		
		Servicio.getServicio().servir(pw,request.getSession()); 
		
		pw.println("</body>");               
		pw.println("</html>");               
	}                                                            
} 

class Servicio{ 

	private static Servicio servicio; 
	private int c1=1; 
	
	private Servicio() { 
		servicio=this;               
	}               
	
	public static synchronized Servicio getServicio(){ 
		if(servicio==null){               
			servicio=new Servicio();               
		}
		
		return servicio;               
	}               
	
	public void servir(PrintWriter pw,HttpSession s){               
		int c2;               
		
		if(s.getAttribute("C2")!=null){                                                                                                                                                                                                 
			c2=(Integer)s.getAttribute("C2");               
		}else{               
			c2=1; 
		}
		
		pw.println((c1++)+"<br>");               
		pw.println((c2++)+"<br>");               
		pw.println(new java.util.Date().toString()+"<br>");               
		s.setAttribute("C2",c2);               
	}               
}  
