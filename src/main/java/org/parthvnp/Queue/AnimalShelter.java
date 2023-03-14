package org.parthvnp.Queue;

import java.util.*;
class Animal{
    public final String type;
    public final String name;
    public Animal(String type, String name){
        this.type = type;
        this.name =name;
    }

    @Override
    public String toString(){
        return this.type + " " + this.name;
    }
}

public class AnimalShelter {
    LinkedList<Animal> list = new LinkedList<>();
    public Animal dequeueAny(){
        if(list.isEmpty()){return null;}
        return list.removeFirst();
    }

    public void enqueue(Animal animal){
        list.addLast(animal);
    }

    public Animal dequeueCat(){
        if(list.isEmpty()){return null;}
        for(var i: list){
            if(i.type.equals("Cat")){
                list.remove(i);
                return i;
            }
        }
        return null;
    }

    public Animal dequeueDog(){
        if(list.isEmpty()){return null;}
        for(var i: list){
            if(i.type.equals("Dog")){
                list.remove(i);
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AnimalShelter as = new AnimalShelter();
        as.enqueue(new Animal("Dog", "A"));
        as.enqueue(new Animal("Dog", "b"));
        as.enqueue(new Animal("Dog", "c"));
        as.enqueue(new Animal("Dog", "d"));
        as.enqueue(new Animal("Dog", "e"));
        System.out.println(as.dequeueAny());
        System.out.println(as.dequeueCat());
        System.out.println(as.dequeueDog());
        System.out.println(as.list);
    }
}
