package uz.isti.maxtel.screen.main.profile

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottomsheet_language.view.*
import kotlinx.android.synthetic.main.fragment_profile.*

import uz.isti.maxtel.R
import uz.isti.maxtel.base.BaseFragment
import uz.isti.maxtel.base.startActivity
import uz.isti.maxtel.base.startClearTopActivity
import uz.isti.maxtel.screen.main.MainViewModel
import uz.isti.maxtel.screen.main.profile.edit.ProfileEditActivity
import uz.isti.maxtel.screen.splash.SplashActivity
import uz.isti.maxtel.utils.LocaleManager.setNewLocale
import uz.isti.maxtel.utils.Prefs

/**
 * A simple [Fragment] subclass.
 */
class FaqFragment : BaseFragment() {
    override fun getLayout(): Int = R.layout.fragment_profile
    lateinit var viewModel: MainViewModel

    override fun setupViews() {
       /* viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val user = Prefs.getClientInfo()

        tvPersonName.text = user?.name
        tvPhone.text = user?.phone

        lyProfile.setOnClickListener {
            getBaseActivity {
                it.startActivity<ProfileEditActivity>()
            }
        }*/


        lyLanguage.setOnClickListener {
            getBaseActivity {base ->
                val bottomSheetDialog = BottomSheetDialog(base)
                val viewLang = layoutInflater.inflate(R.layout.bottomsheet_language, null)
                bottomSheetDialog.setContentView(viewLang)
                viewLang.tvUzbCr.setOnClickListener {
                    Prefs.setLang("uz")
                    setNewLocale(base,"uz")
                    bottomSheetDialog?.dismiss()
                }
                viewLang.tvRu.setOnClickListener {
                    Prefs.setLang("en")
                    setNewLocale(base,"en")
                    bottomSheetDialog?.dismiss()
                }

                bottomSheetDialog.show()
            }
        }


        lyLogout.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Выйти")
            builder.setMessage("Вы действительно хотите выйти?")
            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Prefs.clearAll()
                getBaseActivity {
                    it.startClearTopActivity<SplashActivity>()
                }
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                //
            }
            builder.show()
        }
    }

    override fun loadData() {

    }

    override fun setData() {

    }

}
