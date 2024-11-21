package com.example.pertemuan7.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormMahasiswaView(modifier: Modifier = Modifier,
                      listGender: List<String>,
                      onSubmitClick: (MutableList<String>) -> Unit
){
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJk by remember { mutableStateOf("") }

    val listData: MutableList<String> = mutableListOf(
        nama,nim, memilihJk, alamat, email, noTelepon
    )

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Biodata",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(15.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = nama,
            onValueChange = {nama = it},
            label = {Text("nama")},
            placeholder = {Text("Masukkan Nama")})

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = nim,
            onValueChange = {nim = it},
            label = {Text("nim")},
            placeholder = {Text("Masukkan NIM")})

        Row {
            listGender.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = memilihJk == item,
                        onClick = {
                            memilihJk = item
                        }
                    )
                    Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = email,
            onValueChange = {email = it},
            label = {Text("email")},
            placeholder = {Text("Masukkan Email")})
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = noTelepon,
            onValueChange = {noTelepon = it},
            label = {Text("noTelepon")},
            placeholder = {Text("Masukkan No Telepon")})
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = {Text("alamat")},
            placeholder = {Text("Masukkan Alamat")})

        Button (onClick = {
            onSubmitClick(listData)
        }) {
            Text("Submit")
        }
        ElevatedCard (modifier = Modifier
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Cyan)){
        }
    }
}