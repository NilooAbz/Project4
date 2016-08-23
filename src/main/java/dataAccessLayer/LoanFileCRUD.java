package dataAccessLayer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.LoggerUtil;

/**
 * Created by DotinSchool2 on 8/22/2016.
 */
public class LoanFileCRUD {

    public static void saveLoanFile(LoanFile loanFile, LoanType loanType, RealCustomer realCustomer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            tx.commit();
            LoggerUtil.getLogger().info("Loan File for customer with customer number # " + realCustomer.getCustomerId()+ " with loan type id " + loanType.getLoanId() + "successfully saved in data base with id #" + loanFile.getLoanFileId());
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating loan File for customer number #"  + realCustomer.getCustomerId()+  " with loan type id" + loanType.getLoanId() + " failed!");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
