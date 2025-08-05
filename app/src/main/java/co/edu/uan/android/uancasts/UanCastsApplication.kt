package co.edu.uan.android.uancasts

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UanCastsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}