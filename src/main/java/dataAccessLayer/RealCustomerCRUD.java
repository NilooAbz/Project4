package dataAccessLayer;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

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
        } finally {
            session.close();
        }
    }

    public static List<RealCustomer> retrieveRealCustomer(RealCustomer realCustomer) {
        List<RealCustomer> realCustomers;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
//            realCustomers = makeCriteria(session, realCustomer).list();
                realCustomers = getFromDataBase(session, realCustomer);
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

    private static List getFromDataBase(Session session, RealCustomer realCustomer){
        StringBuilder hqlQuery = new StringBuilder("from RealCustomer rc ");
        StringBuilder whereSection = new StringBuilder();

        Map<String , Object> params = new HashMap<String, Object>();

        if (realCustomer.getCustomerId() != null && !realCustomer.getCustomerId().equals("")){
            whereSection.append(" customerId = :customerId");
            params.put("customerId", realCustomer.getCustomerId());
        }
        if (!realCustomer.getNationalCode().equalsIgnoreCase(null) && !realCustomer.getNationalCode().equals("")){
            whereSection.append(" nationalCode = :nationalCode");
            params.put("nationalCode", realCustomer.getNationalCode());
        }
        if (!realCustomer.getFirstName().equalsIgnoreCase(null) && !realCustomer.getFirstName().equals("")){
            whereSection.append(" firstName = :firstName");
            params.put("firstName", realCustomer.getFirstName());
        }
        if (!realCustomer.getLastName().equalsIgnoreCase(null) && !realCustomer.getLastName().equals("")){
            whereSection.append(" lastName = :lastName");
            params.put("lastName", realCustomer.getLastName());
        }
        if (whereSection.length() > 0){
            hqlQuery.append(" where ").append(whereSection);
        }
        Query result = session.createQuery(hqlQuery.toString());
        for (String param: params.keySet()){
            result.setParameter(param, params.get(param));
        }

        return result.list();
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
    }

    public static List retrieveRealById(Long customerId){
        List<RealCustomer> realCustomer = new ArrayList<RealCustomer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Transaction tx = session.beginTransaction();
//            //session.update(realCustomer);
//            session.get(realCustomer, customerId);
//            tx.commit();
//            } finally {
//                session.close();
//            }

        try{
            Query query = session.createQuery("from RealCustomer rc where rc.customerId = :cId");
            query.setParameter("cId" ,customerId);
            realCustomer = query.list();
        }

        finally {
            session.close();
        }
        return realCustomer;
    }

    public static void updateCustomer(RealCustomer realCustomer){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.update(realCustomer);
            tx.commit();
            } finally {
                session.close();
            }
    }

    public static List findByNationalCode(String nationalCode){
        List<RealCustomer> realCustomers = new ArrayList<RealCustomer>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from RealCustomer  rc where rc.nationalCode = :nationalC");
            query.setParameter("nationalC" , nationalCode);
            realCustomers = query.list();
            } finally {
                session.close();
            }

        return realCustomers;
    }
}
