// Class: Loan
// This is the parent class for all loans.
public abstract class Loan implements LoanConstants {
    // Attributes
    protected int loanNumber; //loan number
    protected String customerLastName; //customer's last name
    protected double loanAmount; //loan amount
    protected double interestRate; //loan interest rate
    protected int loanTerm; //loan term
    protected double loanAmountOwed; //total loan amount owned (loan amount + interest)

    // Constructor
    public Loan(int loanNumber, String customerLastName, double loanAmount, double interestRate, int loanTerm, double loanAmountOwed) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanAmountOwed = calculateTotalAmountDue(loanAmount,interestRate,loanTerm);
    }

    // Getters and Setters
    public int getLoanNumber() {
        return loanNumber;
    }
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }
    public String getCustomerLastName() {
        return customerLastName;
    }
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
       this.loanAmount = loanAmount;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getLoanTerm() {
        return loanTerm;
    }
    public void setLoanTerm(int loanTerm) {
        if (loanTerm == 7){
            this.loanTerm = mediumTerm; //sets rate for 7-year term
        } else if (loanTerm == 15){
            this.loanTerm = longTerm; //sets rate for 15-year term
        } else {
            this.loanTerm = shortTerm; //otherwise, sets rate to 3-year term
        };
    }

    // toString overridden method that prints loan details.
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" +
                "Loan Number=" + loanNumber +
                ", Last Name=" + customerLastName +
                ", Loan Amount=$" + loanAmount +
                ", Interest Rate=" + interestRate +
                ", Loan Term=" + loanTerm +
                ", Loan Amount Owed=$" + loanAmountOwed +
                "]";
    }

    // Custom Method: calculates loan amount owned
    public double calculateTotalAmountDue(double loanAmount, double interestRate, int loanTerm){
        double simpleInterest = loanAmount * interestRate * loanTerm;
        return loanAmount + simpleInterest;
    }
    // equals method to compare whether two loan amounts are the same
    public boolean equals(double loan1, double loan2){
        return loan1 == loan2;
    }
}