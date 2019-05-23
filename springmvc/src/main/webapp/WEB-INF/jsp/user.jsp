
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.shyfay.mvc.model.User" %>
<%
    List<User> userList = (List<User>)request.getAttribute("users");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>This is a springmvc demo page</h2>
    <table style="width:100px">
　　　　<tr>
　　　　　　<td>name</td>
　　　　　　<td>age</td>
　　　　</tr>
      <tr>
          <td colspan="2">
              <% userList.size(); %>
          </td>
      </tr>
    　 <%for (int i=0;i<userList.size();i++){%>
　　　　<tr>
　　　　　　<td> <%=userList.get(i).getName()%> </td>
          <td> <%=userList.get(i).getName()%> </td>
　　　　</tr>
    　　<%} %>
　　</table>
</body>
</html>
