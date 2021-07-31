

import...


public class UnityAdManager {

    private static final String GAME_ID = "your game id";
    private static final String REWARD_ID = "your reward id";
    private static final String INTER_ID = "your inter id";
    private static final String BANNER_ID = "your banner id";
    private static boolean testMode = false;

    public static void InitializeAd(Context context){
        final UnityAdsListener myAdsListener = new UnityAdsListener();
        UnityAds.addListener(myAdsListener);
        UnityAds.initialize (context, GameID, testMode);
    }
                        //use this for Reward Ad
    public static void InitializeAd(Context context, IUnityAdsListener unityAdsListener){
        UnityAds.addListener(unityAdsListener);
        UnityAds.initialize (context, GameID, testMode);
    }
                        //change layout with your layout, LinearLayout just example
    public static void showBannerAd(LinearLayout bannerLayout, Activity activity){
        UnityBannerListener bannerListener = new UnityBannerListener();
        BannerView bannerView = new BannerView(activity, BANNER_ID, new UnityBannerSize(320, 50));
        bannerView.setListener(bannerListener);
        bannerView.load();
        bannerLayout.addView(bannerView);
    }

    public static void showInterstitialAd (Activity activity) {
        if (UnityAds.isReady (INTER_ID)) {
            UnityAds.show (activity, INTER_ID);
        }
    }

    public static void showRewardedVideoAd(Activity activity) {
        if (UnityAds.isReady (REWARD_ID)) {
            UnityAds.show (activity, REWARD_ID);
        }
    }

    public static void DestroyAd(BannerView bannerView){
        bannerView.destroy();
    }


    private static class UnityAdsListener implements IUnityAdsListener {

        @Override
        public void onUnityAdsReady (String adUnitId) {
            // Implement functionality for an ad being ready to show.
        }

        @Override
        public void onUnityAdsStart (String adUnitId) {
            // Implement functionality for a user starting to watch an ad.
        }

        @Override
        public void onUnityAdsFinish (String adUnitId, UnityAds.FinishState finishState) {
            // Implement functionality for a user finishing an ad.
        }

        @Override
        public void onUnityAdsError (UnityAds.UnityAdsError error, String message) {
            // Implement functionality for a Unity Ads service error occurring.
        }
    }

    // Implement listener methods:
    private static class UnityBannerListener implements BannerView.IListener {
        @Override
        public void onBannerLoaded(BannerView bannerAdView) {
            // Called when the banner is loaded.

        }

        @Override
        public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {
            Log.d("SupportTest", "Banner Error");
            // Note that the BannerErrorInfo object can indicate a no fill (see API documentation).
        }

        @Override
        public void onBannerClick(BannerView bannerAdView) {
            // Called when a banner is clicked.
        }

        @Override
        public void onBannerLeftApplication(BannerView bannerAdView) {
            // Called when the banner links out of the application.
        }
    }


}
