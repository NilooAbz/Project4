package logicLayer;

import dataAccessLayer.RealCustomer;
import dataAccessLayer.RealCustomerCRUD;
import exceptions.EmptyFieldException;
import exceptions.WrongNationalCodeFormatException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DotinSchool2 on 8/15/2016.
 */
public class RealCustomerLogic {

    public static void create(RealCustomer realCustomer)
            throws EmptyFieldException, WrongNationalCodeFormatException, Exception {

        validateRealCustomer(realCustomer);
        RealCustomerCRUD.saveRealCustomer(realCustomer.allRealCustomer());
    }

    public static void validateRealCustomer(RealCustomer realCustomer)
            throws EmptyFieldException, WrongNationalCodeFormatException {

        if (realCustomer.getFirstName().equals("")){
            throw new EmptyFieldException("لطفا فیلد نام را وارد کنید.");
        }
        if (realCustomer.getLastName().equals("")){
            throw new EmptyFieldException("لطفا فیلد نام خانوادگی را وارد کنید.");
        }
        if (realCustomer.getFatherName().equals("")){
            throw new EmptyFieldException("لطفا فیلد نام پدر را وارد کنید.");
        }
        if (realCustomer.getDateOfBirth().equals("")){
            throw new EmptyFieldException("لطفا فیلد  تاریخ تولد را وارد کنید.");
        }
        if (realCustomer.getNationalCode().equals("")){
            throw new EmptyFieldException("لطفا فیلد کد ملی را وارد کنید.");
        }else {
            if (realCustomer.getNationalCode().trim().length() != 10){
                throw new WrongNationalCodeFormatException("کد ملی باید ده رقمی باشد.");
            }
            else{
                String national = realCustomer.getNationalCode().trim();
                int sum = 0;
                for (int i=1; i<=9; i++){
                    sum = sum + Integer.parseInt(national.substring(i-1, i )) * i;
                }
                int rightNumber = Integer.parseInt(national.substring(9));
                int remainder = sum % 11;
                if ( !(remainder == rightNumber) && !(remainder == 11 - rightNumber)){
                    throw new WrongNationalCodeFormatException("کد ملی وارد شده صحیح نمی باشد.");
                }
            }
        }
    }

    public static List<RealCustomer> retrieve(RealCustomer realCustomer){
        return RealCustomerCRUD.retrieveRealCustomer(realCustomer);
    }

    public static void deleteById(Long customerId){
        RealCustomerCRUD.deleteRealById(customerId);
    }
}
