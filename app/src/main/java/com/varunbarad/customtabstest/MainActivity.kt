package com.varunbarad.customtabstest

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: AppCompatEditText
    private lateinit var button: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.editText = this.findViewById(R.id.editText)
        this.button = this.findViewById(R.id.button)

        this.button.setOnClickListener { this.openChromeCustomTab(this.editText.text.toString().trim()) }
    }

    private fun openChromeCustomTab(url: String) {
        val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        builder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        builder.addDefaultShareMenuItem()
        builder.setShowTitle(true)
        builder.setStartAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)
        builder.setExitAnimations(this, android.R.anim.fade_in, android.R.anim.fade_out)

        val customTabsIntent: CustomTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}
