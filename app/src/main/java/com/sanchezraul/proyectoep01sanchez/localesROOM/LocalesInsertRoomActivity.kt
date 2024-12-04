package com.sanchezraul.proyectoep01sanchez.localesROOM

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sanchezraul.proyectoep01sanchez.MainActivity
import com.sanchezraul.proyectoep01sanchez.R
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseLocalProvider
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseProvider
import com.sanchezraul.proyectoep01sanchez.dao.Local
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import kotlinx.coroutines.launch

class LocalesInsertRoomActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var nombre by remember { mutableStateOf("") }
            var direccion by remember { mutableStateOf("") }
            var latitud by remember { mutableStateOf("") }
            var longitud by remember { mutableStateOf("") }
            var telefono by remember { mutableStateOf("") }

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
                                                        this@LocalesInsertRoomActivity,
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

                    ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Spacer(modifier = Modifier.height(0.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(0.dp, 20.dp, 0.dp, 10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .background(Color2)
                                    //.border(BorderStroke(1.dp, Color3))
                                ,
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.padding(0.dp,20.dp,0.dp,0.dp)
                                        .background(Color2),
                                    text = "Nuevo Local".uppercase(),
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = Color1
                                )
                                Spacer(modifier = Modifier.width(20.dp))

                                Icon(
                                    painter = painterResource(id = R.drawable.restaurant),

                                    tint =Color1,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable {

                                        },
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            OutlinedTextField(
                                value = nombre,
                                onValueChange = {
                                    nombre = it
                                },
                                label = {
                                    Text(
                                        text = "Nombre",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = direccion,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    direccion = it
                                },
                                label = {
                                    Text(
                                        text = "Dirección",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))

                            OutlinedTextField(
                                value = latitud,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    latitud = it
                                },
                                label = {
                                    Text(
                                        text = "Latitud",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = longitud,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    longitud = it
                                },
                                label = {
                                    Text(
                                        text = "Longitud",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = telefono,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    telefono = it
                                },
                                label = {
                                    Text(
                                        text = "Teléfono",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(40.dp))

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(40.dp, 0.dp, 40.dp, 0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        val database = DatabaseLocalProvider.getDatabase(this@LocalesInsertRoomActivity)
                                        val localDao = database.localDao()
                                        lifecycleScope.launch {
                                            var local = Local(
                                                namelocal = nombre,
                                                direccionlocal = direccion,
                                                latitud = latitud.toDouble(),
                                                longitud = longitud.toDouble(),
                                                telefonolocal = telefono
                                            )

                                            localDao.insertLocal(local)
                                            finish()
                                        }
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .height(55.dp)

                                ) {
                                    Text(
                                        text = "Registrar".uppercase(),
                                        color = Color2,
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