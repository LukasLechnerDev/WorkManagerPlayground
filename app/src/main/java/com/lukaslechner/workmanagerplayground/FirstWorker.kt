package com.lukaslechner.workmanagerplayground

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FirstWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.d("FirstWorker", "FirstWorker#doWork()")
        return Result.success()
    }
}