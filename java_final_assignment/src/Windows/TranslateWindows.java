package Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslateWindows extends MyFrame {
    private Label searchLabel;
    private TextArea searchArea;
    private Button searchButton;
    private TextArea meaningArea;
    private Button exitButton;
    private Button clearButton;
    private ChooseWindows chooseWindows;

    public TranslateWindows() {
        super();
        init();
    }

    private void init() {
        searchLabel = new Label("要翻译的句子");
        searchLabel.setBounds(15, 35, 80, 20);

        searchArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        searchArea.setBounds(15, 60, 410, 80);

        meaningArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        meaningArea.setBounds(15, 140, 410, 80);

        searchButton = new Button("翻译");
        searchButton.setBounds(260, 230, 80, 20);
        exitButton = new Button("退出查询");
        exitButton.setBounds(340, 230, 80, 20);
        clearButton = new Button("清空");
        clearButton.setBounds(180, 230, 80, 20);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meaningArea.setText("");
                searchArea.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        this.add(clearButton);
        this.add(searchLabel);
        this.add(searchArea);
        this.add(searchButton);
        this.add(meaningArea);
        this.add(exitButton);
    }

    private void exit() {
        this.getChooseWindows().setVisible(true);
        this.setVisible(false);
    }

    public TextArea getSearchArea() {
        return searchArea;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public TextArea getMeaningArea() {
        return meaningArea;
    }

    public ChooseWindows getChooseWindows() {
        return chooseWindows;
    }

    public void setChooseWindows(ChooseWindows chooseWindows) {
        this.chooseWindows = chooseWindows;
    }
}
