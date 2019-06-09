package com.ongoza.test

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: TextView = findViewById(R.id.MainText) as TextView
        val gyroView: TextView = findViewById(R.id.GyroText) as TextView
        val mSensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val deviceSensors: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        val sb = StringBuilder()
        var trGyro = false
        sb.append("Sensors list:\n")
        deviceSensors.forEach{
            sb.append(it.stringType.toString()+"\n")
            if(it.stringType.equals("android.sensor.gyroscope")){
                trGyro = true
            }
          }
        val strList = sb.toString()
        listView.text = strList
        if(trGyro){
            gyroView.text = Html.fromHtml("<b>Gyroscope <font color='#22AA22'>is present</font></b> on this device")
        }else{
            gyroView.text = Html.fromHtml("<b>Gyroscope <font color='#AA2222'>is not present</font></b> on this device")
        }
    }
}
