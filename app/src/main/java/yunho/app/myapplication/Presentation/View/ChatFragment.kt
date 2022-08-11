package yunho.app.myapplication.Presentation.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Presentation.BaseFragment
import yunho.app.myapplication.Presentation.ViewModel.ChatViewModel
import yunho.app.myapplication.databinding.FragmentChatBinding
import yunho.app.myapplication.databinding.FragmentHomeBinding

class ChatFragment : BaseFragment<ChatViewModel>() {
    override val viewModel: ChatViewModel by viewModel()
    private lateinit var binding : FragmentChatBinding
    override fun observeData() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }
}