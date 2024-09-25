
public class Package extends Customer
{
    //Attribute
    private String serviceType, carType;
    private char packCode;
    
    // normal constructor 
    public Package(String st, String ct, char pc,String n, String pn, char pm, String np)
    {
        super(n,pn,pm,np);
        serviceType = st;
        carType = ct;
        packCode = pc;
    }
    
    // mutator
    public void setServiceType(String st)
    {
      serviceType = st;  
    }
    
     public void setCarType(String ct)
    {
      carType = ct;  
    }
    
     public void setPackCode(char pc)
    {
      packCode = pc;
    }
    
    public String getServiceType()
    {
        return serviceType;
    }
    
    public String getCarType()
    {
        return carType;
    }
    
    public char getPackCode()
    {
        return packCode;
    }
    
    public double calcPackPrice()
    {
        double packPrice = 0;
        if (serviceType.equalsIgnoreCase("Car Coating"))
        {
            if(packCode == 'B')
            {
                 if(carType.equalsIgnoreCase("SEDAN")||carType.equalsIgnoreCase("SUV"))
                      packPrice = 499.00;
                 else if(carType.equalsIgnoreCase("MPV"))
                      packPrice = 599.00;
            }
            else if(packCode == 'E')
            {
                 if(carType.equalsIgnoreCase("SEDAN")||carType.equalsIgnoreCase("SUV"))
                      packPrice = 799.00;
                 else if(carType.equalsIgnoreCase("MPV"))
                      packPrice = 999.00;
            }
            else if(packCode == 'S')
            {
                 if(carType.equalsIgnoreCase("SEDAN")||carType.equalsIgnoreCase("SUV"))
                      packPrice = 1199.00;
                 else if(carType.equalsIgnoreCase("MPV"))
                      packPrice = 1499.00;
            }
        }
        else if(serviceType.equalsIgnoreCase("Interior Detailing"))
        {
            if(packCode == 'F')
            {
                 if(carType.equalsIgnoreCase("SEDAN")||carType.equalsIgnoreCase("SUV"))
                      packPrice = 350.00;
                 else if(carType.equalsIgnoreCase("MPV"))
                      packPrice = 450.00;
            }    
            else if(packCode == 'L')
            {
                 if(carType.equalsIgnoreCase("SEDAN")||carType.equalsIgnoreCase("SUV"))
                      packPrice = 250.00;
                 else if(carType.equalsIgnoreCase("MPV"))
                      packPrice = 350.00;
             } 
        }
        return packPrice;
    }
    
    //printer
    public void dispPackage()
    {
        System.out.println("\tPackage detail: " + "\n\tService Type: " + serviceType + "\n\tCar Type: " + carType + "\n\tPackage Code: " + packCode + "\n\tPackage Price: RM" + calcPackPrice());
    }
    
}
