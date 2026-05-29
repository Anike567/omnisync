package com.example.omnisync.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun Question(question: String) {
    // 1. Destructuring syntax gives you a direct boolean (selected) and a function (setSelected)
    val (selected, setSelected) = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(50.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))


    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home icon"
        )

        Text(text = question) // 2. Changed hardcoded "Testing" to use your 'question' parameter!

        RadioButton(
            selected = selected, // 3. FIXED: 'selected' is already a boolean, no '.value' needed here
            onClick = { setSelected(!selected) } // 4. FIXED: Clean Kotlin function execution to toggle the value
        )
    }
}