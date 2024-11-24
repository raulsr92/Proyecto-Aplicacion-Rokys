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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.sanchezraul.proyectoep01sanchez.components.DrawBottomBar
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color7
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import org.json.JSONArray

class MaestroActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.5:8081/servicioweb/serviciomaestro.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->

                Log.d("Response JSON Servicio maestro", response);

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

            val idcat  = jsonArray.getJSONObject(i).getString("idcategoria");
            val nombrecat = jsonArray.getJSONObject(i).getString("nombre");
            val descripcioncat = jsonArray.getJSONObject(i).getString("descripcion");
            val foto = jsonArray.getJSONObject(i).getString("foto");

            val hashMap = HashMap<String, String>();

            hashMap["idcategoria"] = idcat
            hashMap["nombrecat"] = nombrecat;
            hashMap["descripcioncat"] = descripcioncat;
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
                                                startActivity(Intent(this@MaestroActivity, MainActivity::class.java))
                                            }


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
                            {startActivity(Intent(this@MaestroActivity, MaestroActivity::class.java))},
                            {startActivity(Intent(this@MaestroActivity, LocalesActivity::class.java))},
                            { startActivity(Intent(this@MaestroActivity, PaisesActivity::class.java))},
                            {startActivity(Intent(this@MaestroActivity, LoginActivity::class.java))})

                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.White)
                            .fillMaxSize()

                    ){
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(1),
                            //verticalItemSpacing = 4.dp,
                            //horizontalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            items(arrayList){ category ->
                                Column (
                                    modifier = Modifier
                                        //.background(Color1)
                                ){
                                    Column (
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color5)
                                            .clickable {
                                                selectCategory(category)
                                            }
                                    ){
                                        Box(
                                        ){
                                            AsyncImage(
                                                model="http://192.168.0.3:8081/servicioweb/fotos/"+category["foto"].toString(),
                                                contentDescription = null,
                                                contentScale = ContentScale.Crop,

                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .height(140.dp)
                                                    //.padding(5.dp, 8.dp,0.dp,0.dp)

                                                    .wrapContentHeight(),


                                            )
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(5.dp, 8.dp,0.dp,0.dp)
                                                    .height(140.dp)

                                            ) {
                                                Column (
                                                    modifier= Modifier.background(Color7.copy(alpha = 0.6f))
                                                        .fillMaxWidth()
                                                        .padding(9.dp, 8.dp,0.dp,8.dp)


                                                ){
                                                    Text(
                                                        text = category["nombrecat"].toString().uppercase(),
                                                        style = MaterialTheme.typography.headlineSmall,
                                                        color = Color1
                                                    )
                                                    Column(
                                                        modifier= Modifier.padding(10.dp, 4.dp,4.dp,0.dp)
                                                    ){
                                                        Text(
                                                            text = category["descripcioncat"].toString(),
                                                            style = MaterialTheme.typography.displaySmall,
                                                            color = Color2,
                                                            textAlign = TextAlign.Start
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

    private fun selectCategory(category: HashMap<String, String>) {
        //Encapsular datos a enviar
        val bundle = Bundle().apply {
            putString("idcategoria", category["idcategoria"])
            putString("nombre", category["nombrecat"])

        }

        val intent = Intent(this, DetalleActivity::class.java)

        // Enviar los datos

        intent.putExtras(bundle);

        startActivity(intent)
    }
}

