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
        baronRecipe.push("Bun");
        baronRecipe.push("Ketchup");
        baronRecipe.push("Mustard");
        baronRecipe.push("Mushrooms");
        baronRecipe.push(patty);
        baronRecipe.push("Cheddar");
        baronRecipe.push("Mozzarella");
        baronRecipe.push("Pepperjack");
        baronRecipe.push(patty);
        baronRecipe.push(patty);
        baronRecipe.push("Onions");
        baronRecipe.push("Tomato");
        baronRecipe.push("Lettuce");
        baronRecipe.push("Baron-Sauce");
        baronRecipe.push("Mayonnaise");
        baronRecipe.push("Bun");
        baronRecipe.push("Pickle");
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

        while (!baronRecipe.isEmpty()) {
            String item = baronRecipe.pop();
            if ("Veggie Chicken Beef".contains(item)) item = patty;
            baronStore.push(item);
            if (category.contains(item)) {
                store.push(item);
            }
            if (item.equals(burger.peek())) {
                store.push(burger.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baronRecipe.push(baronStore.pop());
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
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
        while (!baronRecipe.isEmpty()) {
            String item = baronRecipe.pop();
            baronStore.push(item);
            if ("Veggie Chicken Beef".contains(item)) item = patty;
            if (item.equals(type)) {
                store.push(item);
            }
            if (item.equals(burger.peek())) {
                store.push(burger.pop());
            }
        }
        while (!baronStore.isEmpty()) {
            baronRecipe.push(baronStore.pop());
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
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

