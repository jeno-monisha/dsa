package com.example.queue;

import java.util.LinkedList;

public class AnimalQueue {
	 public LinkedList<Dog> dogs;
     public LinkedList<Cat> cats;
     public static final int MAX_SIZE = 10;
     
     public int size = 0;
     public int order = 0;
     
     public AnimalQueue() {
         this.dogs = new LinkedList<Dog>();
         this.cats = new LinkedList<Cat>();
     }
     
     public boolean enqueue(Animal animal) {
         if(isFull()) {
             System.out.println("Queue is Full");
             return false;
         }
         order++;
         animal.setOrder(order);
         if(animal instanceof Dog) {
             dogs.addLast((Dog)animal);
         } else if(animal instanceof Cat) {
             cats.addLast((Cat)animal);
         }
        size++;
        return true;
     }
     
     public Animal dequeueAny() {
         Animal removed = null;
         if(isEmpty()) {
             System.out.println("Queue is Full");
             return null;
         }
         
         if(dogs.peek().isOlderThan(cats.peek())) {
             removed = dogs.peek();
             dogs.poll();
         } else if(cats.peek().isOlderThan(dogs.peek())) {
             removed = cats.peek();
             cats.poll();
         }
         size--;
         return removed;
     }
     
     public Dog dequeueDogs() {
         size--;
         return dogs.poll();
     }
     
     public Cat dequeueCats() {
         size--;
         return cats.poll();
     }
     
     
     public boolean isFull() {
         return size == MAX_SIZE;
     }
     
     public boolean isEmpty() {
         return size == 0;
     }

}
