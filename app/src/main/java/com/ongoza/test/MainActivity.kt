package com.ongoza.test

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView: TextView = findViewById(R.id.MainText) as TextView
        val mSensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        Log.v ("Total sensors","ww4"+deviceSensors.size)
        var sb = StringBuilder()
        sb.append("Sensors list:")
        deviceSensors.forEach{
            sb.append(it.stringType.toString()+"\n")
            Log.v("SensorDec",it.stringType)
          }
        val strList = sb.toString()
        Log.v("SensorDec",strList)
        textView.text = strList
    }
}
