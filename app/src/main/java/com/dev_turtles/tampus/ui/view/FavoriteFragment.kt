package com.dev_turtles.tampus.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.dev_turtles.tampus.R
import com.dev_turtles.tampus.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val webView: WebView = binding.wvFavoriteFragment
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl("https://www.airbnb.com.pe/wishlists")
        return binding.root
    }

}
