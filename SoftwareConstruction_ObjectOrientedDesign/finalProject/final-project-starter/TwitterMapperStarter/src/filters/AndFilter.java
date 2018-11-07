package filters;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Date;
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
        return (child0.matches(s0) && child1.matches(s1)) || (child0.matches(s1) && child1.matches(s0));
    }

    @Override
    public boolean matches(Status s) {
        return false;
    }

    @Override
    public List<String> terms() {
//        return child0.terms();
        return andTerms();
    }

    public List<String> andTerms() {
        List<String> terms = new ArrayList<>();
        terms.add(String.valueOf(child0.terms()));
        terms.add(String.valueOf(child1.terms()));
        return terms;
    }

    public String toString() {
        return "(" + child1.toString() + " and " + child0.toString() + ")";
    }

    private Status makeStatus(String text) {
        return new Status() {
            @Override
            public Date getCreatedAt() {
                return null;
            }

            @Override
            public long getId() {
                return 0;
            }

            @Override
            public String getText() {
                return text;
            }

            @Override
            public String getSource() {
                return null;
            }

            @Override
            public boolean isTruncated() {
                return false;
            }

            @Override
            public long getInReplyToStatusId() {
                return 0;
            }

            @Override
            public long getInReplyToUserId() {
                return 0;
            }

            @Override
            public String getInReplyToScreenName() {
                return null;
            }

            @Override
            public GeoLocation getGeoLocation() {
                return null;
            }

            @Override
            public Place getPlace() {
                return null;
            }

            @Override
            public boolean isFavorited() {
                return false;
            }

            @Override
            public boolean isRetweeted() {
                return false;
            }

            @Override
            public int getFavoriteCount() {
                return 0;
            }

            @Override
            public User getUser() {
                return null;
            }

            @Override
            public boolean isRetweet() {
                return false;
            }

            @Override
            public Status getRetweetedStatus() {
                return null;
            }

            @Override
            public long[] getContributors() {
                return new long[0];
            }

            @Override
            public int getRetweetCount() {
                return 0;
            }

            @Override
            public boolean isRetweetedByMe() {
                return false;
            }

            @Override
            public long getCurrentUserRetweetId() {
                return 0;
            }

            @Override
            public boolean isPossiblySensitive() {
                return false;
            }

            @Override
            public String getLang() {
                return null;
            }

            @Override
            public Scopes getScopes() {
                return null;
            }

            @Override
            public String[] getWithheldInCountries() {
                return new String[0];
            }

            @Override
            public long getQuotedStatusId() {
                return 0;
            }

            @Override
            public Status getQuotedStatus() {
                return null;
            }

            @Override
            public int compareTo(Status o) {
                return 0;
            }

            @Override
            public UserMentionEntity[] getUserMentionEntities() {
                return new UserMentionEntity[0];
            }

            @Override
            public URLEntity[] getURLEntities() {
                return new URLEntity[0];
            }

            @Override
            public HashtagEntity[] getHashtagEntities() {
                return new HashtagEntity[0];
            }

            @Override
            public MediaEntity[] getMediaEntities() {
                return new MediaEntity[0];
            }

            @Override
            public ExtendedMediaEntity[] getExtendedMediaEntities() {
                return new ExtendedMediaEntity[0];
            }

            @Override
            public SymbolEntity[] getSymbolEntities() {
                return new SymbolEntity[0];
            }

            @Override
            public RateLimitStatus getRateLimitStatus() {
                return null;
            }

            @Override
            public int getAccessLevel() {
                return 0;
            }
        };
    }
}
