package com.padc.travelling.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.padc.travelling.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/17/2016.
 */
public class TouropiaFragment extends Fragment {

    private static final String TOUROPIA_URL = "http://www.touropia.com/tourist-attractions-in-myanmar/";

    @BindView(R.id.wv_web)
    WebView wvWeb;

    public static TouropiaFragment newInstance(){
        TouropiaFragment touropiaFragment = new TouropiaFragment();
        return touropiaFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touropia, container, false);
        ButterKnife.bind(this,view);

        // Websettings to setup the webview
        WebSettings webSettings = wvWeb.getSettings();
//        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCachePath(getActivity().getCacheDir().getAbsolutePath());
        webSettings.setAppCacheEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        wvWeb.setWebChromeClient(new WebChromeClient());

        wvWeb.requestFocus(View.FOCUS_DOWN);
        wvWeb.setFocusable(true);

        wvWeb.loadUrl(TOUROPIA_URL);

        return view;
    }
}
