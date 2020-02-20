//Thomas Chen
//Exception Handling with Custom Exceptions Lab

public class Customer{
  private String customernumber;
  private String fullName;
  private String address;
  private String stateandzip;
  private String filler;

  public Customer(){

  }
  public Customer(String customernumber, String fullName, String address, String stateandzip,String filler){
    this.customernumber = customernumber;
    this.fullName = fullName;
    this.address = address;
    this.stateandzip = stateandzip;
    this.filler = filler;
  }

  public void setcustomernumber(String customernumber){
    this.customernumber = customernumber;
  }

  public void setfullName(String fullName){
    this.fullName = fullName;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public void setstateandzip(String stateandzip){
    this.stateandzip = stateandzip;
  }
  public void setfiller(String filler){
    this.filler = filler;
  }

  public String getcustomernumber(){
    return customernumber;
  }

  public String getfullName(){
    return fullName;
  }

  public String getAddress(){
    return address;
  }

  public String getstateandzip(){
    return stateandzip;
  }
  public String getFiller(){
    return filler;
  }



  public String toString(){
    return "Customer ID: " + customernumber + "\nCustomer Name: " + fullName + "\nCustomer address: " + address + "\nCustomer State and ZipCode: " + stateandzip;
  }
}
