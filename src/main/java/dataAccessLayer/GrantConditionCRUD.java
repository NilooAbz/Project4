package dataAccessLayer;

import exceptions.DataNotFoundException;
import exceptions.EmptyFieldException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.List;
import java.util.Set;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class GrantConditionCRUD {

    public static void saveLoanType(LoanType loanType, Set<GrantCondition> grantConditions) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            loanType.setGrantConditions(grantConditions);
            session.save(loanType);
            tx.commit();
            LoggerUtil.getLogger().info("Loan Type id #" + loanType.getLoanId() + " with interest rate " + loanType.getInterestRate() + " successfully created in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating Loan Type id #" + loanType.getLoanId() + " with interest rate " + loanType.getInterestRate() + " failed!");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<GrantCondition> retrieveLoanTypeConditions(Long loanId)
            throws EmptyFieldException, DataNotFoundException {

        List<GrantCondition> grantConditions;
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Criteria criteria =session.createCriteria(GrantCondition.class);
//            criteria.add(Restrictions.eq("loanType.loanId", loanId));
//            grantConditions = criteria.list();
//
//            if (grantConditions.isEmpty()){
//                throw new EmptyFieldException("خطا در بازیابی شروط اعطا!");
//            }
//            } finally {
//                session.close();
//            }

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from GrantCondition gc where gc.loanId =:lId");
            query.setParameter("lId", loanId);
            grantConditions = query.list();
            LoggerUtil.getLogger().info("Grant condition(s) successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving grant condition(s) from data base failed!");
            e.printStackTrace();
            throw new DataNotFoundException("خطا در بازیابی شروط اعطا!");
        } finally {
            session.close();
        }
        return grantConditions;
    }


}
