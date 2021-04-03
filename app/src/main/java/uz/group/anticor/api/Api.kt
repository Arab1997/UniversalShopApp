package uz.group.anticor.api

import io.reactivex.Observable
import retrofit2.http.*
import uz.group.anticor.model.*
import uz.group.anticor.model.request.CodeConfirmRequest
import uz.group.anticor.model.request.RatingRequest
import uz.group.anticor.utils.Prefs

interface Api {

    @GET("GetStore")
    fun getRegions(): Observable<BaseResponse<List<RegionsModel>?>>
   /* @GET("GetStore")
    fun getRegions(): Observable<BaseResponse<List<StoreSimpleModel>?>>*/
    @GET("SmsCheck")
    fun login(@Query("telephone") phone: String): Observable<BaseResponse<PhoneCheckResponse?>>

    @POST("RegistryClient")
    fun loginConfirm(@Body request: CodeConfirmRequest): Observable<BaseResponse<LoginConfirmResponse?>>

    @POST("ClientInfoEdit")
    fun getInfo(@Body request: ClientInfoRequest): Observable<BaseResponse<ClientInfoModel?>>

/*
    @GET("GetBolim")
    fun getSections(@Query("skladid") storeId: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<SectionModel>?>>

    @GET("GetBrend")
    fun getBrand(@Query("bolimid") bolimid: String, @Query("skladid") storeId: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<BrandModel>?>>

    @GET("GetTovarByBrend")
    fun getProducts(@Query("brendid") brendId: String, @Query("categoryId") categoryId: String, @Query("skladid") storeId: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<ProductModel>?>>

    @GET("GetTovarInfo")
    fun getProductById(@Query("id") id: String, @Query("skladid") storeId: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<ProductModel>?>>

    @GET("GetTovar")
    fun getAllProducts(@Query("skladid") storeId: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<ProductModel>?>>

    @POST("GetTovarByFavourite")
    fun getTovarByIds(@Body request: GetTovarByFavourite): Observable<BaseResponse<List<ProductModel>?>>

    @GET("GetSkladInfo")
    fun getStoreInfo(@Query("id") id: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<StoreModel>?>>
*/



    @GET("GetBronListKlient")
    fun getOrders(@Query("token") token: String = Prefs.getToken()): Observable<BaseResponse<List<OrderModel>?>>

    @POST("PostRating")
    fun postRating(@Body request: RatingRequest): Observable<BaseResponse<Any?>>

    @GET("GetReklama")
    fun getAds(): Observable<BaseResponse<List<AdModel>?>>

    @GET("GetNews")
    fun getNews(): Observable<BaseResponse<List<NewsModel>?>>

/*    @GET("SearchByStringAndSklad")
    fun getProductsByName(@Query("productName") name: String, @Query("skladid") id: String = Prefs.getStore()?.id ?: ""): Observable<BaseResponse<List<ProductModel>?>>*/

    @GET("GetLocationByBron")
    fun getDeliveryLocation(@Query("refKey") id: String): Observable<BaseResponse<DeliveryLocation?>>

    @GET("ClientSverkaList")
    fun getActReport(@Query("bsana")startDate: String, @Query("osana")endDate: String, @Query("skladid") storeId: String, @Query("dollar") dollar: Int, @Query("token") token: String = Prefs.getToken()): Observable<BaseResponse<ActReportModel?>>
}

