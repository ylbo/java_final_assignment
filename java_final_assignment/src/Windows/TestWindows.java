package Windows;

import java.awt.*;

public class TestWindows extends MyFrame {
    private TextArea textArea_question;
    private Button[] option = new Button[4];
    private Button button_quit_module;
    private Button button_show_words_difficulty;
    private Dialog result_dialog;
    private Label result_label_dialog;
    private Label label_dialog_right_option_1;
    private Label label_dialog_right_option_2;

    public Label getLabel_dialog_right_option_1() {
        return label_dialog_right_option_1;
    }

    public Label getLabel_dialog_right_option_2() {
        return label_dialog_right_option_2;
    }

    public TestWindows() {
        super();
        init();
    }

    private void init() {

        textArea_question = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea_question.setBounds(15, 40, 420, 170);

        for (int i = 0; i < 4; i++) {
            option[i] = new Button("  " + Integer.toString(i + 1) + "  ");
            option[i].setBounds(10 + i * 80, 230, 80, 20);
            this.add(option[i]);
        }

        button_show_words_difficulty = new Button("展示单词难度");
        button_show_words_difficulty.setBounds(250, 230, 80, 20);
        button_show_words_difficulty.setVisible(false);
        button_quit_module = new Button("退出考试");
        button_quit_module.setBounds(330, 230, 80, 20);

        result_dialog = new Dialog(this, "杨良博", Dialog.ModalityType.APPLICATION_MODAL);
        result_dialog.setLayout(null);
        result_dialog.setBounds(729, 360, 240, 148);
        label_dialog_right_option_1 = new Label("", Label.CENTER);
        label_dialog_right_option_1.setBounds(0, 60, 240, 20);
        label_dialog_right_option_2 = new Label("", Label.CENTER);
        label_dialog_right_option_2.setBounds(0, 80, 240, 20);

        result_label_dialog = new Label("", Label.CENTER);
        result_label_dialog.setBounds(0, 40, 240, 20);

        result_dialog.add(result_label_dialog);
        result_dialog.add(label_dialog_right_option_1);
        result_dialog.add(label_dialog_right_option_2);

        this.add(textArea_question);
        this.add(button_show_words_difficulty);
        this.add(button_quit_module);

    }

    public Button[] getOption() {
        return option;
    }

    public TextArea getTextArea_question() {
        return textArea_question;
    }

    public Button getButton_show_words_difficulty() {
        return button_show_words_difficulty;
    }

    public Button getButton_quit_module() {
        return button_quit_module;
    }

    public Dialog getResult_dialog() {
        return result_dialog;
    }

    public Label getResult_label_dialog() {
        return result_label_dialog;
    }

}
