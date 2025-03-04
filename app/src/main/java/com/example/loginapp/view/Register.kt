package com.example.loginapp.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginapp.R


@Composable
fun Register(navController: NavController){
    val context= LocalContext.current
    val nameValue= remember{ mutableStateOf("") }
    val emailValue= remember{ mutableStateOf("") }
    val phoneValue= remember{ mutableStateOf("") }
    val passwordValue= remember{ mutableStateOf("") }
    val confirmPasswordValue= remember{ mutableStateOf("") }
    val passwordVisibility= remember { mutableStateOf(false) }
    val confirmPasswordVisibility= remember { mutableStateOf(false) }

    Scaffold {  innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                //Image
                Image(
                    painter = painterResource(id = R.drawable.signin),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Fit

                )
                Spacer(modifier = Modifier.padding(20.dp))

                //name textfield
                OutlinedTextField(
                    value = nameValue.value,
                    onValueChange = {nameValue.value = it},
                    label = { Text(text = "Name") },
                    placeholder = { Text(text = "Name") }

                )
                Spacer(modifier = Modifier.padding(10.dp))
                //email address
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = {emailValue.value = it},
                    label = { Text(text = "Email Address") },
                    placeholder = { Text(text = "Email Address") }
                )
                Spacer(modifier = Modifier.padding(10.dp))

                //phone number

                OutlinedTextField(
                    value = phoneValue.value,
                    onValueChange = {phoneValue.value = it},
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "Phone Number") }

                )
                Spacer(modifier = Modifier.padding(10.dp))

                //password
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = {passwordValue.value = it},
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") }
                )
                //confirm password
                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = {confirmPasswordValue.value = it},
                    label = { Text(text = "Confirm Password") },
                    placeholder = { Text(text = "Confirm Password") }
                )

                //register button
                Button(
                    onClick = {

                        when {
                            nameValue.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter name",
                                    Toast.LENGTH_SHORT).show()
                        }
                            emailValue.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            phoneValue.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter phone number",
                                    Toast.LENGTH_SHORT).show()}
                            passwordValue.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter password",
                                    Toast.LENGTH_SHORT).show()
                            }
                            confirmPasswordValue.value.isEmpty() -> {
                                Toast.makeText(
                                    context,
                                    "Please enter confirm password",
                                    Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                Toast.makeText(
                                    context,
                                    "Registered Successfully",
                                    Toast.LENGTH_SHORT).show()
                                navController.navigate("login")}


                    }             },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Register")
                }

                //already have an account
                TextButton(
                    onClick = {navController.navigate("login")}
                ) {
                    Text(text = "Already have an account")
                }




            }
        }}




}