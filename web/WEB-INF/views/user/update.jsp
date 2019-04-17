
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/save">
    <table>
       <c:if test="${user.id!=null}">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" readonly="readonly" value="${user.id}" /> </td>
        </tr>
       </c:if>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="${user.password}" /></td>
        </tr>
     <tr>
         <td colspan="2">
             <input type="submit" value="save"/>
         </td>
     </tr>
    </table>
</form>




</body>
</html>
