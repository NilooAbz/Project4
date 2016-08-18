<%@ page import="dataAccessLayer.RealCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DotinSchool2
  Date: 8/17/2016
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8>
    <link href=css/Style.css rel=stylesheet>
    <title>اصلاح مشتری حقیقی</title>
</head>
<body>
<div class=title>
    <h1>اصلاح مشتری حقیقی </h1>
</div>

<div class=main-box>
    <br>
    <form action="/SaveRealCustomerServlet" method="post">
        <p>اطلاعات مشتری حقیقی :</p>
        <br>
            <%RealCustomer realCustomerObject = (RealCustomer) request.getAttribute("realCustomers"); %>
        <table>
            <tr>
                <td>شماره مشتری</td>
                <td><input type='text' name='customerId' value="<%=realCustomerObject.getCustomerId()%>"
                           readonly></td>
            </tr>
            <tr>
                <td> نام</td>
                <td><input type='text' name='firstName' value="<%=realCustomerObject.getFirstName()%>"></td>
            </tr>
            <td> نام خانوادگی</td>
            <td><input type='text' name='lastName' value="<%=realCustomerObject.getLastName()%>"></td>
            </tr>
            <td> نام پدر</td>
            <td><input type='text' name='fatherName' value="<%=realCustomerObject.getFatherName()%>"></td>
            </tr>
            <tr>
                <td> تاریخ تولد</td>
                <td><input type='text' name='dateOfBirth' value="<%=realCustomerObject.getDateOfBirth()%>">
                </td>
            </tr>
            <tr>
                <td>کد ملی</td>
                <td><input type='text' name='nationalCode' value="<%=realCustomerObject.getNationalCode()%>"></td>
            </tr>
        </table>
        <input type='submit' class='button' value='ذخیره تغییرات'>
    </form>
</div>


</body>
</html>
