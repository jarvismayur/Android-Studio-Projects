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
import educracypedia.com.databinding.TermsFragmentBinding;

public class Terms extends Fragment {

    private TermsViewModel mViewModel;
    TermsFragmentBinding binding;
    private WebView mWebView;

    public static Terms newInstance() {
        return new Terms();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(TermsViewModel.class);

        binding = TermsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mWebView = root.findViewById(R.id.webview);
        mWebView.loadUrl("https://educracypedia.com/termsandconditions/");

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
        mViewModel = new ViewModelProvider(this).get(TermsViewModel.class);
        // TODO: Use the ViewModel
    }

}