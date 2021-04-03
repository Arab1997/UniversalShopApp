package uz.group.anticor.screen.main.send.detail

import android.os.Bundle
import com.blankj.utilcode.util.NetworkUtils
import kotlinx.android.synthetic.main.activity_make_order.*
import org.greenrobot.eventbus.EventBus
import uz.group.anticor.R
import uz.group.anticor.base.BaseActivity
import uz.group.anticor.model.AddressModel
import uz.group.anticor.screen.main.MainViewModel

class SendActivity : BaseActivity() {
    override fun getLayout(): Int = R.layout.activity_make_order
    lateinit var viewModel: MainViewModel
    var address: AddressModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this)
        }*/
    }
    override fun initViews() {

      /*  viewModel.progress.observe(this, Observer {
            setProgress(it)
        })

        viewModel.progressStoreInfo.observe(this, Observer {
            setProgress(it)
        })

        viewModel.error.observe(this, Observer {
            showError(it)
        })
*/
        imgBackk.setOnClickListener {
            finish()
        }


        send.setOnClickListener {

         /*   var items = products.map {
                MakeOrderProductModel(
                    it.name,
                    it.id,
                    if(Prefs.getCurrency() == CurrencyEnum.USD) it.price else it.price * Prefs.getClientInfo()!!.currency,
                    it.cartCount.toDouble(),
                    edComment.text.toString(),
                    (if(Prefs.getCurrency() == CurrencyEnum.USD) it.price else it.price * Prefs.getClientInfo()!!.currency) * it.cartCount
                )
            }*/

          /*  items.forEach {
                productAmount += it.psumma
            }*/



          /*  val order = MakeOrderModel(
                Prefs.getStore()?.id?.toIntOrNull() ?: 0,
                address?.lon.toString(),
                address?.lat.toString(),
                edAddress.text.toString(),
                address?.address ?: "",
                totalAmount,
                items
            ) */
        }

        NetworkUtils.registerNetworkStatusChangedListener(object: NetworkUtils.OnNetworkStatusChangedListener{
            override fun onConnected(networkType: NetworkUtils.NetworkType?) {
                showConnection(notConnection = false)
                loadData()
            }

            override fun onDisconnected() {
                showConnection(notConnection = true)
            }
        })

    }

    override fun loadData() {
      //  viewModel.getStoreInfo()
    }

    override fun initData() {
      /*  val userInfo = Prefs.getClientInfo()
        edFullName.setText( userInfo?.name )
        edPhone.setText( userInfo?.phone )*/
    }

    override fun updateData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this)
        }
    }

  /*  fun setAddressData(){
        if (address != null && Prefs.getStoreInfo() != null){
            val store = Prefs.getStoreInfo()
            var results = FloatArray(10)
            Location.distanceBetween(store?.latitude?.toDoubleOrNull() ?: 0.0, store?.longitude?.toDoubleOrNull() ?: 0.0,
                address?.lat ?: 0.0, address?.lon ?: 0.0, results)
            var km = results[0] / 1000.0

            if (km.toInt() > (store?.radius ?: 0) && (store?.radius ?: 0) != 0){
                showWarning(getString(R.string.max_radius_delivery, (store?.radius ?: 0).toString()))
                address = null
                return
            }


            edAddress.setText(address?.address)
        }
    }*/

}
