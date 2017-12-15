package Logic;

import Windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run {
    private StringBuilder logInAccount = new StringBuilder();
    private LoginWindows loginWindows;
    private SignInWindoes signInWindoes;
    private ChooseWindows chooseWindows;
    private SearchWindows searchWindows;
    private TestWindows testWindows;
    private ChooseDicWindows chooseDicWindows;
    private TranslateWindows translateWindows;
    private Test test;

    private Run() {
        loginWindows = new LoginWindows();
        signInWindoes = new SignInWindoes();
        chooseWindows = new ChooseWindows();
        searchWindows = new SearchWindows();
        testWindows = new TestWindows();
        translateWindows = new TranslateWindows();
        chooseDicWindows = new ChooseDicWindows();

        chooseWindows.getSearchModuleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchWindows.setVisible(true);
                chooseWindows.setVisible(false);
            }
        });
        chooseWindows.getTestModuleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseDicWindows.setVisible(true);
                chooseWindows.setVisible(false);
            }
        });
        chooseWindows.getTranslateModuleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateWindows.setVisible(true);
                chooseWindows.setVisible(false);
            }
        });
        testWindows.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseWindows.setVisible(true);
                testWindows.setVisible(false);
                testWindows.getShowWordsDifficultyButton().setVisible(false);
                test.question.clear();
                reset();
            }
        });
        translateWindows.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseWindows.setVisible(true);
                translateWindows.setVisible(false);
            }
        });
        new Translate(translateWindows);
        new SignIn(signInWindoes, loginWindows);
        new Search(searchWindows, chooseWindows);
        test = new Test(testWindows, logInAccount);
        new ChooseDic(chooseDicWindows, testWindows, test);
        new Login(loginWindows, signInWindoes, chooseWindows, logInAccount);
    }

    private void reset() {
        testWindows.getQuestionArea().setText("");
        for (int i = 0; i < testWindows.getOptions().length; i++) {
            testWindows.getOptions()[i].setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Run();
    }
}
