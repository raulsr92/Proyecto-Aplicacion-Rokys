package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color7
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class AboutActivity : ComponentActivity() {
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
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(end = 20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Image(
                                        painter = painterResource(id=R.drawable.logo),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp)
                                            .clickable {
                                                startActivity(Intent(this@AboutActivity, MainActivity::class.java))
                                            },

                                        )
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .border(width = 1.dp, color = Color5, CircleShape)

                                    ){
                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center


                                        ) {
                                            Image(
                                                painter = painterResource(id=R.drawable.shoppingcart),
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
                            {startActivity(Intent(this@AboutActivity, MaestroActivity::class.java))},
                            {startActivity(Intent(this@AboutActivity, LocalesActivity::class.java))},
                            { startActivity(Intent(this@AboutActivity, PaisesActivity::class.java))},
                            {startActivity(Intent(this@AboutActivity, LoginActivity::class.java))})


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

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp, 5.dp, 15.dp,5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id= R.string.phrase_4),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color4
                            )
                            Image(
                                painter = painterResource(id=R.drawable.share),
                                contentDescription = "icons",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(Color4)
                            )
                            Image(
                                painter = painterResource(id=R.drawable.heart),
                                contentDescription = "icons",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(Color4)
                            )


                        }

                        Box(
                            modifier = Modifier.padding(15.dp, 10.dp, 15.dp, 15.dp)

                        ){
                            Column(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(17.dp))
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                    .fillMaxWidth()
                                    .background(Color7)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.wrapContentWidth()
                                ) {
                                    Text(
                                        text="Amanda Morales - 5.0",
                                        style = MaterialTheme.typography.headlineSmall,
                                        modifier = Modifier.padding(10.dp, 10.dp, 8.dp, 0.dp),


                                        )
                                    Image(
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = "null",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.size(20.dp),
                                    )
                                }

                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.wrapContentWidth()
                                        .padding(15.dp, 10.dp, 8.dp, 0.dp),

                                    ){
                                    Text(
                                        text = "Es uno de los mejores sabores en referencia a pollo a la brasa que he probado. Totalmente jugoso y las papas crocantitas.",
                                        style = TextStyle(fontSize = 14.sp),
                                        modifier = Modifier.padding(bottom = 30.dp)

                                    )
                                }
                            }
                        }
                        Box(
                            modifier = Modifier.padding(15.dp, 30.dp, 15.dp, 15.dp)
                        ){
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id=R.drawable.minus),
                                        contentDescription = "icons",
                                        modifier = Modifier.size(50.dp),
                                        colorFilter = ColorFilter.tint(Color1)
                                    )

                                    Text(
                                        text="5",
                                        style = TextStyle(
                                            fontSize = 30.sp
                                        ),
                                        color = Color4

                                    )

                                    Image(
                                        painter = painterResource(id=R.drawable.plus),
                                        contentDescription = "icons",
                                        modifier = Modifier.size(50.dp),
                                        colorFilter = ColorFilter.tint(Color1)
                                    )
                                }
                                Button(
                                    onClick = {
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(55.dp)
                                ){
                                    Row (
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Text(
                                            text = stringResource(id = R.string.button_3),
                                            color = Color2,
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

