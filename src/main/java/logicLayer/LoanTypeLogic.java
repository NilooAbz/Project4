package logicLayer;

import dataAccessLayer.LoanType;
import dataAccessLayer.LoanTypeCRUD;
import exceptions.EmptyFieldException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/20/2016.
 */
public class LoanTypeLogic {

    public static LoanType create(String loanName, Double interestRate)
            throws EmptyFieldException {
        return validateLoanType(loanName, interestRate);
    }

    public static LoanType validateLoanType(String loanName, Double interestRate)
            throws EmptyFieldException {
        if (loanName.equals("") && loanName.equals(null)){
            throw new EmptyFieldException("وارد کردن نام تسهیلات الزامی است.");
        }
        if (interestRate == null){
            throw new EmptyFieldException("وارد کردن نرخ سود الزامی است.");
        }
        return new LoanType(loanName, interestRate);
    }

    public static List<LoanType> retrieveAll()
            throws EmptyFieldException {
        return LoanTypeCRUD.retrieveAllLoanTypes();
    }

    public static LoanType retrieve(Long loanId)
            throws EmptyFieldException {
        return LoanTypeCRUD.retrieveLoanTypeById(loanId);
    }
}
