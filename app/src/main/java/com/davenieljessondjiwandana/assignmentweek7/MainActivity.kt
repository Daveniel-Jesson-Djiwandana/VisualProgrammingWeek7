package com.davenieljessondjiwandana.assignmentweek7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.davenieljessondjiwandana.assignmentweek7.soal1.navigation.Soal1AppNavHost
import com.davenieljessondjiwandana.assignmentweek7.soal2.navigation.Soal2AppNavHost
import com.davenieljessondjiwandana.assignmentweek7.ui.theme.AssignmentWeek7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentWeek7Theme {
                Soal1AppNavHost()
                //Soal2AppNavHost()
            }
        }
    }
}