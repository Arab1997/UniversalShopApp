package uz.isti.maxtel.api

import retrofit2.Response
import uz.isti.maxtel.model.OneIdResponce
import javax.inject.Inject


class ApiHelperForRegister @Inject constructor(private val apiServiceForRegister: ApiServiceForRegister) {

    suspend fun getAuthData(code: String): Response<OneIdResponce> =
        apiServiceForRegister.getAuthData(code = code)

}