package com.example.loginapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import org.json.JSONArray
import org.json.JSONObject

class PostRequest(val ct: Context, val type: String, val jsonvalues: JSONObject, val result: (JSONArray) -> Unit) {
    init {
        request_volley()
    }

    private fun request_volley() {
        val url = "https://aydeniztasarim.com/youtubetest/$type.php"
        val requ = object : JsonArrayRequest(Request.Method.POST, url, null,
            Response.Listener {
                result(it)
            }, Response.ErrorListener {
                Log.e("error", "error= $it")
                Toast.makeText(ct,"Error", Toast.LENGTH_LONG).show()
            }) {
            override fun getBody(): ByteArray {
                return jsonvalues.toString().toByteArray()
            }
        }
        MySingleton.getInstance(ct).addToRequestQueue(requ)
    }

}
