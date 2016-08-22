package presentationLayer;

import dataAccessLayer.RealCustomer;
import exceptions.EmptyFieldException;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/16/2016.
 */
public class UpdateRealCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
        request.setCharacterEncoding("UTF-8");
        Long customerId = Long.valueOf(request.getParameter("customerId"));

        RealCustomer realCustomer = new RealCustomer();
        try {
            realCustomer = RealCustomerLogic.retrieveByCustomerId(customerId);
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }

        request.setAttribute("realCustomer", realCustomer);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateRealCustomer.jsp");
        dispatcher.forward(request, response);
    }

}



