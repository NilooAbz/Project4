package dataAccessLayer;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class RealCustomer {

    private Long customerId;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String dateOfBirth;

    public RealCustomer(Long customerId, String nationalCode, String firstName, String lastName, String fatherName, String dateOfBirth) {
        this.customerId = customerId;
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
    }

    public RealCustomer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
