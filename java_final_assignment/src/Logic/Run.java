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
    private Test test;

    private ActionListener quit_test_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            testWindows.setVisible(false);
            testWindows.getButton_show_words_difficulty().setVisible(false);
            test.question.clear();
            test.reset();
        }
    };

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

    private Run() {
        loginWindows = new LoginWindows();
        registerWindoes = new RegisterWindoes();
        chooseWindows = new ChooseWindows();
        searchWindows = new SearchWindows();
        testWindows = new TestWindows();
        chooseDicWindows = new ChooseDicWindows();

        chooseWindows.getButton_search_module().addActionListener(to_search_module);
        chooseWindows.getButton_test_module().addActionListener(to_test_module);
        testWindows.getButton_quit_module().addActionListener(quit_test_button);

        new Register(registerWindoes, loginWindows);
        new Search(searchWindows, chooseWindows);
        test = new Test(testWindows, loged_in_user_name);
        new ChooseDic(chooseDicWindows, testWindows, test);
        new Login(loginWindows, registerWindoes, chooseWindows, loged_in_user_name);
    }

    public static void main(String[] args) {
        new Run();
    }
}
