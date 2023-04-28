package com.example.stack;

public class MinStack {
    
    public int[] data;
    
    public static final int DEFAULT_MAX_SIZE = 10;
    
    public int index =-1;
    
    public int minvalue;
  

  public MinStack() {
   this(DEFAULT_MAX_SIZE);
  }
  
  public MinStack(int size) {
      data = new int[size];
  }

  public int min() {
    return minvalue;
  }

  public void push(int value) {
   if(index == data.length-1) {
       System.out.println("Stack is full");
   }
   if(isEmpty()) {
       minvalue = value;
   } else if(value < minvalue){
       minvalue = 2*value - minvalue;
   }
   index++;
   data[index] = value;
  }

  public int pop() {
    if(index == -1) {
        System.out.println("Stack is Empty");
    }
    int removed = data[index];
    index--;
    if(removed < minvalue) {
        minvalue = 2*minvalue - removed;
    }
    return removed;
  }
  
  public boolean isEmpty() {
      return index == -1;
  }
  
  public void display() {
		for(int i = 0; i <= index; i++) {
			System.out.print(data[i] + " -> ");
		}
		System.out.print("END");
		System.out.println();
 }
}