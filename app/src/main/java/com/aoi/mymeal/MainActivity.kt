package com.aoi.mymeal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aoi.core.ui.theme.MymealTheme
import com.aoi.presentation.navigation.application.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MymealTheme {
                AppNavigation()
            }
        }
    }
}