public class Fruit {
   String name;
   String taste;
   double size;
   public Fruit(String name, String taste, double size){
      this.name = name;
      this.taste = taste;
      this.size = size;
}


public void getFruit(){
//return name;
//return size;
 

   }
public String eat(){

//return name + " is " + taste;

return taste + "is very Good" ;
}

public static void  main (String [] args){
 Fruit myFruit= new Fruit("orange","good ",67.0);
}
 
}


