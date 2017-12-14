package controller;

import services.*;
import view.View;

import java.util.Locale;
import java.util.Scanner;

import static view.ViewConstants.*;

public class UserController {

    private Scanner scanner = new Scanner(System.in);
    private View view;
    private AnswerService answerService;
    private QuestionService questionService;
    private TestService testService;
    private JDBCDaoFactory jdbcDaoFactory;

    public UserController() throws ClassNotFoundException {
        String language = chooseCountry();
        jdbcDaoFactory = new JDBCDaoFactory(language);
        answerService = new AnswerService(jdbcDaoFactory.createAnswerDao());
        questionService = new QuestionService(jdbcDaoFactory.createQuestionDao());
        testService = new TestService(jdbcDaoFactory.createTestDao());
        view = new View(new Locale(language));
    }

    private String chooseCountry(){
        System.out.println("Choose country: \n\t1.Ukraine \n\t2.England");
        int choose = inputInt();
        if(choose == 1)
            return "uk";
        return "en";
    }

    public void userWork(){
        int choose = 0;
        while (choose != 3) {
            view.printMessageFromBundle(CHOOSE_ACT);
            choose = inputInt();
            if (choose == 1)
                createTest();
            else  if(choose == 2)
                passTest();
            else if(choose != 3)view.printMessageFromBundle(WRONG);
        }
    }

    private int inputInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (IllegalArgumentException ex) {
                view.printMessageFromBundle(WRONG);
            }
        }
    }

    private void createTest(){
        view.printMessageFromBundle(INPUT_NAME);
        String name = scanner.next();
        testService.add(name);
        view.printMessageFromBundle(INPUT_QUEST_N);
        int idTest = testService.getListOfElements().stream()
                .filter(test -> test.getTopic().equals(name))
                .findFirst().get().getId();
        int numberOfQ = inputInt();
        inputQuestions(numberOfQ, idTest);
    }

    private void inputQuestions(int number, int id){
        while (number > 0){
            view.printMessageFromBundle(INPUT_TEXT_QUEST);
            String text = scanner.next();
            view.printMessageFromBundle(COMPLEXITY);
            int complexity = inputInt();
            questionService.add(text,id,complexity);
            view.printMessageFromBundle(INPUT_ANSWER_N);
            int idQuestion = questionService.getListOfElements().stream()
                    .filter(question -> question.getText().equals(text))
                    .findFirst().get().getId();
            int numberOfA = inputInt();
            inputAnswers(numberOfA, idQuestion);
            number--;
        }
    }

    private void inputAnswers(int number, int id){
        while (number > 0){
            view.printMessageFromBundle(INPUT_TEXT_ANSWER);
            String text = scanner.next();
            view.printMessageFromBundle(RIGTH);
            boolean right = scanner.next().equals("+");
            answerService.add(text,id,right);
            number--;
        }
    }

    private void passTest(){
        view.printMessageFromBundle(AVAILABLE_TESTS);
        testService.getListOfElements().forEach(System.out::println);
        view.printMessageFromBundle(CHOOSE_TEST);
        int id = inputInt();
        questionService.getListOfElements().stream()
                .filter(question -> question.getTestId() == id)
                .forEach(question -> {
                    if (question.getAnswers().size() == 1) {
                        view.printMessageFromBundle(INPUT_ANSWER);
                        view.printMessage(question.getText());
                        view.printMessage(String.valueOf(answerService.isRightAnswer
                                (question.getAnswers().get(0).getId(), scanner.next())));
                    } else {
                        view.printMessageFromBundle(CHOOSE_ANSWER);
                        view.printMessage(question.getText());
                        question.getAnswers().forEach(System.out::println);
                        view.printMessage(String.valueOf(answerService.isRightAnswer(inputInt())));
                    }
            });
    }
}
