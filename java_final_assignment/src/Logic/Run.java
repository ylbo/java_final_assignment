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

    //region choose
    private ActionListener quit_test_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            chooseDicWindows.setVisible(false);
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

    Run() {
        loginWindows = new LoginWindows();
        registerWindoes = new RegisterWindoes();
        new Register(registerWindoes, loginWindows);

        chooseWindows = new ChooseWindows();
        chooseWindows.getButton_search_module().addActionListener(to_search_module);
        chooseWindows.getButton_test_module().addActionListener(to_test_module);

        searchWindows = new SearchWindows();
        new Search(searchWindows, chooseWindows);

        testWindows = new TestWindows();
        test = new Test(testWindows, loged_in_user_name);
        testWindows.getButton_quit_module().addActionListener(quit_test_button);

        chooseDicWindows = new ChooseDicWindows();
        new ChooseDic(chooseDicWindows, testWindows, test);

        new Login(loginWindows, registerWindoes, chooseWindows, loged_in_user_name);
    }

    //endregion
    public static void main(String[] args) {
        new Run();
    }
}
