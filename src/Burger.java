public class Burger {
    public static int order = 0;
    int pattyCount = 1;
    String pattyType = "Beef";
    MyStack stack;
    MyStack baron = new MyStack();

    public Burger(boolean theWorks) {
        stack = new MyStack();
        baron.push("Pickle");
        baron.push("Bun");
        baron.push("Mayonnaise");
        baron.push("Baron Sauce");
        baron.push("Lettuce");
        baron.push("Tomato");
        baron.push("Onions");
        baron.push("Pepperjack");
        baron.push("Mozzarella");
        baron.push("Cheddar");
        baron.push("Beef");
        baron.push("Mushrooms");
        baron.push("Mustard");
        baron.push("Ketchup");
        baron.push("Bun");
        if (theWorks) {
            MyStack store = new MyStack();
            while (!baron.isEmpty()) {
                String holder = baron.pop();
                stack.push(holder);
                store.push(holder);
            }
            while (!store.isEmpty()) {
                baron.push(store.pop());
            }
        } else {
            stack.push("Bun");
            stack.push("Beef");
            stack.push("Bun");
        }
    }
    void changePatties(String thePattyType) {
        MyStack store = new MyStack();
        while (!stack.isEmpty()) {
            if (stack.peek().equals(pattyType)) {
                stack.pop();
                store.push(thePattyType);
            } else {
                store.push(stack.pop());
            }
        }
        while (!store.isEmpty()) {
            stack.push(store.pop());
        }
        pattyType = thePattyType;
    }
    void addPatty() {
        if (pattyCount != 3) {
            MyStack store = new MyStack();
            while (!("Pepperjack Mozzarella Cheddar" + pattyType)
                    .contains(stack.peek())) {
                store.push(stack.pop());
            }
            stack.push(pattyType);
            pattyCount++;
            while (!store.isEmpty()) {
                stack.push(store.pop());
            }
        }
    }
    void addCategory(String category) {
        String list = switch (category) {
            case "Cheese" -> "Cheddar Mozzarella Pepperjack";
            case "Sauce" -> "Ketchup Mustard Mayonnaise Baron Sauce";
            case "Veggies" -> "Lettuce Tomato Onions Pickle Mushrooms";
            default -> "";
        };
        MyStack store = new MyStack();
        MyStack baronStore = new MyStack();
        while (!stack.isEmpty()) {
            store.push(stack.pop());
        }
        while (!store.isEmpty()) {
            String item = baron.pop();
            baronStore.push(item);
            if (list.contains(item)) {
                stack.push(item);
            }
            if (item.equals(store.peek())) {
                stack.push(store.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baron.push(baronStore.pop());
        }
    }
    void removeCategory(String category) {
        String list = switch (category) {
            case "Cheese" -> "Cheddar Mozzarella Pepperjack";
            case "Sauce" -> "Ketchup Mustard Mayonnaise Baron Sauce";
            case "Veggies" -> "Lettuce Tomato Onions Pickle Mushrooms";
            default -> "";
        };
        MyStack store = new MyStack();
        while (!stack.isEmpty()) {
            if (list.contains(stack.peek())) {
                stack.pop();
            } else {
                store.push(stack.pop());
            }
        }
        while (!store.isEmpty()) {
            stack.push(store.pop());
        }

    }
    void addIngredient(String ingredient) {
        MyStack store = new MyStack();
        MyStack baronStore = new MyStack();
        while (!stack.isEmpty()) {
            store.push(stack.pop());
        }
        while (!store.isEmpty()) {
            String item = baron.pop();
            baronStore.push(item);
            if (item.equals(ingredient)) {
                stack.push(item);
            }
            if (item.equals(store.peek())) {
                stack.push(store.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baron.push(baronStore.pop());
        }
    }
    void removeIngredient(String type) {
        MyStack store = new MyStack();
        while (!stack.isEmpty()) {
            if (stack.peek().equals(type)) {
                stack.pop();
            } else {
                store.push(stack.pop());
            }
        }
        while (!store.isEmpty()) {
            stack.push(store.pop());
        }
    }
    public String toString() {
        ++order;
        return stack.toString();
    }

}

