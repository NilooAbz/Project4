package presentationLayer;

import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import exceptions.EmptyFieldException;
import logicLayer.LoanFileLogic;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class CreateLoanFileServlet extends HttpServlet {

    public void retrieveCustomerLoanType(HttpServletRequest request, HttpServletResponse response) {
        long customerId = Long.parseLong(request.getParameter("customerId"));
        int customerExistence = 0;
        boolean loanTypeExistence = false;

        try {
            List<RealCustomer> realCustomers = RealCustomerLogic.retrieveByCustomerId(customerId);
            RealCustomer realCustomer = new RealCustomer();
            for (Object object : realCustomers) {
                realCustomer = (RealCustomer) object;}
            customerExistence = 1;
            request.setAttribute("realCustomerObject", realCustomer);
            request.setAttribute("customerId", realCustomer.getCustomerId());

            List<LoanType> loanTypes = null;
            loanTypes = LoanFileLogic.retrieveLoanTypes();
            loanTypeExistence = true;
            request.setAttribute("loanTypeObjects", loanTypes);
        } catch (EmptyFieldException e) {
            customerExistence = 0;
            loanTypeExistence = false;
            e.printStackTrace();
        }
        try {
            request.setAttribute("customerExistence",customerExistence);
            request.setAttribute("loanTypeExistence",loanTypeExistence);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createLoanFile.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("retrieveCustomerLoanType")) {
            retrieveCustomerLoanType(request, response);
        }
    }
}
