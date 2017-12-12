package Logic;

import Windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run {
    private StringBuilder loged_in_user_name = new StringBuilder();
    private LoginWindows loginWindows;
    private RegisterWindoes registerWindoes;
    private ChooseWindows chooseWindows;
    private SearchWindows searchWindows;
    private TestWindows testWindows;
    private ChooseDicWindows chooseDicWindows;
    private TranslateWindows translateWindows;
    private Test test;
    private Translate translate;

    private ActionListener quit_test_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            testWindows.setVisible(false);
            testWindows.getButton_show_words_difficulty().setVisible(false);
            test.question.clear();
            reset();
        }
    };
    private Run() {
        loginWindows = new LoginWindows();
        registerWindoes = new RegisterWindoes();
        chooseWindows = new ChooseWindows();
        searchWindows = new SearchWindows();
        testWindows = new TestWindows();
        translateWindows = new TranslateWindows();
        chooseDicWindows = new ChooseDicWindows();

        chooseWindows.getButton_search_module().addActionListener(to_search_module);
        chooseWindows.getButton_test_module().addActionListener(to_test_module);
        chooseWindows.getButton_translate_module().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateWindows.setVisible(true);
                chooseWindows.setVisible(false);
            }
        });
        testWindows.getButton_quit_module().addActionListener(quit_test_button);
        translateWindows.getButton_quit_module().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseWindows.setVisible(true);
                translateWindows.setVisible(false);
            }
        });
        new Translate(translateWindows);

        new Register(registerWindoes, loginWindows);
        new Search(searchWindows, chooseWindows);
        test = new Test(testWindows, loged_in_user_name);
        new ChooseDic(chooseDicWindows, testWindows, test);
        new Login(loginWindows, registerWindoes, chooseWindows, loged_in_user_name);
    }

    private ActionListener to_search_module = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchWindows.setVisible(true);
            chooseWindows.setVisible(false);
        }
    };

    private ActionListener to_test_module = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseDicWindows.setVisible(true);
            chooseWindows.setVisible(false);
        }
    };

    private void reset() {
        testWindows.getTextArea_question().setText("");
        for (int i = 0; i < testWindows.getOption().length; i++) {
            testWindows.getOption()[i].setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Run();
    }
}
