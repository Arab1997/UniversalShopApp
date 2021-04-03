package uz.group.anticor.screen.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.group.anticor.utils.NetworkHelper
import uz.group.anticor.utils.Resource
import uz.group.anticor.api.ApiHelperForRegister
import uz.group.anticor.model.OneIdResponce
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkHelper: NetworkHelper,
    private val apiHelperForRegister: ApiHelperForRegister
) : ViewModel() {

    fun getCode(code1: String): MutableLiveData<Resource<OneIdResponce>> {
        val codeData = MutableLiveData<Resource<OneIdResponce>>()
        viewModelScope.launch {
            codeData.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                apiHelperForRegister.getAuthData(code1).let {
                    if (it.isSuccessful) {
                        codeData.postValue(Resource.success(it.body()))

                    } else codeData.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else codeData.postValue(Resource.error("No internet connection", null))
        }
        return codeData
    }
}