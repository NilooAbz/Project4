package presentationLayer;

import dataAccessLayer.RealCustomer;
import exceptions.DuplicateDataException;
import exceptions.EmptyFieldException;
import exceptions.WrongNationalCodeFormatException;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DotinSchool2 on 8/17/2016.
 */
public class SaveRealCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setCustomerId(Long.valueOf(request.getParameter("customerId")));
        realCustomer.setFirstName(request.getParameter("firstName"));
        realCustomer.setLastName(request.getParameter("lastName"));
        realCustomer.setFatherName(request.getParameter("fatherName"));
        realCustomer.setDateOfBirth(request.getParameter("dateOfBirth"));
        realCustomer.setNationalCode(request.getParameter("nationalCode"));

        try {
            RealCustomerLogic.updateRealCustomer(realCustomer);

            request.setAttribute("header", "عملیات موفق");
            request.setAttribute("text","اطلاعات مشتری اصلاح شد.");
            request.setAttribute("url", "searchRealCustomer.html");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);

        } catch (WrongNationalCodeFormatException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در اصلاح مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "searchRealCustomer.html");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        } catch (EmptyFieldException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در اصلاح مشتری شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "searchRealCustomer.html");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        } catch (DuplicateDataException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در اصلاح مشتری ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "searchRealCustomer.html");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
