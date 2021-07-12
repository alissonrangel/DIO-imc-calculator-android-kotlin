package life.alissonescorcio.imccalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.main_constraint.*

const val EXTRA_MESSAGE = "life.alissonescorcio.imccalculator2.MESSAGE"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)
        setListeners()
    }

    private fun setListeners(){

        etAltura?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        etPeso?.doOnTextChanged { text, _, _, _ ->
            //tvImc?.text = text
        }

        btCalcular?.setOnClickListener {
            calculaIMC(etPeso.text.toString(), etAltura.text.toString())
        }
    }

    private fun calculaIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if ( peso != null && altura != null ){
            val imc = peso / (altura * altura)
            //tvResultado.text = "Seu imc é %.2f".format(imc)
            val resultado = "Seu imc é %.2f".format(imc)
            val intent = Intent(this, ResultActivity::class.java).apply{
                putExtra(EXTRA_MESSAGE, resultado)
            }
            startActivity(intent)
        }
    }
}