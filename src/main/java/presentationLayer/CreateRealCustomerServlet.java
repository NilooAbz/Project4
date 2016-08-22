package presentationLayer;

import dataAccessLayer.RealCustomer;
import exceptions.EmptyFieldException;
import exceptions.WrongNationalCodeFormatException;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class CreateRealCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");


        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setFirstName(request.getParameter("firstName"));
        realCustomer.setLastName(request.getParameter("lastName"));
        realCustomer.setFatherName(request.getParameter("fatherName"));
        realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
        realCustomer.setNationalCode(request.getParameter("nationalCode"));

        try {
            RealCustomerLogic.create(realCustomer);
            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text","اطلاعات مشتری ذخیره شد.");
            request.setAttribute("url", "realCustomerManagement.html");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);

        } catch (EmptyFieldException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "createRealCustomer.jsp");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);

        } catch (WrongNationalCodeFormatException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "createRealCustomer.jsp");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        } catch (Exception e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت مشتری جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "realCustomerManagement.jsp");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        }


    }
}
