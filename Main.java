import java.util.Scanner;

class ATM {
    String[] transaction;
    int i, amount;

    ATM() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total amount");
        amount = sc.nextInt();
        transaction = new String[150];
        i = 0;
    }

    void setTransaction() {
        System.out.println("**********************TRANSACTIONS***************************");
        for (int k = 0; k < i; k++) {
            System.out.println(transaction[k]);

        }
    }

    void withdraw() {
        int withdraw_amount = 0;
        Scanner sc = new Scanner(System.in);
        int R_amount = amount - withdraw_amount;
        System.out.println("***********************WITHDRAW*******************************");
        System.out.println("enter the amount to be withdraw");
        System.out.println(R_amount);
        withdraw_amount = sc.nextInt();
        if (withdraw_amount % 100 == 0 && amount > withdraw_amount && amount - withdraw_amount >= 500) {
            amount -= withdraw_amount;
            System.out.println("Amount Withdraw Successfully");
            //   transaction[i] = new String(i + 1 + ")Withdraw amount : " + withdraw_amount);
            i++;
        } else if (amount - withdraw_amount <= 500) {
            System.out.println("Their is no Sufficient Balance");
        } else if (withdraw_amount % 100 != 0) {
            System.out.println("Enter the amount multiple of 100");
        }
    }

    void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************Transfer**************************");
        System.out.println("Enter Receivers name :");
        String receiver_name = sc.next();
        System.out.println("Enter the amount that transfer to  receiver");
        int transfer_amount = sc.nextInt();
        if (amount - 500 < transfer_amount) {
            System.out.println("Insufficient Balance");
        } else if (transfer_amount > 100000) {
            System.out.println("Sorry!! Limited");
        } else {
            amount = amount - transfer_amount;
            System.out.println("Amount" + transfer_amount );
            System.out.println("Transferred" + receiver_name);
            System.out.println("Successfully");
            // transaction[i] = new String(i + 1 + ")Transfer" + transfer_amount);
            i++;
        }
    }

    void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("******************************Deposit****************************");
        System.out.println("Enter the Deposit amount :");
        int deposit_amount = sc.nextInt();
        amount = amount + deposit_amount;
        System.out.println("**Amount deposited Successfully**");
        //  transaction[i] = new String(i + 1 + ")Deposited Amount :" + deposit_amount);
        i++;
    }

    void restBalance() {
        System.out.println("Rest Balance is" + amount);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter ID");
        int id=sc.nextInt();
        System.out.println("enter PIN");
        int PIN=sc.nextInt();
        int Eid,n_pin;
        int choice;
        do{
            System.out.print("enter the ID");
            Eid=sc.nextInt();
            System.out.print("enter the PIN");
            n_pin=sc.nextInt();
            if(id!=Eid || PIN!=n_pin) {
                System.out.println("Invalid Information please enter the valid Info");
            }
        }while(id!=Eid || PIN!=n_pin);
        ATM a=new ATM();
        while(true)
        {
            System.out.println("************Welcome************");
            System.out.println("press 1 for Transactions");
            System.out.println("press 2 for Withdraw");
            System.out.println("press 3 for Deposit");
            System.out.println("press 4 for transfer");
            System.out.println("press 5 for Rest balance");
            System.out.println("press 6 for Exit");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    a.setTransaction();
                    break;
                case 2:
                    a.withdraw();
                    break;
                case 3:
                    a.deposit();
                    break;
                case 4:
                    a.transfer();
                    break;
                case 5:
                    a.restBalance();
                    break;
                case 6:
                    System.out.println("thanks for doing Transaction");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error in the system please try again");
                    break;
            }
        }
    }

}
