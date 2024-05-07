// Class: BusinessLoan
// This is the subclass for business loans that accepts all loan values and adds 3.2% to prime interest rate.
public class BusinessLoan extends Loan {
    public BusinessLoan (int loanNumber, String customerLastName, double loanAmount, double interestRate, int loanTerm, double loanAmountOwed){
        super(loanNumber, customerLastName,loanAmount, interestRate + 0.032, loanTerm, loanAmountOwed);
    }
}