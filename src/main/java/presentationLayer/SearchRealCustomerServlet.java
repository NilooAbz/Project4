package presentationLayer;

import dataAccessLayer.RealCustomer;
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
        Long custoemrId = Long.valueOf(request.getParameter("customerId"));
        if ( custoemrId == null && custoemrId.equals("")){
            realCustomer.setCustomerId(null);
        }
        //realCustomer.setCustomerId(Long.parseLong(request.getParameter("customerId")));
        realCustomer.setNationalCode(request.getParameter("nationalCode"));

        List<RealCustomer> realCustomers = RealCustomerLogic.retrieve(realCustomer);
        request.setAttribute("realCustomers", realCustomers);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchResult.jsp");
        dispatcher.forward(request , response);

    }
}
