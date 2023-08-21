import java.util.Scanner;
import java.util.Random;

public class BankAcc {

    private int acNo;
    private Float acBalance;
    private String name,password,address;
    private long phNo;


    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the name: ");
        name = sc.nextLine();
        System.out.print("Enter the address:");
        address = sc.nextLine();
        System.out.print("Enter the contact number: ");
        phNo = sc.nextLong();
        System.out.print("Create password:");
        password = sc.next();
        System.out.print("Enter the initial deposit amount: ");
        acBalance=sc.nextFloat();


        Random random = new Random();
        int randomNumber = random.nextInt(1000);  // Generating a random integer
        acNo=randomNumber;
        System.out.println("User Registered successfully,Account number is:"+randomNumber);
    }



    public Boolean login(String pass){
        if(this.password.equals(pass))
            return (true);
        else
            return (false);


    }



    public void display() {
        System.out.println("\nName: " + name);
        System.out.println("Account No: " + acNo);
        System.out.println("Balance: " + acBalance);
        System.out.println("Residential Address: " + address);
        System.out.println("Phone Number: " + phNo);
    }



    public int transfer(BankAcc dest, Float amt) {
        if (amt >= acBalance)
            return 0;
        acBalance -= amt;
        dest.acBalance += amt;
        return 1;
    }


    public static void main(String[] args) {

        BankAcc b1 = new BankAcc();
        BankAcc b2 = new BankAcc();
        BankAcc b3 = new BankAcc();
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        int c=0;
        String p;

        System.out.println(".....WELCOME TO Upskill Campus BANK INFORMATION SYSTEM.....");
        while(true){
            System.out.println("\n***********User Interface MENU***********\nWhat do you wish to do?\n1.User Registration\n2.Login\n3.Account Management\n4.Deposit\n5.Withdraw\n6.Fund Transfer\n7.Account Statements\n8.Exit");
            Scanner sc = new Scanner(System.in);
            int choice= sc.nextInt();

            switch(choice)
            {
                case 1:
                    c++;
                    if(c==1)
                        b1.registerUser();
                    else if(c==2)
                        b2.registerUser();
                    else
                        b3.registerUser();
                    break;


                case 2:
                    System.out.println("Enter the account no:");
                    int an=sc.nextInt();
                    System.out.println("Enter the password:");
                    String pass=sc.next();

                    if(b1.acNo==an){
                        f1 = b1.login(pass);
                        if(f1==true)
                            b1.display();
                        else
                            System.out.println("Password incorrect!");
                    }

                    else if(b2.acNo==an){
                        f2 = b2.login(pass);
                        if(f2==true)
                            b2.display();
                        else
                            System.out.println("Password incorrect!");
                    }

                    else
                    {f3 = b3.login(pass);
                        if(f3==true)
                            b3.display();
                        else
                            System.out.println("Password incorrect!");
                    }

                    break;


                case 3:
                    if(f1==true){
                    
                    System.out.println("Account Management");
                    b1.display();
                    System.out.println("1.Update Name\n2.Update Address\n3.Update Contact details\n4.Update password settings\nEnter choice:");
                    int ch=sc.nextInt();
                    sc.nextLine();
                    switch(ch)
                    {
                        case 1:
                            System.out.println("Name is :"+b1.name);
                            
                            System.out.print("Enter the name you want to update it to:");
                            String n=sc.nextLine();
                            System.out.println("Press enter to confirm.");
                            sc.nextLine();
                            b1.name=n;
                            System.out.println("Information Updated Successfully.......the updated name is:"+b1.name);
                            break;

                        case 2:
                            System.out.println("Current Address is :"+b1.address);
                            System.out.println("Enter the new address:");
                            String add=sc.nextLine();
                            b1.address=add;
                            System.out.println("Information Updated Successfully.......the updated residential address is:"+b1.address);
                            break;

                        case 3:
                            System.out.println("Current phone number is :"+b1.phNo);
                            System.out.println("Enter the phone number:");
                            long pn = sc.nextLong();
                            b1.phNo=pn;
                            System.out.println("Information Updated Successfully.......the updated phone number is:"+b1.phNo);
                            break;

                        case 4:
                            System.out.println("Are you sure you want to chnage your password?Press any character and then 'enter' to confirm.");
                            sc.next();
                            System.out.println("Enter the current password");
                            p=sc.next();
                     
                            if(p.equals(b1.password))
                            {
                                
                                System.out.println("Enter the new password:");
                                String p1=sc.next();
                                b1.password=p1;
                                System.out.println("Information Updated Successfully.......the new password has been saved");
                           
                            }
                            else
                            {
                                System.out.println("Wrong password entered");
                                
                            }
                            break;

                        default:
                            System.out.println("Please enter choice correctly");
                            break;
                    }

                    }
                    else
                    {
                        System.out.println("You need to log in first");
                    }
                
                    break;


                case 4:
                    if(f1==true)
                    {
                        System.out.println("Enter the amount you want to deposit:");
                        int a = sc.nextInt();
                        b1.acBalance+=a;
                        System.out.println("Amout deposited successfully...The balance is:"+b1.acBalance);

                    }
                    else
                        System.out.println("You need to log in first");


                    break;

                case 5:
                    if(f1==true)
                    {
                        System.out.println("Enter the amount you want to withdraw:");
                        int a = sc.nextInt();
                        b1.acBalance-=a;
                        System.out.println("Amout withdrawn successfully...The balance is:"+b1.acBalance);

                    }
                    else
                        System.out.println("You need to log in first");

                    break;





                case 6:
                    if(f1==true)
                    {
                        System.out.println("Enter the amount you want to transfer:");
                        Float a = sc.nextFloat();
                        System.out.println("Enter receiver bank account number:");
                        int no=sc.nextInt();
                        
                        if(b2.acNo==no)
                        {
                            int k = b1.transfer(b2, a);
                            if (k == 1) {
                                System.out.println("Transfer successful.\n\nCurrent status:");
                                b1.display();
                                b2.display();
                            } else {
                                System.out.println("Transfer unsuccessful");
                            }

                        }

                        else

                        {
                            int m = b1.transfer(b3, a);
                            if (m == 1) {
                                System.out.println("Transfer successful.\n\nCurrent status:");
                                b1.display();
                                b3.display();
                            } else {
                                System.out.println("Transfer unsuccessful");
                            }

                        }

                    }
                    else
                        System.out.println("You need to log in first");

                    break;

                case 7:
                    System.out.println("You need to log in first");
                    System.out.println("Account Statement:");
                   /* code yet to completed */
                    break;


                case 8:
                    System.out.println("Exitting...Thanks for visiting!");
                    System.exit(0);

                default:
                            System.out.println("Please enter choice correctly");
                            break;

            }
        }
    }
}


