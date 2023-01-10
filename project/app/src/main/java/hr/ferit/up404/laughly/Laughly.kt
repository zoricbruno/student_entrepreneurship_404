package hr.ferit.up404.laughly

import android.app.Application

class Laughly : Application() {

    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}
