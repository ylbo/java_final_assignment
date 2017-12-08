package Logic;

import Windows.ChooseWindows;
import Windows.SearchWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    private SearchWindows searchWindows;
    ActionListener search_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String meaning = null;
            String word = searchWindows.getTextField_find().getText();
            if (word != null) {
                ResultSet re = SqlHelper.search_word_meaning();
                try {
                    while (re.next()) {
                        if (word.compareTo(re.getString("word")) == 0) {
                            meaning = re.getString("meaning");
                        }
                    }
                } catch (SQLException ss) {

                }
            }
            if (meaning == null)
                searchWindows.getTextArea_meaning().setText("没有该单词词义");
            else searchWindows.getTextArea_meaning().setText(meaning);
        }
    };
    private ChooseWindows chooseWindows;
    private ActionListener quit_search_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            searchWindows.setVisible(false);
        }
    };

    public Search(SearchWindows searchWindows, ChooseWindows chooseWindows) {
        this.searchWindows = searchWindows;
        this.chooseWindows = chooseWindows;
        this.searchWindows.getButton_find_word().addActionListener(search_button);
        this.searchWindows.getButton_quit_module().addActionListener(quit_search_button);
    }
}
