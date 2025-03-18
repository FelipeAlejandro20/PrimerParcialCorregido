package com.maestrocorona.appferia

import android.os.Bundle  // Importa la clase Bundle para manejar el estado de la actividad
import androidx.activity.ComponentActivity  // Importa la clase base para actividades de Compose
import androidx.activity.compose.setContent  // Importa la función para configurar el contenido de la actividad
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image  // Importa la función para mostrar imágenes
import androidx.compose.foundation.layout.* // Importa funciones de diseño (Column, Row, etc.)
import androidx.compose.material3.* // Importa componentes de Material Design 3
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier  // Importa la clase Modifier para modificar la apariencia de los componentes
import androidx.compose.ui.graphics.Color  // Importa la clase Color para definir colores
import androidx.compose.ui.res.painterResource  // Importa la función para cargar imágenes desde recursos
import androidx.compose.ui.text.font.FontFamily  // Importa la clase FontFamily para definir fuentes
import androidx.compose.ui.unit.dp
import android.content.Intent  // Importa la clase Intent para iniciar otras actividades
import androidx.compose.ui.tooling.preview.Preview  // Importa la anotación para previsualizar composables

class MainActivity : ComponentActivity() {  // Define la actividad principal de la aplicación
    override fun onCreate(savedInstanceState: Bundle?) {  // Se llama cuando se crea la actividad
        super.onCreate(savedInstanceState)  // Llama al método onCreate de la superclase
        enableEdgeToEdge()
        setContent {  // Configura el contenido de la actividad usando Compose
            MainScreen(onNavigateToSecondActivity = {  // Llama a la función MainScreen y le pasa una lambda
                startActivity(Intent(this, Activity2::class.java))  // Inicia la actividad Activity2 cuando se llama a la lambda
            })
        }
    }
}

@Composable  // Indica que esta función es un composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {  // Define la función que genera la UI principal
    Surface(  // Crea una superficie (fondo) para la UI
        modifier = Modifier.fillMaxSize(),  // Ocupa todo el espacio disponible
        color = MaterialTheme.colorScheme.background  // Usa el color de fondo del tema actual
    ) {
        Column(  // Organiza los elementos en una columna vertical
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,  // Alinea los elementos al centro horizontalmente
            verticalArrangement = Arrangement.spacedBy(16.dp)  // Agrega un espacio de 16dp entre los elementos
        ) {
            // Agrega cuatro elementos BusinessItem con diferentes textos
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y conciertos")

            Button(  // Crea un botón
                onClick = onNavigateToSecondActivity,  // Ejecuta la lambda onNavigateToSecondActivity al hacer clic
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes", fontFamily = FontFamily.SansSerif)  // Muestra el texto "Fechas importantes" con la fuente SansSerif
            }
        }
    }
}

@Composable  // Indica que esta función es un composable
fun BusinessItem(text: String) {  // Define la función que genera un elemento de negocio
    val purpleLight = Color(0xFF6650a4)  // Define un color morado claro
    val purpleDark = Color(0xFFD0BCFF)  // Define un color morado oscuro (no se usa en este código)

    Card(  // Crea una tarjeta
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(  // Define los colores de la tarjeta
            containerColor = purpleLight,  // Usa el color morado claro como color de fondo
            contentColor = Color.White  // Usa el color blanco para el contenido
        )
    ) {
        Row(  // Organiza los elementos en una fila horizontal
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically  // Alinea los elementos al centro verticalmente
        ) {
            Image(  // Muestra una imagen
                painter = painterResource(id = R.drawable.logo_rest),  // Carga la imagen desde el recurso "logo_rest"
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)  // Define el tamaño de la imagen a 100dp x 100dp
                    .padding(8.dp)  // Agrega un padding de 8dp alrededor de la imagen
            )
            Text(  // Muestra un texto
                text = text,  // Muestra el texto pasado como argumento
                modifier = Modifier.padding(8.dp),  // Agrega un padding de 8dp alrededor del texto
                fontFamily = FontFamily.SansSerif  // Usa la fuente SansSerif
            )
        }
    }
}

@Preview(showBackground = true)  // Indica que esta función es una vista previa y muestra el fondo
@Composable  // Indica que esta función es un composable
fun PreviewMainScreen() {  // Define una vista previa de la UI principal
    MainScreen(onNavigateToSecondActivity = {})  // Llama a MainScreen con una lambda vacía para el parámetro onNavigateToSecondActivity
}