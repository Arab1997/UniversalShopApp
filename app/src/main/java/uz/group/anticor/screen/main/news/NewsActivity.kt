package uz.group.anticor.screen.main.news

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import uz.group.anticor.R

import kotlinx.android.synthetic.main.activity_news.*
import uz.group.anticor.base.BaseActivity
import uz.group.anticor.base.showError
import uz.group.anticor.screen.main.MainViewModel
import uz.group.anticor.view.adapter.NewsAdapter

class NewsActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_news
    lateinit var viewModel: MainViewModel

    override fun initViews() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.progress.observe(this, Observer {
            setProgress(it)
        })

        viewModel.error.observe(this, Observer {
            showError(it)
        })

        viewModel.newsData.observe(this,  Observer {
            initData()
        })

        imgBack.setOnClickListener {
            finish()
        }
    }

    override fun loadData() {
        //viewModel.getNews()
    }

    override fun initData() {
        if (viewModel.newsData.value != null){
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = NewsAdapter(viewModel.newsData.value ?: emptyList())
        }
    }

    override fun updateData() {

    }

}
