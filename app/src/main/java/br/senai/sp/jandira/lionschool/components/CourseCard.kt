package br.senai.sp.jandira.lionschool.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.model.Course
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

@Composable
fun CourseCard(
    course: Course = Course(
        id = 0,
        sigla = "XXX",
        icone = R.drawable.programming1,
        nome = "Curso Exemplo",
        descricao = "Descrição do curso de exemplo.",
        cargaHoraria = "40h"
    ),
    courseIcon: Int? = R.drawable.programming1
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3347B0)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = course.sigla,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFC23D),
                    modifier = Modifier.weight(1f)
                )
                if (courseIcon != null) {
                    Image(
                        painter = painterResource(id = courseIcon),
                        contentDescription = course.nome,
                        modifier = Modifier.size(60.dp)
                    )
                }
            }
            Text(
                text = course.nome,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = course.descricao,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = course.cargaHoraria,
                fontSize = 16.sp,
                color = Color(0xFFFFC23D),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseCardPreview() {
    LionSchoolTheme {
        val exampleCourse = Course(
            id = 2,
            sigla = "RDS",
            icone = R.drawable.internet1,
            nome = stringResource(R.string.course_rds_name),
            descricao = stringResource(R.string.course_rds_description),
            cargaHoraria = stringResource(R.string.course_rds_duration)
        )
        CourseCard(
            course = exampleCourse,
            courseIcon = R.drawable.programming1
        )
    }
}
