<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div align="center">
            <h2>Create User</h2>
            <form:form action="show" commandName="student">
                <table>
                    <tr>
                        <td>
                            <form:label path="name">
                                Name: 
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="age">
                                Age: 
                            </form:label>
                        </td>
                        <td>
                            <form:input path="age" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">Submit</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
