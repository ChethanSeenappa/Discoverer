<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div align="center">
            <h2>Upload your monk file for TR generation</h2>
            <form:form method="POST" enctype="multipart/form-data" action="download">
		File to upload: 
                <input type="file" path="file" name="file" />
                <br /> <br /> <br />
                <input type="submit"> 
            </form:form>
        </div>
    </body>
</html>
