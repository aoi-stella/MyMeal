package com.aoi.core.ui.components.button.outline_button

import androidx.compose.ui.Modifier

data class OutlineButtonState(
    val text: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
    val modifier: Modifier = Modifier
)