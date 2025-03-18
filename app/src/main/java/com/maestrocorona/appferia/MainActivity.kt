package com.maestrocorona.appferia

//En este apartado se encuentra cada una de las importaciones de las cuales de van
//extrayendo los recursos necesarios para cada una de las funciones que se han estado
//pues implementando.

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.ui.tooling.preview.Preview


//Esta es la pantalla principal de la aplicación.
//cada vez que esta se apertura, esta es la primera clase que se ejecuta.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}
//Indica que MainScreenes una función componible, es decir, define una UI en Jetpack Compose.
@Composable
//Es la función principal de la pantalla. Recibe una función onNavigateToSecondActivitycomo parámetro, que se ejecutará cuando el usuario presione el botón.
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {

        Column( // Organiza los elementos en una columna.
            modifier = Modifier
                .fillMaxSize() // Hace que la columna ocupe el espacio disponible
                .padding(16.dp), //Agrega un margen interno
            horizontalAlignment = Alignment.CenterHorizontally, //Centra los elementos en el eje horizontal.
            verticalArrangement = Arrangement.spacedBy(16.dp) //Separa los elementos con un espacio
        ) {
            BusinessItem("Negocios de la Nave 1") //Muestra diferentes elementos en la pantalla
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y conciertos")

            Button( //Define un botón interactivo
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes", fontFamily = FontFamily.SansSerif)
            }
        }
    }
}
//Define una función composable llamada BusinessItem
@Composable
fun BusinessItem(text: String) {
    val purpleLight = Color(0xFF6650a4) //Define dos variables de color, purpleLight y purpleDark
    val purpleDark = Color(0xFFD0BCFF)

    Card( //Crea un componente Card, que es un contenedor
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = purpleLight,
            contentColor = Color.White
        )
    ) {
        Row( //Crea un componente Row, que organiza sus elementos secundarios en una fila horizontal.
            modifier = Modifier
                .fillMaxSize() //hace que la fila ocupe  el espacio disponible
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically //Alinea los elementos  de la fila verticalmente al centro
        ) {
            Image( //Crea un componente Image para mostrar una imagen.
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text( //Crea un componente Text para mostrar texto.

                text = text,
                modifier = Modifier.padding(8.dp),
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}
//En esta parte solo se utiliza lo que es el PREVIEW para visualizar la
//aplicacion sin necesidad de ejecutarla.
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen(onNavigateToSecondActivity = {})
}
