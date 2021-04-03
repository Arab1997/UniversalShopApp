package uz.group.anticor.screen.auth.selectregion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.group.anticor.model.StoreSimpleModel
import uz.group.anticor.repository.UserRepository

class SelectRegionViewModel : ViewModel(){
    val repository = UserRepository()

    val progress = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    val regionsData = MutableLiveData<List<StoreSimpleModel>>()

  /*  fun getRegions(){
        repository.getStores(progress, error, regionsData)
    }


    fun getSend(){
        repository.getStores(progress, error, regionsData)
    }*/

}