package Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseWindows extends MyFrame {
    private Button searchModuleButton;
    private Button testModuleButton;
    private Button translateModuleButton;
    private TranslateWindows translateWindows;
    private ChooseTestWindows chooseTestWindows;
    private SearchWindows searchWindows;

    public ChooseWindows() {
        super();
        init();
    }

    private void init() {
        searchModuleButton = new Button("查找单词");
        searchModuleButton.setBounds(120, 100, 80, 60);
        searchModuleButton.setBackground(Color.YELLOW);

        testModuleButton = new Button("测验模式");
        testModuleButton.setBounds(240, 100, 80, 60);
        testModuleButton.setBackground(Color.CYAN);

        translateModuleButton = new Button("联网翻译");
        translateModuleButton.setBounds(180, 170, 80, 60);
        translateModuleButton.setBackground(Color.WHITE);

        translateModuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translateModuleChicked();
            }
        });
        searchModuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchModuleChicked();
            }
        });
        testModuleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testModuleChicked();
            }
        });


        this.add(translateModuleButton);
        this.add(searchModuleButton);
        this.add(testModuleButton);
    }

    private void translateModuleChicked() {
        this.getTranslateWindows().setVisible(true);
        this.setVisible(false);
    }

    private void searchModuleChicked() {
        this.getSearchWindows().setVisible(true);
        this.setVisible(false);
    }

    private void testModuleChicked() {
        this.getChooseTestWindows().setVisible(true);
        this.setVisible(false);
    }

    public TranslateWindows getTranslateWindows() {
        return translateWindows;
    }

    public void setTranslateWindows(TranslateWindows translateWindows) {
        this.translateWindows = translateWindows;
    }

    public ChooseTestWindows getChooseTestWindows() {
        return chooseTestWindows;
    }

    public void setChooseTestWindows(ChooseTestWindows chooseTestWindows) {
        this.chooseTestWindows = chooseTestWindows;
    }

    public SearchWindows getSearchWindows() {
        return searchWindows;
    }

    public void setSearchWindows(SearchWindows searchWindows) {
        this.searchWindows = searchWindows;
    }
}
