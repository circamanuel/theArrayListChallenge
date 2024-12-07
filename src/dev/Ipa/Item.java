package dev.Ipa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Item {

  public int number;
  ArrayList<String> groceryList = new ArrayList<>(Arrays.asList("Milk", "Eggs", "Bread", "Apples"));


    public Item(int number) {
        this.number = number;


    }

// prints the aray out
  public void print() {

    groceryList.sort(Comparator.naturalOrder());
    System.out.println(groceryList);
  }

  // selects case from 1 - 2 and calls the right class for this case;
  public static void getFunction(int number) {

    switch (number) {
      case 1 -> System.out.println("add");
      case 2 -> System.out.println("delete");
      default -> System.out.println("Select a number betweeen 0 - 2");
    };
  }

  public void addItem(ArrayList<String> itemsToAdd ) {
        ArrayList<String> addedItems =  new ArrayList<>();
        ArrayList<String> notFoundItems = new ArrayList<>();

      for (String item : itemsToAdd) {
          if (!itemDupEx(item)) {
              groceryList.add(item);
              addedItems.add(item);

          } else {
              notFoundItems.add(item);
          }
      }
      if (!addedItems.isEmpty()) {
          System.out.println("added items: " + addedItems);
      }
      if (!notFoundItems.isEmpty()) {
          System.out.println("Items already exists ! " + notFoundItems);
      }
  }

 // checks if dupes else delete item at this position
 public void deleteItem(ArrayList<String> itemsToDelete) {
     ArrayList<String> removedItems = new ArrayList<>();
     ArrayList<String> notFoundItems = new ArrayList<>();

     for (String item : itemsToDelete) {
         if (itemDupEx(item)) {
             groceryList.remove(item);
             removedItems.add(item);
         } else {
             notFoundItems.add(item);
         }
     }

     // Ausgabe der Ergebnisse
     if (!removedItems.isEmpty()) {
         System.out.println("Removed items: " + removedItems);
     }
     if (!notFoundItems.isEmpty()) {
         System.out.println("Items not found: " + notFoundItems);
     }
 }
  //checks if Item: not exists or duplicate
  public boolean itemDupEx(String item) {

    return groceryList.contains(item);
  }
}
