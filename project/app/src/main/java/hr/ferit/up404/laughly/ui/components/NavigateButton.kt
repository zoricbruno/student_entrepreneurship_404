package hr.ferit.up404.laughly.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hr.ferit.up404.laughly.R

@Composable
fun NavigateButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.rosewater),
            contentColor = colorResource(id = R.color.cream)
        )
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewNavigateButton() {
    NavigateButton(text = "Hello world!", onClick = {})
}
