package com.sample.periodicwork

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DemoWorker(context : Context, params : WorkerParameters ) : Worker (context, params) {

    override fun doWork(): Result {
        Log.d( "MainActivity", "Perform some work" )
        return Result.success()
    }
}