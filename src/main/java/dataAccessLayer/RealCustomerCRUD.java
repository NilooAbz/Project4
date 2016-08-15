package dataAccessLayer;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class RealCustomerCRUD {

    public static void saveRealCustomer(RealCustomer realCustomer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(realCustomer);
        session.getTransaction().commit();

    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer) {
        List<RealCustomer> realCustomers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        realCustomers = generateCriteria(session, realCustomer).list();

        return realCustomers;
    }

    private static Criteria generateCriteria(Session session, RealCustomer realCustomer) {
        Criteria criteria = session.createCriteria(RealCustomer.class);
        if (realCustomer.getCustomerId() != null ) {
            criteria.add(Restrictions.eq("customerId", realCustomer.getCustomerId()));
        } else if (!realCustomer.getNationalCode().equalsIgnoreCase(null) ) {
            criteria.add(Restrictions.eq("nationalCode", realCustomer.getNationalCode()));
        } else {
            if (!realCustomer.getFirstName().equalsIgnoreCase(null) ) {
                criteria.add(Restrictions.eq("firstName", realCustomer.getFirstName()));
            }
            if (!realCustomer.getLastName().equalsIgnoreCase(null)) {
                criteria.add(Restrictions.eq("lastName", realCustomer.getLastName()));
            }
            if (!realCustomer.getFatherName().equalsIgnoreCase(null) ) {
                criteria.add(Restrictions.eq("fatherName", realCustomer.getFatherName()));
            }
        }
        return criteria;
    }
}
