package com.example.amphibians.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.Amphibians

/*
*  Home Screen Composable representing the home screen
*  of the app excluding the TopBar.
* */
@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(amphibiansUiState) {
       is AmphibiansUiState.Loading -> LoadingScreen(modifier)
       is AmphibiansUiState.Success -> AmphibiansDataScreen(amphibiansUiState.amphibiansData, modifier)
       is  AmphibiansUiState.Error -> ErrorScreen(retryAction, modifier)
    }
}

/*
*  Composable representing the Loading Phase of the UI screen
*  when, Network is On.
* */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.loading_img),
            contentDescription = stringResource(
            id = R.string.placeholder_msg),
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }

}

/*
* Composable representing the screen with the fetched Data.
* */
@Composable
fun AmphibiansDataScreen(data: List<Amphibians>,modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ){
        items(count = data.size){
            AmphibiansCard(amphibian = data[it])
        }

    }
}
/*
* Composable representing the Card for each data fetched.
* */
@Composable
fun AmphibiansCard(amphibian: Amphibians) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = "${amphibian.name}(${amphibian.type})",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Divider(thickness = 2.dp, color = MaterialTheme.colorScheme.outline, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp))
        AsyncImage( model = ImageRequest.Builder(context = LocalContext.current)
            .data(data = amphibian.imgSrc)
            .crossfade(enable = true)
            .build()
            ,
            contentDescription = amphibian.name,
            placeholder = painterResource(id = R.drawable.loading_img),
            error =  painterResource(id = R.drawable.broken_image),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(4.dp)
                .aspectRatio(1.6f),
        )
        Divider(thickness = 2.dp, color = MaterialTheme.colorScheme.outline, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp))
        Text(
            text = amphibian.description,
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/*
* Composable representing the Error Screen when,
* Network is Off.
* */
@Composable
fun ErrorScreen(retryAction: () -> Unit,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
       Text(
           text = stringResource(id = R.string.errormessage),
           color = MaterialTheme.colorScheme.onBackground,
           style = MaterialTheme.typography.bodyLarge
       )
        Button(
            onClick = retryAction,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.errorContainer),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            shape = ButtonDefaults.elevatedShape,
            ) {
            Text(
                text = stringResource(id = R.string.button_msg),
                color = MaterialTheme.colorScheme.onErrorContainer,
                 style = MaterialTheme.typography.bodyLarge)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
  LoadingScreen()
}

@Preview(showSystemUi = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen({ })
}

@Preview(showSystemUi = true)
@Composable
fun AmphibiansDataScreenPreview() {
    AmphibiansDataScreen(data = listOf(
        Amphibians(
            "Frog",
            "Frog",
            "Welcome to the AmphibiansApp",
            "D:\\JetpackCompose\\Amphibians\\app\\src\\main\\res\\drawable-nodpi\\amphibian.png"

        )
    ))
}
