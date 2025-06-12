package cms.auth.spring_auth_mybank.dto;

public class LoanDTO {
    private Integer loanId;
    private String loanType;
    private Double loanAmount;

    public LoanDTO(Integer loanId, String loanType, Double loanAmount) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }
    public LoanDTO() {
    }


    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
