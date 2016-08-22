package dataAccessLayer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Created by DotinSchool2 on 8/22/2016.
 */
public class LoanFileCRUD {

    public static void saveLoanFile(LoanFile loanFile, LoanType loanType, RealCustomer realCustomer){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            loanFile.setLoanType(loanType);
            loanFile.setRealCustomer(realCustomer);
            session.save(loanFile);
            tx.commit();
            } finally {
                session.close();
            }
    }
}
