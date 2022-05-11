package com.example.application.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.application.R;
import com.example.application.databinding.ContactUsFragmentBinding;
import com.example.application.databinding.NewsFragmentBinding;

public class News extends Fragment {

    private NewsViewModel mViewModel;private @NonNull
    NewsFragmentBinding binding;
    private WebView mWebView;

    public static News newInstance() {
        return new News();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = NewsFragmentBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        mWebView = (WebView) root.findViewById(R.id.webview);
        mWebView.loadUrl("http://news.educracypedia.com/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        // TODO: Use the ViewModel
    }

}