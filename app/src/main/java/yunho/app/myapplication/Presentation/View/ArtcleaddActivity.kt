package yunho.app.myapplication.Presentation.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Data.RemoteDB.provideFirebaseDB
import yunho.app.myapplication.Presentation.ViewModel.HomeViewModel
import yunho.app.myapplication.databinding.ActivityAddarticleBinding

class ArtcleaddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddarticleBinding
    private val viewModel : HomeViewModel by inject()
    private val database = provideFirebaseDB(viewModel,this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddarticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initviews()
    }

    private fun initviews() = with(binding){
        articlePost.setOnClickListener {
            val title = titleInput.text.toString()
            val content = contentInput.text.toString()
            val article = articleEntity(title = title
                , content = content)
            database.push().setValue(article)
            val intent = Intent(this@ArtcleaddActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}