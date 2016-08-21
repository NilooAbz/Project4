package logicLayer;

import dataAccessLayer.LoanType;
import exceptions.EmptyFieldException;

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
}
