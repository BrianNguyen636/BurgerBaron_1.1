import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;
/*
 * @Author Brian Nguyen
 */

public class Main {
    public static void main(String[] args) {
        testMyStack();
        testBurger();
        try {
            Scanner inputScan = new Scanner(System.in);
            System.out.println("Type name of input file (include file extension): ");
            String file = inputScan.nextLine();
            File myObj = new File(file);
            Scanner scan = new Scanner(myObj);
            int orderNumber = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println("Processing order " + orderNumber + ": " + line);
                parseLine(line);
                orderNumber++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        }
    }
    static void parseLine(String line) {
        line = line.replace(".", "");
        List<String> order = List.of(line.split(" "));
        boolean theWorks = order.contains("Baron");
        Burger theBurger = new Burger(theWorks);

        if (order.contains("Double")) {
            theBurger.addPatty();
        }
        else if (order.contains("Triple")) {
            theBurger.addPatty();
            theBurger.addPatty();
        }
        if (order.contains("Chicken")) {
            theBurger.changePatties("Chicken");
        } else if (order.contains("Veggie")) {
            theBurger.changePatties("Veggie");
        }
        if (!theWorks) {
            if (order.contains("with")) {
                int additionsIndex;
                if (order.contains("but")) {
                    additionsIndex = order.indexOf("but");
                } else {
                    additionsIndex = order.size();
                }
                for (int i = order.indexOf("with") + 1; i < additionsIndex; i++) {
                    if ("Cheese Sauce Veggies".contains(order.get(i))) {
                        theBurger.addCategory(order.get(i));
                    } else {
                        theBurger.addIngredient(order.get(i));
                    }
                }
                if (order.contains("but")) {
                    for (int i = order.indexOf("no") + 1; i < order.size(); i++) {
                        theBurger.removeIngredient(order.get(i));
                    }
                }
            }
        } else {
            if (order.contains("with")) {
                int omissionsIndex;
                if (order.contains("but")) {
                    omissionsIndex = order.indexOf("but");
                } else {
                    omissionsIndex = order.size();
                }
                for (int i = order.indexOf("no") + 1; i < omissionsIndex; i++) {
                    if ("Cheese Sauce Veggies".contains(order.get(i))) {
                        theBurger.removeCategory(order.get(i));
                    } else {
                        theBurger.removeIngredient(order.get(i));
                    }
                }
                if (order.contains("but")) {
                    for (int i = order.indexOf("but") + 1; i < order.size(); i++) {
                        theBurger.addIngredient(order.get(i));
                    }
                }
            }
        }
        System.out.println(theBurger);
    }

    static void testMyStack() {
        System.out.println("Testing MyStack class...");
        MyStack stack = new MyStack();
        System.out.println("Pushing test1");
        stack.push("test1");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pushing test2");
        stack.push("test2");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pushing test3");
        stack.push("test3");
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack: " + stack);
        System.out.println("Popping: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack: " + stack);
        System.out.println();

    }
    static void testBurger() {
        System.out.println("Testing Burger class...");
        System.out.println("Making burger");
        Burger burger = new Burger(false);
        System.out.println(burger);
        System.out.println("Making Baron Burger");
        Burger burg = new Burger(true);
        System.out.println(burg);
        System.out.println("Add Patty Test");
        System.out.println(burg);
        burg.addPatty();
        System.out.println(burg);
        burg.addPatty();
        System.out.println(burg);
        System.out.println("Change Patty Test");
        burg.changePatties("Chicken");
        System.out.println(burg);
        System.out.println("Remove ingredient test, removing Mayonnaise");
        burg.removeIngredient("Mayonnaise");
        System.out.println(burg);
        System.out.println("Removing veggies");
        burg.removeCategory("Veggies");
        System.out.println(burg);
        System.out.println("Adding ingredient test, adding Mushrooms");
        burg.addIngredient("Mushrooms");
        System.out.println(burg);
        System.out.println("Removing category test, removing cheese");
        burg.removeCategory("Cheese");
        System.out.println(burg);
        System.out.println("Adding category test, adding Cheese");
        burg.addCategory("Cheese");
        System.out.println(burg);
        System.out.println();
    }
}
