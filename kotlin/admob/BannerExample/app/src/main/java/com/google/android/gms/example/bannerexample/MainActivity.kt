package com.google.android.gms.example.bannerexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Log the Mobile Ads SDK version.
    Log.d(TAG, "Google Mobile Ads SDK Version: " + MobileAds.getVersion())

    // Initialize the Mobile Ads SDK with an AdMob App ID.
    MobileAds.initialize(this) {}

    // Set your test devices. Check your logcat output for the hashed device ID to
    // get test ads on a physical device. e.g.
    // "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345"))
    // to get test ads on this device."
    MobileAds.setRequestConfiguration(
      RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF012345")).build()
    )

    // Create an ad request.
    val adRequest = AdRequest.Builder().build()

    // Start loading the ad in the background.
    ad_view.loadAd(adRequest)
  }

  // Called when leaving the activity
  public override fun onPause() {
    ad_view.pause()
    super.onPause()
  }

  // Called when returning to the activity
  public override fun onResume() {
    super.onResume()
    ad_view.resume()
  }

  // Called before the activity is destroyed
  public override fun onDestroy() {
    ad_view.destroy()
    super.onDestroy()
  }
}
