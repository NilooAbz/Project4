<%--
  Created by IntelliJ IDEA.
  User: DotinSchool2
  Date: 8/15/2016
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/Style.css">
    <title>تعریف نوع تسهیلات</title>
</head>
<body>
<div class=title>
    <h1> تعریف نوع تسهیلات</h1>
</div>
<div class=main-box>
    <br>
    <br>
    <form action="/createLoanTypeServlet" method="post">
        <table>
            <tr>
                <td> نام نوع تسهیلات </td>
                <td> <input type="text" name="loanName" required="required" oninvalid="alert('وارد کردن نوع تسهیلات الزامی است')"> </td>
            </tr>
            <tr>
                <td> نرخ سود </td>
                <td><input type="text" name="interestRate" required="required" oninvalid="alert('وارد کردن نرخ سود الزامی است')"/></td>
            </tr>
        </table>
        <br>
        <br>
        <input class="button" type="submit" value="اضافه کردن شروط اعطا">
    </form>
    <a href="realCustomerManagement.html" class="form">بازگشت به صفحه قبل</a>
</div>
</body>
</html>
