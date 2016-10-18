<%@page import="com.team.mighty.domain.*"%>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<div class="container">
<div class="header">
<div style="float: right; font-size: 9;">
</div>
<div style="float: right;">
<div style="display: inline;">
<a href="adminHome">Home</a> &nbsp;&nbsp;|&nbsp;&nbsp;<a
href="logout">Logout</a>
</div>
<%
AdminUser adminUser=(AdminUser)request.getSession().getAttribute("adminUser");
%>
Welcome
<%=adminUser.getDisplayname()%>
<%out.print(adminUser.getRole().getName());%>
</div>
<table>
<tr>
<td><a href="http://www.unizentechnologies.com/"><img
src="images/logo.png" /></a></td>
<td>
<div style="float: left">
<h1 style="color: #FF4000;">Mighty</h1>
<h4>Mighty Cloud</h4>
</div>
</td>
<td style="float: right;">
</td>
</tr>
</table>
<div class="clear"></div>
</div>
<div class="clr"></div>
<div id="cssmenu">
<ul>
${userMenu}
</ul>
</div>
<%
String message = "";
try {
message = request.getAttribute("status").toString();
System.out.println("Statuss"+message);
} catch (Exception e) {
message = "";
}
request.setAttribute("status", "");
if (message != null && !message.equals("")) {
System.out.println("Statuss Error IN IF"+message);
%>
<div id="statusMessage">
<%=message%>
</div>
<%
}
%>
</div>