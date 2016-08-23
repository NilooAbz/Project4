<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="css/Style.css" rel="stylesheet">
    <script type="text/javascript" src="checkNationalCode.js"></script>
    <title>ثبت مشتری حقیقی</title>
</head>

<body>
<div class="title">
    <br>
    <h1>ثبت مشتری حقیقی</h1>
    <br>
</div>

<div class="main-box">
    <br>
    <p>لطفا اطلاعات زیر را تکمیل فرمایید </p>
    <br>
    <form action="/CreateRealCustomerServlet" method="post"  onsubmit="return checkMelliCode(document.getElementById('nationalCode')).value()">
        <table>
            <tr>
                <td> نام</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td> نام خانوادگی</td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>نام پدر</td>
                <td><input type="text" name="fatherName"></td>
            </tr>
            <tr>
                <td>تاریخ تولد</td>
                <td><input type="text" name="dateOfBirth"></td>
            </tr>
            <tr>
                <td>کد ملی</td>
                <td><input type="text" name="nationalCode" id="nationalCode"
                           ></td>
            </tr>
        </table>
        <input type="submit"  class="button" value="ثبت اطلاعات">
        <br><br>
        <a href="realCustomerManagement.html" class="form" >بازگشت به صفحه قبل </a>
    </form>
    <br>
    <br>
</div>
</body>
</html>