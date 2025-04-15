package br.senai.sp.jandira.lionschoolapp.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.lionschoolapp.R


@Composable
fun SoonComplete(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp), // define a altura da linha
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxHeight(1f)
                .padding(5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_text),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .padding(5.dp)
        )
    }
}


@Preview
@Composable
private fun SoonCompletePreview() {
    SoonComplete()
}