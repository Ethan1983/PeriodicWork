package com.sample.periodicwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.scheduleText).setOnClickListener {

            Log.e( "MainActivity", "Schedule work requests" )

            PeriodicWorkRequestBuilder<DemoWorker>( 60, TimeUnit.MINUTES ).build().also { workRequest ->
                WorkManager.getInstance().enqueue( workRequest )
            }

            OneTimeWorkRequestBuilder<DemoWorker>()
                .setInitialDelay( 25, TimeUnit.MINUTES )
                .build().also { workRequest ->
                WorkManager.getInstance().enqueue( workRequest )
            }
        }
    }

    protected fun doSomething() {
        repeat( 100 ) {
            Log.e( "MainActivity", "doSometing $it" )
        }
    }
}
