package com.sanchezraul.proyectoep01sanchez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import org.json.JSONArray

class LocalesActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.5:8081/servicioweb/locales.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->

                Log.d("Response JSON", response);

                fillArray(response);

            },
            {  })

        queue.add(stringRequest)
    }

    private fun fillArray(response: String){
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>();

        for (i in 0 until jsonArray.length()){
            val nombres = jsonArray.getJSONObject(i).getString("nombre");
            val direccion = jsonArray.getJSONObject(i).getString("direccion");
            val provincia = jsonArray.getJSONObject(i).getString("provincia");
            val distrito = jsonArray.getJSONObject(i).getString("distrito");
            val telefono = jsonArray.getJSONObject(i).getString("telefono");
            val foto = jsonArray.getJSONObject(i).getString("foto");

            val hashMap = HashMap<String, String>();

            hashMap["nombres"] = nombres;
            hashMap["direccion"] = direccion;
            hashMap["provincia"] = provincia;
            hashMap["distrito"] = distrito;
            hashMap["telefono"] = telefono;
            hashMap["foto"] = foto;

            arrayList.add(hashMap)

        }

        drawList(arrayList);
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
                                        painter = painterResource(id=R.drawable.logo),
                                        contentDescription = null,
                                        modifier = Modifier.size(70.dp)
                                            .clickable {
                                                startActivity(Intent(this@LocalesActivity, MainActivity::class.java))
                                            },

                                        )
                                }

                            }
                        )
                    },
                    bottomBar = {

                        DrawBottomBar(
                            {startActivity(Intent(this@LocalesActivity, MaestroActivity::class.java))},
                            {startActivity(Intent(this@LocalesActivity, LocalesActivity::class.java))},
                            { startActivity(Intent(this@LocalesActivity, PaisesActivity::class.java))},
                            {startActivity(Intent(this@LocalesActivity, LoginActivity::class.java))})
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color5)


                    ) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(1),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(vertical = 15.dp),

                            modifier = Modifier
                                .fillMaxSize()
                                //.background(Color4)
                                .padding(8.dp, 10.dp, 8.dp, 0.dp)
                        ) {
                            items(arrayList){ product ->
                                Card (
                                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    modifier = Modifier.height(370.dp)
                                ){

                                    Column(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        AsyncImage(
                                            model="http://192.168.0.3:8081/servicioweb/fotos/"+product["foto"].toString(),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .height(130.dp)
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                                            contentScale= ContentScale.Crop
                                        )
                                    }

                                    Column (
                                        modifier = Modifier.padding(10.dp)
                                    ){


                                        Text(
                                            text = product["nombres"].toString(),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = Color1
                                        )

                                        
                                        /*Image(
                                            painter = painterResource(id = R.drawable.local1),
                                            contentDescription = null,
                                            modifier = Modifier.height(130.dp)
                                        )*/

                                        Text(
                                            text = product["direccion"].toString()+", " +product["provincia"].toString()+" - "+product["distrito"].toString(),
                                            style = MaterialTheme.typography.displaySmall, textAlign = TextAlign.Start
                                        )
                                        Column {
                                            Text(
                                                text = "Horario de tienda",
                                                style = MaterialTheme.typography.displayMedium,
                                                color = Color6

                                            )
                                            Text(
                                                text = "Domingo a Jueves 11:00 am - 11:30 m",
                                                style = MaterialTheme.typography.displaySmall
                                            )
                                            Text(
                                                text = "Viernes a Sabado 11:00 am - 12:30 am",
                                                style = MaterialTheme.typography.displaySmall
                                            )
                                        }
                                        Column {
                                            Text(
                                                text = "Teléfono",
                                                style = MaterialTheme.typography.displayMedium,
                                                color = Color6

                                            )
                                            Text(
                                                text = product["telefono"].toString(),
                                                style = MaterialTheme.typography.displaySmall
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
}}

