package yunho.app.myapplication.Presentation.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Presentation.BaseFragment
import yunho.app.myapplication.Presentation.ViewModel.HomeViewModel
import yunho.app.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel>() {
    private lateinit var binding : FragmentHomeBinding
    override val viewModel: HomeViewModel by viewModel()

    override fun observeData() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
}