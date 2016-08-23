package presentationLayer;

import dataAccessLayer.RealCustomer;
import exceptions.DataNotFoundException;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class SearchRealCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        RealCustomer realCustomer = new RealCustomer();

        realCustomer.setFirstName(request.getParameter("firstName"));
        realCustomer.setLastName(request.getParameter("lastName"));
        realCustomer.setNationalCode(request.getParameter("nationalCode"));
        String customerId = request.getParameter("customerId");
        if ( customerId != null && !customerId.equals("")){
            realCustomer.setCustomerId(Long.parseLong(customerId));
        }

        List<RealCustomer> realCustomers = null;
        try {
            realCustomers = RealCustomerLogic.retrieve(realCustomer);
            request.setAttribute("realCustomers", realCustomers);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchResult.jsp");
            dispatcher.forward(request , response);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }


    }
}
