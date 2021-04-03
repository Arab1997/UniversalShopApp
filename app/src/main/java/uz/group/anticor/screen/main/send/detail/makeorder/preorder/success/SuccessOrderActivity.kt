package uz.group.anticor.screen.main.send.detail.makeorder.preorder.success

import kotlinx.android.synthetic.main.activity_success_order.*
import uz.group.anticor.R
import uz.group.anticor.base.BaseActivity
import uz.group.anticor.base.startActivityToOpenUrlInBrowser
import uz.group.anticor.base.startClearActivity
import uz.group.anticor.base.startClearTopActivity
import uz.group.anticor.screen.main.MainActivity
import uz.group.anticor.utils.Constants


class SuccessOrderActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_success_order
    lateinit var url: String
    var summa = 0

    override fun initViews() {
        url = intent.getStringExtra(Constants.EXTRA_DATA)
        summa = intent.getIntExtra(Constants.EXTRA_DATA_2, 0)

        if (summa > 0){
           //tvOkButtonText.text = getString(R.string.do_pay)
            send.setOnClickListener {
                startClearActivity<MainActivity>()
                startActivityToOpenUrlInBrowser(url)
            }
        }else{
            send.setOnClickListener {
                startClearTopActivity<MainActivity>()
            }
        }
    }

    override fun onBackPressed() {
        startClearActivity<MainActivity>()
    }

    override fun loadData() {

    }

    override fun initData() {

    }

    override fun updateData() {

    }

}
