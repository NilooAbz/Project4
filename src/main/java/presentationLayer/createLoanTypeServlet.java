package presentationLayer;

import dataAccessLayer.LoanType;
import exceptions.EmptyFieldException;
import logicLayer.LoanTypeLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DotinSchool2 on 8/20/2016.
 */
public class createLoanTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        String loanName = request.getParameter("loanName");
        Double interestRate = Double.parseDouble(request.getParameter("interestRate"));

        try {
            LoanType loanType = LoanTypeLogic.create(loanName,interestRate);
            request.setAttribute("LoanType", loanType);
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/createGrantCondition.jsp");
            dispatcher.forward(request,response);
        } catch (EmptyFieldException e) {
            request.setAttribute("header","عملیات ناموفق");
            request.setAttribute("text","خطا در ثبت نوع تسهیلات ایجاد شده است." + "\n" + e.getMessage());
            request.setAttribute("url", "createLoanType.jsp");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/info.jsp");
            dispatcher.forward(request , response);
        }
    }
}
