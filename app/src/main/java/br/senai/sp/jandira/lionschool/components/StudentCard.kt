package br.senai.sp.jandira.lionschool.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

@Composable
fun StudentCard(
    name: String = "Pedro da Silva Borges",
    ra: String = "20151001018",
    year: String = "2022",
    status: String = "Finalizado",
    photo: Int = R.drawable.logo
) {
    val statusColor = if (status == "Finalizado") Color(0xFFFFC23D) else Color(0xFF3347B0)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF7D87E4)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(8.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
                        .background(statusColor)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = photo),
                    contentDescription = "Student photo",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.lion_chip1),
                            contentDescription = "RA icon",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = ra,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Calendar",
                    tint = statusColor,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = year,
                    fontWeight = FontWeight.Bold,
                    color = statusColor
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun StudentCardPreview() {
    LionSchoolTheme {
        StudentCard()
    }
}
