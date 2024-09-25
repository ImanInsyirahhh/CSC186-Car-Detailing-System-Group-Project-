
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class carDetailingApp {
    public static void main(String[] args) throws IOException {
        String name, phoneNum, plateNum, typeCar, serviceType, cardNum, cardDate, cardCode,serviceOn= " ";
        char start, packCode = ' ', payMethod, bank = ' ', addOnCode = ' ',codeOn = ' ';
        double total = 0,priceOn = 0;
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("\t\t*************************************CAR DETAILING**************************************");
        System.out.print("\n\tDo you want to start the system? [ Y | N ]: ");
        start = sc.next().charAt(0);
        sc.nextLine();

        Customer[] cust = new Customer[5];
        int custCount = 0;
        
        FileWriter f = new FileWriter("packageDetail.txt");
        PrintWriter p = new PrintWriter(f);
        
        while (start == 'Y' || start == 'y') {
            System.out.print("\n\t###############################################################################################");
            System.out.print("\n\t######||||##||##||||##|||||||||##|||#######|||||||####|||||#####|||##||||##|||###|||||||||#####");
            System.out.print("\n\t#######|||##||##|||###|||########|||######|||########||###||####||||||||||||||###|||###########");
            System.out.print("\n\t#######|||##||##|||###|||||||####|||#####|||########|||###|||###|||##||||##|||###|||||||#######");
            System.out.print("\n\t########|||#||#|||####|||||||####|||#####|||########|||###|||###|||########|||###|||||||#######");
            System.out.print("\n\t########|||#||#|||####|||########|||######|||########||###||####|||########|||###|||###########");
            System.out.print("\n\t#########||||||||#####|||||||||##|||||||###|||||||####|||||#####|||########|||###|||||||||#####");
            System.out.print("\n\t###############################################################################################");

            System.out.println("\n\n\tDear User, Please fill in the required information. Thank you!!!");

            System.out.print("\n\tName: ");
            name = sc.next();
            System.out.print("\n\tPhone Number: ");
            phoneNum = sc.next();
            System.out.print("\n\tCar Plate: ");
            plateNum = sc.next();
            sc.nextLine(); 

            System.out.println("\n\t##################################################################");
            System.out.println("\t#####    ####### ####### ######  #       # # ###### #######  #####  ");
            System.out.println("\t#####   ##       ##      #     #  #     #  # #      ##       #####  ");
            System.out.println("\t#####    ######  ######  #  ####   #   #   # #      #######  #####  ");
            System.out.println("\t#####        ### ##      #   #      # #    # #      ##       #####  ");
            System.out.println("\t#####   #######  ######  #    ###    #     # ###### #######  #####  ");
            System.out.println("\t##################################################################");

            System.out.print("\n\tChoose A Service [ Car Coating | Interior Detailing ]: ");
            serviceType = sc.nextLine();
      
                System.out.println("\t--------------------------------------------------------------------------");
                System.out.println("\t|  Package Code  |     Car Package    |     Car Type     |    Price(RM)  |");
                System.out.println("\t|------------------------------------------------------------------------|");
                System.out.println("\t|                |                    |       SEDAN      |               |");
                System.out.println("\t|                |                    |------------------|     499.00    |");
                System.out.println("\t|       B        |        Basic       |        SUV       |               |");
                System.out.println("\t|                |                    |------------------|---------------|");
                System.out.println("\t|                |                    |        MPV       |     599.00    |");
                System.out.println("\t|------------------------------------------------------------------------|");
                System.out.println("\t|                |                    |       SEDAN      |               |");
                System.out.println("\t|                |                    |------------------|     799.00    |");
                System.out.println("\t|       E        |        Elite       |        SUV       |               |");
                System.out.println("\t|                |                    |------------------|---------------|");
                System.out.println("\t|                |                    |        MPV       |     999.00    |");
                System.out.println("\t|------------------------------------------------------------------------|");
                System.out.println("\t|                |                    |       SEDAN      |               |");
                System.out.println("\t|                |                    |------------------|    1199.00    |");
                System.out.println("\t|       S        |       Supreme      |        SUV       |               |");
                System.out.println("\t|                |                    |------------------|---------------|");
                System.out.println("\t|                |                    |        MPV       |    1499.00    |");
                System.out.println("\t|------------------------------------------------------------------------|");
                System.out.println("\t|                |                    |       SEDAN      |               |");
                System.out.println("\t|                |                    |------------------|     350.00    |");
                System.out.println("\t|       F        |       Fabric       |        SUV       |               |");
                System.out.println("\t|                |                    |------------------|---------------|");
                System.out.println("\t|                |                    |        MPV       |     450.00    |");
                System.out.println("\t|------------------------------------------------------------------------|");
                System.out.println("\t|                |                    |       SEDAN      |               |");
                System.out.println("\t|                |                    |------------------|     250.00    |");
                System.out.println("\t|       L        |       Leather      |        SUV       |               |");
                System.out.println("\t|                |                    |------------------|---------------|");
                System.out.println("\t|                |                    |        MPV       |     350.00    |");
                System.out.println("\t--------------------------------------------------------------------------");  
            
            
            if (serviceType != null) {
                if (serviceType.equalsIgnoreCase("Car Coating")) {
                    System.out.print("\n\tEnter Car Coating Package Code [ B | E | S ]: ");
                    packCode = sc.next().charAt(0);
                    sc.nextLine();
                    
                } else if (serviceType.equalsIgnoreCase("Interior Detailing")) {
                    System.out.print("\n\tEnter Interior Detailing Package Code [ F | L ]: ");
                    packCode = sc.next().charAt(0);
                    sc.nextLine(); 
                    
                } else {
                    System.out.println("Invalid Service Type");
                    continue;
                    
                }

                System.out.print("\n\tCar Type [ SEDAN | SUV | MPV ]: ");
                typeCar = sc.nextLine();

                Package pack = new Package(serviceType, typeCar, packCode, name, plateNum, ' ', phoneNum);
                double packagePrice = pack.calcPackPrice();
                pack.dispPackage();

      
                System.out.print("\n\tDo you want to add more services? [ Y | N ]: ");
                char addOn = sc.next().charAt(0);
                sc.nextLine(); 

                AddOn add = null; 
                double addOnPrice = 0;
                
                if (addOn == 'Y' || addOn == 'y') {
                    
                    System.out.println("\t-----------------------------------------------------------");
                    System.out.println("\t|  Add-On Code  |      Add-On Service      |   Price(RM)  |");
                    System.out.println("\t|---------------------------------------------------------|");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t|       A       |      Headlamp Polish     |     35.00    |");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t|---------------------------------------------------------|");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t|       B       |     Car Disinfection     |     50.00    |");
                    System.out.println("\t|               |       & Sanitizing       |              |");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t|---------------------------------------------------------|");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t|       C       |     Car Polish & Wax     |    150.00    |");
                    System.out.println("\t|               |                          |              |");
                    System.out.println("\t-----------------------------------------------------------");

                    System.out.print("\n\tEnter Add-On Code [ A | B | C ]: ");
                    addOnCode = sc.next().charAt(0);
                    sc.nextLine();                    

                    add = new AddOn(addOnCode, serviceOn, priceOn);
                    addOnPrice = add.priceOn();
                    String addDetail = add.getServiceOn();
                    add.displayAddOn();
                
                    
                }
                                
                
                total = packagePrice + addOnPrice;
                System.out.println("\n\tTotal payment: RM" + df.format(total));

                System.out.println("\n\t-----------------------------------------------------");
                System.out.println("\t\tMODE OF PAYMENT");
                System.out.println("\t\t[1] Credit Card/ Debit Card");
                System.out.println("\t\t[2] Cash");
                System.out.println("\t-----------------------------------------------------");
                System.out.print("\tEnter mode of payment: ");
                payMethod = sc.next().charAt(0);
                sc.nextLine();

                if (payMethod == '1') {
                    System.out.print("\tEnter your card number [xxxx-xxxx-xxxx-xxxx]: ");
                    cardNum = sc.next();
                    System.out.print("\tExpiry Date [MM/YY]: ");
                    cardDate = sc.next();
                    System.out.print("\tSecurity Code [3-digit]: ");
                    cardCode = sc.next();

                    do {
                        System.out.print("\n\t[ 1 - MAYBANK ]\n\t[ 2 - BANK ISLAM ]\n\t[ 3 - AM BANK ]\n\t[ 4 - CIMB BANK ]\n\t[ 5 - RHB BANK ] \n\t[ 6 - AGRO BANK ] "); 
                        System.out.print("\n\tPlease enter your bank [ 1 to 6 ]: ");
                        bank = sc.next().charAt(0);
                        sc.nextLine();
                        if (bank < '1' || bank > '6') {
                            System.out.print("\nYou entered a wrong code. Please re-enter your bank's code: ");
                        }
                    } while (bank < '1' || bank > '6');
                } 

                System.out.println("\n\tYOU SUCCESSFULLY MADE THE PAYMENT. THANK YOU!");        
                
                try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt", true))) {
                    pw.println("\t\t*****************************************************************");
                    pw.println("\t\t                           RECEIPT                               ");
                    pw.println("\t\t*****************************************************************");
                    pw.println("\t\t                         CAR DETAILING                           ");
                    pw.println("\t\tName:\t" + name);
                    pw.println("\t\tPhone Number:\t" + phoneNum);
                    pw.println("\t\tCar Plate:\t" + plateNum);
                    pw.println("\t\t-----------------------------------------------------------------");
                    pw.println("\t\tDESCRIPTION\t\tPRICE");
                    pw.println("\t\t" + serviceType + "\t\t" + packagePrice);

                    if (add != null) {
                        pw.println("\t\t" + add.getServiceOn() + "\t\t" + addOnPrice);
                    }

                    pw.println("\t\t-----------------------------------------------------------------");
                    pw.println("\t\tTOTAL\t\t" + df.format(total));
                }

                custCount++;
            } else {
                System.out.println("Invalid service type.");
            }

            try (FileOutputStream fos = new FileOutputStream("customers.dat");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (int i = 0; i < custCount; i++) {
                    oos.writeObject(cust[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            System.out.print("\n\tDo you want to start the program again? [ Y | N ]: ");
            start = sc.next().charAt(0);
            sc.nextLine(); 
            
            if(start == 'N' || start == 'n')
            {
                System.out.println("\n\t************THANK YOU FOR USING OUR CAR DETAILING SYSTEM!*****************");
            }
        }
        sc.close();
        
    }
}
