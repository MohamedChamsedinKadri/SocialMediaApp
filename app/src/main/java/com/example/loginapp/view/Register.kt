package com.example.loginapp.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginapp.R


@OptIn(ExperimentalMaterial3Api::class)
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
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16 .dp)
        ){
                //Image
                Image(
                    painter = painterResource(id = R.drawable.signin),
                    contentDescription = "register Image",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp),
                    contentScale = ContentScale.Fit

                )

                //name textfield
                OutlinedTextField(
                    value = nameValue.value,
                    onValueChange = {nameValue.value = it},
                    label = { Text(text = "Name") },

                    placeholder = { Text(text = "Name") },

                    modifier= Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor =MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant)

                )
                //email address
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = {emailValue.value = it},
                    label = { Text(text = "Email Address") },
                    placeholder = { Text(text = "Email Address") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor =MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant)

                )

                //phone number

                OutlinedTextField(
                    value = phoneValue.value,
                    onValueChange = {phoneValue.value = it},
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "Phone Number") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor =MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant)


                )

                //password
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = {passwordValue.value = it},
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordVisibility.value){ VisualTransformation.None} else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton (onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                            Icon(
                                imageVector = if (passwordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = if (passwordVisibility.value) "Hide password" else "Show password"
                            )
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor =MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant)
                    )

                //confirm password
                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = {confirmPasswordValue.value = it},
                    label = { Text(text = "Confirm Password") },
                    placeholder = { Text(text = "Confirm Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton (onClick = {confirmPasswordVisibility.value= !confirmPasswordVisibility.value}) {
                            Icon(
                                imageVector = if (confirmPasswordVisibility.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = if (confirmPasswordVisibility.value) "Hide password" else "Show password"
                            )
                        }
                    }
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
                                navController.navigate("LoginPage")}


                    }             },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(text = "Register")
                }

                //already have an account
                TextButton(
                    onClick = {navController.navigate("LoginPage")}
                ) {
                    Text(text = "Already have an account")
                }




            }
        }}
