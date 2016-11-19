/**
 * Created by mikus on 2016.11.7.
 */

package lv.mikust.tehbot;

import twitter4j.*;

import java.io.IOException;

public class TweetBot {
    private static final Logger logger = Logger.getLogger(TwitterStream.class);

    public static void main(String[] args) throws TwitterException {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(listener);
        twitterStream.user();
        WebRequests webRequests = new WebRequests();
    }

    // Stream listener

    private static UserStreamListener listener = new UserStreamListener() {
        @Override
        public void onStatus(Status status) {
            logger.info("Message: " + status.getUser().getScreenName() + " - " + status.getText());
            // Responds with help message
            if (status.getText().toLowerCase().contains("!help")) {
                sendResponse(status, "Awailable commands\n!d <domain> - returns webserver version\n!w <city> - returns current weather.");

            } else if (status.getText().toLowerCase().contains("!d")) {
                ExtractUri extractUri = new ExtractUri();
                if (extractUri.splitText(status.getText()) != null) {
                    String domainName = extractUri.splitText(status.getText());
                    logger.info("Sending GET / request to " + domainName);
                    try {
                        sendResponse(status, WebRequests.getGet(domainName));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (status.getText().toLowerCase().contains("!w")) {
                GetOpenWeather getOpenWeather = new GetOpenWeather();
                String[] city = status.getText().toLowerCase().split(" ");
                getOpenWeather.setCity(city[2]);
                logger.info("Sending weather tweet");
                try {
                    String weatherTweet = getOpenWeather.slurpData();
                    sendResponse(status, weatherTweet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendResponse(Status status, String response) {
            Twitter twitter = new TwitterFactory().getInstance();
            StatusUpdate statusUpdate = new StatusUpdate("@" + status.getUser().getScreenName() + " " + response);
            statusUpdate.inReplyToStatusId(status.getId());
            try {
                twitter.updateStatus(statusUpdate);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        }

        @Override
        public void onDeletionNotice(long directMessageId, long userId) {
        }

        @Override
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        }

        @Override
        public void onScrubGeo(long userId, long upToStatusId) {
        }

        @Override
        public void onStallWarning(StallWarning warning) {
            logger.info("Stall warning: " + warning);
        }

        @Override
        public void onFriendList(long[] friendIds) {
        }

        @Override
        public void onFavorite(User source, User target, Status favoritedStatus) {
        }

        @Override
        public void onUnfavorite(User source, User target, Status unfavoritedStatus) {
        }

        @Override
        public void onFollow(User source, User followedUser) {
        }

        @Override
        public void onUnfollow(User source, User followedUser) {
        }

        @Override
        public void onDirectMessage(DirectMessage directMessage) {
        }

        @Override
        public void onUserListMemberAddition(User addedMember, User listOwner, UserList list) {
        }

        @Override
        public void onUserListMemberDeletion(User deletedMember, User listOwner, UserList list) {
        }

        @Override
        public void onUserListSubscription(User subscriber, User listOwner, UserList list) {
        }

        @Override
        public void onUserListUnsubscription(User subscriber, User listOwner, UserList list) {
        }

        @Override
        public void onUserListCreation(User listOwner, UserList list) {
        }

        @Override
        public void onUserListUpdate(User listOwner, UserList list) {
        }

        @Override
        public void onUserListDeletion(User listOwner, UserList list) {
        }

        @Override
        public void onUserProfileUpdate(User updatedUser) {
        }

        @Override
        public void onUserDeletion(long deletedUser) {
        }

        @Override
        public void onUserSuspension(long suspendedUser) {
        }

        @Override
        public void onBlock(User source, User blockedUser) {
        }

        @Override
        public void onUnblock(User source, User unblockedUser) {
        }

        @Override
        public void onRetweetedRetweet(User source, User target, Status retweetedStatus) {
        }

        @Override
        public void onFavoritedRetweet(User source, User target, Status favoritedRetweet) {

        }

        @Override
        public void onQuotedTweet(User source, User target, Status quotingTweet) {

        }

        @Override
        public void onException(Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception: " + ex.getMessage());
        }
    };
}
