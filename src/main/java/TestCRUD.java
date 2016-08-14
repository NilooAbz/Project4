import dataAccessLayer.RealCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class TestCRUD {

    public static void main(String[] args) {
        Session session = null;

        try {
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
        }
    }
}
