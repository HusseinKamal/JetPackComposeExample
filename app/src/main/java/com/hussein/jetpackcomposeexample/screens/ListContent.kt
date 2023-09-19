package com.hussein.jetpackcomposeexample.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.hussein.jetpackcomposeexample.R
import com.hussein.jetpackcomposeexample.model.ProductX

@Composable
@ExperimentalCoilApi
fun ListContent(items:LazyPagingItems<ProductX>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        items(
            count = items.itemCount,
            key = items.itemKey(key = { unsplashImage->
                unsplashImage.id
            }
            ),
            contentType = items.itemContentType(
            )
        ) { index ->
            val item = items[index]
            item?.let { ProductItem(product = it) }
        }
    }
}

@Composable
@ExperimentalCoilApi
fun ProductItem(product: ProductX){
    val context= LocalContext.current

    val painter=  rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(product.images[0])
            .crossfade(true)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .build(),
    )

    Box(modifier= Modifier
        .height(300.dp)
        .fillMaxWidth(), contentAlignment = Alignment.BottomCenter){

        Image(modifier = Modifier.fillMaxSize(),painter = painter, contentScale = ContentScale.Crop, contentDescription = "Unspalsh Image")

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .alpha(ContentAlpha.medium),
            color = Color.Black) {
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = buildAnnotatedString {
                append("Name ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(product.title)
                }
                append(" Price")
            },
                color=Color.White,
                maxLines = 1,
                fontSize = MaterialTheme.typography.caption.fontSize,
                overflow = TextOverflow.Ellipsis,
            )
            LikeCounter(modifier = Modifier.weight(3f),
                painter= painterResource(id = R.drawable.ic_money),
                likes= "${product.price}")
        }

    }
}

@Composable
@ExperimentalCoilApi
fun LikeCounter(modifier: Modifier,painter: Painter,likes:String){
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        Icon(painter = painter, contentDescription = "Like Icon", tint = Color.Red)
        Divider(Modifier.width(6.dp))
        Text(
            text = likes,
            color = Color.White,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}