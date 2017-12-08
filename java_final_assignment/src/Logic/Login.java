package Logic;

import Windows.ChooseWindows;
import Windows.LoginWindows;
import Windows.RegisterWindoes;

import java.awt.event.*;

public class Login {
    private LoginWindows loginWindows;
    private StringBuilder loged_in_user_name;
    private RegisterWindoes registerWindoes;
    private ChooseWindows chooseWindows;
    private MouseListener login_button_visible_password = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            loginWindows.getTextField_password().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            loginWindows.getTextField_password().setEchoChar('*');
        }
    };
    private WindowListener login_dialog_clicked = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            loginWindows.getDialog().setVisible(false);
        }
    };
    private int login_count = 0;
    private ActionListener login_button_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (SqlHelper.check_userInfo(loginWindows.getTextField_user_name().getText(), loginWindows.getTextField_password().getText()) == false) {
                loginWindows.getDialog().setVisible(true);
                record();
                return;
            }
            loginWindows.getButton_login().removeActionListener(login_button_clicked);
            loged_in_user_name.append(loginWindows.getTextField_user_name().getText());
            System.out.println(loged_in_user_name);
            loginWindows.getLabel_dialog().setText("µÇÂ¼³É¹¦");
            chooseWindows.setVisible(true);
            loginWindows.setVisible(false);

        }
    };
    private ActionListener to_registerWindoes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerWindoes.setVisible(true);
            loginWindows.setVisible(false);
        }
    };

    public Login(LoginWindows loginWindows, RegisterWindoes registerWindoes, ChooseWindows chooseWindows, StringBuilder loged_in_user_name) {
        this.loginWindows = loginWindows;
        this.registerWindoes = registerWindoes;
        this.chooseWindows = chooseWindows;
        this.loged_in_user_name = loged_in_user_name;
        loginWindows.getButton_login().addActionListener(login_button_clicked);
        loginWindows.getButton_register().addActionListener(to_registerWindoes);
        loginWindows.getDialog().addWindowListener(login_dialog_clicked);
        loginWindows.getButton_visible_password().addMouseListener(login_button_visible_password);
    }

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

}
