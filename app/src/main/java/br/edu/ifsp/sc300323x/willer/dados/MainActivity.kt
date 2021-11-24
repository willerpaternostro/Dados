package br.edu.ifsp.sc300323x.willer.dados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.ifsp.sc300323x.willer.dados.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var  activityMainBinding: ActivityMainBinding
    private lateinit var geradorRandomico: Random

    private lateinit var  settingsActivityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        geradorRandomico = Random(System.currentTimeMillis())

        activityMainBinding.jogarDadoBt.setOnClickListener{
            val resultado: Int = geradorRandomico.nextInt(1..6)
            "A face sorteada foi $resultado".also{ activityMainBinding.resultadoTv.text = it }
            val nomeImagem = "dice_${resultado}"
            activityMainBinding.resultadoIv.setImageResource(
                resources.getIdentifier(nomeImagem, "mipmap", packageName)
            )
        }

        settingsActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK) {
                //Modificações na view
                if(result.data != null){
                    val configuracao: Configuracao? = result.data?.getParcelableExtra<Configuracao>(Intent.EXTRA_USER)
                    // Se a qtd de dados for 2, vai ser preciso ter 2 image view, 1 pra face do 1º dado e outro para 2º dado
                    //Se a quantidade das faces for maior do que 6 não mostra nenhum image view
                    // Fazer o exercício - Recebida a configuração, como reagir? Isto é, a modificação necessária

                }

            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settingsMi){
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            settingsActivityLauncher.launch(settingsIntent)
            return true
        }
        return false
    }
}