
package uz.isti.maxtel.screen.main.oneId

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_one_id.*
import uz.isti.maxtel.R
import uz.isti.maxtel.base.BaseActivity
import uz.isti.maxtel.databinding.ActivityMainBinding
import uz.isti.maxtel.screen.main.MainActivity
import uz.isti.maxtel.utils.Status

class OneIDActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    var redirect_url = "https://anticorruption.uz/uz"
    var responceType = "one_code"
    var clientId = "anticorruption.uz"
    var scope = "12"
    var state = "0wOQhto6c0bDKLrl28i96w=="
    private val TAG = "OneIDActivity"

    override fun getLayout(): Int = R.layout.activity_one_id
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_one_id)
        val url =
            "http://sso.egov.uz:8443/sso/oauth/Authorization.do?response_type=$responceType&client_id=$clientId&redirect_uri=$redirect_url&scope=$scope&state=$state"
        webView.webViewClient = MyWebViewClient(binding.root.context)
        webView.loadUrl(url)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        imgBack_btn.setOnClickListener {
            finish()
        }

        initViews()
    }

    override fun initViews() {
        imgBack_btn.setOnClickListener {
            finish()
        }

    }

    inner class MyWebViewClient internal constructor(private val context: Context) :
        WebViewClient() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            val url: String = request?.url.toString()
            if (url.contains("${redirect_url}?code=")) {
                val index1 = url.indexOf("code=")
                val index2 = url.indexOf("&state")
                val code = url.substring(index1 + 5, index2)


                imgBack_btn.setOnClickListener {
                    finish()
                }

                mainViewModel.getCode(code).observe(this@OneIDActivity, Observer {
                    if (it.status == Status.SUCCESS) {
                        Log.d(TAG, "shouldOverrideUrlLoading: ${it.data}")
                        val intent = Intent(this@OneIDActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                })
            } else {
                view?.loadUrl(url)
            }
            return true
        }

        override fun onReceivedError(
            view: WebView,
            request: WebResourceRequest,
            error: WebResourceError
        ) {
            Toast.makeText(context, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }


    }
    override fun onBackPressed() {
        finish()
    }
    override fun loadData() {
        imgBack_btn.setOnClickListener {
            finish()
        }
    }

    override fun initData() {

        imgBack_btn.setOnClickListener {
            finish()
        }
    }

    override fun updateData() {

        imgBack_btn.setOnClickListener {
            finish()
        }
    }


}
