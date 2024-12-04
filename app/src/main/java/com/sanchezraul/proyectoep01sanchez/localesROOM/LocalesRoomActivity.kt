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
import androidx.compose.foundation.interaction.DragInteraction
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.MainActivity
import com.sanchezraul.proyectoep01sanchez.R
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseLocalProvider
import com.sanchezraul.proyectoep01sanchez.dao.Local
import com.sanchezraul.proyectoep01sanchez.dao.LocalDao
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color7
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class LocalesRoomActivity : ComponentActivity() {


    private lateinit var localDao: LocalDao


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = DatabaseLocalProvider.getDatabase(this)

        localDao = database.localDao()

        enableEdgeToEdge()
        setContent {

            var localList = remember { mutableStateOf(listOf<Local>())}

                LaunchedEffect(Unit) {
                localDao.getAllLocales().collect { locales ->

                    localList.value = locales
                }
            }

            ProyectoEP01SanchezTheme {
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
                                                            this@LocalesRoomActivity,
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
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    startActivity(Intent(this@LocalesRoomActivity,
                                        LocalesInsertRoomActivity::class.java
                                        )
                                    )
                                },
                                containerColor = Color1
                            )
                            {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Add a local",
                                    tint = Color2,
                                )
                            }
                        }

                    ) { innerPadding ->
                        Column(
                            modifier = Modifier.padding(innerPadding).fillMaxSize()
                                .background(Color2)
                        ) {
                            Spacer(modifier = Modifier.height(15.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth().background(Color.White)
                                    .padding(10.dp, 0.dp, 10.dp, 0.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Conoce todos nuestros locales".uppercase(),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = Color1
                                )
                            }

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(14.dp),
                                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp).background(
                                    Color2)
                            ) {
                                items(localList.value) { local ->
                                    Column(
                                        modifier = Modifier
                                            //.border(2.dp, MaterialTheme.colorScheme.primary)
                                            .padding(12.dp, 0.dp, 12.dp, 0.dp)
                                            .fillMaxWidth()
                                            // .background(
                                            //     Color1, RoundedCornerShape(10.dp)
                                            // )
                                            .clickable {}
                                    ) {
                                        OutlinedCard (
                                            colors = CardDefaults.cardColors(Color2),
                                            border = BorderStroke(4.dp, Color1),
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .background(Color1)
                                                    .padding(20.dp,10.dp,0.dp,5.dp),

                                                //horizontalAlignment =  Alignment.CenterHorizontally,
                                            ){
                                                Text(
                                                    text = "Local " + local.idlocal.toString(),
                                                    textAlign = TextAlign.Left,
                                                    style = MaterialTheme.typography.headlineMedium,
                                                    color = Color2,
                                                )
                                            }
                                            Row (
                                                modifier = Modifier.fillMaxWidth()
                                                    .background(Color2)
                                                    .padding(20.dp,10.dp,20.dp,10.dp),
                                            ){
                                                Column(
                                                    modifier = Modifier.weight(1f)
                                                        .background(Color2),
                                                    //horizontalAlignment = Alignment.CenterHorizontally, PARA QUE EL ALINEAMIENTO DEL
                                                    // TEXTO QUE ESTA DENTRO FUNCIONE, QUITÉ ESTA PROPIEDAD
                                                )
                                                {
                                                    Spacer(modifier = Modifier.height(10.dp))

                                                    Text(
                                                        text =  local.namelocal,
                                                        style = MaterialTheme.typography.displayLarge,
                                                        textAlign = TextAlign.Left,
                                                        color = Color1
                                                    )
                                                    Spacer(modifier = Modifier.width(10.dp))

                                                    Text(
                                                        text = local.direccionlocal,
                                                        style = MaterialTheme.typography.displayMedium,
                                                        color = Color6
                                                    )

                                                    Spacer(modifier = Modifier.height(10.dp))

                                                    Row(
                                                        modifier = Modifier.fillMaxSize()
                                                            .background(Color2),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {

                                                        Icon(
                                                            painter = painterResource(id = R.drawable.telephone),
                                                            contentDescription = null,
                                                            tint = Color1,
                                                            modifier = Modifier.size(25.dp)
                                                        )

                                                        Spacer(modifier = Modifier.width(5.dp))

                                                        Text(
                                                            text = local.telefonolocal,
                                                            modifier = Modifier.padding(top = 5.dp),
                                                            style = MaterialTheme.typography.displaySmall,
                                                            color = Color1
                                                        )
                                                    }
                                                }
                                                Column(
                                                    modifier = Modifier.weight(0.5f)
                                                        .background(Color2),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Bottom
                                                ) {
                                                    Spacer(modifier = Modifier.height(75.dp))

                                                    Row(
                                                        modifier = Modifier.fillMaxSize(),
                                                        horizontalArrangement = Arrangement.Center,
                                                        verticalAlignment = Alignment.CenterVertically

                                                    ) {
                                                        Icon(
                                                            painter = painterResource(id = R.drawable.pencil),
                                                            contentDescription = null,
                                                            tint =Color1,
                                                            modifier = Modifier
                                                                .size(30.dp)
                                                                .clickable {
                                                                    val intent = Intent(this@LocalesRoomActivity,
                                                                        LocalesUpdateRoomActivity::class.java)

                                                                    // Pasar variables

                                                                    intent.putExtra("idEditar", local.idlocal)
                                                                    intent.putExtra("nombreEditar", local.namelocal)
                                                                    intent.putExtra("direccionEditar", local.direccionlocal)
                                                                    intent.putExtra("latitudEditar", local.latitud.toString())
                                                                    intent.putExtra("longitudEditar", local.longitud.toString())
                                                                    intent.putExtra("telefonoEditar", local.telefonolocal)

                                                                    startActivity(intent)
                                                                },
                                                        )
                                                        Spacer(modifier = Modifier.width(15.dp))

                                                        //Para que el icno se vea con sus colores, lo cambié por Image
                                                        Image(
                                                            painter = painterResource(id = R.drawable.map),
                                                            contentDescription = null,
                                                            //tint = Color1,

                                                            modifier = Modifier.
                                                                size(40.dp)
                                                                .clickable {
                                                                },
                                                        )
                                                    }

                                                }
                                            }
                                            Spacer(modifier = Modifier.height(5.dp))

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
