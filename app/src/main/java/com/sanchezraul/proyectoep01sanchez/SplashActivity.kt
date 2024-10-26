package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var startAnimation by remember { mutableStateOf(false) }

            val offsetY by animateDpAsState(

                targetValue = if (startAnimation) 0.dp else 1500.dp,
                animationSpec = tween(durationMillis = 1000)
            )

            val alpha by animateFloatAsState(
                targetValue = if (startAnimation) 1f else 0f,
                animationSpec = tween(durationMillis = 3000)
            )

            val scale by animateFloatAsState(
                targetValue = if (startAnimation) 1f else 3f,
                animationSpec = tween(durationMillis = 3000)
            )
            ProyectoEP01SanchezTheme {
                LaunchedEffect(key1 = true) {
                    startAnimation  = true
                    delay(5000)
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }

                Box(
                    modifier = Modifier.fillMaxSize()

                        .background(Color1),

                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Bienvenido al",
                            color = Color2,
                            style = MaterialTheme.typography.headlineLarge,
                            )

                        Image(
                            painter= painterResource (R.drawable.logo),
                            contentDescription = "El logo de la empresa",
                            modifier = Modifier
                                .offset(y=offsetY)
                                .graphicsLayer(
                                    alpha = alpha,
                                    scaleX = scale,
                                    scaleY = scale
                                )

                        )
                    }


                }
                }
            }
        }
    }


