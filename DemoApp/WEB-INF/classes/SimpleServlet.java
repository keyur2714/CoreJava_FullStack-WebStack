
		import javax.servlet.GenericServlet;
		import javax.servlet.ServletException;
		import java.io.IOException;
		import javax.servlet.ServletRequest;
		import javax.servlet.ServletResponse;
		import java.io.PrintWriter;
		
		public class SimpleServlet extends GenericServlet {
			
			public void service(ServletRequest request,ServletResponse response)throws IOException,ServletException{
					String msg = request.getParameter("msg");
					
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					if("gm".equalsIgnoreCase(msg)){
						out.println("<h1>Hello From Servlet...!Good Morning...</h1>");
					}else if("aft".equalsIgnoreCase(msg)){
						out.println("<h1>Hello From Servlet...!Good Afternoon...</h1>");	
					}					
					String str = request.getParameter("str");
					String revStr = new StringBuffer().append(str).reverse().toString();
					out.println("<h1>Original String is...!"+str+"</h1>");	
					out.println("<h1>Reverse String is...!"+revStr+"</h1>");	
			}
			
		}