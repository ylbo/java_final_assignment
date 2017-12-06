package old;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MyWindows {

    //记录当前成功登录的用户名
    private String loged_in_user_name = null;

    //<editor-fold desc="窗体组件">
    private MyFrame f;
    //登陆界面组件
    private Label login_label_user_name;
    private Label login_label_user_passwords;
    private TextField login_textField_user_name;
    private TextField login_textField_password;
    private Button login_button_login;
    private Button login_button_register;
    private Button login_button_visible_password;
    //注册界面组件
    private Label register_label_user_name;
    private Label register_label_passwords_input;
    private Label register_label_passwords_confirm;
    private TextField register_textField_user_name;
    private TextField register_textField_passwords_input;
    private TextField register_textField_passwords_confirm;
    private Button register_button_register;
    private Button register_button_quit_register;
    private Button register_button_visible_password;
    //选择界面组件
    private Button choose_button_search_module;
    private Button choose_button_test_module;
    //查找单词界面组件
    private Label search_label_find;
    private TextField search_textField_find;
    private Button search_button_find_word;
    private TextArea search_textArea_meaning;
    private Button search_button_quit_search_module;
    //考试界面组件
    private TextArea test_textArea_question;
    private TextField test_textField_answer;
    private Button test_button_submit;
    private Button test_button_show_words_difficulty;
    private Button test_button_put_grade;
    private Button test_button_quit_test_module;
    //消息提示框
    private Dialog login_dialog;
    private Dialog register_dialog;
    private Dialog test_finish_dialog;
    private Dialog test_result_dialog;
    private Label login_label_dialog;
    private Label register_label_dialog;
    private Label test_finish_label_dialog;
    private Label test_result_label_dialog;
    //</editor-fold>

    MyWindows() {
        try {
            data.read_word();
        } catch (SQLException s) {
            System.out.println("读取单词失败");
        }
        try {
            data.read_userInfo();
        } catch (SQLException s) {
            System.out.println("读取用户信息失败");
        }
        inti();
    }

    private void inti() {
        f = new MyFrame("杨良博");
        f.setLayout(null);
        f.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);

        // 登陆界面组件
        login_label_user_name = new Label("  帐号");
        login_label_user_name.setBounds(100, 90, 50, 20);
        login_label_user_passwords = new Label("  密码");
        login_label_user_passwords.setBounds(100, 130, 50, 20);

        login_textField_user_name = new TextField();
        login_textField_user_name.setBounds(150, 90, 160, 20);
        login_textField_password = new TextField();
        login_textField_password.setBounds(150, 130, 160, 20);
        login_textField_password.setEchoChar('*');

        login_button_login = new Button("登录");
        login_button_login.setBounds(110, 190, 90, 30);
        login_button_register = new Button("注册");
        login_button_register.setBounds(240, 190, 90, 30);
        login_button_visible_password = new Button("显示密码");
        login_button_visible_password.setBounds(320, 130, 60, 20);

        f.add(login_label_user_name);
        f.add(login_label_user_passwords);
        f.add(login_textField_user_name);
        f.add(login_textField_password);
        f.add(login_button_register);
        f.add(login_button_login);
        f.add(login_button_visible_password);

        // 注册界面组件
        register_label_user_name = new Label("新用户名");
        register_label_user_name.setBounds(80, 70, 50, 20);
        register_label_passwords_input = new Label("输入密码");
        register_label_passwords_input.setBounds(80, 110, 50, 20);
        register_label_passwords_confirm = new Label("确认密码");
        register_label_passwords_confirm.setBounds(80, 150, 50, 20);

        register_textField_user_name = new TextField();
        register_textField_user_name.setBounds(150, 70, 160, 20);
        register_textField_passwords_input = new TextField();
        register_textField_passwords_input.setEchoChar('*');
        register_textField_passwords_input.setBounds(150, 110, 160, 20);
        register_textField_passwords_confirm = new TextField();
        register_textField_passwords_confirm.setEchoChar('*');
        register_textField_passwords_confirm.setBounds(150, 150, 160, 20);

        register_button_visible_password = new Button("显示密码");
        register_button_visible_password.setBounds(320, 110, 60, 20);
        register_button_register = new Button("注册");
        register_button_register.setBounds(110, 190, 90, 30);
        register_button_quit_register = new Button("退出注册");
        register_button_quit_register.setBounds(240, 190, 90, 30);

        f.add(register_label_user_name);
        f.add(register_label_passwords_input);
        f.add(register_label_passwords_confirm);
        f.add(register_textField_user_name);
        f.add(register_textField_passwords_input);
        f.add(register_textField_passwords_confirm);
        f.add(register_button_register);
        f.add(register_button_quit_register);
        f.add(register_button_visible_password);

        // 选择界面组件
        choose_button_search_module = new Button("查找单词");
        choose_button_search_module.setBounds(120, 100, 80, 60);
        choose_button_search_module.setBackground(Color.yellow);

        choose_button_test_module = new Button("测验模式");
        choose_button_test_module.setBounds(240, 100, 80, 60);
        choose_button_test_module.setBackground(Color.CYAN);
        f.add(choose_button_search_module);
        f.add(choose_button_test_module);

        // 查找单词界面组件
        search_label_find = new Label("输入单词");
        search_label_find.setBounds(15, 35, 60, 20);

        search_textField_find = new TextField();
        search_textField_find.setBounds(80, 35, 240, 20);

        search_textArea_meaning = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        search_textArea_meaning.setBounds(15, 60, 410, 160);

        search_button_find_word = new Button("搜索");
        search_button_find_word.setBounds(340, 35, 80, 20);
        search_button_quit_search_module = new Button("退出查询");
        search_button_quit_search_module.setBounds(340, 230, 80, 20);

        f.add(search_label_find);
        f.add(search_textField_find);
        f.add(search_button_find_word);
        f.add(search_textArea_meaning);
        f.add(search_button_quit_search_module);

        // 考试界面组件
        test_textArea_question = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        test_textArea_question.setBounds(15, 40, 420, 170);

        test_textField_answer = new TextField();
        test_textField_answer.setBounds(20, 230, 60, 20);

        test_button_submit = new Button("提交答案");
        test_button_submit.setBounds(90, 230, 80, 20);
        test_button_show_words_difficulty = new Button("考试结果");
        test_button_show_words_difficulty.setBounds(170, 230, 80, 20);
        test_button_put_grade = new Button("输出成绩");
        test_button_put_grade.setBounds(250, 230, 80, 20);
        test_button_quit_test_module = new Button("退出考试");
        test_button_quit_test_module.setBounds(330, 230, 80, 20);

        f.add(test_textArea_question);
        f.add(test_textField_answer);
        f.add(test_button_submit);
        f.add(test_button_show_words_difficulty);
        f.add(test_button_put_grade);
        f.add(test_button_quit_test_module);

        //消息框
        login_dialog = new Dialog(f, "杨良博");
        login_dialog.setBounds(729, 360, 240, 148);
        login_dialog.setLayout(null);
        register_dialog = new Dialog(f, "杨良博");
        register_dialog.setLayout(null);
        register_dialog.setBounds(729, 360, 240, 148);
        test_finish_dialog = new Dialog(f, "杨良博");
        test_finish_dialog.setLayout(null);
        test_finish_dialog.setBounds(729, 360, 240, 148);
        test_result_dialog = new Dialog(f, "杨良博");
        test_result_dialog.setLayout(null);
        test_result_dialog.setBounds(729, 360, 240, 148);

        login_label_dialog = new Label("登录失败");
        login_label_dialog.setBounds(90, 60, 50, 20);
        register_label_dialog = new Label("注册失败");
        register_label_dialog.setBounds(90, 60, 50, 20);
        test_finish_label_dialog = new Label("考试结束");
        test_finish_label_dialog.setBounds(90, 60, 50, 20);
        test_result_label_dialog = new Label("回答错误");
        test_result_label_dialog.setBounds(90, 60, 50, 20);

        login_dialog.add(login_label_dialog);
        register_dialog.add(register_label_dialog);
        test_finish_dialog.add(test_finish_label_dialog);
        test_result_dialog.add(test_result_label_dialog);

        // 预先将除登录模块外的组建都设置为不可见
        change_register_interfact(false);
        change_choose_interface(false);
        change_find_Word_interface(false);
        change_test_interfact(false);

        myEvent();
        f.setVisible(true);
    }

    private void myEvent() {
        login_button_login.addActionListener(login_AL);
        register_button_register.addActionListener(register_AL);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        login_button_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_login_interface(false);
                change_register_interfact(true);
            }
        });
        register_button_quit_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                change_register_interfact(false);
                clean_register();
                change_login_interface(true);

            }
        });
        choose_button_search_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_choose_interface(false);
                change_find_Word_interface(true);
            }
        });
        search_button_quit_search_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_choose_interface(true);
                change_find_Word_interface(false);
            }
        });
        choose_button_test_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_choose_interface(false);
                change_test_interfact(true);
                test();
            }
        });
        test_button_quit_test_module.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_choose_interface(true);
                change_test_interfact(false);
                count = 0;
                if_show_next_question = true;
                test_textArea_question.setText("");
            }
        });
        search_button_find_word.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_textArea_meaning.setText(data.word.get(search_textField_find.getText()));
            }
        });
        test_button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(test_textField_answer.getText()) == right_option) {
                    if_show_next_question = true;
                    Integer it = data.right.get(right_word);
                    data.right.put(right_word, it + 1);
                    test_result_label_dialog.setText("回答正确");
                    test_result_dialog.setVisible(true);
                } else {
                    if_show_next_question = false;
                    Integer it = data.wrong.get(right_word);
                    data.wrong.put(right_word, it + 1);
                    test_result_label_dialog.setText("回答错误");
                    test_result_dialog.setVisible(true);
                }
                test_textField_answer.setText("");
                test_textArea_question.setText("");
                test();
            }
        });
        test_button_put_grade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<String> rit = data.right.keySet().iterator();
                String right;
                for (int i = 0; i < data.word.size(); i++) {
                    while (rit.hasNext()) {
                        right = rit.next();
                        data.write_grade(loged_in_user_name, right, data.right.get(right), data.wrong.get(right));
                    }
                }
            }
        });
        register_button_visible_password.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                register_textField_passwords_input.setEchoChar('\0');
                register_textField_passwords_confirm.setEchoChar('\0');
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                register_textField_passwords_input.setEchoChar('*');
                register_textField_passwords_confirm.setEchoChar('*');
            }
        });
        login_button_visible_password.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                login_textField_password.setEchoChar('\0');
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                login_textField_password.setEchoChar('*');
            }
        });
        test_button_show_words_difficulty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= data.word.size() + 1) {
                    test_textArea_question.append("单词难度展示 星星越多难度越高\n\r");
                    try {
                        ResultSet set = data.read_gread(loged_in_user_name);
                        while (set.next()) {
                            test_textArea_question.append(set.getString("word") + "......." +
                                    show_start_number(Float.parseFloat(set.getString("error"))) + "\r\n");
                        }
                    } catch (SQLException SQL) {
                        System.out.println("test_button_show_words_difficulty");
                    }
                }
            }
        });

        login_dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                login_dialog.setVisible(false);
                login_label_dialog.setText("登录失败");
            }
        });
        register_dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                register_dialog.setVisible(false);
                register_label_dialog.setText("注册失败");
            }
        });
        test_finish_dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                test_finish_dialog.setVisible(false);
            }
        });
        test_result_dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                test_result_dialog.setVisible(false);
            }
        });
    }

    private String show_start_number(float f) {
        if (f >= Float.parseFloat("0") && f <= Float.parseFloat("0.2"))
            return "*";
        if (f > Float.parseFloat("0.2") && f < Float.parseFloat("0.4"))
            return "**";
        if (f >= Float.parseFloat("0.4") && f < Float.parseFloat("0.6"))
            return "***";
        if (f >= Float.parseFloat("0.6") && f < Float.parseFloat("0.8"))
            return "****";
        if (f >= Float.parseFloat("0.8") && f <= Float.parseFloat("1.0"))
            return "*****";
        //出错就显示6个零
        return "000000";
    }

    //<editor-fold desc="change_interface">
    private void change_login_interface(boolean flag) {
        login_label_user_name.setVisible(flag);
        login_label_user_passwords.setVisible(flag);
        login_textField_user_name.setVisible(flag);
        login_textField_password.setVisible(flag);
        login_button_login.setVisible(flag);
        login_button_register.setVisible(flag);
        login_button_visible_password.setVisible(flag);
        login_textField_password.setText(" ");
        login_textField_password.setText("");
        f.invalidate();
    }

    private void change_choose_interface(boolean flag) {
        choose_button_search_module.setVisible(flag);
        choose_button_test_module.setVisible(flag);
        f.invalidate();
    }

    private void change_find_Word_interface(boolean flag) {
        search_label_find.setVisible(flag);
        search_textField_find.setVisible(flag);
        search_button_find_word.setVisible(flag);
        search_textArea_meaning.setVisible(flag);
        search_button_quit_search_module.setVisible(flag);
        f.invalidate();
    }

    private void change_test_interfact(boolean flag) {
        test_textArea_question.setVisible(flag);
        test_textField_answer.setVisible(flag);
        test_button_submit.setVisible(flag);
        test_button_show_words_difficulty.setVisible(flag);
        test_button_put_grade.setVisible(flag);
        test_button_quit_test_module.setVisible(flag);
        f.invalidate();
    }

    private void change_register_interfact(boolean flag) {
        register_label_user_name.setVisible(flag);
        register_label_passwords_input.setVisible(flag);
        register_label_passwords_confirm.setVisible(flag);
        register_textField_user_name.setVisible(flag);
        register_textField_passwords_input.setVisible(flag);
        register_textField_passwords_confirm.setVisible(flag);
        register_button_register.setVisible(flag);
        register_button_quit_register.setVisible(flag);
        register_button_visible_password.setVisible(flag);
        f.invalidate();
    }
    //</editor-fold>

    //<editor-fold desc="login_module">
    private int login_count = 0;

    private ActionListener login_AL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (check(login_textField_user_name.getText(), login_textField_password.getText()) == false) {
                login_dialog.setVisible(true);
                record();
                return;
            }
            loged_in_user_name = login_textField_user_name.getText();
            login_label_dialog.setText("登录成功");
            login_dialog.setVisible(true);
            change_login_interface(false);
            change_choose_interface(true);
        }
    };

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
        if (user_password.compareTo(data.userInfo.get(user_name)) == 0)
            return true;
        return false;
    }

    //</editor-fold>

    //<editor-fold desc="register_module">
    private ActionListener register_AL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (check_register()) {
                register_label_dialog.setText("注册成功");
                register_dialog.setVisible(true);

                data.write_userInfo(register_textField_user_name.getText(), register_textField_passwords_input.getText());
                data.userInfo.put(register_textField_user_name.getText(), register_textField_passwords_input.getText());

                clean_register();
                change_register_interfact(false);
                change_login_interface(true);
            } else {
                register_dialog.setVisible(true);
                System.out.println("注册失败");
            }
        }
    };

    private boolean check_register() {
        return if_register_success(register_textField_user_name.getText()) == false &&
                register_textField_passwords_input.getText().contentEquals(new StringBuffer(register_textField_passwords_confirm.getText())) &&
                register_textField_user_name.getText().compareTo("") != 0 &&
                limit_password(register_textField_passwords_input.getText()) == true;
    }

    private boolean limit_password(String PW) {
        String regex = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{7,11}";
        return PW.matches(regex);
    }

    private void clean_register() {
        register_textField_user_name.setText(" ");
        register_textField_passwords_input.setText(" ");
        register_textField_passwords_confirm.setText(" ");
        register_textField_user_name.setText("");
        register_textField_passwords_input.setText("");
        register_textField_passwords_confirm.setText("");
    }

    private boolean if_register_success(String user_name) {
        return data.userInfo.containsKey(user_name);
    }
    //</editor-fold>

    //<editor-fold desc="choose_button_test_module">
    Random rand = new Random();
    private int count = 0;
    private boolean if_show_next_question = true;
    private String right_word = null;
    private String right_word_meaning = null;
    private String wrong_word = null;
    private int right_option;

    public void test() {
        if (if_show_next_question == true) {
            if (create_right_word_and_meaning() == false) {
                finish_test();
                return;
            }
        }
        create_wrong_word(count);
        show_question_and_options();
    }

    private void show_question_and_options() {
        test_textArea_question.append(right_word_meaning + "\n\r");
        // 正确选项位置随机生成 并记录在right_option中
        right_option = rand.nextInt(2) + 1;
        for (int i = 1; i <= 2; i++) {
            if (i == right_option) test_textArea_question.append(right_option + ": " + right_word + "\n\r");
            else
                test_textArea_question.append(i + ": " + wrong_word + "\n\r");
        }
    }

    private void create_wrong_word(int index) {
        String arr = null;
        Set<String> str = data.word.keySet();
        Iterator<String> it = str.iterator();
        int r = rand.nextInt(6);
        while (true) {
            if (r == index - 1)
                r = rand.nextInt(6);
            else break;
        }
        for (int j = 0; j <= r; j++) {
            wrong_word = it.next();
        }
    }

    private boolean create_right_word_and_meaning() {
        Set<String> arr = data.word.keySet();
        Iterator<String> it = arr.iterator();
        for (int i = 0; i <= count; i++) {
            if (it.hasNext()) right_word = it.next();
        }
        right_word_meaning = data.word.get(right_word);
        count++;
        if (count >= data.word.size() + 1) return false;
        return true;
    }

    private void finish_test() {
        test_textArea_question.setText("");
        test_button_submit.setVisible(false);
        test_textField_answer.setVisible(false);
        test_finish_dialog.setVisible(true);
        f.invalidate();
    }
    //</editor-fold>

    public static void main(String[] args) {
        new MyWindows();
    }
}
