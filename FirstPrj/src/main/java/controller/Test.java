package controller;

import services.*;
import view.View;
import java.util.Scanner;
import static view.ViewConstants.*;

public class Test {

    private JDBCDaoFactory jdbcDaoFactory;
    private AnswerService answerService;
    private QuestionService questionService;
    private TestService testService;
    private View view;
    private Scanner scanner;

    Test(JDBCDaoFactory jdbcDaoFactory, View view, Scanner scanner) throws ClassNotFoundException {
        this.jdbcDaoFactory = jdbcDaoFactory;
        answerService = new AnswerService(jdbcDaoFactory.createAnswerDao());
        questionService = new QuestionService(jdbcDaoFactory.createQuestionDao());
        testService = new TestService(jdbcDaoFactory.createTestDao());
        this.view = view;
        this.scanner = scanner;
    }

    void createTest() {
        view.printMessageFromBundle(INPUT_NAME);
        String name = scanner.next();
        testService.add(name);
        view.printMessageFromBundle(INPUT_QUEST_N);
        int idTest = testService.getListOfElements().stream()
                .filter(test -> test.getTopic().equals(name))
                .findFirst().get().getId();
        int numberOfQ = inputInt();
        inputQuestions(numberOfQ, idTest);
        view.printMessageFromBundle(ADDED);
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

    void passTest(){
        view.printMessageFromBundle(AVAILABLE_TESTS);
        testService.getListOfElements().forEach(System.out::println);
        view.printMessageFromBundle(CHOOSE_TEST);
        int id = inputInt();
        view.printMessageFromBundle(SORTED);
        questionService.getSortedList(scanner.next().equals("+"), jdbcDaoFactory).stream()
                .filter(question -> question.getTestId() == id)
                .forEach(question -> {
                    if (question.getAnswers().size() == 1) {
                        view.printMessageFromBundle(INPUT_ANSWER);
                        view.printMessage(question.toString());
                        view.printMessage(String.valueOf(answerService.isRightAnswer
                                (question.getAnswers().get(0).getId(), question.getId(), scanner.next())));
                    } else {
                        view.printMessageFromBundle(CHOOSE_ANSWER);
                        view.printMessage(question.toString());
                        question.getAnswers().forEach(System.out::println);
                        view.printMessage(String.valueOf(answerService.isRightAnswer(question.getId(), inputInt())));
                    }
                });
    }

    private int inputInt() {
        while (true) {
            try {
                int i = scanner.nextInt();
                return i;
            } catch (IllegalArgumentException ex) {
                view.printMessageFromBundle(WRONG);
            }
        }
    }
}
