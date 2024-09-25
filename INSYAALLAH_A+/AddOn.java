
public class AddOn 
{
     private char codeOn;
     private String serviceOn;
     private double priceOn;
     
     public AddOn(char co, String so, double po)
     {
          codeOn = co;
          serviceOn = so;
          priceOn = po;
     }
     
     public void setAddOn(char co, String so, double po)
     {
          codeOn = co;
          serviceOn = so;
          priceOn = po;         
     }
     
     public char getCodeOn()
     {
         return codeOn;
     }
     
     public String getServiceOn()
     {
         switch(codeOn)
         {
            case 'A':
                serviceOn = "Headlamp Polish";
            case 'B':
                serviceOn = "Car Disinfection & Sanitizing";
            case 'C':
                serviceOn = "Car Polish & Wax";
         }
         return serviceOn;
     }
     
     public double priceOn()
     {
         double addPrice =0;
         
         if(getCodeOn() == 'A'){
               addPrice = 35.00;
         }      
         else if(getCodeOn() == 'B'){
               addPrice = 50.00;
         }      
         else if(getCodeOn() == 'C'){
               addPrice = 150.00;
         }
         else{
               addPrice = 0;
         }
         
         return addPrice;         
     }
     
     public void displayAddOn()
     {
         System.out.println("\tPackage Detail:  \n\tAdd-On Code: "+ codeOn + "\n\tAdd-On Service: " + getServiceOn() + "\n\tAdd-On Price: RM" + priceOn());
     }
}
