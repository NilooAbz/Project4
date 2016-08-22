package dataAccessLayer;

import exceptions.EmptyFieldException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by DotinSchool2 on 8/21/2016.
 */
public class GrantConditionCRUD {

    public static void saveLoanType(LoanType loanType, Set<GrantCondition> grantConditions){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            loanType.setGrantConditions(grantConditions);
            session.save(loanType);
            tx.commit();
            }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
                session.close();
            }
    }

    public static List<GrantCondition> retrieveLoanTypeConditions(Long loanId) throws EmptyFieldException {
        //GrantCondition conditions;
        List<GrantCondition> grantConditions;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria =session.createCriteria(GrantCondition.class);
            criteria.add(Restrictions.eq("loanType.loanId", loanId));
            grantConditions = criteria.list();
           // conditions = session.get(GrantCondition.class, loanId);
            //for (GrantCondition grantList: grantConditions) {
            //    grantList =
            //}
            if (grantConditions.isEmpty()){
                throw new EmptyFieldException("خطا در بازیابی شروط اعطا!");
            }
            } finally {
                session.close();
            }
        return grantConditions;
    }


}
