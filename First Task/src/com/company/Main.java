
package com.company;

/**
 * Main program class
 */
public class Main {

    public static void main(String[] args) {

        //Initialization of all objects
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);

        //Run
        controller.processUser();
    }
}
