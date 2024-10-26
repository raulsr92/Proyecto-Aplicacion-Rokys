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
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.HindGuntur
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import org.json.JSONArray

class DetalleActivity : ComponentActivity() {

    var nombre: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle = intent.extras

        val idcategoria = bundle?.getString("idcategoria")
        nombre = bundle?.getString("nombre").toString();

        //Conectarnos a servicio web usado un método

        readService(idcategoria);

        enableEdgeToEdge()

    }

    private fun readService(idcategoria: String?) {
        val queue = Volley.newRequestQueue(this)
        val url =
            "http://192.168.0.3:8081/servicioweb/serviciodetalle.php?idcategoria=$idcategoria";

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.d("Response JSON CATEGORY", response);
                fillArray(response);
            },
            { })
        queue.add(stringRequest);
    }

    private fun fillArray(response: String) {
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>();

        for (i in 0 until jsonArray.length()) {
            val idcombo = jsonArray.getJSONObject(i).getString("idcombo");
            val nombre = jsonArray.getJSONObject(i).getString("nombre");
            val precio = jsonArray.getJSONObject(i).getString("precio");
            val descripcion = jsonArray.getJSONObject(i).getString("descripcion");
            val preciooferta = jsonArray.getJSONObject(i).getString("preciooferta");
            val foto = jsonArray.getJSONObject(i).getString("foto");

            val hashMap = HashMap<String, String>();
            hashMap["idcombo"] = idcombo
            hashMap["nombre"] = nombre
            hashMap["precio"] = precio
            hashMap["descripcion"] = descripcion
            hashMap["preciooferta"] = preciooferta
            hashMap["foto"] = foto

            arrayList.add(hashMap);
        }

        drawList(arrayList);
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun drawList(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
            ProyectoEP01SanchezTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                    ,
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
                                        modifier = Modifier.size(70.dp)
                                            .clickable {
                                                startActivity(Intent(this@DetalleActivity, MainActivity::class.java))
                                            },
                                        )
                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                    ) {
                                        Text(
                                            text = nombre.uppercase(),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color=Color1
                                        )
                                    }

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
                                        this@DetalleActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@DetalleActivity,
                                        LocalesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@DetalleActivity,
                                        PaisesActivity::class.java
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
                    )
                    {
                       LazyVerticalGrid(
                           columns = GridCells.Fixed(2),
                           verticalArrangement = Arrangement.spacedBy(8.dp),
                           horizontalArrangement = Arrangement.spacedBy(8.dp),
                           modifier = Modifier.fillMaxSize(),
                           contentPadding = PaddingValues(vertical = 14.dp, horizontal = 10.dp),
                           ) {
                           items(arrayList) { product ->
                               Card(
                                   elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                                   colors = CardDefaults.cardColors(containerColor = Color.White),

                               ) {
                                   Box(){
                                       val preciooferta = product["preciooferta"].toString().toFloat()
                                       val precio = product["precio"].toString().toFloat()
                                       val porcentajeDcto = (1-(preciooferta/precio))*100

                                       Column {
                                           AsyncImage(
                                               model = "http://192.168.0.3:8081/servicioweb/fotos/"+product["foto"],
                                               contentDescription = null,
                                               modifier = Modifier.fillMaxWidth()
                                           )

                                           Column (
                                               modifier = Modifier.padding(6.dp, 2.dp, 6.dp, 6.dp)
                                               //background(Color1)
                                           ) {
                                               Text(
                                                   text = product["nombre"].toString(),
                                                   style = MaterialTheme.typography.headlineSmall,
                                                   textAlign = TextAlign.Center,
                                                   color = Color1
                                               )
                                               Spacer(modifier = Modifier.height(6.dp))
                                               Column  (
                                                   modifier = Modifier.fillMaxWidth(),
                                                   //horizontalArrangement = Arrangement.SpaceBetween,
                                                   //verticalAlignment = Alignment.CenterVertically

                                               ){
                                                   Text(
                                                       text = product["descripcion"].toString(),
                                                       style = MaterialTheme.typography.displaySmall,
                                                       color = Color3,
                                                       modifier = Modifier.fillMaxWidth()
                                                   )
                                                   if (preciooferta == 0f ){
                                                       Column(
                                                           modifier=Modifier.fillMaxWidth()
                                                               .padding(0.dp,0.dp,10.dp,0.dp),
                                                           horizontalAlignment = Alignment.End
                                                       ) {
                                                           Text(
                                                               text = "S/ " + "%.2f".format(precio),
                                                               style = TextStyle(fontSize = 20.sp, fontFamily = HindGuntur, fontWeight = FontWeight.Bold),
                                                               color = Color1
                                                           )

                                                       }

                                                   } else{
                                                       Column(

                                                           modifier=Modifier.fillMaxWidth()
                                                               .padding(0.dp,0.dp,10.dp,0.dp),
                                                           horizontalAlignment = Alignment.End
                                                       ){
                                                           Text(
                                                               text = "S/ " + "%.2f".format(preciooferta),
                                                               style = TextStyle(fontSize = 20.sp, fontFamily = HindGuntur, fontWeight = FontWeight.Bold),
                                                               color = Color1
                                                           )
                                                           Text(
                                                               text = "S/ " + "%.2f".format(precio),
                                                               style = TextStyle(fontSize = 16.sp, fontFamily = HindGuntur, fontWeight = FontWeight.Bold),
                                                               textDecoration = TextDecoration.LineThrough,
                                                               color = Color.Red
                                                           )


                                                       }

                                                   }

                                               }
                                               Column (
                                                   modifier = Modifier
                                                       .fillMaxWidth()
                                                       .padding(7.dp,0.dp,7.dp,0.dp),
                                                   horizontalAlignment = Alignment.CenterHorizontally
                                               ) {
                                                   Button(
                                                       onClick = {},
                                                       modifier = Modifier.fillMaxWidth()

                                                   ) {
                                                       Text(
                                                           text = "Comprar".uppercase(),
                                                           color  = Color2
                                                       )
                                                   }
                                               }
                                           }
                                       }
                                       if(preciooferta != 0f){
                                           Column (
                                               modifier = Modifier.background(Color1)
                                                   .padding(4.dp,3.dp,8.dp,0.dp)
                                           ){
                                               Row (
                                                   horizontalArrangement = Arrangement.Center,
                                                   verticalAlignment = Alignment.CenterVertically

                                               ) {
                                                   Text(
                                                       text = "- " + "%.0f".format(porcentajeDcto),
                                                       style = TextStyle(fontSize = 20.sp, fontFamily = HindGuntur, fontWeight = FontWeight.Bold),
                                                       color = Color2

                                                   )
                                                   Text(
                                                       text = " %",
                                                       style = TextStyle(fontSize = 14.sp, fontFamily = HindGuntur, fontWeight = FontWeight.Bold),
                                                       color = Color2

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
    }
}


