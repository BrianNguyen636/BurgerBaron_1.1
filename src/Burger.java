/*
 * @author Brian Nguyen
 */
class Burger {
    int pattyCount = 1;
    String patty = "Beef";
    MyStack burger;
    MyStack baronRecipe = new MyStack();

    Burger(boolean theWorks) {
        burger = new MyStack();
        if (theWorks) {
            burger.push("Bun");
            burger.push("Ketchup");
            burger.push("Mustard");
            burger.push("Mushrooms");
            burger.push(patty);
            burger.push("Cheddar");
            burger.push("Mozzarella");
            burger.push("Pepperjack");
            burger.push("Onions");
            burger.push("Tomato");
            burger.push("Lettuce");
            burger.push("Baron-Sauce");
            burger.push("Mayonnaise");
            burger.push("Bun");
            burger.push("Pickle");
        } else {
            burger.push("Bun");
            burger.push(patty);
            burger.push("Bun");
        }
        baronRecipe.push("Pickle");
        baronRecipe.push("Bun");
        baronRecipe.push("Mayonnaise");
        baronRecipe.push("Baron-Sauce");
        baronRecipe.push("Lettuce");
        baronRecipe.push("Tomato");
        baronRecipe.push("Onions");
        baronRecipe.push(patty);
        baronRecipe.push(patty);
        baronRecipe.push("Pepperjack");
        baronRecipe.push("Mozzarella");
        baronRecipe.push("Cheddar");
        baronRecipe.push(patty);
        baronRecipe.push("Mushrooms");
        baronRecipe.push("Mustard");
        baronRecipe.push("Ketchup");
        baronRecipe.push("Bun");
    }
    void changePatties(String pattyType) {
        MyStack store = new MyStack();
        while (!burger.isEmpty()) {
            if (burger.peek().equals(patty)) {
                burger.pop();
                store.push(pattyType);
            } else {
                store.push(burger.pop());
            }
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
        }
        patty = pattyType;
    }
    void addPatty() {
        if (pattyCount != 3) {
            MyStack store = new MyStack();
            while (!("Pepperjack Mozzarella Cheddar" + patty)
                    .contains(burger.peek())) {
                store.push(burger.pop());
            }
            burger.push(patty);
            pattyCount++;
            while (!store.isEmpty()) {
                burger.push(store.pop());
            }
        }
    }
    void addCategory(String type) {
        String category = switch (type) {
            case "Cheese" -> "Cheddar Mozzarella Pepperjack";
            case "Sauce" -> "Ketchup Mustard Mayonnaise Baron-Sauce";
            case "Veggies" -> "Lettuce Tomato Onions Pickle Mushrooms";
            default -> "";
        };
        MyStack store = new MyStack();
        MyStack baronStore = new MyStack();
        while (!burger.isEmpty()) {
            store.push(burger.pop());
        }
        while (!store.isEmpty()) {
            String item = baronRecipe.pop();
            if ("Veggie Chicken Beef".contains(item)) item = patty;
            baronStore.push(item);
            if (category.contains(item)) {
                burger.push(item);
            }
            if (item.equals(store.peek())) {
                burger.push(store.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baronRecipe.push(baronStore.pop());
        }
    }
    void removeCategory(String type) {
        String category = switch (type) {
            case "Cheese" -> "Cheddar Mozzarella Pepperjack";
            case "Sauce" -> "Ketchup Mustard Mayonnaise Baron-Sauce";
            case "Veggies" -> "Lettuce Tomato Onions Pickle Mushrooms";
            default -> "";
        };
        MyStack store = new MyStack();
        while (!burger.isEmpty()) {
            if (category.contains(burger.peek())) {
                burger.pop();
            } else {
                store.push(burger.pop());
            }
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
        }

    }
    void addIngredient(String type) {
        MyStack store = new MyStack();
        MyStack baronStore = new MyStack();
        while (!burger.isEmpty()) {
            store.push(burger.pop());
        }
        while (!store.isEmpty()) {
            String item = baronRecipe.pop();
            baronStore.push(item);
            if ("Veggie Chicken Beef".contains(item)) item = patty;
            if (item.equals(type)) {
                burger.push(item);
            }
            if (item.equals(store.peek())) {
                burger.push(store.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baronRecipe.push(baronStore.pop());
        }
    }
    void removeIngredient(String type) {
        MyStack store = new MyStack();
        while (!burger.isEmpty()) {
            if (burger.peek().equals(type)) {
                burger.pop();
            } else {
                store.push(burger.pop());
            }
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
        }
    }
    public String toString() {
        return burger.toString() + "\n";
    }

}

