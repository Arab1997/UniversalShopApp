package uz.group.anticor.screen.main.splash

import android.content.Intent
import android.os.CountDownTimer
import android.os.Handler
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottomsheet_language.view.*
import uz.group.anticor.R
import uz.group.anticor.base.*
import uz.group.anticor.screen.main.MainActivity
import uz.group.anticor.utils.LocaleManager
import uz.group.anticor.utils.Prefs

class SplashActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_splash
    private lateinit var listener: () -> Unit
    fun setListener(listener: () -> Unit) {
        this.listener = listener
    }

    override fun initViews() {
     /*   Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 3000)*/
       // showLanguageDialog()
      //  showMustUpdate()

        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
           //    istener.invoke()

                startClearTopActivity<MainActivity>()
            }

            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }

    override fun loadData() {

     /*   Handler().postDelayed({
            val mIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 2000)
        startClearTopActivity<MainActivity>()
        finish()*/
    }

    override fun initData() {

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
