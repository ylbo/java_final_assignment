package Logic;

import Sql.SqlHelper;
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

    public Search(SearchWindows searchWindows) {
        this.searchWindows = searchWindows;
        this.searchWindows.getSearchWordButton().addActionListener(searchButtonChicked);
    }
}
