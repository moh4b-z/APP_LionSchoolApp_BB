package br.senai.sp.jandira.lionschoolapp.screens




import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapp.R
import br.senai.sp.jandira.lionschoolapp.screens.components.SoonComplete
import org.w3c.dom.Text
import java.util.Locale

@Composable
fun StudentListScreen(
) {
    val searchCourseState = remember {
        mutableStateOf(value = "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        SoonComplete()
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .padding(10.dp)
                        ,
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxHeight()
                                .aspectRatio(1f)
                            ,
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                colorResource(R.color.light_orange)
                            ),
                            elevation = CardDefaults.elevatedCardElevation(5.dp)
                        ) { }
                    }


                }

                HorizontalDivider(
                    color = colorResource(R.color.light_orange)
                )
            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp, 20.dp, 10.dp, 20.dp)
            ) {
                Column {
                    OutlinedTextField(
                        value = searchCourseState.value,
                        onValueChange = {
                            searchCourseState.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = colorResource(R.color.light_gray),
                                RoundedCornerShape(18.dp)
                            )
                            .border(
                                2.dp,
                                color = colorResource(R.color.light_orange),
                                RoundedCornerShape(18.dp))
                        ,
                        label = {
                            Text(
                                text = stringResource(R.string.find_your_course),
                                color = colorResource(R.color.gray),
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "",
                                tint = colorResource(R.color.gray)
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            cursorColor = Color(0xFFBA88FF),
                            unfocusedLabelColor = Color(0xFFBA88FF)
                        )
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 20.dp, 0.dp, 20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "",
                        tint = colorResource(R.color.light_orange)
                    )
                    Text(
                        text = stringResource(R.string.students_list),
                        color = colorResource(R.color.blue_purple),
                        fontSize = 24.sp

                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {  }
            }
        }
    }
}

@Preview
@Composable
private fun StudentListScreenPreview() {
    StudentListScreen()
}