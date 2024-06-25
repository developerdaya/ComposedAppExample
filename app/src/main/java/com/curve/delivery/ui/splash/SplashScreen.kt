package com.curve.delivery.ui.splash

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.curve.delivery.R
import androidx.compose.ui.res.painterResource
import com.curve.delivery.ui.home.HomeScreen
import com.curve.delivery.ui.login.LoginScreen
import com.curve.delivery.util.moveActivity
import com.curve.delivery.util.SharedPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(1024,1024)
        setContent {
            SplashScreen(this)
        }
    }



    @SuppressLint("NotConstructor")
    @Composable
    fun SplashScreen(myContext:Context)
    {
        Column(modifier = Modifier.fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(painter = painterResource(id = R.drawable.spalsh_logo), contentDescription = "Logo")

        }


        CoroutineScope(Dispatchers.IO).launch {
            delay(300)
            withContext(Dispatchers.Main)
            {
                if (SharedPreference.get(myContext).isLogin)
                {
                    moveActivity(HomeScreen())
                    finish()
                }
                else{
                    moveActivity(LoginScreen())
                    finish()
                }
            }
        }



    }

}




