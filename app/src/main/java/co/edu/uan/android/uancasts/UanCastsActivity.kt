package co.edu.uan.android.uancasts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.edu.uan.android.uancasts.ui.theme.UANCastsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UanCastsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UANCastsTheme {
                UANCastsApp()
            }
        }
    }
}
