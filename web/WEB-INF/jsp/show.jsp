<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div align="center">
            <h2>User details</h2>
            <table>
                <tr>
                    <td>
                        <label>Name:    </label>
                    </td>
                    <td>
                        ${name}
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Age: </label>
                    </td>
                    <td>
                        ${age}
                    </td>
                </tr>
        </table>
    </body>
</html>
