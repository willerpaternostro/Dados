package br.edu.ifsp.sc300323x.willer.dados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.ifsp.sc300323x.willer.dados.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var  activitySettingsBinding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySettingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(activitySettingsBinding.root)

        activitySettingsBinding.salvarSettingsBt.setOnClickListener{
            val numeroDados: Int = (activitySettingsBinding.numeroDadosSp.selectedView as TextView).text.toString().toInt()
            val numeroFaces: Int = activitySettingsBinding.numeroFacesEt.text.toString().toInt()
            val configuracao = Configuracao(numeroDados, numeroFaces)
            val retornoIntent = Intent()
            retornoIntent.putExtra(Intent.EXTRA_USER, configuracao)
            setResult(RESULT_OK, retornoIntent)
            finish()
        }
    }
}