package com.sanchezraul.proyectoep01sanchez.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sanchezraul.proyectoep01sanchez.R
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color2
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color3
import com.sanchezraul.proyectoep01sanchez.ui.theme.Color4

@Composable
fun DrawBottomBar(onclick: () -> Unit,onclick2: () -> Unit, onclick3: () -> Unit,onclick4: () -> Unit) {
    BottomAppBar(
        containerColor = Color2,
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color3, // Set border color to Red
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            }

        /*
        contentColor = MaterialTheme.colorScheme.primary*/
    )
    {
        NavigationBar(
            containerColor = Color2,
        ) {

            NavigationBarItem(
                selected = false,
                onClick = onclick,
                icon = {
                    Image(
                        painter = painterResource(id= R.drawable.categ),
                        contentDescription = "icons",
                        modifier = Modifier.size(26.dp),
                        colorFilter = ColorFilter.tint(Color4)
                    )
                },
                label={
                    Text(
                    text = "Carta",
                    style = TextStyle(
                        color = Color4
                    )
                )
                }
            )
            NavigationBarItem(
                selected = false,
                onClick = onclick2,
                icon = {
                    Image(
                        painter = painterResource(id= R.drawable.locales),
                        contentDescription = "icons",
                        modifier = Modifier.size(26.dp),
                        colorFilter = ColorFilter.tint(Color4)
                    )
                },
                label={
                    Text(
                    text = "Locales",
                    style = TextStyle(
                        color = Color4
                    )
                )
                }                                )
            NavigationBarItem(
                selected = false,
                onClick = onclick3,
                icon = {
                    Image(
                        painter = painterResource(id= R.drawable.paises),
                        contentDescription = "icons",
                        modifier = Modifier.size(26.dp),
                        colorFilter = ColorFilter.tint(Color4)
                    )
                },
                label={
                    Text(
                    text = "Países",
                    style = TextStyle(
                        color = Color4
                    )
                )

                },
            )
            NavigationBarItem(
                selected = false,
                onClick = onclick4,
                icon = {
                    Image(
                        painter = painterResource(id= R.drawable.perfil),
                        contentDescription = "icons",
                        modifier = Modifier.size(26.dp),
                        colorFilter = ColorFilter.tint(Color4)
                    )
                },
                label={
                    Text(
                    text = "Perfil",
                    style = TextStyle(
                        color = Color4
                    )
                )
                }                                )
        }
    }
}


