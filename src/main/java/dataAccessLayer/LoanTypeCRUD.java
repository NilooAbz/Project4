package dataAccessLayer;

import exceptions.EmptyFieldException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/20/2016.
 */
public class LoanTypeCRUD {

    public static List retrieveAllLoanTypes()
            throws EmptyFieldException {
        List<LoanType> loanTypes = new ArrayList<LoanType>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from LoanType lt ");
            loanTypes = query.list();
            LoggerUtil.getLogger().info("Loan type(s) successfully retrieved from data base!");
            if (loanTypes.isEmpty()){
                LoggerUtil.getLogger().info("retrieving loan type(s) from data base failed!");
                throw new EmptyFieldException("هیچ نوع تسهیلاتی ثبت نشده است!");
            }
            } finally {
                session.close();
            }

        return loanTypes;
    }

    public static LoanType retrieveLoanTypeById(Long loanId)
            throws EmptyFieldException {

        LoanType loanType;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            loanType = session.get(LoanType.class, loanId);
            LoggerUtil.getLogger().info("Loan type "  + "with loan Id #" + loanType.getLoanId() + " successfully retrieved from data base!");
            if (loanType.equals(null)){
                LoggerUtil.getLogger().info("retrieving loan type with loan Id #" + loanId +" failed!");
                throw new EmptyFieldException("نوع تسهیلات با شماره" + loanId + "وجود ندارد.");
            }
            } finally {
                session.close();
            }

        return loanType;
    }

}
