package com.example.a02_uilibrary.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.a02_uilibrary.ui.theme.AppColors
import com.example.a02_uilibrary.ui.theme.AppIcons
import com.example.a02_uilibrary.ui.theme.AppStrings

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    headerText: String? = null,
    isPasswordVisibleDefault: Boolean = false,
    showErrors: Boolean = false,
    helperText: String? = null,
    showHelper: Boolean = true,
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(isPasswordVisibleDefault) }

    val isValid = listOf(
        password.length >= 8,
        password.any { it.isUpperCase() },
        password.any { it.isDigit() },
        password.any { "!@#\$%^&*()_+-=[]{}|;':\",./<>?".contains(it) }
    ).all { it }

    val showErrorNow = showErrors && !isValid
    val showSuccessIcon = showErrors && isValid
    val shouldShowHelperText = showHelper && !isValid

    Column(modifier = modifier) {
        InputView(
            value = password,
            onValueChange = onPasswordChange,
            headerText = headerText,
            isError = showErrorNow,
            helperText = if (shouldShowHelperText) helperText else null,
            placeholder = AppStrings.Placeholder,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            trailingIcon = {
                when {
                    showSuccessIcon -> {
                        Icon(
                            imageVector = AppIcons.checkCircle(),
                            contentDescription = "valid",
                            tint = AppColors.SurfaceBrand,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    else -> {
                        Icon(
                            imageVector = if (isPasswordVisible) AppIcons.viewSolid() else AppIcons.iconNoView(),
                            contentDescription = if (isPasswordVisible) "hide password" else "show password",
                            tint = AppColors.ContentOnNeutralLow,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { isPasswordVisible = !isPasswordVisible }
                        )
                    }
                }
            }
        )
    }
}