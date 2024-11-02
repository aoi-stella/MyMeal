package com.aoi.core.ui.components.input_form

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.aoi.core.ui.spacing.MyMealSpacing

//TODO: Shapeの設定を追加
@Composable
fun MyMealUserInputForm(state: MyMealUserInputFormState) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column(modifier = state.modifier) {
        BasicTextField(
            value = state.value,
            onValueChange = state.onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            interactionSource = interactionSource,
            singleLine = true,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            keyboardOptions = state.keyboardOptions,
            decorationBox = { innerTextField ->
                Column {
                    if (state.iconImageVector != null) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = state.iconImageVector,
                                contentDescription = null,
                                tint = if (state.isError) {
                                    MaterialTheme.colorScheme.error
                                } else {
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                }
                            )
                            Spacer(modifier = Modifier.width(MyMealSpacing.componentSmall))
                            Box(modifier = Modifier.weight(1f)) {
                                if (state.value.isEmpty()) {
                                    Text(
                                        text = state.placeholder,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier.fillMaxWidth()) {
                            if (state.value.isEmpty()) {
                                Text(
                                    text = state.placeholder,
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                    modifier = Modifier.padding(end = MyMealSpacing.componentMedium)
                                )
                            }
                            innerTextField()
                        }
                    }

                    Spacer(modifier = Modifier.height(MyMealSpacing.componentTiny))

                    // アンダーライン
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = when {
                            state.isError -> MaterialTheme.colorScheme.error
                            isFocused -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                        }
                    )
                }
            }
        )

        if (state.isError && state.errorMessage != null) {
            Text(
                text = state.errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = MyMealSpacing.componentSmall)
            )
        }
    }
}