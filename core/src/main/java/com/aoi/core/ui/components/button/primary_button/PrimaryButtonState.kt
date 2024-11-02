package com.aoi.core.ui.components.button.primary_button

import androidx.compose.ui.Modifier

data class PrimaryButtonState(
    val text: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
    val modifier: Modifier = Modifier
)