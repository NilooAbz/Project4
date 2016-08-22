package presentationLayer;

import dataAccessLayer.LoanFile;
import dataAccessLayer.LoanType;
import dataAccessLayer.RealCustomer;
import exceptions.EmptyFieldException;
import exceptions.NotSupportedConditionRangeException;
import logicLayer.LoanFileLogic;
import logicLayer.RealCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class CreateLoanFileServlet extends HttpServlet {

    public void retrieveCustomerLoanType(HttpServletRequest request, HttpServletResponse response) {
        long customerId = Long.parseLong(request.getParameter("customerId"));
//        int customerExistence = 0;
//        boolean loanTypeExistence = false;

            try {
                RealCustomer realCustomer = RealCustomerLogic.retrieveByCustomerId(customerId);
                //customerExistence = 1;
                request.setAttribute("customerExistence", 1);
                request.setAttribute("realCustomerObject", realCustomer);
                request.setAttribute("customerId", realCustomer.getCustomerId());

                List<LoanType> loanTypes = LoanFileLogic.retrieveLoanTypes();
                //loanTypeExistence = true;
                request.setAttribute("loanTypeExistence",true);
                request.setAttribute("loanTypeObjects", loanTypes);
            } catch (EmptyFieldException e) {
//            customerExistence = 0;
//            loanTypeExistence = false;
            request.setAttribute("customerExistence",0);
            request.setAttribute("loanTypeExistence",false);
            e.printStackTrace();
        }
        try {
            //request.setAttribute("customerExistence",customerExistence);
            //request.setAttribute("loanTypeExistence",loanTypeExistence);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createLoanFile.jsp");
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createLoanFile(HttpServletRequest request, HttpServletResponse response){

        try {
            Long customerId = Long.parseLong(request.getParameter("RequestedCustomerId"));
            Long loanId = Long.parseLong(request.getParameter("loanId"));
            LoanFile loanFile = new LoanFile();
            loanFile.setAmount(new BigDecimal(request.getParameter("amount")));
            loanFile.setDuration(Integer.parseInt(request.getParameter("duration")));
            LoanFileLogic.create(customerId,loanId,loanFile);

            request.setAttribute("header","عملیات موفق");
            request.setAttribute("text","پرونده تسهیلاتی با موفقیت ثبت شد.");
            request.setAttribute("url","CreateLoanFileServlet?action=firstRun");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NotSupportedConditionRangeException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت پرونده تسهیلاتی جدیدایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url","CreateLoanFileServlet?action=firstRun");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
//        finally {
//            try {
//                request.setAttribute("url","CreateLoanFileServlet?action=firstRun");
//                getServletConfig().getServletContext().getRequestDispatcher("/info.jsp").forward(request,response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

    }

    public void firstRun(HttpServletRequest request, HttpServletResponse response){

        request.setAttribute("customerExistence", -1);
        request.setAttribute("customerId","");
        try {
            getServletConfig().getServletContext().getRequestDispatcher("/createLoanFile.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");

        if (action.equals("firstRun")){
            firstRun(request, response);
        }
        if (action.equals("retrieveCustomerLoanType")) {
            retrieveCustomerLoanType(request, response);
        }
        if (action.equals("create")){
            createLoanFile(request, response);
        }
    }
}
