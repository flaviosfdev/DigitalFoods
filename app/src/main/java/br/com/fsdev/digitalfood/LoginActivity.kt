package br.com.fsdev.digitalfood

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.VideoView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var videoView: VideoView
    private lateinit var path: String
    private lateinit var uri: Uri

    private lateinit var editLoginEmail: TextInputEditText
    private lateinit var editLoginSenha: TextInputEditText
    private lateinit var buttonEsqueciSenha: MaterialButton
    private lateinit var buttonEntrar: MaterialButton
    private lateinit var buttonCadastrarSe: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        initListeners()
        playVideo()

    }

    private fun initViews() {
        videoView = findViewById(R.id.video_view)
        editLoginEmail = findViewById(R.id.edit_login_email)
        editLoginSenha = findViewById(R.id.edit_login_senha)
        buttonEsqueciSenha = findViewById(R.id.button_login_esqueci_senha)
        buttonEntrar = findViewById(R.id.button_login_entrar)
        buttonCadastrarSe = findViewById(R.id.button_login_cadastrar_se)
    }

    private fun initListeners() {
        buttonEsqueciSenha.setOnClickListener(this)
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
            buttonEsqueciSenha.id -> {
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