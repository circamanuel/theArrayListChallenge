package dev.Ipa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Item item = new Item(1);
        item.print();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select 0 to end, 1 to add item, 2 to delete an item:");
            String input = scanner.nextLine();
            int selected;

            try {
                selected = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (0 - 2)");
                continue;

            }  if (selected == 1) {
                System.out.println("Enter items to add (comma-separated):");
                String itemsInput = scanner.nextLine();
                ArrayList<String> itemsToAdd = new ArrayList<>(Arrays.asList(itemsInput.split(",")));

                for (int i = 0; i < itemsToAdd.size(); i++) {
                    itemsToAdd.set(i, itemsToAdd.get(i).trim());
                }
                 item.addItem(itemsToAdd);

            } else if (selected == 2) {
                System.out.println("Enter items to delete (comma-separated):");
                String itemsInput = scanner.nextLine();
                ArrayList<String> itemsToDelete = new ArrayList<>(Arrays.asList(itemsInput.split(",")));

                for ( int i = 0; i < itemsToDelete.size(); i++) {
                    itemsToDelete.set(i, itemsToDelete.get(i).trim());
                }
                item.deleteItem(itemsToDelete);

            } else {
                System.out.println("Invalid selection. Please choose 0, 1, or 2.");
            }

            // Print updated list after each operation
            item.print();
        }
    }
}
