package com.programmerhuntbd.bulbul.careerpathbd.webpost;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.programmerhuntbd.bulbul.careerpathbd.MainActivity;
import com.programmerhuntbd.bulbul.careerpathbd.R;

public class WPPostDetails extends AppCompatActivity {
    TextView title;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wppost_details);
        //title = (TextView) findViewById(R.id.title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Post Details");

        webView = (WebView) findViewById(R.id.postwebview);
        Intent i = getIntent();
        int position = i.getExtras().getInt("itemPosition");

        //  title.setText( MainActivity.mListPost.get(position).getTitle().getRendered());



//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(WebMain.mListPost.get(position).getLink());
//        // to open webview inside app -- otherwise It will open url in device browser
//        webView.setWebViewClient(new WebViewClient());

        String  url = WebMain.mListPost.get(position).getLink();

        final ProgressDialog pd = ProgressDialog.show(WPPostDetails.this, "", "Please wait, your website is being processed...", true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myBrowser(pd));
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //----------------------------------------------

        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);


        if(url.endsWith(".pdf") ){
            pd.show();
            webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);
            pd.dismiss();
        }else{
            webView.loadUrl(url);
        }



    }

    public class myBrowser extends WebViewClient {
        ProgressDialog progressDialog;

        public myBrowser(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
            progressDialog.show();


        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }
}