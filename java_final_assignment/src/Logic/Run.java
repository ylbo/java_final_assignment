package Logic;

import Windows.*;

import java.awt.event.*;
import java.sql.SQLException;

public class Run {

    private static LoginWindows loginWindows;
    private static RegisterWindoes registerWindoes;
    private static ChooseWindows chooseWindows;
    private static SearchWindows searchWindows;
    private static TestWindows testWindows;

    private static Login login;
    private static Register register;
    private static Choose choose;
    private static Search search;
    private static Test test;

    //region rigister
    private static ActionListener quit_register=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginWindows.setVisible(true);
            register.clean_register();
            registerWindoes.setVisible(false);
        }
    };


    private static ActionListener rigister_botton_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check_register()) {
                registerWindoes.getRegister_label_dialog().setText("◊¢≤·≥…π¶");
                registerWindoes.getRegister_dialog().setVisible(true);

                Data.write_userInfo(registerWindoes.getRegister_textField_user_name().getText(), registerWindoes.getRegister_textField_passwords_input().getText());
                Data.userInfo.put(registerWindoes.getRegister_textField_user_name().getText(), registerWindoes.getRegister_textField_passwords_input().getText());
                loginWindows.setVisible(true);
                clean_register();
                System.out.println("◊¢≤·≥…π¶");
                registerWindoes.getRegister_dialog().setVisible(false);
                registerWindoes.setVisible(false);
            } else {
                registerWindoes.getRegister_dialog().setVisible(true);
                System.out.println("◊¢≤· ß∞‹");
            }
        }
    };

    static private boolean check_register() {
        return if_register_success(registerWindoes.getRegister_textField_user_name().getText()) == false &&
                registerWindoes.getRegister_textField_passwords_input().getText().compareTo(registerWindoes.getRegister_textField_passwords_confirm().getText())==0 &&
                registerWindoes.getRegister_textField_user_name().getText().compareTo("") != 0 &&
                limit_password(registerWindoes.getRegister_textField_passwords_input().getText()) == true;
    }

    static private boolean limit_password(String PW) {
        String regex = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{7,11}";
        return PW.matches(regex);
    }

    static private void clean_register() {
        registerWindoes.getRegister_textField_user_name().setText(" ");
        registerWindoes.getRegister_textField_passwords_input().setText(" ");
        registerWindoes.getRegister_textField_passwords_confirm().setText(" ");
        registerWindoes.getRegister_textField_user_name().setText("");
        registerWindoes.getRegister_textField_passwords_input().setText("");
        registerWindoes.getRegister_textField_passwords_confirm().setText("");
    }

    static private boolean if_register_success(String user_name) {
        return Data.userInfo.containsKey(user_name);
    }
    //endregion

    //region login
    private static ActionListener login_button_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check(loginWindows.getLogin_textField_user_name().getText(), loginWindows.getLogin_textField_password().getText()) == false) {
                loginWindows.getLogin_dialog().setVisible(true);
                record();
                return;
            }
            Data.loged_in_user_name = loginWindows.getLogin_textField_user_name().getText();
            loginWindows.getLogin_label_dialog().setText("µ«¬º≥…π¶");
            chooseWindows.setVisible(true);
            loginWindows.setVisible(false);
        }
    };

    private static int login_count = 0;

    static private void record() {
        login_count++;
        if (login_count == 3) {
            login_count = 0;
            try {
                Thread.sleep(2000);
            } catch (Exception ss)
            { }
            System.exit(0);
        }
    }

    static private boolean check(String user_name, String user_password) {
        if(Data.userInfo.containsKey(user_name)==true)
        {
            if (user_password.compareTo(Data.userInfo.get(user_name)) == 0)
                return true;
        }
        return false;
    }

    private static ActionListener to_registerWindoes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerWindoes.setVisible(true);
            loginWindows.setVisible(false);
        }
    };
    //endregion

    //region choose
    private static ActionListener quit_test_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            testWindows.setVisible(false);
            test.reset();
        }
    };

    private static ActionListener to_search_module = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchWindows.setVisible(true);
            chooseWindows.setVisible(false);
        }
    };

    private static ActionListener quit_search_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            searchWindows.setVisible(false);

        }
    };
    private static ActionListener to_test_module = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            testWindows.setVisible(true);
            chooseWindows.setVisible(false);
            test.runTest();
        }
    };
    //endregion

    public static void main(String[] args) {
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
        register = new Register(registerWindoes);
        registerWindoes.getRegister_button_register().addActionListener(rigister_botton_clicked);
        registerWindoes.getRegister_button_quit_register().addActionListener(quit_register);


        chooseWindows = new ChooseWindows("—Ó¡º≤©");
        choose = new Choose(chooseWindows);
        chooseWindows.getChoose_button_search_module().addActionListener(to_search_module);
        chooseWindows.getChoose_button_test_module().addActionListener(to_test_module);

        searchWindows = new SearchWindows("—Ó¡º≤©");
        search = new Search(searchWindows);
        searchWindows.getSearch_button_quit_search_module().addActionListener(quit_search_button);

        testWindows = new TestWindows("—Ó¡º≤©");
        test = new Test(testWindows);
        testWindows.getTest_button_quit_test_module().addActionListener(quit_test_button);

    }
}
