<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="header" align="center">
            <img alt="Discoverer" src="<c:url value="/resources/logo.png"/>" height="130px;">
        </div>
        <div align="center">
            <h2>Upload monk file for TR/RR generation</h2>
            <form:form method="POST" enctype="multipart/form-data" action="generateOutput">
		File to upload: 
                <input type="file" path="file" name="file" />
                <br /> <br /> <br />
                <input type="submit"> 
            </form:form>
        </div>
    </body>
</html>
