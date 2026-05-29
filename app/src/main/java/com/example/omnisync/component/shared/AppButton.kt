package com.example.omnisync.component.shared

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.omnisync.type.ButtonType

@Composable
fun AppButton(
    type: ButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // 1. FIXED: Added @Composable here because MaterialTheme requires a Composable context
    @Composable
    fun getContainerColor(type: ButtonType): Color {
        return when (type) {
            ButtonType.Primary -> MaterialTheme.colorScheme.primary
            ButtonType.Secondary -> MaterialTheme.colorScheme.secondary
            ButtonType.Tertiary -> MaterialTheme.colorScheme.tertiary
            ButtonType.TextButton -> MaterialTheme.colorScheme.background
        }
    }

    // 2. FIXED: Added @Composable here as well
    @Composable
    fun getContentColor(type: ButtonType): Color {
        return when (type) {
            ButtonType.Primary -> MaterialTheme.colorScheme.onPrimary
            ButtonType.Secondary -> MaterialTheme.colorScheme.onSecondary
            ButtonType.Tertiary -> MaterialTheme.colorScheme.onTertiary
            ButtonType.TextButton -> MaterialTheme.colorScheme.error
        }
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            // 3. Since the functions are composables now, calling them here is perfectly safe
            containerColor = getContainerColor(type),
            contentColor = getContentColor(type)
        )
    ) {
        content()
    }
}