package com.mizukikubota.tsundokubreak

import android.app.Application
import androidx.room.Room
import com.mizukikubota.tsundokubreak.domain.service.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.tag("mizukiTag")

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        ).build()
    }
}
