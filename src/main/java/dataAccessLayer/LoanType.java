package dataAccessLayer;

import java.util.List;
import java.util.Set;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class LoanType {

    private double interestRate;
    private String loanName;
    private Long loanId;
    private Set<GrantCondition> grantConditions;

    public LoanType(double interestRate, String loanName, Long loanId) {
        this.interestRate = interestRate;
        this.loanName = loanName;
        this.loanId = loanId;
    }

    public LoanType() {
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Set<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setGrantConditions(Set<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}


