public class Customer
{
    //attribute
    private String name, plateNum, phoneNum;
    private char payMethod;
    
    //normal constructor
    public Customer(String n, String pn, char pm, String np)
    {
        name = n;
        plateNum = pn;
        payMethod = pm;
        phoneNum = np;
    }
    
    public void setCustomer(String n, String pn, char pm, String np)
    {
        name = n;
        plateNum = pn;
        payMethod = pm;
        phoneNum = np;
    }
    
    //retriever
    public String getName()
    {
        return name;
    }
    
    public String getPlateNum()
    {
        return plateNum;
    }
    
    public char getPayMethod()
    {
        return payMethod;
    }
    
    public String getPhoneNum()
    {
        return phoneNum;
    }
    
    //printer
    public void displayCustomerDetail()
    {
        System.out.println("CAR DETAILING SYSTEM"+"\nCustomer's Receipt:" + "\nCustomer Name: " + name +  "\nPhone Number: " + phoneNum + "\nPlate Number: " + plateNum + "\nPayment Method: " +payMethod);
    }
}

