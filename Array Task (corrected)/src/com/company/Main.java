package com.company;

/**
 * CHANGES
 * This program is second version of task where I changed Controller and Model.
 */

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);

        controller.processUser();
    }
}
