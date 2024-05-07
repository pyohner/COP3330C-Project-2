/*
Phillip Yohner
COP 3330C - CRN 24680
January 22, 2024

Description:
The purpose of this program - Loan App - is to allow the user to enter five different loans for JPL company
and have the details printed along with additional information.
The user will provide current prime interest rate, the loan type (personal or business), the customer's
last name, the loan amount, and loan term (3/7/15 years).
The results include:
  - the loan type, loan number, last name, loan amount, adjusted interest rate (prime + loan type rate),
    term, and total amount owed (loan amount + calculated interest) for each loan.
  - whether loan 2 is the same amount as loan 4.
  - the amount due for loan 3.
  - the total amount JPL loaned out.
  - the total amount loaned out for personal loans.
  - the total amount loaned out for business loans.
*/

import java.util.Scanner;

// Class: LoanApp (main class)
// Prompts users for prime rate and loan details. Loan details are printed and summarized (see app description).

public class LoanApp implements LoanConstants{
    public static void main(String[] args) {

        // creates arrays for loans
        Loan[] loanArray = new Loan[5];

        // Begin user prompts and inputs
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the current prime interest rate?:");
        double interestRate = userInput.nextDouble();
        for (int i = 0; i < loanArray.length; i++){
            userInput.nextLine();  // Handles possible newline character
            System.out.println("What is the customer's last name?:");
            String customerLastName = userInput.nextLine();
            System.out.println("Is this a personal (enter 1) or business (enter 2) loan?:");
            int loanType = userInput.nextInt();
            while (loanType < 1 || loanType > 2){
                System.out.println("Improper loan type. Please try again.");
                System.out.println("Is this a personal (enter 1) or business (enter 2) loan?:");
                loanType = userInput.nextInt();
            }
            System.out.println("How much is the loan (maximum $"+ maxLoanAmount +")?:");
            double loanAmount = userInput.nextDouble();
            while (loanAmount < 0 || loanAmount > maxLoanAmount){
                System.out.println("Loan amount is outside the valid range. Please enter loan amount again.");
                System.out.println("How much is the loan (maximum $"+ maxLoanAmount +")?:");
                loanAmount = userInput.nextDouble();
            };
            System.out.println("What is the loan term; 3, 7, or 15 years?:");
            int loanTerm = userInput.nextInt();
            double loanAmountOwed = 0.0;
            // create object as personal or business class and place in loan array.
            if(loanType == 1){
                loanArray[i] = new PersonalLoan(i + 1, customerLastName, loanAmount, interestRate, loanTerm, loanAmountOwed);
            } else {
                loanArray[i] = new BusinessLoan(i + 1, customerLastName, loanAmount, interestRate, loanTerm, loanAmountOwed);
            }
        }

        // Begin detail print out
        System.out.println(companyName + " Loans:");
        //calls toString for each loan
        for (Loan loan : loanArray) {
            System.out.println(loan.toString());
        }
        //calls equals method to compare loan 2 with loan 4
        if (loanArray[1].equals(loanArray[1].loanAmount,loanArray[3].loanAmount)){
            System.out.println("Loans 2 and 4 are the same amount.");
        } else {
            System.out.println("Loans 2 and 4 are NOT the same amount.");
        }
        //prints loan 3 amount
        System.out.println("The amount due for Loan 3 is $" + loanArray[2].loanAmountOwed + ".");
        //variables for totals
        double totalAmountLoaned = 0.0;
        double totalPersonalLoaned = 0.0;
        double totalBusinessLoaned = 0.0;
        for (Loan loan : loanArray){
            totalAmountLoaned += loan.loanAmount; //sums all loan amounts
            if(loan instanceof PersonalLoan){
                totalPersonalLoaned += loan.loanAmount; //sums personal loans
            } else if (loan instanceof BusinessLoan){
                totalBusinessLoaned += loan.loanAmount; //sums business loans
            }
        }
        //print out loan totals
        System.out.println("The total amount loaned by " + companyName + " is $" + totalAmountLoaned);
        System.out.println("Personal Loans total: $" + totalPersonalLoaned);
        System.out.println("Business Loans total: $" + totalBusinessLoaned);
    }
}