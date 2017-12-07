package Logic;

import Windows.LoginWindows;
import Windows.RegisterWindoes;

import java.awt.event.*;

public class Register {
    private RegisterWindoes registerWindoes;
    private LoginWindows loginWindows;

    public Register(RegisterWindoes registerWindoes, LoginWindows loginWindows) {
        this.registerWindoes = registerWindoes;
        this.loginWindows = loginWindows;
        registerWindoes.getRegister_button_visible_password().addMouseListener(visible_password_button_clicked);
        registerWindoes.getRegister_dialog().addWindowListener(dialog_button);
        registerWindoes.getRegister_button_register().addActionListener(rigister_botton_clicked);
        registerWindoes.getRegister_button_quit_register().addActionListener(quit_register);
    }

    private WindowListener dialog_button = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            registerWindoes.getRegister_dialog().setVisible(false);
        }
    };

    private MouseListener visible_password_button_clicked = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            registerWindoes.getRegister_textField_passwords_input().setEchoChar('\0');
            registerWindoes.getRegister_textField_passwords_confirm().setEchoChar('\0');
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            registerWindoes.getRegister_textField_passwords_input().setEchoChar('*');
            registerWindoes.getRegister_textField_passwords_confirm().setEchoChar('*');
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

    private ActionListener rigister_botton_clicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check_register()) {
                registerWindoes.getRegister_label_dialog().setText("×¢²á³É¹¦");
                registerWindoes.getRegister_dialog().setVisible(true);

                Data.write_userInfo(registerWindoes.getRegister_textField_user_name().getText(), registerWindoes.getRegister_textField_passwords_input().getText());
                Data.userInfo.put(registerWindoes.getRegister_textField_user_name().getText(), registerWindoes.getRegister_textField_passwords_input().getText());
                loginWindows.setVisible(true);
                clean_register();
                System.out.println("×¢²á³É¹¦");
                registerWindoes.getRegister_dialog().setVisible(false);
                registerWindoes.setVisible(false);
            } else {
                registerWindoes.getRegister_dialog().setVisible(true);
                System.out.println("×¢²áÊ§°Ü");
            }
        }
    };

    private boolean check_register() {
        return if_register_success(registerWindoes.getRegister_textField_user_name().getText()) == false &&
                registerWindoes.getRegister_textField_passwords_input().getText().compareTo(registerWindoes.getRegister_textField_passwords_confirm().getText()) == 0 &&
                registerWindoes.getRegister_textField_user_name().getText().compareTo("") != 0 &&
                limit_password(registerWindoes.getRegister_textField_passwords_input().getText()) == true;
    }

    private boolean limit_password(String PW) {
        String regex = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{7,11}";
        return PW.matches(regex);
    }

    private void clean_register() {
        registerWindoes.getRegister_textField_user_name().setText(" ");
        registerWindoes.getRegister_textField_passwords_input().setText(" ");
        registerWindoes.getRegister_textField_passwords_confirm().setText(" ");
        registerWindoes.getRegister_textField_user_name().setText("");
        registerWindoes.getRegister_textField_passwords_input().setText("");
        registerWindoes.getRegister_textField_passwords_confirm().setText("");
    }

    private boolean if_register_success(String user_name) {
        return Data.userInfo.containsKey(user_name);
    }
}


