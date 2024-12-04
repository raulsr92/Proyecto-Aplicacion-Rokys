package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            ProyectoEP01SanchezTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
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
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id=R.drawable.logo),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp),

                                        )
                                }

                            }
                        )
                    },
                    bottomBar = {
                        DrawBottomBar(
                            {startActivity(Intent(this@MainActivity, MaestroActivity::class.java))},
                            {startActivity(Intent(this@MainActivity, LocalesRoomActivity::class.java))},
                            { startActivity(Intent(this@MainActivity, PaisesActivity::class.java))},
                            {startActivity(Intent(this@MainActivity, LoginActivity::class.java))}
                            )
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.White)
                            .fillMaxSize()

                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.pollo_1),
                            contentDescription = "null",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(250.dp)
                        )
                        Column (
                            modifier = Modifier.padding(30.dp,30.dp,30.dp,20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ){
                            Text(
                                text = "Bienvenido a Roky's",
                                style = MaterialTheme.typography.headlineLarge,
                                color = Color4
                            )
                            Text(
                                text = "En tu casa o en la nuestra no importa donde estés, siempre vamos a engreirte con el gran sabor que nos caracteriza. ¡Gracias por preferirnos!",
                                style = MaterialTheme.typography.displaySmall,
                                color = Color4
                                )
                        }

                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp)    ,
                            horizontalArrangement = Arrangement.Center

                        ){
                            Image(
                                painter = painterResource(id = R.drawable.circulito),
                                contentDescription = "null",
                                colorFilter = ColorFilter.tint(Color1),
                                modifier = Modifier.size(15.dp),
                            )
                            Spacer(modifier = Modifier.width(5.dp)) // Para agregar espacio entre elementos
                            Image(
                                painter = painterResource(id = R.drawable.circulito),
                                contentDescription = "null",
                                colorFilter = ColorFilter.tint(Color5),
                                modifier = Modifier.size(15.dp),
                            )
                            Spacer(modifier = Modifier.width(5.dp))

                            Image(
                                painter = painterResource(id = R.drawable.circulito),
                                contentDescription = "null",
                                colorFilter = ColorFilter.tint(Color5),
                                modifier = Modifier.size(15.dp),
                            )
                            Spacer(modifier = Modifier.width(5.dp))

                            Image(
                                painter = painterResource(id = R.drawable.circulito),
                                contentDescription = "null",
                                colorFilter = ColorFilter.tint(Color5),
                                modifier = Modifier.size(15.dp),
                            )
                        }

                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp,0.dp,20.dp,0.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Button(
                                onClick = {
                                startActivity(Intent(this@MainActivity, FoodActivity::class.java))
                                },
                                modifier = Modifier.fillMaxWidth()
                                    .height(50.dp)
                            ){
                                Row (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Spacer(modifier = Modifier.width(30.dp))


                                    Text(
                                        text = stringResource(id = R.string.button_1),
                                        color = Color2,
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.flecha_ingresar),
                                        contentDescription = "null",
                                        colorFilter = ColorFilter.tint(Color6),
                                        modifier = Modifier.size(45.dp),
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

