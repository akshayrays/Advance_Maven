<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		<div align="center">

			<%
				String err = (String) request.getAttribute("err");
				if (err != null) {
			%><font color="red"><%=err%></font>
			<%
				}
			%>
			<table>
				<tr>
					<th>Login :</th>
					<td><input type="text" name="login"></td>
					<td>
						<%
							String err1 = (String) request.getAttribute("err1");
							if (err1 != null) {
						%><font color="red"><%=err1%></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="password" name="pwd"></td>
					<td>
						<%
							String err2 = (String) request.getAttribute("err2");
							if (err2 != null) {
						%><font color="red"><%=err2%></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</div>

	</form>

</body>
</html>