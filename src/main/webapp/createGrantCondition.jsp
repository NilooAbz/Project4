<%@ page import="dataAccessLayer.LoanType" %><%--
  Created by IntelliJ IDEA.
  User: DotinSchool2
  Date: 8/20/2016
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/Style.css">
    <script type="text/javascript" src="showTable.js"></script>
    <title>تعریف شروط اعطا</title>
</head>
<div class=title>
    <h1> تعریف شروط اعطا</h1>
</div>
<body>
<div class=main-box>
    <br>
    <br>
    <table>
        <%
            LoanType loanTypeObject = (LoanType) request.getAttribute("LoanType");
        %>
        <tr>
            <td>نام تسهیلات</td>
            <td><%=loanTypeObject.getLoanName()%></td>
        </tr>
        <tr>
            <td>نرخ سود تسهیلات</td>
            <td><%=loanTypeObject.getInterestRate()%></td>
        </tr>
    </table>
    <br>
    <a href="createLoanType.jsp" class=form>تصحیح</a>
    <br>
    <hr>
    <br>
    <h3>لطفا مشخصات شروط اعطای مورد نظر را وارد نمایید</h3>
    <br>
    <table>
        <tr>
            <td> نام</td>
            <td><input type="text" id="grantName" ></td>
        </tr>
        <tr>
            <td> حداقل مدت قرارداد</td>
            <td><input type="text" id="minDuration" ></td>
        </tr>
        <tr>
            <td> حداکثر مدت قرارداد</td>
            <td><input type="text" id="maxDuration" ></td>
        </tr>
        <tr>
            <td> حداقل مبلغ قرارداد</td>
            <td><input type="text" id="minAmount" ></td>
        </tr>
        <tr>
            <td> حداکثر مبلغ قرارداد</td>
            <td><input type="text" id="maxAmount" ></td>
        </tr>
    </table>
    <br>
    <input class="button" type="submit" value="اضافه کردن شروط" onclick="addRow()">
    <br>
    <hr>
    <br>
    <form action="/GrantConditionServlet" method="get">
        <input type="hidden" name="loanName" value="<%= request.getParameter("loanName")%>">
        <input type="hidden" name="interestRate" value="<%= request.getParameter("interestRate")%>">
        <table class="result-table" id="GrantConditionShowTable"></table>
        <br>
    </form>
</div>
</body>
</html>
