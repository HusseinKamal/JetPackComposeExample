package com.hussein.jetpackcomposeexample.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hussein.jetpackcomposeexample.R

@Composable
fun Profile(navHostController: NavHostController){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        )
        {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                CreateEditText()
            }
        }
    }
}
@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.Blue,
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium,
            text = "Hussein Kamal"
        )

        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "@JetpackCompose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}
@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(154.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
private fun CreateEditText(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       TextField(
           value = "Hussein",
           onValueChange = {},
           placeholder = { Text(text = "First Name")},
           label ={ Text(text = "FirstName",color = MaterialTheme.colorScheme.onBackground, fontSize = 10.sp)},
           textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
       )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "Kamal",
            onValueChange = {},
            label ={ Text(text = "LastName",color = MaterialTheme.colorScheme.onBackground, fontSize = 10.sp)},
            placeholder = { Text(text = "Last Name")},
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "Hussein0115300@gmail.com",
            onValueChange = {},
            label ={ Text(text = "Email",color = MaterialTheme.colorScheme.onBackground, fontSize = 10.sp)},
            placeholder = { Text(text = "Email")},
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "+201153001232",
            onValueChange = {},
            label ={ Text(text = "Mobile",color = MaterialTheme.colorScheme.onBackground, fontSize = 10.sp)},
            placeholder = { Text(text = "Mobile")},
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        GradientButton(text = "Update Profile", textColor = Color.White, gradient = Brush.horizontalGradient(
            colors = listOf(MaterialTheme.colorScheme.primary,MaterialTheme.colorScheme.inversePrimary)
        ), onClick = {
            Toast.makeText(context,"Profile Updated Successfully",Toast.LENGTH_SHORT).show()
        }
        )
    }
}
