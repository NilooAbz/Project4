package logicLayer;

import dataAccessLayer.GrantCondition;
import dataAccessLayer.GrantConditionCRUD;
import dataAccessLayer.LoanType;
import exceptions.DataNotFoundException;
import exceptions.EmptyFieldException;

import javax.transaction.NotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class GrantConditionLogic {

    public static void create( LoanType loanType, Set<GrantCondition> grantConditions)
            throws NotSupportedException {

        validateGrantConditions(grantConditions);
        GrantConditionCRUD.saveLoanType(loanType, grantConditions);
    }

    private static void validateGrantConditions(Set<GrantCondition> grantConditions)
            throws NotSupportedException {

        for(GrantCondition grantConditionObject : grantConditions){
            if(grantConditionObject.getMinDuration() > grantConditionObject.getMaxDuration()){
                throw new NotSupportedException("حداکثر مدت قرارداد باید بزرگتر از حداقل مدت قرارداد باشد.");
            }
            if(grantConditionObject.getMinAmount().compareTo(grantConditionObject.getMaxAmount())==1){
                throw new NotSupportedException("حداکثر مبلغ قرارداد باید بزرگتر از حداقل مبلغ قرارداد باشد.");
            }
        }
    }

    public static List<GrantCondition> retrieveConditionsByLoanId(Long loanId)
            throws EmptyFieldException, DataNotFoundException {

        return GrantConditionCRUD.retrieveLoanTypeConditions(loanId);

    }
}


