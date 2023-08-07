package com.gravition.mirrorfinder

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.isAvailableOnDevice
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.gravition.mirrorfinder.ui.theme.MirrorFinderTheme
import com.gravition.mirrorfinder.ui.theme.provider
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.horizontal.topAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entriesOf
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created
 * https://fonts.google.com/?query=Impallari+Type
 */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MirrorFinderTheme {
                var dialogState by remember {
                    mutableStateOf(false)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Gravition",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    )
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                                navigationIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null,
                                        modifier = Modifier.padding(8.dp),
                                        tint = Color.White
                                    )
                                }
                            )
                        }
                    ) {
                        Surface(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxSize(),
                            color = MaterialTheme.colorScheme.surfaceVariant
                        ) {

                            val windowInsets =
                                WindowCompat.getInsetsController(window, window.decorView)
                            windowInsets.systemBarsBehavior =
                                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE


                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                //CanvasDraw()
                                //webTextScrapper()
                                JsopTest()
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun GoogleFontEg() {
        //some fonts not working correctly
        //use this group fonts Impallari

        val context = LocalContext.current
        LaunchedEffect(Unit) {
            if (provider.isAvailableOnDevice(context)) {
                Log.d("FCK LGBTQ", "Success!")
            } else {
                Log.d("FCK LGBTQ", "Failure!")
            }
        }
        val fontName = GoogleFont("Kaushan Script")

        val fontFamily = FontFamily(
            Font(
                googleFont = fontName,
                fontProvider = provider,
                style = FontStyle.Normal,
                weight = FontWeight.Bold
            )
        )
        Text(
            text = "Some of you may know about my life my lif is my message ",
            fontFamily = fontFamily
        )
    }

    @Composable
    fun ColumnChart() {
        val chartModel = ChartEntryModelProducer(entriesOf(34f, 23f, 19f, 29f))

        Chart(
            chart = columnChart(
                dataLabel = null,
            ),
            model = chartModel.getModel(),
            startAxis = startAxis(
                title = "SomeChanges",
                titleComponent = textComponent(
                    color = Color.Red
                )

            ),
            bottomAxis = bottomAxis(
                title = "Bottom Axis"
            ),
            topAxis = topAxis()
        )
    }

}


@Composable
fun CanvasDraw() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        // Spacer(modifier = Modifier.width(16.dp))
        //this is also a change


        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            val height = size.height / 3f
            val width = 60f
            // val size = height * width.toDp().toPx()
            inset(
                horizontal = 16f,
                vertical = 16f,
            ) {
                drawRoundRect(
                    size = Size(width = width, height = height),
                    cornerRadius = CornerRadius(24f, 24f),
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Gray,
                            Color.Gray
                        )
                    )
                )
            }
        })
    }
}

@Composable
fun webTextScrapper() {
    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
    StrictMode.setThreadPolicy(policy)


    var data = "no data"
    val connection = URL("http://www.google.com").openConnection() as HttpURLConnection
    try {
        data = connection.inputStream.bufferedReader().use { it.readText() }
    } catch (io: IOException) {
        io.localizedMessage
    } finally {
        connection.disconnect()

    }


    Text(text = data.toString(), style = MaterialTheme.typography.bodyMedium)
}


@Composable
fun JsopTest() {
    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
    StrictMode.setThreadPolicy(policy)

    val doc = Jsoup.connect("https://en.wikipedia.org/wiki/J._Robert_Oppenheimer").get()
    val element = doc.selectXpath("//*[@id=\"mw-content-text\"]/div[1]/p[3]")
    Column(modifier =  Modifier.fillMaxWidth()) {
        Text(text = doc.title())
        Text(text = element.text())
    }

}