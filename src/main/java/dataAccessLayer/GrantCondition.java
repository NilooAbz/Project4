package dataAccessLayer;

import java.math.BigDecimal;

/**
 * Created by DotinSchool2 on 8/14/2016.
 */
public class GrantCondition {

    private Long grantId;
    private String grantName;
    private int minDuration;
    private int maxDuration;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Long loanId;

    public GrantCondition(Long grantId, String grantName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount) {
        this.grantId = grantId;
        this.grantName = grantName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public GrantCondition() {
    }

    public GrantCondition(Long grantId) {
        this.grantId = grantId;
    }

    public Long getGrantId() {
        return grantId;
    }

    public void setGrantId(Long grantId) {
        this.grantId = grantId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }
}
