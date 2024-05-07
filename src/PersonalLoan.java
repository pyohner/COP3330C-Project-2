// Class: PersonalLoan
// This is the subclass for personal loans that accepts all loan values and adds 2.7% to prime interest rate.
public class PersonalLoan extends Loan {
    public PersonalLoan (int loanNumber, String customerLastName, double loanAmount, double interestRate, int loanTerm, double loanAmountOwed){
        super(loanNumber, customerLastName,loanAmount, interestRate + 0.027, loanTerm, loanAmountOwed);
    }
}