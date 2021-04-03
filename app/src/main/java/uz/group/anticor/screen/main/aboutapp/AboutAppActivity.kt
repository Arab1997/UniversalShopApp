package uz.group.anticor.screen.main.aboutapp
import kotlinx.android.synthetic.main.activity_about_app.*
import uz.group.anticor.BuildConfig
import uz.group.anticor.R
import uz.group.anticor.base.BaseActivity
import uz.group.anticor.base.startActivityToOpenUrlInBrowser

class AboutAppActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_about_app

    override fun initViews() {
        tvVersion.text = "version: ${BuildConfig.VERSION_NAME}"

        imgBack.setOnClickListener { finish() }

        lyDeveloper.setOnClickListener {
            startActivityToOpenUrlInBrowser("")
        }
    }

    override fun loadData() {

    }

    override fun initData() {

    }

    override fun updateData() {

    }

}
