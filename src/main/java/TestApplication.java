import dataAccessLayer.GrantCondition;
import dataAccessLayer.LoanType;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class TestApplication {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        LoanType loanType = new LoanType();
        GrantCondition grantCondition = new GrantCondition();

        //Set<GrantCondition> grant = new HashSet<GrantCondition>();
        //grant.add(new GrantCondition(2l, "vam", 1, 23, new BigDecimal(4000), new BigDecimal(10000)) );
        loanType.setInterestRate(0.4d);
        loanType.setLoanId(34l);
        loanType.setLoanName("khodro");
        //loanType.setGrantConditions(grant);
        grantCondition.setLoanType(loanType);

        session.save(loanType);
        session.save(grantCondition);
        session.getTransaction().commit();

    }

}
//    public static void main(String[] args) {
//
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//
//        }catch (Throwable ex){
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        TestApplication test = new TestApplication();
//        ArrayList<GrantCondition> grant = new ArrayList<GrantCondition>();
//        grant.add(new GrantCondition(2l, "vam", 1, 23, new BigDecimal(4000), new BigDecimal(10000)) );
//
//        Long nemidunam = test.addLoanType("khodro",4l, 0.4d, grant );
//        test.listEmployees();


        //Session session = null;

        /*try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session =sessionFactory.openSession();

            System.out.println("Inserting Record");

            RealCustomer realCustomer = new RealCustomer();

            realCustomer.setDateOfBirth("1370/11/19");
            realCustomer.setFirstName("نیلوفر");
            realCustomer.setLastName("علیزاده");
            realCustomer.setFatherName("جمشید");
            realCustomer.setNationalCode("0014176356");
            session.save(realCustomer);
            System.out.println("Done");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.flush();
            session.close();
        }*/


//    /* Method to add an employee record in the database */
//    public Long addLoanType(String loanName, Long loanId, double interestRate, ArrayList grant){
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        Long loannnId = null;
//        try{
//            tx = session.beginTransaction();
//            LoanType loanType = new LoanType(interestRate,loanName,loanId);
//            //Employee employee = new Employee(fname, lname, salary);
//            loanType.setGrantconditions(grant);
//            loannnId = (Long) session.save(loanType);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return loannnId;
//    }
//
//    /* Method to list all the employees detail */
//    public void listEmployees( ){
//        Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//        try{
//            transaction = session.beginTransaction();
//            List loanTypes = session.createQuery("FROM LoanType ").list();
//            for (Iterator iterator1 =
//                 loanTypes.iterator(); iterator1.hasNext();){
//                LoanType loanType = (LoanType) iterator1.next();
//                System.out.print(" Loan Name: " + loanType.getLoanName());
//                System.out.print(" interest rate: " + loanType.getInterestRate());
//                List grantConditions = loanType.getGrantconditions();
//                for (Iterator iterator2 =
//                     grantConditions.iterator(); iterator2.hasNext();){
//                     GrantCondition grants = (GrantCondition) iterator2.next();
//                    System.out.println("Grant name: " + grants.getGrantName());
//                    System.out.println("Grant min duration: " + grants.getMinDuration());
//                    System.out.println("Grant max duration: " + grants.getMaxDuration());
//                    System.out.println("Grant max amount: " + grants.getMaxAmount());
//                    System.out.println("Grant min amount: " + grants.getMinAmount());
//                }
//            }
//            transaction.commit();
//        }catch (HibernateException e) {
//            if (transaction!=null) transaction.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
    /* Method to update salary for an employee */
//    public void updateEmployee(Integer EmployeeID, int salary ){
//        Session session = sessionFactory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            employee.setSalary( salary );
//            session.update(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Method to delete an employee from the records */
//    public void deleteEmployee(Integer EmployeeID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            session.delete(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }

