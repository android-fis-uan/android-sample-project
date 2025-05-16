package co.edu.uan.android.uancasts

import android.app.Application
import co.edu.uan.android.uancasts.data.AppContainer
import co.edu.uan.android.uancasts.data.DefaultAppContainer

class UanCastsApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}