package uz.isti.maxtel.screen.splash

import android.content.Intent
import android.os.Handler
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottomsheet_language.view.*
import kotlinx.android.synthetic.main.must_update_layout.view.*
import uz.isti.maxtel.BuildConfig
import uz.isti.maxtel.R
import uz.isti.maxtel.base.*
import uz.isti.maxtel.screen.main.MainActivity
import uz.isti.maxtel.utils.LocaleManager
import uz.isti.maxtel.utils.Prefs

class SplashActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_splash

    override fun initViews() {
     /*   Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 3000)*/
       // showLanguageDialog()
      //  showMustUpdate()
    }

    override fun loadData() {
       // getData()
       // showMustUpdate()

        Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)
        startClearTopActivity<MainActivity>()
        finish()
    }

    override fun initData() {
       // showMustUpdate()
      /*  Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 3000)*/
        //startClearTopActivity<MainActivity>()
    }

    override fun updateData() {
    }

     fun showLanguageDialog(){
        val bottomSheetDialog = BottomSheetDialog(this)
        val viewLang = layoutInflater.inflate(R.layout.bottomsheet_language, null)
        bottomSheetDialog.setContentView(viewLang)
        bottomSheetDialog.setCancelable(false)
        viewLang.tvUzbCr.setOnClickListener {
            Prefs.setLang("uz")
            LocaleManager.setNewLocale(this, "uz")
            bottomSheetDialog?.dismiss()
            startClearTopActivity<MainActivity>()
            finish()
        }
        viewLang.tvRu.setOnClickListener {
            Prefs.setLang("en")
            LocaleManager.setNewLocale(this, "en")
            bottomSheetDialog?.dismiss()

            startClearTopActivity<MainActivity>()
            finish()
        }

       //bottomSheetDialog.show()
    }

   /* fun showMustUpdate(){
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.must_update_layout, null)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.setCancelable(false)
        view.cardViewDownload.setOnClickListener {
            //startActivityToOpenUrlInBrowser("https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}")
        }

        bottomSheetDialog.show()
    }*/
}
