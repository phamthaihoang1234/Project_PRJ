package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_002dform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!-- CSS only -->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- JavaScript Bundle with Popper -->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <style>\n");
      out.write("            .card-registration .select-input.form-control[readonly]:not([disabled]) {\n");
      out.write("                font-size: 1rem;\n");
      out.write("                line-height: 2.15;\n");
      out.write("                padding-left: .75em;\n");
      out.write("                padding-right: .75em;\n");
      out.write("            }\n");
      out.write("            .card-registration .select-arrow {\n");
      out.write("                top: 13px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section class=\"h-100 bg-dark\">\n");
      out.write("            <div class=\"container py-5 h-100\">\n");
      out.write("                <div class=\"row d-flex justify-content-center align-items-center h-100\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <div class=\"card card-registration my-4\">\n");
      out.write("                            <div class=\"row g-0\">\n");
      out.write("                                <div class=\"col-xl-6 d-none d-xl-block\">\n");
      out.write("                                    <img\n");
      out.write("                                        src=\"https://mdbootstrap.com/img/Photos/new-templates/bootstrap-registration/img4.jpg\"\n");
      out.write("                                        alt=\"Sample photo\"\n");
      out.write("                                        class=\"img-fluid\"\n");
      out.write("                                        style=\"border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;\"\n");
      out.write("                                        />\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xl-6\">\n");
      out.write("                                    <div class=\"card-body p-md-5 text-black\">\n");
      out.write("                                        <h3 class=\"mb-5 text-uppercase\">User registration form</h3>\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-6 mb-4\">\n");
      out.write("                                                <div class=\"form-outline\">\n");
      out.write("                                                    <input type=\"text\" id=\"form3Example1m\" class=\"form-control form-control-lg\" />\n");
      out.write("                                                    <label class=\"form-label\" for=\"form3Example1m\">Name</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-6 mb-4\">\n");
      out.write("                                                <div class=\"form-outline\">\n");
      out.write("                                                    <input type=\"text\" id=\"form3Example1n\" class=\"form-control form-control-lg\" />\n");
      out.write("                                                    <label class=\"form-label\" for=\"form3Example1n\">Phone</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"col-md-6 mb-4\">\n");
      out.write("                                                <div class=\"form-outline\">\n");
      out.write("                                                    <input type=\"text\" id=\"form3Example1m1\" class=\"form-control form-control-lg\" />\n");
      out.write("                                                    <label class=\"form-label\" for=\"form3Example1m1\">Address</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-md-6 mb-4\">\n");
      out.write("                                                <div class=\"form-outline\">\n");
      out.write("                                                    <input type=\"text\" id=\"form3Example1n1\" class=\"form-control form-control-lg\" />\n");
      out.write("                                                    <label class=\"form-label\" for=\"form3Example1n1\">Username</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"form-outline mb-4\">\n");
      out.write("                                            <input type=\"text\" id=\"form3Example8\" class=\"form-control form-control-lg\" />\n");
      out.write("                                            <label class=\"form-label\" for=\"form3Example8\">Password</label>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                       \n");
      out.write("\n");
      out.write("                                        \n");
      out.write("\n");
      out.write("                                        <div class=\"d-flex justify-content-end pt-3\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-light btn-lg\">Reset all</button>\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-warning btn-lg ms-2\">Submit form</button>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
