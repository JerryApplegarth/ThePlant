package com.applecompose.theplant

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applecompose.theplant.ui.theme.ThePlantTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ThePlantTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxWidth(),
					color = MaterialTheme.colors.background
				) {
					SpecimenFacts()
				}
			}
		}
	}
}

@Composable
fun SpecimenFacts() {
	var plantName by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }
	var location by remember { mutableStateOf("") }
	var datePlanted by remember { mutableStateOf("") }
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(12.dp)
	) {
		TopAppBar(

		) {
			Text(
				text = "The Plant",
				fontSize = 20.sp,
				modifier = Modifier
					.padding(16.dp),

				)
		}
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {


			OutlinedTextField(
				value = plantName,
				onValueChange = { plantName = it },
				label = { Text(stringResource(R.string.plant_name)) },
				modifier = Modifier
					.fillMaxWidth()
			)
			OutlinedTextField(
				value = location,
				onValueChange = { location = it },
				label = { Text(stringResource(R.string.location)) },
				modifier = Modifier
					.fillMaxWidth()
			)
			OutlinedTextField(
				value = description,
				onValueChange = { description = it },
				label = { Text(stringResource(R.string.description)) },
				modifier = Modifier
					.fillMaxWidth()
			)
			OutlinedTextField(
				value = datePlanted,
				onValueChange = { datePlanted = it },
				label = { Text(stringResource(R.string.date_planted)) },
				modifier = Modifier
					.fillMaxWidth()
			)
			Button(onClick = {
				// code goes here
				Toast.makeText(
					context,
					"You have SAVED $plantName, " +
							"$location, " +
							"$description, " +
							"$datePlanted, $",
					Toast.LENGTH_LONG
				).show()

			}) {
				Text(text = "Save")
			}
		}
	}


}

@Preview(
	showBackground = true,
	//showSystemUi = true,
	name = "Light Model"
)
@Preview(
	showBackground = true,
	//showSystemUi = true,
	name = "Dark Mode",
	uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreviewDark() {
	ThePlantTheme {
		Surface(
			color = MaterialTheme.colors.background,
			modifier = Modifier.fillMaxWidth(),
		) {
			SpecimenFacts()
		}
	}
}