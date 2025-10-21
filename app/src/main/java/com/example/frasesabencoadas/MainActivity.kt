package com.example.frasesabencoadas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frasesabencoadas.ui.theme.FrasesAbencoadasTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrasesAbencoadasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var resultado by remember { mutableStateOf ("Deus falará com você aqui") }

    val lista = stringArrayResource(R.array.frases)
    Surface(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.imagem), // trazer a imagem
            contentDescription = null, //descrever o conteudo da imagem para fim de acessibilidade
            contentScale = ContentScale.Crop, // ajeitar a imagem se ela estiver com resolução diferente
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) { // COLUNA
            Text(
                text = resultado,
                color = Color.White,
                fontStyle = FontStyle.Normal, // estilo da fonte
                fontWeight = FontWeight.SemiBold, // negrito ?
                fontSize = 25.sp, // tamanho da fonte
                modifier = modifier.padding(20.dp), //modificador, limite nas laterais
                textAlign = TextAlign.Center //o texto continue centralizado mesmo quando quebra de linha
                )

            Text("")  // pular uma linha para o botão

            Button(onClick = {
                val indice = Random.nextInt(lista.size)
                resultado = lista[indice]
            } ) {
                Text("Frase Diária")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FrasesAbencoadasTheme {
        MainScreen()
    }
}