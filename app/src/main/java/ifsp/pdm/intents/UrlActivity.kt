package ifsp.pdm.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ifsp.pdm.intents.Constant.URL
import ifsp.pdm.intents.databinding.ActivityUrlBinding

class UrlActivity : AppCompatActivity() {

    private lateinit var amb: ActivityUrlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityUrlBinding.inflate(layoutInflater)
        setContentView(amb.root)

        supportActionBar?.subtitle = "URLActivity"

        val urlAnterior = intent.getStringExtra(URL) ?: ""

        urlAnterior.takeIf { it.isNotEmpty() }.also { amb.urlEt.setText(it) }

        amb.entrarUrlBt.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val retornoIntent = Intent()
                retornoIntent.putExtra(URL, amb.urlEt.text.toString())
                setResult(RESULT_OK, retornoIntent)
                finish()
            }
        })
    }
}