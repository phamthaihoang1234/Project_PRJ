<%-- 
    Document   : user-form
    Created on : Oct 4, 2021, 1:32:59 PM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>User Management Application</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <div>
                    <h3> Category
                        Management  </h3>
                </div>

                                <ul class="navbar-nav">
                                    <li><a href="CategoryServlet"
                                           class="nav-link">Category</a></li>
                                </ul>
                
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                  

                            <caption>
                                <h2>
                                    <c:if test="${cate != null}">
                                        View Category
                                    </c:if>
                                    
                                </h2>
                            </caption>

                            <c:if test="${cate != null}">
                                <input type="hidden" readonly="" name="id" value="<c:out value='${cate.cateID}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Name</label> <input type="text" readonly
                                                               value="<c:out value='${cate.cateName}' />" class="form-control"
                                                               name="categoryname" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Status</label> <input type="text" readonly
                                                               value="<c:out value='${cate.status}' />" class="form-control"
                                                               name="Status">
                            </fieldset>



                            <a class="btn btn-success" href="CategoryServlet" >Back</a>
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
