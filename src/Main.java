public class Main {
    public static void main(String[] args) {
//        testMyStack();
//        testBurger();
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
