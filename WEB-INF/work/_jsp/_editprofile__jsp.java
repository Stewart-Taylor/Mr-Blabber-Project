/*
 * JSP generated by Resin-3.0.21 (built Thu, 10 Aug 2006 12:03:19 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _editprofile__jsp extends com.caucho.jsp.JavaPage{
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
    response.setContentType("text/html");
    try {
      uk.ac.dundee.computing.stewarttaylor.ProfileBean profileBean;
      synchronized (session) {
        profileBean = (uk.ac.dundee.computing.stewarttaylor.ProfileBean) session.getAttribute("profileBean");
        if (profileBean == null) {
          profileBean = new uk.ac.dundee.computing.stewarttaylor.ProfileBean();
          session.setAttribute("profileBean", profileBean);
        }
      }
      out.write(_jsp_string0, 0, _jsp_string0.length);
      uk.ac.dundee.computing.stewarttaylor.UserBean userBean2;
      synchronized (session) {
        userBean2 = (uk.ac.dundee.computing.stewarttaylor.UserBean) session.getAttribute("userBean2");
        if (userBean2 == null) {
          userBean2 = new uk.ac.dundee.computing.stewarttaylor.UserBean();
          session.setAttribute("userBean2", userBean2);
        }
      }
      out.write(_jsp_string1, 0, _jsp_string1.length);
      
						uk.ac.dundee.computing.stewarttaylor.UserBean uBean2 = (uk.ac.dundee.computing.stewarttaylor.UserBean)session.getAttribute("userBean");
				String sName = uBean2.getUsername();
		
		
      out.write(_jsp_string2, 0, _jsp_string2.length);
       out.print(sName); 
      out.write(_jsp_string3, 0, _jsp_string3.length);
       out.print(sName);    
      out.write(_jsp_string4, 0, _jsp_string4.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("editprofile.jsp"), -1420942517869993020L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("parts/header.jsp"), 7818843393653806549L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string4;
  private final static char []_jsp_string0;
  private final static char []_jsp_string2;
  private final static char []_jsp_string1;
  private final static char []_jsp_string3;
  static {
    _jsp_string4 = " </a> \r\n\r\n			<a href=\"/stewarttaylor/newsfeed\">Home </a> \r\n\r\n			<a href=\"/stewarttaylor/Logout\">Logout </a> \r\n\r\n			</div>\r\n\r\n		</div>\r\n\r\n\r\n		</div>\r\n\r\n\r\n\r\n					\r\n					\r\n			<div id=\"content\">\r\n				\r\n				\r\n				<div id = \"middle_content\">\r\n				\r\n						<div id=\"signup_box\">\r\n						\r\n							<h4>Edit Profile</h4>\r\n							\r\n							<form name=\"register\" action=\"/stewarttaylor/editprofile\" method=\"Post\">\r\n							\r\n								<div id=\"signup_item\">\r\n									Email  <input type=\"text\"  class =\"tb3\" name=\"email\" maxlength=\"30\" />\r\n								</div>\r\n								\r\n								<div id=\"signup_item\">\r\n									Old Password  <input type=\"password\"  class =\"tb3\" name=\"password\" maxlength=\"30\" />\r\n								</div>\r\n											\r\n								<div id=\"signup_item\">\r\n									New Password  <input type=\"password\"  class =\"tb3\" name=\"password2\" maxlength=\"30\" />\r\n								</div>\r\n									\r\n								<div id=\"signup_item\">\r\n									Image Link  <input type=\"text\"  class =\"tb3\" name=\"image\"  />\r\n								</div>\r\n						\r\n								<input type=\"submit\" class=\"btn1\" value=\"Confirm Changes\" />\r\n							\r\n							</form>\r\n						\r\n						</div>\r\n				</div>\r\n				\r\n				\r\n				\r\n			</div><!--end of middle content-->\r\n\r\n\r\n			<div style=\"clear: both;\">\r\n			</div><!-- #content-->\r\n\r\n				<footer id=\"footer\">\r\n\r\n					<p>Created By Stewart Taylor</p>\r\n\r\n				</footer><!-- #footer -->\r\n\r\n			</div><!-- #wrapper -->\r\n\r\n\r\n	</body>\r\n</html>".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html>\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n\r\n	<head>\r\n		<meta charset=\"utf-8\" />\r\n		<!--[if IE]><script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script><![endif]-->\r\n		<title> </title>\r\n		<meta name=\"keywords\" content=\"\" />\r\n		<meta name=\"description\" content=\"\" />\r\n		<link rel=\"stylesheet\" href=\"/stewarttaylor/style.css\" type=\"text/css\" media=\"screen, projection\" />\r\n	</head>\r\n\r\n	<body>\r\n\r\n			<div id=\"wrapper\">\r\n					\r\n				".toCharArray();
    _jsp_string2 = "\r\n		\r\n			<a href=\"/stewarttaylor/profile/".toCharArray();
    _jsp_string1 = "\r\n\r\n	<div id=\"header\">\r\n    	\r\n		<div id = \"logobox\">\r\n			<a href=\"/stewarttaylor/newsfeed\" >\r\n			<img src=\"/stewarttaylor/Images/Logo.png\" alt=\"Logo\" />\r\n			</a>\r\n		</div>\r\n		\r\n		\r\n		\r\n		\r\n		<div id = \"searchbar\">\r\n				<form name=\"search\" action=\"/stewarttaylor/search/\" method=\"get\" >\r\n					 <input type=\"text\" name=\"search\" />\r\n					<input type=\"submit\"   class=\"btn2\" value=\"Search\" />\r\n				</form>\r\n		</div>\r\n		\r\n		\r\n		\r\n		\r\n				<div id = \"Profilebox\">\r\n\r\n	\r\n		<div class=\"hbuttons\">\r\n		\r\n		".toCharArray();
    _jsp_string3 = "\">".toCharArray();
  }
}
