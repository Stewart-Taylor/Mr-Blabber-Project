/*
 * JSP generated by Resin-3.0.21 (built Thu, 10 Aug 2006 12:03:19 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _signup__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=windows-1256");
    request.setCharacterEncoding("windows-1256");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
       
				
				try
				{
				
					 String atmpt =request.getParameter("attempt");
					
					if(atmpt.equals("1"))
					{
						out.print("<h2> Username already Exists </h2>");
					}
					else if(atmpt.equals("2"))
					{
						out.print("<h2> Passwords Don't Match </h2>");
					}
					else if(atmpt.equals("3"))
					{
						out.print("<h2> Invalid Username or password </h2>");
					}
			
				
				}catch(Exception E)
				{
				
				
				}
				
				
				
      out.write(_jsp_string1, 0, _jsp_string1.length);
      pageContext.include("parts/Signup.jsp", true);
      out.write(_jsp_string2, 0, _jsp_string2.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      com.caucho.jsp.QJspFactory.freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.make.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != -6418134904411496499L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.make.Dependency depend;
      depend = (com.caucho.make.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("signup.jsp"), 3668656144884320381L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  static {
    _jsp_string0 = "\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n\"http://www.w3.org/TR/html4/loose.dtd\">\r\n\r\n\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n\r\n<head>\r\n	<meta charset=\"utf-8\" />\r\n	<!--[if IE]><script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script><![endif]-->\r\n	<title> </title>\r\n	<meta name=\"keywords\" content=\"\" />\r\n	<meta name=\"description\" content=\"\" />\r\n	<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" media=\"screen, projection\" />\r\n	\r\n	<script language=\"javascript\" src=\"md5.js\"></script>\r\n</head>\r\n\r\n\r\n\r\n<body>\r\n\r\n	<div id=\"wrapper\">\r\n\r\n	\r\n		<div id=\"header\">\r\n			\r\n			<div id = \"logobox\">\r\n				<img src=\"Images/Logo.png\" alt=\"Logo\" />\r\n			</div>\r\n\r\n		</div>\r\n\r\n\r\n		<div id=\"content\">\r\n\r\n				\r\n		<div id=\"middle_content\">\r\n\r\n				".toCharArray();
    _jsp_string2 = "\r\n			\r\n		</div><!--end of left content-->\r\n\r\n		<div style=\"clear: both;\">\r\n		</div><!-- #content-->\r\n\r\n		\r\n		<footer id=\"footer\">\r\n			<p>Created By Stewart Taylor</p>\r\n		</footer><!-- #footer -->\r\n\r\n\r\n	</div><!-- #wrapper -->\r\n\r\n\r\n\r\n</body>\r\n\r\n</html>".toCharArray();
    _jsp_string1 = "\r\n			\r\n				".toCharArray();
  }
}
