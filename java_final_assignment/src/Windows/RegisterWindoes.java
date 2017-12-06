package Windows;

import java.awt.*;
import java.awt.event.WindowAdapter;

public class RegisterWindoes extends MyFrame {
    private Label register_label_user_name;
    private Label register_label_passwords_input;
    private Label register_label_passwords_confirm;
    private TextField register_textField_user_name;
    private TextField register_textField_passwords_input;
    private TextField register_textField_passwords_confirm;
    private Button register_button_register;
    private Button register_button_quit_register;
    private Button register_button_visible_password;
    private Dialog register_dialog;
    private Label register_label_dialog;
    public TextField getRegister_textField_user_name() {
        return register_textField_user_name;
    }

    public TextField getRegister_textField_passwords_input() {
        return register_textField_passwords_input;
    }

    public TextField getRegister_textField_passwords_confirm() {
        return register_textField_passwords_confirm;
    }

    public Button getRegister_button_register() {
        return register_button_register;
    }

    public Button getRegister_button_quit_register() {
        return register_button_quit_register;
    }

    public Button getRegister_button_visible_password() {
        return register_button_visible_password;
    }

    public Dialog getRegister_dialog() {
        return register_dialog;
    }

    public Label getRegister_label_dialog() {
        return register_label_dialog;
    }
    public RegisterWindoes(String s)
    {
        super(s);
        init();
    }
    
    private void init()
    {
        register_label_user_name = new Label("–¬”√ªß√˚");
        register_label_user_name.setBounds(80, 70, 50, 20);
        register_label_passwords_input = new Label(" ‰»Î√‹¬Î");
        register_label_passwords_input.setBounds(80, 110, 50, 20);
        register_label_passwords_confirm = new Label("»∑»œ√‹¬Î");
        register_label_passwords_confirm.setBounds(80, 150, 50, 20);

        register_textField_user_name = new TextField();
        register_textField_user_name.setBounds(150, 70, 160, 20);
        register_textField_passwords_input = new TextField();
        //register_textField_passwords_input.setEchoChar('*');
        register_textField_passwords_input.setBounds(150, 110, 160, 20);
        register_textField_passwords_confirm = new TextField();
        //register_textField_passwords_confirm.setEchoChar('*');
        register_textField_passwords_confirm.setBounds(150, 150, 160, 20);

        register_button_visible_password = new Button("œ‘ æ√‹¬Î");
        register_button_visible_password.setBounds(320, 110, 60, 20);
        register_button_register = new Button("◊¢≤·");
        register_button_register.setBounds(110, 190, 90, 30);
        register_button_quit_register = new Button("ÕÀ≥ˆ◊¢≤·");
        register_button_quit_register.setBounds(240, 190, 90, 30);

        register_dialog = new Dialog(this, "—Ó¡º≤©");
        register_dialog.setLayout(null);
        register_dialog.setBounds(729, 360, 240, 148);
        
        register_label_dialog = new Label("◊¢≤· ß∞‹");
        register_label_dialog.setBounds(90, 60, 50, 20);
        
        register_dialog.add(register_label_dialog);

        this.add(register_label_user_name);
        this.add(register_label_passwords_input);
        this.add(register_label_passwords_confirm);
        this.add(register_textField_user_name);
        this.add(register_textField_passwords_input);
        this.add(register_textField_passwords_confirm);
        this.add(register_button_register);
        this.add(register_button_quit_register);
        //this.add(register_button_visible_password);

    }
}
