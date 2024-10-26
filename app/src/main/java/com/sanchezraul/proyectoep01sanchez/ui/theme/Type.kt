package com.sanchezraul.proyectoep01sanchez.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sanchezraul.proyectoep01sanchez.R

val HindGuntur = FontFamily(
    Font(R.font.hindguntur_regular, FontWeight.Normal),
    Font(R.font.hindguntur_bold, FontWeight.Bold),
    Font(R.font.hindguntur_light, FontWeight.Light),
    Font(R.font.hindguntur_medium, FontWeight.Medium),
    Font(R.font.hindguntur_semibold, FontWeight.SemiBold)

)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    headlineLarge =  TextStyle(
        fontFamily = HindGuntur,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center

    ),

    headlineSmall =  TextStyle(
        fontFamily = HindGuntur,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),

    displayMedium =  TextStyle(
        fontFamily = HindGuntur,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),

    displaySmall =  TextStyle(
        fontFamily = HindGuntur,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center

    )

)