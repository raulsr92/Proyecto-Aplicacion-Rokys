package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class LoginActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoEP01SanchezTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.shadow(
                                elevation = 4.dp, // Adjust the elevation value as needed
                                spotColor = Color3, // Adjust the shadow color if needed
                                ambientColor = Color5 // Adjust the ambient shadow color if needed
                            ),
                            colors = topAppBarColors(
                                containerColor = Color2,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(70.dp)
                                            .clickable {
                                                startActivity(
                                                    Intent(
                                                        this@LoginActivity,
                                                        MainActivity::class.java
                                                    )
                                                )
                                            },
                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .border(width = 1.dp, color = Color5, CircleShape)

                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center


                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.shoppingcart),
                                                contentDescription = null,
                                                modifier = Modifier.size(20.dp),
                                            )
                                        }
                                    }
                                }

                            }
                        )
                    },
                    bottomBar = {
                        DrawBottomBar(
                            {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        LocalesRoomActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {startActivity(Intent(this@LoginActivity, LoginActivity::class.java))})
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color2)
                            .fillMaxSize()

                    ) {
                        Spacer(modifier = Modifier.height(5.dp))

                        Column (
                            modifier = Modifier.fillMaxWidth()
                                .padding(0.dp, 20.dp, 0.dp, 10.dp)
                            ,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            Text(
                                text = "Inicia Sesión".uppercase(),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color1
                            )
                        }
                        Spacer(modifier = Modifier.height(0.dp))
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                            OutlinedTextField(
                                value= " ",
                                //shape = RoundedCornerShape(20.dp),
                                onValueChange = {
                                },
                                label = {
                                    Text(
                                        text="Correo Electrónico",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value= " ",
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                },
                                label = {
                                    Text(
                                        text="Contraseña",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(25.dp))

                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(50.dp,0.dp,50.dp,0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .height(55.dp)

                                ) {
                                    Text(
                                        text = "Iniciar Sesión".uppercase(),
                                        color  = Color2,
                                        style = MaterialTheme.typography.displayMedium,

                                        )
                                }
                                Spacer(modifier = Modifier.height(40.dp))
                                Text(
                                    text = "¿No tienes una cuenta?",
                                    color = Color1,
                                    style = MaterialTheme.typography.displayMedium,

                                    )
                                OutlinedButton (
                                    onClick = {
                                        startActivity(Intent(this@LoginActivity, UserActivty::class.java))
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .height(55.dp),
                                    //cambio de color de borde
                                    border = BorderStroke(2.dp, Color1)


                                ) {
                                    Text(
                                        text = "únete Ahora".uppercase(),
                                        color  = Color1,
                                        style = MaterialTheme.typography.displayMedium,

                                        )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

