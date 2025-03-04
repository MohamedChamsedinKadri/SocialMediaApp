package com.example.loginapp.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController){
    val context= LocalContext.current
    val emailValue= remember{ mutableStateOf("") }
    val passwordValue= remember{ mutableStateOf("") }
    val passwordVisibility= remember { mutableStateOf(false) }

    Scaffold { innerPadding ->


        Box(modifier=Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding),
            contentAlignment = Alignment.Center){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier =Modifier.fillMaxSize()
            ){//image
                    Image(modifier = Modifier
                        .width(200 .dp)
                        .height (200.dp),
                        painter = painterResource( com.example.loginapp.R.drawable.login),
                        contentDescription = "Login Image",
                        contentScale = ContentScale.Fit)


                Spacer(modifier = Modifier.padding(20.dp))

                //sign in text
                Text(
                    text = "Sign in",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black)
                Spacer(modifier = Modifier.padding(20 .dp))

                //email textfield

                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = {emailValue.value = it},
                    label = { Text(text = "Email Address", color = Color.Black)},
                    placeholder = { Text(text = "Email Address", color = Color.Black)},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedTextColor = Color.Black
                    ))
                Spacer(modifier = Modifier.padding(10.dp))

                //password textfield

                OutlinedTextField(
                                value = passwordValue.value,
                                onValueChange = {passwordValue.value = it},
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Color.Black,
                                    focusedTextColor = Color.Black
                                ),
                                trailingIcon = {
                                    IconButton (onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    }) {
                                        Icon(
                                            painter = painterResource(id = com.example.loginapp.R.drawable.baseline_remove_red_eye_24),
                                            contentDescription = "Password ",
                                            tint = if (passwordVisibility.value) Color.Black else Color.Gray)
                                    }
                                },
                                label = { Text(text = "Password", color = Color.Black) },
                                placeholder = { Text(text = "Password", color = Color.Black) },
                                singleLine = true,
                                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )

                Spacer(modifier = Modifier.padding(20.dp))

                //signin button

                            Button(
                                onClick = {
                                    when {
                                        emailValue.value.isEmpty() -> {
                                            Toast.makeText(
                                                context,
                                                "Please enter email",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }

                                        passwordValue.value.isEmpty() -> {
                                            Toast.makeText(
                                                context,
                                                "Please enter password",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }

                                        else -> {
                                            Toast.makeText(
                                                context,
                                                "Logged Successfully",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            navController.navigate("home")
                                        }
                                    }

                                    },
                                    modifier = Modifier
                                        .fillMaxWidth(0.8f)
                                        .height(50.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primary)


                                    ) {
                                    Text(text = "Sign In", fontSize = 20.sp, color = Color.Black)
                                }
                                    Spacer(modifier = Modifier.padding(20.dp))

                //create an account text
                            TextButton (
                                onClick = {
                                    navController.navigate("signup")
                                }
                            ) {
                                Text(
                                text = "create an account",
                                color = MaterialTheme.colorScheme.primary
                                )
                        }

                    }


                }
            }
        }