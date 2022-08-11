package yunho.app.myapplication.Presentation.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Presentation.BaseActivity
import yunho.app.myapplication.Presentation.BaseViewModel
import yunho.app.myapplication.Presentation.ViewModel.MainViewModel
import yunho.app.myapplication.Presentation.articleState
import yunho.app.myapplication.R
import yunho.app.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel>() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override val viewModel: MainViewModel by viewModel()

    override fun observeData() {
        viewModel.articleLiveData.observe(this) {
            when (it) {
                is articleState.Uninitialized -> initViews()
            }
        }
    }

    private fun initViews() {
        showFragment(HomeFragment())
        binding.bottomNav.run {
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.home -> showFragment(HomeFragment())
                    R.id.chat -> showFragment(ChatFragment())
                    R.id.user -> showFragment(UserFragment())
                    else -> true
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Frame,fragment)
            commit()
        }
        return true
    }

}