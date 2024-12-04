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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseProvider
import com.sanchezraul.proyectoep01sanchez.dao.User
import com.sanchezraul.proyectoep01sanchez.dao.UserDao
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class UserActivty : ComponentActivity() {

    private lateinit var userDao: UserDao

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = DatabaseProvider.getDatabase(this)

        userDao  = database.userDao()

        enableEdgeToEdge()
        setContent {
            var userList = remember { mutableStateOf(listOf<User>()) }

            LaunchedEffect(Unit) {
                userDao.getAllUsers().collect{ users ->
                    userList.value  = users
                }
            }

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
                                                        this@UserActivty,
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
                                        this@UserActivty,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserActivty,
                                        LocalesRoomActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@UserActivty,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {startActivity(Intent(this@UserActivty, LoginActivity::class.java))})
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@UserActivty,
                            UserInsertActivity::class.java
                                    ))
                            },
                            containerColor = Color1
                        )
                        {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "Add a country",
                                tint = Color2,
                            )
                        }
                    }

                ) { innerPadding ->
                    Column (
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                            .background(Color.White)
                    ) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(14.dp),
                            modifier = Modifier.padding(10.dp, 40.dp, 10.dp, 40.dp)
                        ) {
                            items(userList.value) { user ->
                                Column(
                                    modifier = Modifier
                                        .border(2.dp, MaterialTheme.colorScheme.primary)
                                        .padding(12.dp, 15.dp, 12.dp, 15.dp)
                                        .fillMaxWidth()
                                        .background(
                                            Color2, RoundedCornerShape(10.dp)
                                        )
                                        .clickable {
                                            val intent = Intent(this@UserActivty, UserUpdateActivity::class.java)
                                            intent.putExtra("idroom", user.idroom)
                                            intent.putExtra("nameroom", user.nameroom)
                                            intent.putExtra("lastnameroom", user.lastnameroom)
                                            intent.putExtra("emailroom", user.emailroom)
                                            intent.putExtra("telefonoroom", user.telefonoroom)
                                            intent.putExtra("passwordroom", user.passwordroom)
                                            intent.putExtra("dniroom", user.dniroom)

                                            startActivity(intent)
                                        }

                                )
                                {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Text(
                                            text = user.idroom.toString(),
                                            style = MaterialTheme.typography.headlineLarge,
                                            color = Color1
                                        )
                                        Spacer(modifier = Modifier.width(20.dp))

                                        Column {
                                            Text(
                                                text = user.nameroom+" " + user.lastnameroom,
                                                style = MaterialTheme.typography.headlineSmall,
                                                textAlign = TextAlign.Start,
                                                color = Color1
                                            )
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Text(
                                                    text = "Correo: ",
                                                    style = MaterialTheme.typography.displayMedium,
                                                    color = Color6
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Text(
                                                    text = user.emailroom,
                                                    style = MaterialTheme.typography.displaySmall,
                                                    color = Color4
                                                )
                                            }

                                            Row (
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Text(
                                                    text = "Teléfono: ",
                                                    style = MaterialTheme.typography.displayMedium,
                                                    color = Color6
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))

                                                Text(
                                                    text = user.telefonoroom.toString(),
                                                    style = MaterialTheme.typography.displaySmall,
                                                    color = Color4
                                                )
                                            }
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "DNI: ",
                                                    style = MaterialTheme.typography.displayMedium,
                                                    color = Color6
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Text(
                                                    text = user.dniroom.toString(),
                                                    style = MaterialTheme.typography.displaySmall,
                                                    color = Color4
                                                )
                                            }

                                            Text(
                                                text = user.createdAt.toString(),
                                                style = MaterialTheme.typography.displaySmall,
                                                        color = Color3

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
    }
}

