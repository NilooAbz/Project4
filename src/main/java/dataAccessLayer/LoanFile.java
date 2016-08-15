package dataAccessLayer;

import java.math.BigDecimal;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class LoanFile {

    private Long loanFileId;
    private BigDecimal amount;
    private int duration;
    private Long loanId;
    private Long customerId;
    private LoanType loanType;
    private RealCustomer realCustomer;

    public LoanFile(Long loanFileId, BigDecimal amount, int duration) {
        this.loanFileId = loanFileId;
        this.amount = amount;
        this.duration = duration;
    }

    public LoanFile() {
    }

    public Long getLoanFileId() {
        return loanFileId;
    }

    public void setLoanFileId(Long loanFileId) {
        this.loanFileId = loanFileId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public RealCustomer getRealCustomer() {
        return realCustomer;
    }

    public void setRealCustomer(RealCustomer realCustomer) {
        this.realCustomer = realCustomer;
    }
}
