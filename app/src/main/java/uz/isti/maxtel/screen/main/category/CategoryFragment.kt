package uz.isti.maxtel.screen.main.category

import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_category.*
import uz.isti.maxtel.R
import uz.isti.maxtel.base.*
import uz.isti.maxtel.screen.main.MainViewModel

class CategoryFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {
    override fun getLayout(): Int = R.layout.fragment_category
    lateinit var viewModel: MainViewModel

    override fun setupViews() {
        category_card1.setOnClickListener {
            Log.d("btnSetup", "Selected")

        }

        category_card1.setOnClickListener {

        }

       /* category_card2.setOnClickListener {
            findNavController().navigate(R.id.sendFragment)
        }
        category_card3.setOnClickListener {
            findNavController().navigate(R.id.sendFragment)
        }
        category_card4.setOnClickListener {
            findNavController().navigate(R.id.sendFragment)
        }*/

    }


    override fun loadData() {

    }

    override fun setData() {

    }

    override fun onRefresh() {

    }

    /* fun setAds(){
         if (viewModel.successAdsData.value != null){
             val data = viewModel.successAdsData.value

             carouselView.setImageListener { position, imageView ->
                 imageView.scaleType = ImageView.ScaleType.FIT_XY
                 if (position == 0){
                     imageView.loadImage(App.imageBaseUrl + data?.reklama1)
                 }
                 if (position == 1){
                     imageView.loadImage(App.imageBaseUrl + data?.reklama2)
                 }
                 if (position == 2){
                     imageView.loadImage(App.imageBaseUrl + data?.reklama3)
                 }
             }

             carouselView.pageCount = 3
             carouselView.visibility = View.VISIBLE
         }
     }*/

   /* override fun setData() {
        if (viewModel.storesData.value != null){
            viewModel.storesData.value!!.forEach { store ->
                if (Prefs.getStore()?.id == store.id){
                    store.checked = true
                }
            }
            recycler.layoutManager = LinearLayoutManager(activity)
            recycler.adapter = StoresAdapter(viewModel.storesData.value ?: emptyList(), object : BaseAdapterListener{
                override fun onClickItem(item: Any?) {
                    getBaseActivity {
                        if (Prefs.getCartList().count() > 0){
                            activity?.showWarning(getString(R.string.please_clear_cart))
                            return@getBaseActivity
                        }

                        Prefs.setStore(item as StoreSimpleModel)

                        it.updateStore()
                        it.showSuccess(getString(R.string.store_selected))
                    }
                }
            })
        }
    }*/



}
