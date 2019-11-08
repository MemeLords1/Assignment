//Ahmed Moawad
//Thomas Chen
//Lawrence Williams
//Ruben Yanez
//Abigail Singh

import java.util.*;
class GenericStack<T> {
   private LinkedList<T> stack;
   public GenericStack() {
       stack = new LinkedList<T>();
   }
   public void push(T element){
       System.out.println("push: "+element);
       stack.addLast(element);
   }
   public T pop(){
       if(stack.size() == 0)
           return null;
       return stack.removeLast();
   }
   public T peek(){
       if(stack.size() == 0)
           return null;
       return stack.getLast();
   }
   public int size(){
       return stack.size();

   }
}

class GenericStackTest {

   public static void main(String[] args) {
       GenericStack<String> stack = new GenericStack<>();
       stack.push("Apple");
       stack.push("Oranges");
       stack.push("Bananas");
       System.out.println("The stack contains "+stack.size()+" items");
       System.out.println("Peak: "+stack.peek()+" The stack contains "+stack.size()+" items");
       System.out.println("Pop: "+stack.pop());
       System.out.println("Pop: "+stack.pop());
       System.out.println("Pop: "+stack.pop());
       System.out.println("The stack contains "+stack.size()+" items");

   }

}