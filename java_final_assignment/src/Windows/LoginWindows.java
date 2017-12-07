package Windows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginWindows extends MyFrame{
    private Label login_label_user_name;
    private Label login_label_user_passwords;
    private TextField login_textField_user_name;
    private TextField login_textField_password;
    private Button login_button_login;
    private Button login_button_register;
    private Button login_button_visible_password;
    private Dialog login_dialog;
    private Label login_label_dialog;

    public TextField getLogin_textField_user_name() {
        return login_textField_user_name;
    }
    public TextField getLogin_textField_password() {
        return login_textField_password;
    }
    public Button getLogin_button_login() {
        return login_button_login;
    }
    public Button getLogin_button_register() {
        return login_button_register;
    }
    public Button getLogin_button_visible_password() {
        return login_button_visible_password;
    }
    public Label getLogin_label_dialog() {
        return login_label_dialog;
    }
    public Dialog getLogin_dialog() {
        return login_dialog;
    }


    @Override
    public void print(Graphics g) {
        super.print(g);
        super.paint(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\VULCAN\\Desktop\\work.jpg"));//×¢ÒâµØÖ·µÄÐÎÊ½£¬±ÊÕßÊÇÔÚMacÉÏÐ´µÄ
            g.drawImage(image, 0, 0, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LoginWindows(String s)
    {
        super(s);
        init();
        this.setVisible(true);
    }

    private void init()
    {
        /*this.setLayout(null);
        this.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);*/
        login_label_user_name = new Label("  ÕÊºÅ");
        login_label_user_name.setBounds(100, 90, 50, 20);

        login_label_user_passwords = new Label("  ÃÜÂë");
        login_label_user_passwords.setBounds(100, 130, 50, 20);

        login_textField_user_name = new TextField();
        login_textField_user_name.setBounds(150, 90, 160, 20);

        login_textField_password = new TextField();
        login_textField_password.setBounds(150, 130, 160, 20);
        //login_textField_password.setEchoChar('*');

        login_button_login = new Button("µÇÂ¼");
        login_button_login.setBounds(110, 190, 90, 30);

        login_button_register = new Button("×¢²á");
        login_button_register.setBounds(240, 190, 90, 30);

        login_button_visible_password = new Button("ÏÔÊ¾ÃÜÂë");
        login_button_visible_password.setBounds(320, 130, 60, 20);

        login_dialog = new Dialog(this, "ÑîÁ¼²©");
        login_dialog.setBounds(729, 360, 240, 148);
        login_dialog.setLayout(null);

        login_label_dialog = new Label("µÇÂ¼Ê§°Ü");
        login_label_dialog.setBounds(90, 60, 50, 20);

        login_dialog.add(login_label_dialog);

        this.add(login_label_user_name);
        this.add(login_label_user_passwords);
        this.add(login_textField_user_name);
        this.add(login_textField_password);
        this.add(login_button_login);
        this.add(login_button_register);
        //this.add(login_button_visible_password);

    }
}
