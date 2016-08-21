package dataAccessLayer;

import exceptions.EmptyFieldException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

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
            if (loanTypes.size() == 0){
                throw new EmptyFieldException("هیچ نوع تسهیلاتی ثبت نشده است!");
            }
            } finally {
                session.close();
            }

        return loanTypes;
    }

}
