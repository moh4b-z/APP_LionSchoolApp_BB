package br.senai.sp.jandira.lionschool.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.components.StudentCard
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

@Composable
fun StudentsScreen() {
    LionSchoolTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = stringResource(R.string.logo_descripition),
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.title),
                            fontSize = 18.sp,
                            color = Color(0xFF3347B0),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Card(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        colors = CardDefaults.cardColors(Color(0xFFFFC23D)),
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Text(text = "DS", fontWeight = FontWeight.Bold, color = Color(0xFF3347B0))
                        }
                    }
                }

                // Campo de busca
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = {
                        Text(text = stringResource(R.string.search_placeholder))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search_placeholder),
                            tint = Color.Gray
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Filtros
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    FilterButton("Todos", selected = true)
                    FilterButton("Cursando", selected = false)
                    FilterButton("Finalizado", selected = false)
                }

                Divider(
                    color = Color(0xFFFFC23D),
                    thickness = 2.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "Students List",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3347B0),
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp)
                )

                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    StudentCard()
                    StudentCard()
                    StudentCard()
                }
            }
        }
    }
}

@Composable
fun FilterButton(text: String, selected: Boolean) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0xFF3347B0) else Color(0xFFFFC23D),
            contentColor = if (selected) Color.White else Color(0xFF3347B0)
        ),
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
        modifier = Modifier.height(40.dp)
    ) {
        Text(text = text)
    }
}

@Preview(showSystemUi = true)
@Composable
fun StudentsScreenPreview() {
    LionSchoolTheme {
        StudentsScreen()
    }
}
