package educracypedia.com.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import educracypedia.com.R;
import educracypedia.com.databinding.ContactUsFragmentBinding;

import educracypedia.com.databinding.ContactUsFragmentBinding;

public class ContactUs extends Fragment {

    private educracypedia.com.ui.ContactUsViewModel mViewModel;
    private ContactUsFragmentBinding binding;
    private WebView mWebView;

    public static ContactUs newInstance() {
        return new ContactUs();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(educracypedia.com.ui.ContactUsViewModel.class);

        binding = ContactUsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mWebView = root.findViewById(R.id.webview);
        mWebView.loadUrl("https://educracypedia.com/contact/");

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
        mViewModel = new ViewModelProvider(this).get(educracypedia.com.ui.ContactUsViewModel.class);
        // TODO: Use the ViewModel
    }

}