package com.example.a02_uilibrary.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.a02_uilibrary.ui.theme.AppColors
import com.example.a02_uilibrary.ui.theme.Dimens
import com.example.a02_uilibrary.ui.theme.fontBodyM
import com.example.a02_uilibrary.ui.theme.fontLabelM
import com.example.a02_uilibrary.ui.theme.fontLabelS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputView(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    headerText: String? = null,
    isError: Boolean = false,
    helperText: String? = null,
    placeholder: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    var isFocused by remember { mutableStateOf(false) }

    Column(modifier = modifier.background(AppColors.BackgroundColor)) {
        if (headerText != null) {
            Text(
                text = headerText,
                style = MaterialTheme.typography.fontLabelM,
                color = if (isError) {
                    AppColors.SurfaceDanger
                } else AppColors.ContentOnNeutralXXHigh,
                modifier = Modifier.padding(bottom = Dimens.SpacingXs)
            )
        }
        val interactionSource = remember { MutableInteractionSource() }

        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            singleLine = true,
            interactionSource = interactionSource,
            cursorBrush = SolidColor(AppColors.SurfaceBrand),
            visualTransformation = visualTransformation,
            textStyle = MaterialTheme.typography.fontBodyM.copy(color = AppColors.ContentOnNeutralXXHigh),
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 56.dp)
                .border(
                    width = 1.dp,
                    color = when {
                        isError -> AppColors.SurfaceDanger
                        isFocused -> AppColors.StateDefaultFocus
                        else -> AppColors.SurfaceXHigh
                    },
                    shape = RoundedCornerShape(Dimens.RadiusInput)
                )
                .onFocusChanged { focusState -> isFocused = focusState.isFocused }
        ) { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                interactionSource = interactionSource,
                visualTransformation = visualTransformation,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.fontLabelM,
                        color = AppColors.ContentOnNeutralLow
                    )
                },
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = true,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = OutlinedTextFieldDefaults.colors(),
                        shape = RoundedCornerShape(Dimens.RadiusInput),
                        focusedBorderThickness = 1.dp,
                        unfocusedBorderThickness = 1.dp
                    )
                },
                trailingIcon = trailingIcon
            )
        }

        if (isFocused && helperText != null) {
            Spacer(modifier = Modifier.height(Dimens.SpacingXs))
            Text(
                text = helperText,
                color = AppColors.ContentOnNeutralMedium,
                style = MaterialTheme.typography.fontLabelS
            )
        }
    }
}