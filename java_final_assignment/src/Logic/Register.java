package Logic;

import Windows.LoginWindows;
import Windows.RegisterWindoes;

import java.awt.event.*;

public class Register {
    private RegisterWindoes registerWindoes;
    private LoginWindows loginWindows;

    private WindowListener dialog_button = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            registerWindoes.getDialog().setVisible(false);
        }
    };
    private MouseListener visible_password_button_clicked = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            registerWindoes.getTextField_passwords_input().setEchoChar('\0');
            registerWindoes.getTextField_passwords_confirm().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            registerWindoes.getTextField_passwords_input().setEchoChar('*');
            registerWindoes.getTextField_passwords_confirm().setEchoChar('*');
        }
    };
    private ActionListener rigister_botton_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check_register()) {
                registerWindoes.getLabel_dialog().setText("×¢²á³É¹¦");
                registerWindoes.getDialog().setVisible(true);
                SqlHelper.write_userInfo(registerWindoes.getTextField_user_name().getText(), registerWindoes.getTextField_passwords_input().getText());
                loginWindows.setVisible(true);
                clean_register();
                System.out.println("×¢²á³É¹¦");
                registerWindoes.getDialog().setVisible(false);
                registerWindoes.setVisible(false);
            } else {
                registerWindoes.getDialog().setVisible(true);
                System.out.println("×¢²áÊ§°Ü");
            }
        }
    };

    private ActionListener quit_register = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginWindows.setVisible(true);
            clean_register();
            registerWindoes.setVisible(false);
        }
    };

    public Register(RegisterWindoes registerWindoes, LoginWindows loginWindows) {
        this.registerWindoes = registerWindoes;
        this.loginWindows = loginWindows;
        registerWindoes.getButton_visible_password().addMouseListener(visible_password_button_clicked);
        registerWindoes.getDialog().addWindowListener(dialog_button);
        registerWindoes.getButton_register().addActionListener(rigister_botton_clicked);
        registerWindoes.getButton_quit_register().addActionListener(quit_register);
    }

    private boolean check_register() {
        return SqlHelper.check_Info(registerWindoes.getTextField_user_name().getText()) == false &&
                registerWindoes.getTextField_passwords_input().getText().compareTo(registerWindoes.getTextField_passwords_confirm().getText()) == 0 &&
                registerWindoes.getTextField_user_name().getText().compareTo("") != 0 &&
                limit_password(registerWindoes.getTextField_passwords_input().getText()) == true;
    }

    private boolean limit_password(String PW) {
        String regex = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{7,11}";
        return PW.matches(regex);
    }

    private void clean_register() {
        registerWindoes.getTextField_user_name().setText(" ");
        registerWindoes.getTextField_passwords_input().setText(" ");
        registerWindoes.getTextField_passwords_confirm().setText(" ");
        registerWindoes.getTextField_user_name().setText("");
        registerWindoes.getTextField_passwords_input().setText("");
        registerWindoes.getTextField_passwords_confirm().setText("");
    }
}


