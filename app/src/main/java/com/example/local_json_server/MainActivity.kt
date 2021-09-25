package com.example.local_json_server

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.json.server.jsonData.TestJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Jsonテスト   begin
        var pTestJson = TestJson()
        GlobalScope.launch() {
            withContext(Dispatchers.IO) {
                //特別データ　テスト
                Log.e(TAG, "onCreate: 特別データ　テスト!!!", )
                try {
                    pTestJson.post()
                } catch (e: Exception) {
                    Log.e(TAG, "TAG", e)
                }
            }
        }
        //Jsonテスト   begin
    }
}