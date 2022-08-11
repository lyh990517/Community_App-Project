package yunho.app.myapplication.Presentation.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Presentation.BaseFragment
import yunho.app.myapplication.Presentation.ViewModel.UserViewModel
import yunho.app.myapplication.databinding.FragmentChatBinding
import yunho.app.myapplication.databinding.FragmentUserBinding

class UserFragment : BaseFragment<UserViewModel>() {
    override val viewModel: UserViewModel by viewModel()
    private lateinit var binding : FragmentUserBinding
    override fun observeData() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }
}