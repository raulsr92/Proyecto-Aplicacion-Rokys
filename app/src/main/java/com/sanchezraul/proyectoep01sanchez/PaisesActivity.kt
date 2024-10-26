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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import org.json.JSONArray

class PaisesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/paises.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->

                Log.d("Response JSON Servicio paises", response);

                fillArray(response);

            },
            {  })

        queue.add(stringRequest)
        enableEdgeToEdge()
    }

    private fun fillArray(response: String){
        val jsonArray = JSONArray(response);
        val arrayList = ArrayList<HashMap<String, String>>();

        for (i in 0 until jsonArray.length()){

            val idpais  = jsonArray.getJSONObject(i).getString("idpais");
            val codpais = jsonArray.getJSONObject(i).getString("codpais");
            val pais = jsonArray.getJSONObject(i).getString("pais");
            val capital = jsonArray.getJSONObject(i).getString("capital");
            val area = jsonArray.getJSONObject(i).getString("area");
            val poblacion = jsonArray.getJSONObject(i).getString("poblacion");
            val continente = jsonArray.getJSONObject(i).getString("continente");

            val hashMap = HashMap<String, String>();

            hashMap["idpais"] = idpais
            hashMap["codpais"] = codpais;
            hashMap["pais"] = pais;
            hashMap["capital"] = capital;
            hashMap["area"] = area;
            hashMap["poblacion"] = poblacion;
            hashMap["continente"] = continente;

            arrayList.add(hashMap)

        }

        drawList(arrayList);
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun drawList(arrayList: ArrayList<HashMap<String, String>>) {
        setContent {
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
                                                        this@PaisesActivity,
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
                                        this@PaisesActivity,
                                        MaestroActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@PaisesActivity,
                                        LocalesActivity::class.java
                                    )
                                )
                            },
                            {
                                startActivity(
                                    Intent(
                                        this@PaisesActivity,
                                        PaisesActivity::class.java
                                    )
                                )
                            })
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@PaisesActivity,
                                        PaisesInsertActivity::class.java
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
                            items(arrayList) { country ->
                                Column (
                                    modifier = Modifier
                                        .border(
                                            width = 3.dp,
                                            color = Color6,
                                        )
                                        .height(200.dp)
                                        .background(Color2)


                                ) {
                                    Column (
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp, 5.dp, 0.dp, 0.dp)

                                    ){
                                        Text(
                                            text = country["pais"].toString(),
                                            style = MaterialTheme.typography.headlineSmall,
                                            color = Color1
                                        )
                                    }
                                    Column (
                                        modifier = Modifier
                                            .padding(15.dp, 0.dp, 5.dp, 0.dp)
                                            .fillMaxWidth()
                                    ){
                                        Text(
                                            text = "Capital: "+country["capital"].toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            color = Color3,
                                            textAlign = TextAlign.Start,
                                           // modifier=Modifier.background(Color3)
                                        )
                                        Text(
                                            text = "Población: "+country["poblacion"].toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            color = Color3
                                        )
                                        Text(
                                            text = "Continente: "+country["continente"].toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            color = Color3
                                        )
                                        Text(
                                            text = "Codigo: "+country["codpais"].toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            color = Color3
                                        )
                                        Text(
                                            text = "Area: "+country["area"].toString(),
                                            style = MaterialTheme.typography.displaySmall,
                                            color = Color3
                                        )
                                    }


                                }

                            }
            }
        }
    }
} }
    }
}


