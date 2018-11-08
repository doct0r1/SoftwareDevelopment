package filters;

import twitter4j.Status;
import ui.MapMarkerSimple;
import ui.MapMarkerSimpleColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;

/**
 * A basic filter that matches every tweet that contains the given word
 */
public class BasicFilter extends Observable implements Filter {
    final private String word;
    final private Pattern pattern;

    public BasicFilter(String word) {
        this.word = word;
        pattern = Pattern.compile("(?i).*" + Pattern.quote(word) + ".*");
    }

    @Override
    public boolean matches(Status s) {
        String text = s.getText();
        return pattern.matcher(text).matches();
    }

    @Override
    public List<String> terms() {
        List<String> ans = new ArrayList<>(1);
        ans.add(word);
        return ans;
    }

    @Override
    public String toString() {
        return word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public void notifyObservers() {
        setChanged();
        notifyObservers("basic");
    }
}
