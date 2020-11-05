package io.sabri.devfestcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import io.sabri.devfestcompose.ui.DevFestComposeTheme
import io.sabri.devfestcompose.ui.purple500

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DevFestComposeTheme {
				ListDemo()
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TapCounter() {

	var tapCount by remember { mutableStateOf(0) }

	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					Text(text = "DevFest")
				}
			)
		},
		floatingActionButton = {
			FloatingActionButton(onClick = {
				tapCount = +1
			}) {
				Icon(Icons.TwoTone.Add)
			}
		}
	) {
		Box(
			modifier = Modifier.fillMaxWidth()
				.fillMaxHeight()
		) {
			Text(
				modifier = Modifier.align(Alignment.Center),
				fontSize = 32.sp,
				text = tapCount.toString()
			)

		}
	}
}


@Preview(showBackground = true)
@Composable
fun ListDemo() {

	var list by remember { mutableStateOf(mutableStateListOf("Item 1")) }

	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					Text(text = "DevFest")
				}
			)
		},
		floatingActionButton = {
			FloatingActionButton(onClick = {
				list.add("Item ${list.size + 1}")
			}) {
				Icon(Icons.TwoTone.Add)
			}
		}
	) {
		LazyColumnFor(items = list) { title ->
			Text(
				modifier = Modifier
					.fillMaxWidth()
					.padding(4.dp)
					.background(color = purple500, shape = CircleShape)
					.padding(8.dp),
				textAlign = TextAlign.Center,
				color = Color.White,
				text = title
			)
		}
	}
}

