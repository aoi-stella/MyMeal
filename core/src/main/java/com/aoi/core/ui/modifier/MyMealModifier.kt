package com.aoi.core.ui.modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import com.aoi.core.ui.spacing.MyMealSpacing

object MyMealModifier {
    // 画面最上位SurfaceのModifier
    val screenParentModifier = Modifier
        .fillMaxSize()

    // 親Modifierの1階層下のColumn用Modifier
    val screenTopChildColumnModifier = Modifier
        .fillMaxSize()
        .padding(top = MyMealSpacing.screenTop, bottom = MyMealSpacing.screenBottom, start = MyMealSpacing.screenEdge, end = MyMealSpacing.screenEdge)
        .systemBarsPadding()
        .navigationBarsPadding()
}