package uz.group.anticor.repository

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import uz.group.anticor.App
import uz.group.anticor.api.Api
import uz.group.anticor.api.Client

open class BaseRepository {

   // val api = Client.getInstance(App.app).create(Api::class.java)

    val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable): Disposable {
        compositeDisposable.add(disposable)
        return disposable
    }
}