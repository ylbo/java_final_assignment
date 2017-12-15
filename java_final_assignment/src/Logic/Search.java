package Logic;

import Windows.ChooseWindows;
import Windows.SearchWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    private SearchWindows searchWindows;
    ActionListener searchButtonChicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String meaning = null;
            String word = searchWindows.getEnterWordField().getText();
            if (word != null) {
                ResultSet re = SqlHelper.seachWordMeaning();
                try {
                    while (re.next()) {
                        if (word.compareTo(re.getString("word")) == 0) {
                            meaning = re.getString("meaning");
                        }
                    }
                    re.close();
                } catch (SQLException ignored) {

                }
            }
            if (meaning == null)
                searchWindows.getMeaningArea().setText("没有该单词词义");
            else searchWindows.getMeaningArea().setText(meaning);
        }
    };
    private ChooseWindows chooseWindows;
    private ActionListener exitSearchButtonChicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooseWindows.setVisible(true);
            searchWindows.setVisible(false);
        }
    };

    public Search(SearchWindows searchWindows, ChooseWindows chooseWindows) {
        this.searchWindows = searchWindows;
        this.chooseWindows = chooseWindows;
        this.searchWindows.getSearchWordButton().addActionListener(searchButtonChicked);
        this.searchWindows.getExitButton().addActionListener(exitSearchButtonChicked);
    }
}
