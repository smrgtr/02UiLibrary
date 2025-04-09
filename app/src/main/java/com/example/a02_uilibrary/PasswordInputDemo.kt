package com.example.a02_uilibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a02_uilibrary.components.PasswordInput
import com.example.a02_uilibrary.ui.theme.AppColors
import com.example.a02_uilibrary.ui.theme.AppStrings
import com.example.a02_uilibrary.ui.theme.Dimens
import com.example.a02_uilibrary.ui.theme.fontLabelS

//this screen serves only as showcase of the component PasswordInput
@Composable
fun PasswordInputDemo() {
    var password1 by remember { mutableStateOf("") }
    var showError1 by remember { mutableStateOf(false) }

    var password2 by remember { mutableStateOf("") }
    var showError2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.BackgroundColor)
            .padding(Dimens.SpacingL),
        verticalArrangement = Arrangement.spacedBy(Dimens.SpacingL)
    ) {
        PasswordInput(
            password = password1,
            onPasswordChange = { password1 = it },
            headerText = AppStrings.PasswordLabel,
            helperText = AppStrings.HelperText,
            showErrors = showError1,
            modifier = Modifier.fillMaxWidth(),
        )

        AppButton(
            text = "Skontrolovať prvé",
            onClick = { showError1 = true }
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(AppColors.ContentOnNeutralMedium)
        )

        // showcase of no header text && no helper text
        PasswordInput(
            password = password2,
            onPasswordChange = { password2 = it },
            showErrors = showError2,
            showHelper = false,
            modifier = Modifier.fillMaxWidth(),
        )

        AppButton(
            text = "Skontrolovať druhé",
            onClick = { showError2 = true }
        )
    }

}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = AppColors.SurfaceBrand),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.fontLabelS
        )
    }
}