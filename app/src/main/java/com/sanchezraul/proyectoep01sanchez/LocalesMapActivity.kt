package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesRoomActivity
import com.sanchezraul.proyectoep01sanchez.localesROOM.LocalesUpdateRoomActivity
import com.sanchezraul.proyectoep01sanchez.maps.MapsLocalesActivity
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color7
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import org.json.JSONArray

class LocalesMapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1° Conectarnos al servicio
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.5:8081/servicioweb/localesmapa.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.d("Response JSON", response);
                fillArray(response);
            },
            {  })
        queue.add(stringRequest)
    }

    private fun fillArray(response: String?) {
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>();

        for (i in 0 until jsonArray.length()){
            val idlocal = jsonArray.getJSONObject(i).getString("idlocal");
            val nombres = jsonArray.getJSONObject(i).getString("nombre");
            val descripcion = jsonArray.getJSONObject(i).getString("descripcion");
            val latitud = jsonArray.getJSONObject(i).getDouble("latitud");
            val longitud = jsonArray.getJSONObject(i).getDouble("longitud");
            Log.d("MapaFUNCIONA", "Latitud: $latitud, Longitud: $longitud")

            val foto = jsonArray.getJSONObject(i).getString("foto");

            val hashMap = HashMap<String, String>();

            hashMap["idlocal"] = idlocal;
            hashMap["nombres"] = nombres;
            hashMap["descripcion"] = descripcion;
            hashMap["latitud"] = latitud.toString();
            hashMap["longitud"] = longitud.toString();
            hashMap["foto"] = foto;
            
            arrayList.add(hashMap)
        }

        drawList(arrayList);
        Log.d("arrayListVERIFICAR", arrayList.toString())


    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun drawList(arrayList: ArrayList<HashMap<String, String>>) {
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
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp)
                                            .clickable {
                                                startActivity(
                                                    Intent(
                                                        this@LocalesMapActivity,
                                                        MainActivity::class.java
                                                    )
                                                )
                                            },

                                        )
                                }

                            }
                        )
                    },
                    bottomBar = {

                        DrawBottomBar(
                            {
                                startActivity(
                                    Intent(
                                        this@LocalesMapActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@LocalesMapActivity,
                                        LocalesMapActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@LocalesMapActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@LocalesMapActivity,
                                        LoginActivity::class.java
                                    )
                                )
                            })
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color1)
                    ) {

                        LazyHorizontalGrid(
                            rows = GridCells.Fixed(1),
                            verticalArrangement = Arrangement.spacedBy(2.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(vertical = 25.dp),
                            modifier = Modifier
                                .fillMaxSize()
                                //.background(Color4)
                                .padding(8.dp, 10.dp, 8.dp, 0.dp)
                        ) {
                            items(arrayList){ localmap ->

                                OutlinedCard(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    modifier = Modifier.width(300.dp).
                                    clickable {
                                        val intent = Intent(this@LocalesMapActivity,
                                            LocalesMapLocationActivity::class.java)

                                        // Pasar variables

                                        intent.putExtra("idMapa", localmap["idlocal"].toString())
                                        intent.putExtra("nombreMapa", localmap["nombres"].toString())
                                        intent.putExtra("descripcionMapa", localmap["descripcion"].toString())
                                        intent.putExtra("latitudMapa", localmap["latitud"].toString())
                                        intent.putExtra("longitudMapa", localmap["longitud"].toString())


                                        startActivity(intent)
                                    },
                                    border = BorderStroke(2.dp, Color2),


                                ){
                                    Column (
                                        modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp).
                                        background(Color1)
                                    ){
                                        Box(
                                            modifier = Modifier.fillMaxSize()
                                                .padding(0.dp,0.dp,0.dp,0.dp)
                                        ){
                                            AsyncImage(
                                                model="http://192.168.0.5:8081/servicioweb/localesmapa/"+localmap["foto"].toString(),
                                                contentDescription = null,
                                                modifier = Modifier.fillMaxSize(),
                                                contentScale = ContentScale.Crop
                                            )

                                            Column(
                                                modifier = Modifier.fillMaxSize()
                                                .padding(0.dp,50.dp,0.dp,0.dp)
                                            ) {
                                                Column(
                                                    modifier= Modifier.background(Color4.copy(alpha = 0.4f))
                                                        .fillMaxWidth()
                                                        .padding(9.dp, 8.dp,0.dp,8.dp)
                                                ) {
                                                    Text(
                                                    text = localmap["nombres"].toString(),
                                                    style = MaterialTheme.typography.displayMedium,
                                                    color = Color2,
                                                )
                                                }

                                                Spacer(
                                                    modifier = Modifier.height(300.dp)
                                                )

                                                Column(
                                                    modifier= Modifier.background(Color1.copy(alpha = 0.5f))
                                                        .fillMaxWidth()
                                                        .padding(30.dp, 8.dp,10.dp,12.dp)
                                                ) {
                                                    Text(
                                                        text = localmap["descripcion"].toString(),
                                                        style = MaterialTheme.typography.displayMedium,
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
        }
    }
}

