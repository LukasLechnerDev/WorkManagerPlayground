package com.lukaslechner.workmanagerplayground

import android.app.Application
import android.util.Log
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d("MyApplication", "MyApplication#onCreate()")

        val firstWorkerRequest =
            PeriodicWorkRequestBuilder<FirstWorker>(1, TimeUnit.MINUTES).setInitialDelay(
                1,
                TimeUnit.MINUTES
            ).build()

        WorkManager
            .getInstance(this)
            .enqueueUniquePeriodicWork("FirstWorker", ExistingPeriodicWorkPolicy.KEEP, firstWorkerRequest)
    }
}