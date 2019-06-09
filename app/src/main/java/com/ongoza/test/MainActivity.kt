package com.ongoza.test

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView: TextView = findViewById(R.id.MainText) as TextView
        var gyroView: TextView = findViewById(R.id.GyroText) as TextView
        val mSensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        Log.v ("Total sensors","ww4"+deviceSensors.size)
        var sb = StringBuilder()
        var trGyro = true
        sb.append("Sensors list:\n")
        deviceSensors.forEach{
            sb.append(it.stringType.toString()+"\n")
            if(it.stringType.equals("android.sensor.gyroscope")){
                trGyro = true
            }
            Log.v("SensorDec",it.stringType)
          }
        val strList = sb.toString()
        Log.v("SensorDec",strList)
        listView.text = strList
        if(trGyro){
            gyroView.text = Html.fromHtml("<b>Gyroscope <font color='#22AA22'>is present</font></b> on this device")
        }else{
            gyroView.text = Html.fromHtml("<b>Gyroscope <font color='#AA2222'>is not present</font></b> on this device")
        }
    }
}
