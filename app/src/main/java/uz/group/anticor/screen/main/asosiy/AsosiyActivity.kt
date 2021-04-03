package uz.group.anticor.screen.main.asosiy

import kotlinx.android.synthetic.main.activity_asosiy.*
import uz.group.anticor.R
import uz.group.anticor.base.BaseActivity

class AsosiyActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_asosiy

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