package com.pierretest.spacexapp.ui

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.pierretest.spacexapp.data.models.CompanyInfoModel
import com.pierretest.spacexapp.data.models.SingleLaunchModel
import java.text.NumberFormat
import java.time.Duration
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.abs


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier, viewModel: LaunchesViewModel) {

    var searchQuery by remember { mutableStateOf("") }

    TextField(
        value = searchQuery,
        onValueChange = { newValue ->
            searchQuery = newValue
            viewModel.searchLaunchByYear(searchQuery)
        },
        label = { Text(text = "Search") },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LaunchListScreen(
    navController: NavHostController,
    viewModel: LaunchesViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.getAllLaunches()
    }

    val launchList by viewModel.listAllLaunches.collectAsState()
    val companyInfo by viewModel.companyInfo.collectAsState()
    val searchList by viewModel.listSearchLaunches.collectAsState()

    var searchQuery by remember { mutableStateOf("") }



    Column {
        TextField(
            value = searchQuery,
            onValueChange = { newValue ->
                searchQuery = newValue
                viewModel.searchLaunchByYear(searchQuery)
            },
            label = { Text(text = "Search by launch year") },
            maxLines=1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .background(Color.LightGray)
                ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        CompanyInfo(company = companyInfo)
        Divider()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(searchList) { launch ->
                LaunchItem(singleLaunchModel = launch) {
                    navController.navigate("DetailLaunchScreen/${launch.flightNumber}")

                }

            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LaunchItem(singleLaunchModel: SingleLaunchModel, onItemClick: () -> Unit) {

    Card(
        modifier = Modifier
            .padding(2.dp, 1.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(16.dp),
//        elevation =
    ) {

        Surface(
            onClick = onItemClick
        ) {

            Row(
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxSize()
                    .background(Color(200, 200, 120))
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(2.dp),
                    painter = rememberAsyncImagePainter(singleLaunchModel.links?.missionPatchSmall),
                    contentDescription = "thumbnail",

                    )

                Row() {
                    Column(
                        modifier = Modifier
//                    .fillMaxSize()
                            .padding(2.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = "Mission",
//                    style=MaterialTheme.typography.labelLarge,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(
                            text = "Date / Time",
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(
                            text = "Rocket",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Days",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(4.dp)
//                            .widthIn(max = 170.dp)
                        ,

                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = singleLaunchModel.missionName.toString(),
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,

                            )
                        val test = "OK"
                        val bdate =
                            singleLaunchModel.launchDateLocal?.let { HumanReadableDate(dateString = it) }
//                        singleLaunchModel.launchDateLocal?.let { HumanReadableDate(dateString = it) }
                        if (bdate != null) {
                            Text(
                                text = bdate,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Text(
                            text = singleLaunchModel.rocket?.rocketName.toString(),
                            style = MaterialTheme.typography.titleMedium

                        )
                        val difference = singleLaunchModel.launchDateLocal?.let {
                            DaysDifferenceFromDate(dateString = it)
                        }
                        val NbOfDays = difference?.let { abs(it) }
                        val message =
                            "$NbOfDays days ${if (difference!! < 0) "Since" else "from"} event"

                        Text(
                            text = message,
                            style = MaterialTheme.typography.titleMedium

                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        singleLaunchModel.launchSuccess?.let { LaunchStatus(it) }
                    }
                }
            }
        }
    }
}

@Composable
fun LaunchStatus(status: Boolean) {
    if (status) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Success",
            tint = Color.Green
        )
    } else {
        Icon(
            imageVector = Icons.Default.Cancel,
//            imageVector = Icons.Default.Error,
            contentDescription = "Failed",
            tint = Color.Red
        )
    }


}

@Preview
@Composable
fun PreviewIcon() {
    LaunchStatus(false)

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HumanReadableDate(dateString: String): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val dateTime = OffsetDateTime.parse(dateString, formatter)

//    val formattedDate = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy hh:mm a").format(dateTime)
    val formattedDate = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a").format(dateTime)

//    Text(text = formattedDate)
    return formattedDate
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysDifferenceFromDate(dateString: String): Long {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val dateTime = OffsetDateTime.parse(dateString, formatter)
    val providedDate = ZonedDateTime.ofInstant(dateTime.toInstant(), ZoneId.systemDefault())

    val currentDate = ZonedDateTime.now()
    return Duration.between(currentDate, providedDate).toDays()

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewHumanReadableDate() {
    HumanReadableDate("2006-03-25T10:30:00+12:00")
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewDaysDifference() {
    DaysDifferenceFromDate("2026-03-25T10:30:00+12:00")
}

@Composable
fun CompanyInfo(company: CompanyInfoModel) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
        ) {
            CustomTitle(company.name.toString())
            Divider()
//            FilterScreen()
            CustomHeader(header = "company")
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "${company.name} was founded by ${company.founder} in ${company.founded}." +
                        "It has now ${company.employees} employees, ${company.launchSites} launch sites," +
                        "and is valued at ${company.valuation?.let { formatCurrency(it) }} USD.",
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.titleMedium
            )
            CustomHeader(header = "launches")


        }
    }

}

@Composable
fun CustomTitle(title: String) {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Surface() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = title.uppercase(),
                style = MaterialTheme.typography.bodyLarge,
//                textAlign = TextAlign.Center
            )

            Column(
                modifier = Modifier
                    .padding(2.dp)
            ) {

                Button(
                    onClick = { isDropdownExpanded = !isDropdownExpanded },
                    contentPadding = PaddingValues(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    elevation = null
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Sort,
                            contentDescription = "Filter",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Black
                        )
                    }
                }

                // Dropdown Menu
                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("By Date") },
                        onClick = {

                            Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() }
                    )
                    Divider()
                    DropdownMenuItem(
                        text = { Text("Success Launch") },
                        onClick = { Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show() }
                    )
                    // Add more DropdownMenuItems for other filter options
                }
            }


        }
    }

}


@Composable
fun CustomHeader(header: String) {
    Surface(
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Black)
        ) {
            Text(
                text = header.uppercase(),
                style = MaterialTheme.typography.labelLarge,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview
@Composable
fun PreviewHeader() {
    CustomHeader(header = "company")
}

@Preview
@Composable
fun PreviewTitle() {
    CustomTitle(title = "Space X")
}

fun formatCurrency(number: Double, locale: Locale = Locale.US): String {
    val numberFormat = NumberFormat.getCurrencyInstance(locale)
    return numberFormat.format(number)


}



