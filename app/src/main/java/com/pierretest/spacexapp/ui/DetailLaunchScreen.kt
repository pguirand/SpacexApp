package com.pierretest.spacexapp.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pierretest.spacexapp.data.models.SingleLaunchModel

@Composable
fun DetailLaunchScreen(launchingEvent: SingleLaunchModel) {
    // Create an ActivityResultLauncher to handle the URL opening result
    val openUrlLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            // Handle the result if needed (e.g., URL opened successfully)
//        } else {
//            // Handle the result if needed (e.g., URL opening failed)
//        }
    }
    Surface() {
        Column {
            Column(modifier = Modifier
                .padding(6.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier
                        .weight(0.4f),
                        text = "Flight No")
                    Text(modifier = Modifier.weight(0.6f),
                        text = launchingEvent.flightNumber.toString(),
                    style = MaterialTheme.typography.headlineSmall)
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(modifier = Modifier.weight(0.4f), text = "Mission Name : ")
                    Text(modifier = Modifier.weight(0.6f), text = launchingEvent.missionName.toString(),
                    style = MaterialTheme.typography.headlineSmall)
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .width(100.dp)
                    .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(modifier = Modifier.weight(0.4f), text = "Status : ")
                    Text(modifier = Modifier.weight(0.6f),
                        text = " ${if (launchingEvent.launchSuccess == true) "Succeed" else "Failed"}",
                        color = if (launchingEvent.launchSuccess == true) Color.Green else Color.Red,
                        style = MaterialTheme.typography.headlineSmall)

                }
            }
            Divider(modifier = Modifier
                .width(10.dp)
                .padding(10.dp)
            )
            Text(
                modifier = Modifier
                    .padding(6.dp),
                text = launchingEvent.details.toString(),
                textAlign = TextAlign.Justify
            )

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .padding(2.dp),
                    painter = rememberAsyncImagePainter(launchingEvent.links?.missionPatch),
                    contentDescription = "thumbnail",
                )
            }

            Spacer(modifier = Modifier.height(16.dp))



            Row (modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(launchingEvent.links?.wikipedia))
                        try {
                            openUrlLauncher.launch(intent)
                        } catch (e: ActivityNotFoundException) {
                            // Handle the case where the device doesn't have a web browser
                        }
                    }) {
                    Text(text = "Wikipedia")
                }

                Button(modifier = Modifier, onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(launchingEvent.links?.videoLink))

                    try {
                        openUrlLauncher.launch(intent)
                    } catch (e: ActivityNotFoundException) {
                        // Handle the case where the device doesn't have a web browser
                    }
                }) {
                    Text(text = "Youtube")

                }

            }
        }

        }
    }

