package com.example.a02_uilibrary.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a02_uilibrary.R

val Inter = FontFamily(
    Font(R.font.inter_variable)
)
val Typography.fontLabelM: TextStyle
    @Composable get() = titleMedium

val Typography.fontLabelS: TextStyle
    @Composable get() = labelMedium

val Typography.fontBodyM: TextStyle
    @Composable get() = bodyMedium

val AppTypography = Typography(
    // font.label.m
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.16.sp
    ),

    // font.label.s
    labelMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight(550),
        fontSize = 14.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.16.sp
    ),

    // font.body.m
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    )
)
