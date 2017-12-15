package controller;

abstract class CommandTest {
    Test test;

    CommandTest(Test test){
        this.test = test;
    }
    abstract void execute();
}
