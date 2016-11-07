/**
 * Created by mikus on 07/11/2016.
 */

package lv.mikust.tehbot;

import twitter4j.*;

public final class TweetBot {
    public static void main(String[] args) throws TwitterException {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(listener);
        twitterStream.user();
    }

    private static final UserStreamListener listener = new UserStreamListener() {
        @Override
        public void onStatus(Status status) {
            System.out.println("onStatus @" + status.getUser().getScreenName() + " - " + status.getText());
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
            System.out.println("Stall warning: " + warning);
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