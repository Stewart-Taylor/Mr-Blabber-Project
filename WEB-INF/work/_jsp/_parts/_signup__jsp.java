/*
 * JSP generated by Resin-3.0.21 (built Thu, 10 Aug 2006 12:03:19 PDT)
 */

package _jsp._parts;
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
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, null, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
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
    long lastModified = 0;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      Object oDepend = _caucho_depends.get(i);
      if (oDepend instanceof com.caucho.vfs.Depend) {
        com.caucho.vfs.Depend depend = (com.caucho.vfs.Depend) oDepend;
        if (lastModified < depend.getLastModified())
          lastModified = depend.getLastModified();
      }
    }

    return lastModified;
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("parts/Signup.jsp"), -7554159037385008641L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\r\n<script language=\"javascript\">\r\n\r\n\r\nfunction passResponse2()\r\n {\r\n\r\n \r\n \r\ndocument.hform2.username.value = document.register.username.value;\r\ndocument.hform2.password.value = MD5(document.register.password.value);\r\ndocument.hform2.password2.value = MD5(document.register.password2.value);\r\ndocument.register.password.value = \"\";\r\ndocument.register.password2.value = \"\";\r\n\r\n\r\n\r\ndocument.hform2.submit();\r\n\r\n\r\n}\r\n\r\n\r\n</script>\r\n\r\n\r\n\r\n\r\n<div id=\"signup_box\">\r\n			\r\n	<h4>Join Today</h4>\r\n			\r\n			<form name=\"hform2\" action=\"/stewarttaylor/signup/\" method=\"post\" >\r\n<input type=\"hidden\" name=\"username\">\r\n<input type=\"hidden\" name=\"password\">\r\n<input type=\"hidden\" name=\"password2\">\r\n			</form>\r\n			\r\n	<form name=\"register\"  method=\"Post\">\r\n			\r\n			<div id=\"signup_item\">\r\n				Username  <input type=\"text\"  class =\"tb3\" name=\"username\" maxlength=\"30\" />\r\n			</div>\r\n				\r\n			<div id=\"signup_item\">\r\n				Password  <input type=\"password\"  class =\"tb3\" name=\"password\" maxlength=\"30\" />\r\n			</div>\r\n				\r\n			<div id=\"signup_item\">\r\n				Password Again  <input type=\"password\"  class =\"tb3\" name=\"password2\" maxlength=\"30\" />\r\n			</div>\r\n	\r\n		<input type=\"submit\"    onClick=\"passResponse2(); return false;\"  class=\"btn1\" value=\"Sign Up\" />\r\n	</form>	\r\n</div>\r\n\r\n\r\n".toCharArray();
  }
}
