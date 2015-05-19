<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discoverer</title>
    </head>
    <body>
        <div id="header" align="center">
            <img alt="Discoverer" src="<c:url value="/resources/logo.png"/>" height="130px;">
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div align='center' class="bodyStyle">
            <form action="download" method="POST">
                <input type="hidden" name="filePath" value="${resultPath}"/>
                <input type="hidden" name="contentType" value="${contentType}"/>
                <input type="hidden" name="fileName" value="${fileName}"/>
                Here you go !!!. check out the ${fileName} sheet.<br/><br/>
                <input type="submit" value="click here to download">
            </form>
            <br>
            Do you want to generate another TR/RR?<a href="upload">Click here!!!</a>	
        </div>
    </body>
</html>
