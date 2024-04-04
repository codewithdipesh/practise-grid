package com.example.practisegrid

import Datasource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practisegrid.Model.Topic
import com.example.practisegrid.ui.theme.PractiseGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PractiseGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {

    Courses(
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top=8.dp
            )
   )
    

}


@Composable
fun Courses(modifier: Modifier=Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2) ,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier){

        items(Datasource.topic) {  topic->
            run {
                TopicsUI(topic = topic)
            }
        }
    }

}


@Composable
fun TopicsUI(modifier: Modifier= Modifier,topic: Topic){


       Card {
           Row{
               Box {
                   Image(
                       painter = painterResource(topic.image), contentDescription = stringResource(
                           topic.title
                       ),
                       modifier= Modifier
                           .height(68.dp)
                           .width(68.dp)
                           .aspectRatio(1f)
                       ,
                       contentScale = ContentScale.Crop
                   )
               }

               Column (
                   modifier=Modifier
                       .padding(top = 16.dp, start =16.dp, end = 16.dp)
               ){
                   //title
                   Text(
                       text = stringResource(topic.title),
                       style = MaterialTheme.typography.bodyMedium
                   )
                   Row (modifier=Modifier
                       .padding(top = 8.dp),
                       verticalAlignment = Alignment.CenterVertically){
                       Icon(
                           painter = painterResource(R.drawable.ic_grain),
                           contentDescription = null,
                       )
                       Text(
                           text = topic.number.toString(),
                           style = MaterialTheme.typography.labelMedium,
                           modifier= Modifier
                               .padding(8.dp)
                       )
                   }

               }
           }
       }






}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PractiseGridTheme {
        CoursesApp()
    }
}