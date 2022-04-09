class Burger {
    public static int orders = 0;
    int orderNum;
    int pattyCount = 1;
    String pattyType = "Beef";
    MyStack burger;
    MyStack baronRecipe = new MyStack();

    public Burger(boolean theWorks) {
        burger = new MyStack();
        orderNum = orders;
        orders++;
        if (theWorks) {
            burger.push("Bun");
            burger.push("Ketchup");
            burger.push("Mustard");
            burger.push("Mushrooms");
            burger.push(pattyType);
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
            burger.push(pattyType);
            burger.push("Bun");
        }
        baronRecipe.push("Pickle");
        baronRecipe.push("Bun");
        baronRecipe.push("Mayonnaise");
        baronRecipe.push("Baron-Sauce");
        baronRecipe.push("Lettuce");
        baronRecipe.push("Tomato");
        baronRecipe.push("Onions");
        baronRecipe.push(pattyType);
        baronRecipe.push(pattyType);
        baronRecipe.push("Pepperjack");
        baronRecipe.push("Mozzarella");
        baronRecipe.push("Cheddar");
        baronRecipe.push(pattyType);
        baronRecipe.push("Mushrooms");
        baronRecipe.push("Mustard");
        baronRecipe.push("Ketchup");
        baronRecipe.push("Bun");
    }
    void changePatties(String thePattyType) {
        MyStack store = new MyStack();
        while (!burger.isEmpty()) {
            if (burger.peek().equals(pattyType)) {
                burger.pop();
                store.push(thePattyType);
            } else {
                store.push(burger.pop());
            }
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
        }
        pattyType = thePattyType;
    }
    void addPatty() {
        if (pattyCount != 3) {
            MyStack store = new MyStack();
            while (!("Pepperjack Mozzarella Cheddar" + pattyType)
                    .contains(burger.peek())) {
                store.push(burger.pop());
            }
            burger.push(pattyType);
            pattyCount++;
            while (!store.isEmpty()) {
                burger.push(store.pop());
            }
        }
    }
    void addCategory(String category) {
        String list = switch (category) {
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
            if ("Veggie Chicken Beef".contains(item)) item = pattyType;
            baronStore.push(item);
            if (list.contains(item)) {
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
    void removeCategory(String category) {
        String list = switch (category) {
            case "Cheese" -> "Cheddar Mozzarella Pepperjack";
            case "Sauce" -> "Ketchup Mustard Mayonnaise Baron-Sauce";
            case "Veggies" -> "Lettuce Tomato Onions Pickle Mushrooms";
            default -> "";
        };
        MyStack store = new MyStack();
        while (!burger.isEmpty()) {
            if (list.contains(burger.peek())) {
                burger.pop();
            } else {
                store.push(burger.pop());
            }
        }
        while (!store.isEmpty()) {
            burger.push(store.pop());
        }

    }
    void addIngredient(String ingredient) {
        MyStack store = new MyStack();
        MyStack baronStore = new MyStack();
        while (!burger.isEmpty()) {
            store.push(burger.pop());
        }
        while (!store.isEmpty()) {
            String item = baronRecipe.pop();
            baronStore.push(item);
            if ("Veggie Chicken Beef".contains(item)) item = pattyType;
            if (item.equals(ingredient)) {
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

