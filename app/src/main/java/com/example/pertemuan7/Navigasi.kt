package com.example.pertemuan7

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan7.ui.view.FormMahasiswaView
import com.example.pertemuan7.ui.viewmodel.MahasiswaViewModel
import java.lang.reflect.Modifier

enum class Halaman {
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier(),
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.dataModel.collectAsState()

        NavHost(
            modifier = Modifier.padding(isipadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ){
            composable(route = Halaman.Form.name) {
                val context = LocalContext.current
                FormMahasiswaView(
                    listGender = ListGender.listGender.map { genderId ->
                        context.resources.getString(genderId)
                    },
                    onSubmitClick = { listData ->
                        viewModel.saveDataMhs(listData)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }



        }
    }
