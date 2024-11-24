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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseProvider
import com.sanchezraul.proyectoep01sanchez.dao.User
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import kotlinx.coroutines.launch

class UserUpdateActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle = intent.extras

        var idroom = bundle!!.getInt("idroom")
        var nameroom = bundle.getString("nameroom")
        var lastnameroom = bundle.getString("lastnameroom")
        var emailroom = bundle.getString("emailroom")
        var telefonoroom = bundle.getString("telefonoroom")
        var passwordroom = bundle.getString("passwordroom")
        var dniroom = bundle.getString("dniroom")

        enableEdgeToEdge()
        setContent {
            var idf by remember { mutableStateOf(idroom.toString()) }
            var namef by remember { mutableStateOf(nameroom.toString()) }
            var lastnamef by remember { mutableStateOf(lastnameroom.toString()) }
            var emailf by remember { mutableStateOf(emailroom.toString()) }
            var celularf by remember { mutableStateOf(telefonoroom.toString()) }
            var passwordf by remember { mutableStateOf(passwordroom.toString()) }
            var dnif by remember { mutableStateOf(dniroom.toString()) }

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
                                                        this@UserUpdateActivity,
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
                                        this@UserUpdateActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserUpdateActivity,
                                        LocalesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserUpdateActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserUpdateActivity,
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
                                text = "Actualizar mis datos".uppercase(),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color1
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(15.dp, 0.dp, 15.dp, 0.dp)
                            ,
                        ) {
                            OutlinedTextField(
                                modifier = Modifier.width(100.dp),
                                value = idf,
                                //shape = RoundedCornerShape(20.dp),
                                onValueChange = {
                                },
                                label = {
                                    Text(
                                        text = "Código",
                                        style = MaterialTheme.typography.displayMedium,
                                    )
                                },
                                textStyle = TextStyle(
                                    color = Color3,
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))

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
                                    value = namef,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        namef=it
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
                                    value = emailf,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        emailf=it
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
                                    value = passwordf,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        passwordf=it
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
                                    value = lastnamef,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        lastnamef=it
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
                                    value = celularf,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        celularf=it
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
                                    value = dnif,
                                    //shape = RoundedCornerShape(20.dp),
                                    onValueChange = {
                                        dnif=it
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

                        Spacer(modifier = Modifier.height(20.dp))

                        Column(      modifier = Modifier
                            .fillMaxWidth()
                            .padding(50.dp,0.dp,50.dp,0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally)
                        {
                            Button(
                                onClick = {
                                    val database = DatabaseProvider.getDatabase(this@UserUpdateActivity)
                                    val userDao = database.userDao()
                                    lifecycleScope.launch {
                                        val user = User(
                                            idroom =idf.toInt(),
                                            nameroom = namef,
                                            lastnameroom = lastnamef,
                                            emailroom = emailf,
                                            telefonoroom = celularf,
                                            dniroom= dnif,
                                            passwordroom = passwordf,
                                        )
                                        userDao.updateUser(user)
                                        finish()
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                                    .height(55.dp)

                            ) {
                                Text(
                                    text = "Actualizar".uppercase(),
                                    color = Color2,
                                    style = MaterialTheme.typography.displayMedium,
                                    )
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedButton (
                                onClick = {
                                    val database = DatabaseProvider.getDatabase(this@UserUpdateActivity)
                                    val userDao = database.userDao()
                                    lifecycleScope.launch {
                                        val user = User(
                                            idroom =idf.toInt(),
                                            nameroom = namef,
                                            lastnameroom = lastnamef,
                                            emailroom = emailf,
                                            telefonoroom = celularf,
                                            dniroom= dnif,
                                            passwordroom = passwordf,
                                        )
                                        userDao.deleteUser(user)
                                        finish()
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                                    .height(55.dp),
                                //cambio de color de borde
                                border = BorderStroke(2.dp, Color1)


                            ) {
                                Text(
                                    text = "Eliminar".uppercase(),
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

