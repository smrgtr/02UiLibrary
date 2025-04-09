package com.example.a02_uilibrary.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.a02_uilibrary.R


object AppIcons {
    @Composable
    fun iconNoView(): ImageVector {
        return ImageVector.vectorResource(id = R.drawable.icon_noview_solid)
    }
    @Composable
    fun viewSolid(): ImageVector {
        return ImageVector.vectorResource(id = R.drawable.view_solid)
    }
    @Composable
    fun checkCircle(): ImageVector {
        return ImageVector.vectorResource(id = R.drawable.check_circle)
    }
}