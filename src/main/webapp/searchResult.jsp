<%@ page import="dataAccessLayer.RealCustomer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DotinSchool2
  Date: 8/16/2016
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8>
    <link href=css/Style.css rel=stylesheet>
    <title>جستجوی مشتری</title>
</head>
<body>
<div class=title>
    <h1>جستجوی مشتری</h1>
</div>
<div class=main-box>
    <br>
    <br>
    <form method="post"
    <%
        int count = 0;
        ArrayList<RealCustomer> realCustomerObjects = (ArrayList<RealCustomer>) request.getAttribute("realCustomers");
        if (realCustomerObjects.size() > 0) {
    %>
    <p>نتایج جستجو به شرح زیر است:</p>
    <table>
        <thead>
        <tr>
            <th>
                ردیف
            </th>
            <th>
                نام
            </th>
            <th>
                نام خانوادگی
            </th>
            <th>
                نام پدر
            </th>
            <th>
                کد ملی
            </th>
            <th>
                شماره مشتری
            </th>
            <th>
                انجام عملیات
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            for (RealCustomer realCustomerObject : realCustomerObjects) {
                count++;
        %>
        <tr>
            <td>
                <%=count%>
            </td>
            <td>
                <%=realCustomerObject.getFirstName()%>
            </td>
            <td>
                <%=realCustomerObject.getLastName()%>
            </td>
            <td>
                <%=realCustomerObject.getFatherName()%>
            </td>
            <td>
                <%=realCustomerObject.getNationalCode()%>
            </td>
            <td>
                <%=realCustomerObject.getCustomerId()%>
            </td>
            <td><a href=DeleteRealCustomerServlet?customerId=<%=realCustomerObject.getCustomerId() %> class=form>حذف</a>
                <a href=UpdateRealCustomerServlet?customerId=<%=realCustomerObject.getCustomerId() %> class=form>اصلاح</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%} else {%>
    <h3>مشتری با مشخصات وارد شده وجود ندارد!</h3>
    <%}%>
    <a href=searchRealCustomer.html class=form>بازگشت به صفحه قبل</a>
</div>
</body>
</html>
