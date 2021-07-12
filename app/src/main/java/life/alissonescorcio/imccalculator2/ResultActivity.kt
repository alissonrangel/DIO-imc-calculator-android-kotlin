package life.alissonescorcio.imccalculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultado = intent.getStringExtra(EXTRA_MESSAGE)

        Log.w("test", "Resultado")

        tvResultado.text = resultado
    }
}