package dataAccessLayer;

import exceptions.DataNotFoundException;
import exceptions.EmptyFieldException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            LoggerUtil.getLogger().info("Real customer with customer number #" + realCustomer.getCustomerId()
                    + " successfully created in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Creating real customer with customer number #" + realCustomer.getCustomerId() + " failed!");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer)
            throws DataNotFoundException {
        List<RealCustomer> realCustomers;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            realCustomers = getFromDataBase(session, realCustomer);
            LoggerUtil.getLogger().info("Real Customer(s) successfully retrieved from data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("retrieving real Customer(s) from data base failed!");
            e.printStackTrace();
            throw new DataNotFoundException("خطا در بازیابی مشتری!");
        }finally {
            session.close();
        }
        return realCustomers;
    }

//    private static Criteria makeCriteria(Session session, RealCustomer realCustomer) {
//        Criteria criteria = session.createCriteria(RealCustomer.class);
//        if (realCustomer.getCustomerId() != null && !realCustomer.getCustomerId().equals("")) {
//            criteria.add(Restrictions.eq("customerId", realCustomer.getCustomerId()));
//        } else if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().equals("") ) {
//            criteria.add(Restrictions.eq("nationalCode", realCustomer.getNationalCode()));
//        } else {
//            if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().equals("")) {
//                criteria.add(Restrictions.eq("firstName", realCustomer.getFirstName()));
//            }
//            if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().equals("")) {
//                criteria.add(Restrictions.eq("lastName", realCustomer.getLastName()));
//            }
//        }
//        return criteria;
//    }

    private static List getFromDataBase(Session session, RealCustomer realCustomer) {
        StringBuilder hqlQuery = new StringBuilder("from RealCustomer rc ");
        StringBuilder whereSection = new StringBuilder();

        Map<String, Object> params = new HashMap<String, Object>();

        if (realCustomer.getCustomerId() != null && !realCustomer.getCustomerId().equals("")) {
            whereSection.append(" customerId = :customerId");
            params.put("customerId", realCustomer.getCustomerId());
        }
        if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().equals("")) {
            whereSection.append(" nationalCode = :nationalCode");
            params.put("nationalCode", realCustomer.getNationalCode());
        }
        if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().equals("")) {
            whereSection.append(" firstName = :firstName");
            params.put("firstName", realCustomer.getFirstName());
        }
        if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().equals("")) {
            whereSection.append(" lastName = :lastName");
            params.put("lastName", realCustomer.getLastName());
        }
        if (whereSection.length() > 0) {
            hqlQuery.append(" where ").append(whereSection);
        }
        Query result = session.createQuery(hqlQuery.toString());
        for (String param : params.keySet()) {
            result.setParameter(param, params.get(param));
        }

        return result.list();
    }

    public static void deleteRealById(Long customerId) {

        RealCustomer realCustomer = new RealCustomer();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            realCustomer = session.get(RealCustomer.class, customerId);
            if (realCustomer != null) {
                session.delete(realCustomer);
            }
            tx.commit();
            LoggerUtil.getLogger().info("Real Customer with customer number #" + realCustomer.getCustomerId() + " successfully deleted from in data base!");
        }catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Deleting real Customer with customer number #" + realCustomer.getCustomerId() + " failed!");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static RealCustomer retrieveRealById(Long customerId)
            throws EmptyFieldException {

        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Transaction tx = session.beginTransaction();
//            //session.update(realCustomer);
//            session.get(realCustomer, customerId);
//            tx.commit();
//            } finally {
//                session.close();
//            }
        try {
            Query query = session.createQuery("from RealCustomer rc where rc.customerId = :cId");
            query.setParameter("cId", customerId);
            List<RealCustomer> result = query.list();
            if (result.isEmpty()) {
                LoggerUtil.getLogger().info("retrieving real Customer with customer number #" + customerId + " failed!");
                throw new EmptyFieldException("مشتری با شماره " + customerId + "وجود ندارد.");
            } else {
                LoggerUtil.getLogger().info("Real Customer with customer number #" + result.get(0).getCustomerId() + " successfully retrieved from data base!");
                return result.get(0);
            }
        } finally {
            session.close();
        }
    }

    public static void updateCustomer(RealCustomer realCustomer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.update(realCustomer);
            tx.commit();
            LoggerUtil.getLogger().info("Real Customer with customer number #" + realCustomer.getCustomerId() + " successfully updated in data base!");
        } catch (RuntimeException e) {
            LoggerUtil.getLogger().info("Updating real Customer with customer number #" + realCustomer.getCustomerId() + " failed!");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List findByNationalCode(String nationalCode) {
        List<RealCustomer> realCustomers = new ArrayList<RealCustomer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from RealCustomer  rc where rc.nationalCode = :nationalC");
            query.setParameter("nationalC", nationalCode);
            realCustomers = query.list();
        } finally {
            session.close();
        }

        return realCustomers;
    }
}
