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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
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
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme

class FoodActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val options = arrayOf(R.string.food_1, R.string.food_2,R.string.food_3,R.string.food_4)

        val images = arrayOf(R.drawable.pollo_1, R.drawable.parrilla,R.drawable.papas,R.drawable.salad)

        val combos = arrayOf(R.drawable.combo1, R.drawable.combo2,R.drawable.combo3,R.drawable.combo4)

        val cards_recomendations_title = arrayOf(
            "Combo Familiar",
            "Pack Refréscate",
            "Parrilla Clásica",
            "Lomo Saltado"
        )

        val cards_recomendations_price = arrayOf(
            "S/. 90.90",
            "S/. 87.90",
            "S/. 35.90",
            "S/. 149.90"
        )
        enableEdgeToEdge()
        setContent {
            ProyectoEP01SanchezTheme {
                                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
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
                                                startActivity(Intent(this@FoodActivity, MainActivity::class.java))
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
                            {startActivity(Intent(this@FoodActivity, MaestroActivity::class.java))},
                            {startActivity(Intent(this@FoodActivity, LocalesActivity::class.java))},
                            { startActivity(Intent(this@FoodActivity, PaisesActivity::class.java))},
                            {startActivity(Intent(this@FoodActivity, LoginActivity::class.java))})

                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.White)
                            .fillMaxSize()

                    ) {
                        // Elemento input

                        /*
                        TextField(
                          placeholder = {
                              Text("A él")}
                        )
                        */


                        // Imagen con botón
                        Box(
                            modifier = Modifier
                                //.background(Color1)
                                //.padding(15.dp, 12.dp, 15.dp, 8.dp)
                                //.clip(RoundedCornerShape(25.dp))
                                .height(240.dp)
                        ){

                            Image(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "null",
                                modifier = Modifier.fillMaxSize()
                                //modifier = Modifier.clip(RoundedCornerShape(25.dp))
                                )
                            Row(
                                modifier = Modifier
                                            .fillMaxSize(),
                                verticalAlignment = Alignment.Bottom
                            ){
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.lomo2),
                                        contentDescription = "null",

                                        modifier = Modifier
                                            .width(170.dp)

                                    )
                                    Spacer(
                                        modifier = Modifier.height(10.dp)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.lomo2),
                                        contentDescription = "null",

                                        modifier = Modifier
                                            .width(170.dp)

                                    )
                                    Spacer(
                                        modifier = Modifier.height(19.dp)
                                    )
                                }
                                Spacer(
                                    modifier = Modifier.width(10.dp)
                                )

                                Column (
                                    modifier=Modifier
                                        .weight(1f)
                                        .padding(top = 20.dp)
                                ){
                                    Text(
                                        text = "Desde 30 soles DELIVERY GRATIS",
                                        style = MaterialTheme.typography.displayMedium,
                                        color = Color1
                                    )
                                    Text(
                                        text = "De Lunes a Viernes",
                                        style = MaterialTheme.typography.displaySmall,
                                        modifier = Modifier.padding(top = 5.dp).padding(bottom=10.dp)
                                    )

                                    Column(
                                        modifier = Modifier
                                            .padding(end = 20.dp)
                                    ) {
                                        Button(
                                            onClick = {
                                                startActivity(Intent(this@FoodActivity, AboutActivity::class.java))
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(40.dp)
                                        ){
                                            Row (
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Text(
                                                    text = stringResource(id = R.string.button_2),
                                                    color = Color2,
                                                )
                                            }
                                        }
                                        Spacer(
                                            modifier = Modifier.height(10.dp)
                                        )
                                        Button(
                                            onClick = {
                                                startActivity(Intent(this@FoodActivity, LocalesActivity::class.java))
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(40.dp)
                                        ){
                                            Row (
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Text(
                                                    text = stringResource(id = R.string.button_4),
                                                    color = Color2,
                                                )
                                            }
                                        }
                                        Spacer(
                                            modifier = Modifier.height(30.dp)
                                        )
                                    }

                                    }

                                }
                        }



                        // Carrusel horizontal

                        LazyHorizontalGrid(
                            rows = GridCells.Fixed(1),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                            modifier = Modifier
                                    .padding(15.dp, 12.dp, 15.dp, 8.dp)
                                .height(100.dp)



                            ) {
                                items(options.size) { index ->
                                    Card (
                                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                                        colors = CardDefaults.cardColors(Color2)

                                    )
                                    { Image(
                                            painter = painterResource(id=images[index]),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.size(100.dp)
                                        )
                                      Column {

                                          Text(
                                              text = stringResource(id=options[index]),
                                              style = MaterialTheme.typography.displaySmall
                                          )
                                      }

                                    }
                                }
                            }

                        // Texto


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp, 5.dp, 15.dp,5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id= R.string.phrase_1),
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color4
                                )

                            Text(
                                text = stringResource(id= R.string.link_1),
                                style = TextStyle(
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 18.sp
                                    ),
                                color = Color1,
                            )
                        }

                        // Grid de 2 columnas con scroll vertical

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.padding(15.dp,12.dp,15.dp,0.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)

                            ) {
                                items(cards_recomendations_title.size) { index->
                                    Card (
                                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                                        colors = CardDefaults.cardColors(Color5),
                                    )
                                    {
                                        Box(
                                            modifier=Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.BottomEnd // PARA ALINEAR EL CARRITO
                                        )
                                        {
                                            Column (
                                                 modifier = Modifier.size(32.dp)
                                                     .background(Color1),
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                Image(
                                                    painter = painterResource(R.drawable.shoppingcart),
                                                    contentDescription = null,
                                                    modifier = Modifier.size(20.dp),
                                                    alignment = Alignment.BottomEnd,
                                                    colorFilter = ColorFilter.tint(Color2)
                                                )
                                            }

                                            Column(
                                                modifier = Modifier.padding(10.dp, 8.dp, 10.dp,0.dp)
                                                    .fillMaxWidth(),
                                                horizontalAlignment = Alignment.Start

                                            ) {
                                                Image(
                                                    painter = painterResource(id=combos[index]),
                                                    contentDescription = null,
                                                    contentScale = ContentScale.FillWidth,
                                                    modifier = Modifier
                                                        .clip(RoundedCornerShape(10.dp))
                                                )
                                                Text(
                                                    cards_recomendations_title[index],
                                                    style = MaterialTheme.typography.displaySmall,
                                                    color = Color4

                                                )
                                                Text(
                                                    cards_recomendations_price[index],
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    color = Color4
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






