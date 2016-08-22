<%--
  Created by IntelliJ IDEA.
  User: DotinSchool2
  Date: 8/22/2016
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="css/Style.css" rel="stylesheet">
    <title>پرونده تسهیلاتی</title>
</head>
<body>
<div class="title">
    <h1>پرونده تسهیلاتی</h1>
</div>
<div class=main-box>
    <br>
    <br>
    <form action="/CreateLoanFileServlet" >
        <input type="text" name="action" value="retrieveCustomerLoanType" hidden>
        <table>
            <tr>
                <td>شماره مشتری</td>
                <td><input type="text" name="customerId" value="<%=request.getAttribute("customerId")%>"></td>
                <td><input class="button" type="submit" value="بازیابی"></td>
                <td><a href="realCustomerManagement.html" class="form">بازگشت به صفحه قبل</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
