package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class PaisesInsertActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var pais by remember { mutableStateOf("") }
            var capital by remember { mutableStateOf("") }
            var poblacion by remember { mutableStateOf("") }
            var continente by remember { mutableStateOf("") }
            var codigo by remember { mutableStateOf("") }
            var area by remember { mutableStateOf("") }


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
                                                        this@PaisesInsertActivity,
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
                                        this@PaisesInsertActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@PaisesInsertActivity,
                                        LocalesMapActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@PaisesInsertActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {startActivity(Intent(this@PaisesInsertActivity, LoginActivity::class.java))})
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
                                text = "Registra un nuevo país".uppercase(),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color1
                            )
                        }
                        Spacer(modifier = Modifier.height(0.dp))
                        Column(
                            modifier = Modifier.fillMaxSize()
                                ,
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            OutlinedTextField(
                                value= pais,
                                //shape = RoundedCornerShape(20.dp),
                                onValueChange = {
                                    pais = it
                                },
                                label = {
                                    Text(
                                        text="País",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value= capital,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    capital = it
                                },
                                label = {
                                    Text(
                                        text="Capital",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value= poblacion,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    poblacion = it
                                },
                                label = {
                                    Text(
                                        text="Población",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            OutlinedTextField(
                                value= continente,
                                //shape = RoundedCornerShape(20.dp),

                                onValueChange = {
                                    continente = it
                                },
                                label = {
                                    Text(
                                        text="Continente",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )

                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .padding(40.dp, 0.dp, 40.dp, 0.dp)
                                    ,
                                horizontalArrangement = Arrangement.Center

                            ) {
                                OutlinedTextField(
                                    value= codigo,
                                    //shape = RoundedCornerShape(20.dp),

                                    onValueChange = {
                                        codigo = it
                                    },
                                    label = {
                                        Text(
                                            text="Código",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    ),
                                    modifier = Modifier.fillMaxWidth(0.4f)

                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                OutlinedTextField(
                                    value= area,
                                    //shape = RoundedCornerShape(20.dp),

                                    onValueChange = {
                                        area = it
                                    },
                                    label = {
                                        Text(
                                            text="Área",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(50.dp,0.dp,50.dp,0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        insertCountry(pais, capital, poblacion, continente, codigo, area)
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .height(55.dp)

                                ) {
                                    Text(
                                        text = "Registrar".uppercase(),
                                        color  = Color2,
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

    private fun insertCountry(pais: String, capital: String, poblacion: String, continente: String, codigo: String, area: String) {

        Log.d("Response", pais + "insertCountry"+ capital + poblacion + continente)

        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/paisesinsert.php"

        val stringRequest = object: StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("Response JSON ", response);

                startActivity(Intent(this@PaisesInsertActivity, PaisesActivity::class.java))
            },
            {  }) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["pais"] = pais
                params["capital"] = capital
                params["poblacion"] = poblacion
                params["continente"] = continente
                params["codpais"] = codigo
                params["area"]= area
                return params
            }
        }
        queue.add(stringRequest)
    }
}

