package educracypedia.com.ui;

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

import educracypedia.com.R;
import educracypedia.com.databinding.NewsFragmentBinding;
import educracypedia.com.databinding.StudyCentralFragmentBinding;

public class StudyCentral extends Fragment {

    private educracypedia.com.ui.StudyCentralViewModel mViewModel;private @NonNull
    StudyCentralFragmentBinding binding;
    private WebView mWebView;

    public static StudyCentral newInstance() {
        return new StudyCentral();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(educracypedia.com.ui.StudyCentralViewModel.class);

        binding = StudyCentralFragmentBinding.inflate(inflater, container, false);

        View root = binding.getRoot();


        mWebView = root.findViewById(R.id.webview);
        mWebView.loadUrl("https://educracypedia.com/studycentral/");

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
        mViewModel = new ViewModelProvider(this).get(StudyCentralViewModel.class);
        // TODO: Use the ViewModel
    }

}