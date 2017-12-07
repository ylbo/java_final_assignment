package Logic;

import Windows.TestWindows;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Test {

    private TestWindows testWindows;
    private String loged_in_user_name;

    public Test(TestWindows testWindows, String loged_in_user_name) {
        this.testWindows = testWindows;
        this.loged_in_user_name = loged_in_user_name;
        testWindows.getTest_button_submit().addActionListener(submint_button);
        testWindows.getTest_button_show_words_difficulty().addActionListener(show_word_difficulty);
        testWindows.getTest_button_put_grade().addActionListener(put_grade);
        testWindows.getTest_result_dialog().addWindowListener(result_dialog);
        testWindows.getTest_finish_dialog().addWindowListener(finish_dialog);
    }

    public void runTest()
    {
        test();
    }

    private WindowListener finish_dialog=new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            testWindows.getTest_finish_dialog().setVisible(false);
        }
    };

    private WindowListener result_dialog=new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            testWindows.getTest_result_dialog().setVisible(false);
        }
    };

    private ActionListener put_grade = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Iterator<String> it = Data.right.keySet().iterator();
            String right;
            for (int i = 0; i < Data.word.size(); i++) {
                while (it.hasNext()) {
                    right = it.next();
                    Data.write_grade(loged_in_user_name, right, Data.right.get(right), Data.wrong.get(right));
                }
            }
        }
    };

    private ActionListener show_word_difficulty = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (count >= Data.word.size() + 1) {
                testWindows.getTest_textArea_question().append("单词难度展示 星星越多难度越高\n\r");
                try {
                    ResultSet set = Data.read_gread(loged_in_user_name);
                    while (set.next()) {
                        testWindows.getTest_textArea_question().append(set.getString("word") + "......." +
                                show_start_number(Float.parseFloat(set.getString("r"))) + "\r\n");
                    }
                } catch (SQLException SQL) {
                    System.out.println("test_button_show_words_difficulty");
                }
            }
        }
    };

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

    private ActionListener submint_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Integer.parseInt(testWindows.getTest_textField_answer().getText()) == right_option) {
                if_show_next_question = true;
                Integer it = Data.right.get(right_word);
                Data.right.put(right_word, it + 1);
                testWindows.getTest_result_label_dialog().setText("回答正确");
                testWindows.getTest_result_dialog().setVisible(true);
            } else {
                if_show_next_question = false;
                Integer it = Data.wrong.get(right_word);
                Data.wrong.put(right_word, it + 1);
                testWindows.getTest_result_label_dialog().setText("回答错误");
                testWindows.getTest_result_dialog().setVisible(true);
            }
            testWindows.getTest_textField_answer().setText("");
            testWindows.getTest_textArea_question().setText("");
            test();
        }
    };
    private Random rand = new Random();
    private int count = 0;
    private boolean if_show_next_question = true;
    private String right_word = null;
    private String right_word_meaning = null;
    private String wrong_word = null;
    private int right_option;

    private void test() {
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
        testWindows.getTest_textArea_question().append(right_word_meaning + "\n\r");
        // 正确选项位置随机生成 并记录在right_option中
        right_option = rand.nextInt(2) + 1;
        for (int i = 1; i <= 2; i++) {
            if (i == right_option)
                testWindows.getTest_textArea_question().append(right_option + ": " + right_word + "\n\r");
            else
                testWindows.getTest_textArea_question().append(i + ": " + wrong_word + "\n\r");
        }
    }

    private void create_wrong_word(int index) {
        String arr = null;
        Set<String> str = Data.word.keySet();
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
        Set<String> arr = Data.word.keySet();
        Iterator<String> it = arr.iterator();
        for (int i = 0; i <= count; i++) {
            if (it.hasNext()) right_word = it.next();
        }
        right_word_meaning = Data.word.get(right_word);
        count++;
        if (count >= Data.word.size() + 1) return false;
        return true;
    }

    private void finish_test() {
        testWindows.getTest_textArea_question().setText("");
        testWindows.getTest_button_submit().setVisible(false);
        testWindows.getTest_textField_answer().setVisible(false);
        testWindows.getTest_finish_dialog().setVisible(true);
        testWindows.invalidate();
    }

    public void reset()
    {
        count=0;
        if_show_next_question=true;
        testWindows.getTest_textArea_question().setText("");
        testWindows.getTest_textField_answer().setVisible(true);
        testWindows.getTest_button_submit().setVisible(true);
    }
}
