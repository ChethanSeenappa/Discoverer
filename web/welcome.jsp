<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
        .bodyStyle{
            font-family: verdana; 
            padding: 10px; 
            border-radius: 10px; 
            font-size: 12px;
        }
        </style>
    </head>
    <body>
        <br>
        <div id="header" align="center">
            <img alt="Discoverer" src="<c:url value="/resources/logo.png"/>" height="130px;">
        </div>
        <div align='center' class="bodyStyle">
            <a href="upload">Login Page Upload file</a>	
        </div>
    </body>
</html>
