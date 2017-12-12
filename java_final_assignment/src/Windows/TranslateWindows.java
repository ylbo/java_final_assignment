package Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslateWindows extends MyFrame {
    private Label label_find;
    private TextArea textArea_find;
    private Button button_find_word;
    private TextArea textArea_meaning;
    private Button button_quit_module;
    private Button button_clear;

    public TranslateWindows() {
        super();
        init();
    }

    private void init() {
        label_find = new Label("要翻译的句子");
        label_find.setBounds(15, 35, 80, 20);

        textArea_find = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea_find.setBounds(15, 60, 410, 80);

        textArea_meaning = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea_meaning.setBounds(15, 140, 410, 80);

        button_find_word = new Button("翻译");
        button_find_word.setBounds(260, 230, 80, 20);
        button_quit_module = new Button("退出查询");
        button_quit_module.setBounds(340, 230, 80, 20);
        button_clear = new Button("清空");
        button_clear.setBounds(180, 230, 80, 20);
        button_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea_meaning.setText("");
                textArea_find.setText("");
            }
        });

        this.add(button_clear);
        this.add(label_find);
        this.add(textArea_find);
        this.add(button_find_word);
        this.add(textArea_meaning);
        this.add(button_quit_module);
    }

    public TextArea getTextArea_find() {
        return textArea_find;
    }

    public Button getButton_find_word() {
        return button_find_word;
    }

    public TextArea getTextArea_meaning() {
        return textArea_meaning;
    }

    public Button getButton_quit_module() {
        return button_quit_module;
    }
}
