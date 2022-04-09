class Burger {
    public static int orders = 0;
    int orderNum = 0;
    int pattyCount = 1;
    String pattyType = "Beef";
    MyStack burger;
    MyStack baron = new MyStack();

    public Burger(boolean theWorks) {
        burger = new MyStack();
        orderNum = orders;
        orders++;
        baron.push("Pickle");
        baron.push("Bun");
        baron.push("Mayonnaise");
        baron.push("Baron-Sauce");
        baron.push("Lettuce");
        baron.push("Tomato");
        baron.push("Onions");
        baron.push("Pepperjack");
        baron.push("Mozzarella");
        baron.push("Cheddar");
        baron.push(pattyType);
        baron.push("Mushrooms");
        baron.push("Mustard");
        baron.push("Ketchup");
        baron.push("Bun");
        if (theWorks) {
            MyStack store = new MyStack();
            while (!baron.isEmpty()) {
                String holder = baron.pop();
                burger.push(holder);
                store.push(holder);
            }
            while (!store.isEmpty()) {
                baron.push(store.pop());
            }
        } else {
            burger.push("Bun");
            burger.push(pattyType);
            burger.push("Bun");
        }
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
            String item = baron.pop();
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
            baron.push(baronStore.pop());
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
            String item = baron.pop();
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
            baron.push(baronStore.pop());
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

