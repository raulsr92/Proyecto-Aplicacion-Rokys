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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseProvider
import com.sanchezraul.proyectoep01sanchez.dao.User
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import kotlinx.coroutines.launch

class UserInsertActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var name by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var celular by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var dni by remember { mutableStateOf("") }

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
                                                        this@UserInsertActivity,
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
                                        this@UserInsertActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserInsertActivity,
                                        LocalesRoomActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserInsertActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserInsertActivity,
                                        LoginActivity::class.java
                                    )
                                )
                            })
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color2)
                            .fillMaxSize()

                    ) {
                        Spacer(modifier = Modifier.height(5.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(0.dp, 20.dp, 0.dp, 0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Crear Cuenta".uppercase(),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color1
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(15.dp, 0.dp, 15.dp, 0.dp)
                            ,
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Column(
                                //distribuir 50% de ancho para la columna dentro de la fila
                                modifier = Modifier.weight(1f)
                            ) {
                                OutlinedTextField(
                                    value = name,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        name=it
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
                                Spacer(modifier = Modifier.height(35.dp))

                                OutlinedTextField(
                                    value = email,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        email=it
                                    },
                                    label = {
                                        Text(
                                            text = "E-mail",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )

                                Spacer(modifier = Modifier.height(35.dp))

                                OutlinedTextField(
                                    value = password,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        password=it
                                    },
                                    label = {
                                        Text(
                                            text = "Contraseña",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    visualTransformation = PasswordVisualTransformation(),
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Column(
                                //distribuir 50% de ancho para la columna dentro de la fila

                                modifier = Modifier.weight(1f)

                            ) {
                                OutlinedTextField(
                                    value = lastName,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        lastName=it
                                    },
                                    label = {
                                        Text(
                                            text = "Apellido",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )
                                Spacer(modifier = Modifier.height(35.dp))
                                OutlinedTextField(
                                    value = celular,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        celular=it
                                    },
                                    label = {
                                        Text(
                                            text = "Celular",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )
                                Spacer(modifier = Modifier.height(35.dp))
                                OutlinedTextField(
                                    value = dni,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        dni=it
                                    },
                                    label = {
                                        Text(
                                            text = "Nro DNI",
                                            style = MaterialTheme.typography.displayMedium,
                                        )
                                    },
                                    textStyle = TextStyle(
                                        color = Color3,
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        Column(      modifier = Modifier
                            .fillMaxWidth()
                            .padding(50.dp,0.dp,50.dp,0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally)
                        {
                            Button(
                                onClick = {
                                    val database = DatabaseProvider.getDatabase(this@UserInsertActivity)
                                    val userDao = database.userDao()
                                    lifecycleScope.launch {
                                        val user = User(
                                            nameroom = name,
                                            lastnameroom = lastName,
                                            emailroom = email,
                                            telefonoroom = celular,
                                            passwordroom = password,
                                            dniroom = dni
                                        )
                                        userDao.insertUser(user)
                                        finish()
                                    }

                                },
                                modifier = Modifier.fillMaxWidth()
                                    .height(55.dp)

                            ) {
                                Text(
                                    text = "Únete ahora".uppercase(),
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

