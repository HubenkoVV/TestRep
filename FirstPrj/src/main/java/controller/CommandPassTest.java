package controller;

public class CommandPassTest extends CommandTest{

    public CommandPassTest(Test test) {
        super(test);
    }

    void execute() {
        test.passTest();
    }
}
