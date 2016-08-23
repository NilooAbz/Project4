package logicLayer;

import dataAccessLayer.*;
import exceptions.DataNotFoundException;
import exceptions.EmptyFieldException;
import exceptions.NotSupportedConditionRangeException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class LoanFileLogic {

    public static List<LoanType> retrieveLoanTypes()
            throws EmptyFieldException {
        return LoanTypeLogic.retrieveAll();
    }
    public static LoanType retrieveLoanType(Long loanId)
            throws EmptyFieldException {
        return LoanTypeLogic.retrieve(loanId);
    }
    public static void create(Long customerId, Long loanId, LoanFile loanFile)
            throws NotSupportedConditionRangeException, DataNotFoundException {

        try {
            LoanType loanType = retrieveLoanType(loanId);
            validateLoanFile(loanFile,loanId);
            loanFile.setLoanType(loanType);
            RealCustomer realCustomer = RealCustomerLogic.retrieveByCustomerId(customerId);
            loanFile.setRealCustomer(realCustomer);
            LoanFileCRUD.saveLoanFile(loanFile, loanType, realCustomer);
        } catch (EmptyFieldException e) {
            e.printStackTrace();
        }

    }

    public static void validateLoanFile(LoanFile loanFile, Long loanId)
            throws NotSupportedConditionRangeException, EmptyFieldException, DataNotFoundException {

        List<GrantCondition> grantConditionObjects = GrantConditionLogic.retrieveConditionsByLoanId(loanId);
        for(GrantCondition grantConditionObject : grantConditionObjects){
            if( loanFile.getDuration() > grantConditionObject.getMaxDuration() || loanFile.getDuration() < grantConditionObject.getMinDuration()){
                throw new NotSupportedConditionRangeException("مدت زمان وارد شده در محدوده مدت زمان های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
            if( loanFile.getAmount().compareTo(grantConditionObject.getMaxAmount())==1  || loanFile.getAmount().compareTo(grantConditionObject.getMinAmount())==-1 ){
                throw new NotSupportedConditionRangeException("مبلغ وارد شده در محدوده مبلغ های شرایط تسهیلات صدق نمی کند! لطفا دوباره تلاش کنید.");
            }
        }
    }
}
