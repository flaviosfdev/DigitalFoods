package br.com.fsdev.digitalfood

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val videoView: VideoView by lazy { findViewById(R.id.video_view) }
    private lateinit var path: String

    private lateinit var uri: Uri
    private val editLoginEmail: TextInputEditText by lazy { findViewById(R.id.edit_login_email) }
    private val editLoginSenha: TextInputEditText by lazy { findViewById(R.id.edit_login_senha) }
    private val textViewEsqueciSenha: TextView by lazy { findViewById(R.id.text_view_login_esqueci_senha) }
    private val buttonEntrar: MaterialButton by lazy { findViewById(R.id.button_login_entrar) }
    private val buttonCadastrarSe: MaterialButton by lazy { findViewById(R.id.button_login_cadastrar_se) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initListeners()
        playVideo()

    }

    private fun initListeners() {
        textViewEsqueciSenha.setOnClickListener(this)
        buttonEntrar.setOnClickListener(this)
        buttonCadastrarSe.setOnClickListener(this)
    }

    private fun playVideo() {
        path = "android.resource://br.com.fsdev.digitalfood/${R.raw.video_background}"
        uri = Uri.parse(path)
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
        }
    }

    override fun onResume() {
        videoView.resume()
        super.onResume()
    }

    override fun onPause() {
        videoView.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        videoView.stopPlayback()
        super.onDestroy()
    }

    override fun onClick(v: View) {

        when (v.id) {
            textViewEsqueciSenha.id -> {
                Toast.makeText(this, "Em desenvolvimento", Toast.LENGTH_SHORT).show()
            }
            buttonEntrar.id -> {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
            buttonCadastrarSe.id -> {
                startActivity(Intent(this, CadastroActivity::class.java))
            }
        }

    }

}