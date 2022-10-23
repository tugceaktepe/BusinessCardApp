package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp(
                        name = "Tugce AKTEPE",
                        jobTitle = "Android Developer",
                        phoneNumber = "+90 (555) 444 33 22",
                        socialMedia = "@tugceaktepe",
                        email = "tugce@mail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    name: String,
    jobTitle: String,
    phoneNumber: String,
    socialMedia: String,
    email: String
) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Header(name, jobTitle)
        ContactInfo(phoneNumber, socialMedia, email)
    }
}

@Composable
fun Header(name: String, jobTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = stringResource(R.string.profile_picture),
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = name,
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 48.sp
        )
        Text(
            text = jobTitle,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ContactInfo(phoneNumber: String, socialMedia: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        )
        ContactInfoRow(
            painterResource(id = R.drawable.ic_phone),
            phoneNumber,
            stringResource(R.string.phone_number)
        )
        Spacer(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        )
        ContactInfoRow(painterResource(id = R.drawable.ic_share), socialMedia, stringResource(R.string.social_media))
        Spacer(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        )
        ContactInfoRow(painterResource(id = R.drawable.ic_email), email, stringResource(R.string.email))
    }
}

@Composable
fun ContactInfoRow(
    painter: Painter,
    info: String,
    contentDescription: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(start = 48.dp)
        )
        Text(
            text = info, color = Color.White,
            modifier = Modifier.padding(start = 16.dp, end = 48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCardApp(
            name = "Tugce AKTEPE",
            jobTitle = "Android Developer",
            phoneNumber = "+90 (555) 444 33 22",
            socialMedia = "@tugceaktepe",
            email = "tugce@mail.com"
        )
    }
}