package Logic;

import Windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Run {
    private String loged_in_user_name = null;
    private LoginWindows loginWindows;
    private RegisterWindoes registerWindoes;
    private ChooseWindows chooseWindows;
    private SearchWindows searchWindows;
    private static TestWindows testWindows;

    private Login login;
    private Register register;
    private Choose choose;
    private Search search;
    private Test test;


    //region login
    private ActionListener login_button_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check(loginWindows.getLogin_textField_user_name().getText(), loginWindows.getLogin_textField_password().getText()) == false) {
                loginWindows.getLogin_dialog().setVisible(true);
                record();
                return;
            }
            loged_in_user_name = new String(loginWindows.getLogin_textField_user_name().getText());
            System.out.println(loged_in_user_name);
            loginWindows.getLogin_label_dialog().setText("µ«¬º≥…π¶");
            chooseWindows.setVisible(true);
            loginWindows.setVisible(false);
            testWindows = new TestWindows("—Ó¡º≤©");
            test = new Test(testWindows, loged_in_user_name);
            testWindows.getTest_button_quit_test_module().addActionListener(quit_test_button);
        }
    };

    private int login_count = 0;

    private void record() {
        login_count++;
        if (login_count == 3) {
            login_count = 0;
            try {
                Thread.sleep(2000);
            } catch (Exception ss) {
            }
            System.exit(0);
        }
    }

    private boolean check(String user_name, String user_password) {
        if (Data.userInfo.containsKey(user_name) == true) {
            if (user_password.compareTo(Data.userInfo.get(user_name)) == 0)
                return true;
        }
        return false;
    }

    private ActionListener to_registerWindoes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerWindoes.setVisible(true);
            loginWindows.setVisible(false);
        }
    };
    //endregion

    //region choose
    private ActionListener quit_test_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            testWindows.setVisible(false);
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

    private ActionListener quit_search_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            searchWindows.setVisible(false);

        }
    };
    private ActionListener to_test_module = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            testWindows.setVisible(true);
            chooseWindows.setVisible(false);
            test.runTest();
        }
    };
    //endregion

    public static void main(String[] args) {
        new Run();
    }

    Run() {
        try {
            Data.read_word();
        } catch (SQLException s) {
            System.out.println("∂¡»°µ•¥  ß∞‹");
        }
        try {
            Data.read_userInfo();
        } catch (SQLException s) {
            System.out.println("∂¡»°”√ªß–≈œ¢ ß∞‹");
        }

        loginWindows = new LoginWindows("—Ó¡º≤©");
        login = new Login(loginWindows);
        loginWindows.getLogin_button_login().addActionListener(login_button_clicked);
        loginWindows.getLogin_button_register().addActionListener(to_registerWindoes);

        registerWindoes = new RegisterWindoes("—Ó¡º≤©");
        register = new Register(registerWindoes,loginWindows);

        searchWindows = new SearchWindows("—Ó¡º≤©");
        search = new Search(searchWindows);
        searchWindows.getSearch_button_quit_search_module().addActionListener(quit_search_button);

        chooseWindows = new ChooseWindows("—Ó¡º≤©");
        chooseWindows.getChoose_button_search_module().addActionListener(to_search_module);
        chooseWindows.getChoose_button_test_module().addActionListener(to_test_module);
    }
}
