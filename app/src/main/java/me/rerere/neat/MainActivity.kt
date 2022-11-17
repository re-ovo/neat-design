package me.rerere.neat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            NeatApp {
                // TODO: Preview all widgets
                CircularProgressIndicator()
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Test() {
    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        TabRow(selectedTabIndex = 0) {
            Tab(
                selected = true,
                onClick = { /*TODO*/ },
                text = {
                    Text("Test1")
                }
            )
            Tab(
                selected = false,
                onClick = { /*TODO*/ },
                text = {
                    Text("Test2")
                }
            )
            Tab(
                selected = false,
                onClick = { /*TODO*/ },
                text = {
                    Text("Test3")
                }
            )
        }
    }
}