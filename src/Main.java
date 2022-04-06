import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        testMyStack();
//        testBurger();
        parseLine("Single Burger with Veggies but no Lettuce.");
        parseLine("Double Chicken Burger with Ketchup Cheddar Onions Mushrooms.");
    }
    static void parseLine(String line) {
//        line = line.substring(0,line.length() - 1);
        line = line.replace(".", "");
        List<String> order = List.of(line.split(" "));
        int burgerIndex = order.indexOf("Burger");
        boolean theWorks = order.get(burgerIndex - 1).equals("Baron");
        Burger theBurger = new Burger(theWorks);
        System.out.println("Proccessing order " + theBurger.orderNum + ": " + line);
        if (!theWorks) {
            int additionsIndex = 0;
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
        System.out.println(theBurger);
    }

    void testMyStack() {
        MyStack stack = new MyStack();
        stack.push("test1");
        System.out.println(stack.peek());
        stack.push("test2");
        System.out.println(stack.peek());
        stack.push("test3");
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
    void testBurger() {
        Burger burg = new Burger(true);
        System.out.println("Remove ingredient test, removing Mayonnaise");
        burg.removeIngredient("Mayonnaise");
        System.out.println(burg);
        System.out.println("Removing category test, removing cheese");
        burg.removeCategory("Cheese");
        System.out.println(burg);
        System.out.println("Removing veggies");
        burg.removeCategory("Veggies");
        System.out.println(burg);
        System.out.println("Adding ingredient test, adding Mushrooms");
        burg.addIngredient("Mushrooms");
        System.out.println(burg);
        System.out.println("Adding category test, adding Cheese");
        burg.addCategory("Cheese");
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
    }
}
