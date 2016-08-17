package presentationLayer;

import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DotinSchool2 on 8/16/2016.
 */
public class DeleteRealCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long customerId = Long.valueOf(request.getParameter("customerId"));

        RealCustomerLogic.deleteById(customerId);
        request.setAttribute("header", "عملیات موفق");
        request.setAttribute("text","اطلاعات مشتری حذف شد.");
        request.setAttribute("url", "searchRealCustomer.html");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
        dispatcher.forward(request , response);
    }
}
