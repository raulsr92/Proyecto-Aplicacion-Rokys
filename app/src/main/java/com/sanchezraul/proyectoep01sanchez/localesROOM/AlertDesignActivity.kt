package com.sanchezraul.proyectoep01sanchez.localesROOM

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.sanchezraul.proyectoep01sanchez.R
import com.sanchezraul.proyectoep01sanchez.dao.DatabaseLocalProvider
import com.sanchezraul.proyectoep01sanchez.dao.Local
import com.sanchezraul.proyectoep01sanchez.ui.theme.ProyectoEP01SanchezTheme
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color1
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color5
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color6
import kotlinx.coroutines.launch

class AlertDesignActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoEP01SanchezTheme {

                Column(
                    modifier = Modifier.fillMaxSize().background(Color2),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){

                    AlertDialog(
                        containerColor = Color2,
                        onDismissRequest = {
                        },

                        title = {
                            Text(
                                text = "Eliminar Local".uppercase(),
                                style = MaterialTheme.typography.displayLarge,
                                color = Color1,
                            )
                        },
                        text = {
                            Text(
                                text = "¿Está seguro que desea eliminar el registro?",
                                style = MaterialTheme.typography.displayMedium,
                                color = Color6,
                                )
                        },

                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.caution),
                                //tint = Color1,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clickable {
                                    }
                            )
                        } ,

                        confirmButton = {
                            Button(
                                onClick = {
                                }
                            ) {
                                Text(
                                    text = "Aceptar",
                                    style = MaterialTheme.typography.displayMedium,
                                    color = Color2,
                                    )
                            }
                        },

                        dismissButton = {
                            Button(
                                onClick = {
                                }
                            ) {
                                Text(
                                    text = "Cancelar",
                                    style = MaterialTheme.typography.displayMedium,
                                    color = Color2,                                )
                            }
                        }

                    )
                }
            }
        }
    }
}

