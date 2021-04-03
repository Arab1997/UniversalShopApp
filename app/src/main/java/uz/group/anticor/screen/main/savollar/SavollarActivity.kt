package uz.group.anticor.screen.main.savollar

import kotlinx.android.synthetic.main.activity_savollar.*
import uz.group.anticor.R
import uz.group.anticor.base.BaseActivity

class SavollarActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_savollar

    override fun initViews() {
        imgBackk.setOnClickListener { finish() }

    }

    override fun loadData() {
    }

    override fun initData() {
    }

    override fun updateData() {
    }
}