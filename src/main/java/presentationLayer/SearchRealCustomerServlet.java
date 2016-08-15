package presentationLayer;

import dataAccessLayer.RealCustomer;
import logicLayer.RealCustomerLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class SearchRealCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RealCustomer realCustomer = new RealCustomer();
        realCustomer.setCustomerId(Long.valueOf(request.getParameter("customerId")));
        realCustomer.setFirstName(request.getParameter("firstName"));
        realCustomer.setLastName(request.getParameter("lastName"));
        realCustomer.setNationalCode(request.getParameter("nationalCode"));

        ArrayList<RealCustomer> realCustomers = RealCustomerLogic.retrieve(realCustomer);
    }
}
