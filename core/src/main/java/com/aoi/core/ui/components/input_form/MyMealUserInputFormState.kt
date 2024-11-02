package com.aoi.core.ui.components.input_form

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class MyMealUserInputFormState(
    val value: String = "",
    val isError: Boolean = false,
    val errorMessage: String? = null,
    val isEnabled: Boolean = true,
    val placeholder: String = "",
    val modifier: Modifier = Modifier,
    val iconImageVector: ImageVector? = null,
    val onValueChange: (String) -> Unit = {},
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
)