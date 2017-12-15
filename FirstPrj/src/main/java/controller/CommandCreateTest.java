package controller;

class CommandCreateTest extends CommandTest{

    public CommandCreateTest(Test test) {
        super(test);
    }

    void execute(){
            test.createTest();
    };
}
