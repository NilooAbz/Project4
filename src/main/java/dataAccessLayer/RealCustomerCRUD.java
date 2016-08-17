package dataAccessLayer;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class RealCustomerCRUD {

    public static void saveRealCustomer(RealCustomer realCustomer) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(realCustomer);
            tx.commit();
        } finally {
            session.close();
        }
    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer) {
        List<RealCustomer> realCustomers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Query query = session.createQuery("select rc.customerId from RealCustomer rc");
        realCustomers = makeCriteria(session, realCustomer).list();

        return realCustomers;
    }

    private static Criteria makeCriteria(Session session, RealCustomer realCustomer) {
        Criteria criteria = session.createCriteria(RealCustomer.class);
        if (realCustomer.getCustomerId() != null && !realCustomer.getCustomerId().equals("")) {
            criteria.add(Restrictions.eq("customerId", realCustomer.getCustomerId()));
        } else if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().equals("") ) {
            criteria.add(Restrictions.eq("nationalCode", realCustomer.getNationalCode()));
        } else {
            if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().equals("")) {
                criteria.add(Restrictions.eq("firstName", realCustomer.getFirstName()));
            }
            if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().equals("")) {
                criteria.add(Restrictions.eq("lastName", realCustomer.getLastName()));
            }

        }
        return criteria;
    }

    public static void deleteRealById(Long customerId){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            RealCustomer realCustomer = session.get(RealCustomer.class, customerId);
            if (realCustomer != null){
            session.delete(realCustomer);
            }
            tx.commit();
            } finally {
                session.close();
            }

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        RealCustomer realCustomer = session.get(RealCustomer.class, customerId);
//        if (realCustomer != null){
//            session.delete(realCustomer);
//        }
//        session.getTransaction().commit();

    }
}
