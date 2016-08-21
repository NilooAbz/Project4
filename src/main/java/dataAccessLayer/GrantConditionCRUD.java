package dataAccessLayer;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class GrantConditionCRUD {

    public static void saveLoanType(LoanType loanType, ArrayList<GrantCondition> grantConditions){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(loanType);
            for(GrantCondition grantCondition : grantConditions){
                grantCondition.setLoanId(loanType.getLoanId());
                session.save(grantCondition);
            }
            tx.commit();
            } finally {
                session.close();
            }
    }
}
