package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A filter that represents the logical not of its child0 filter
 */
public class AndFilter implements Filter {

    private final Filter child0;
    private final Filter child1;


    public AndFilter(Filter child, Filter child1) {
        this.child0 = child;
        this.child1 = child1;
    }

    /**
     * @param s0     the tweet to check
     * @param s1     the next tweet to check
     * @return      2 status are matches
     */
    public boolean matches(Status s0, Status s1) {
        return child0.matches(s0) && child1.matches(s1) || child0.matches(s1) && child1.matches(s0);
    }

    @Override
    public boolean matches(Status s) {
        return false;
    }

    @Override
    public List<String> terms() {
        return child0.terms();
    }

    public List<String> andTerms() {
        ArrayList<String> terms = new ArrayList<>();
        terms.add(String.valueOf(child0.terms()));
        terms.add(String.valueOf(child1.terms()));
        return terms;
    }

    public String toString() {
        return child1.toString() + " and " + child0.toString();
    }
}
