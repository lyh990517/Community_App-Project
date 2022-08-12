package yunho.app.myapplication.Presentation.View

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Presentation.Adapter.ArticleAdapter
import yunho.app.myapplication.Presentation.BaseFragment
import yunho.app.myapplication.Presentation.ViewModel.HomeViewModel
import yunho.app.myapplication.Presentation.articleState
import yunho.app.myapplication.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel>() {
    private lateinit var binding: FragmentHomeBinding
    private val adapter = ArticleAdapter()
    override val viewModel: HomeViewModel by viewModel()

    override fun observeData() {
        viewModel.articleLiveData.observe(this) {
            when (it) {
                is articleState.Uninitialized -> initViews()
                is articleState.Loading -> handleLoading()
                is articleState.success -> handleSuccess(it)
            }
        }
    }

    private fun handleSuccess(it: articleState.success) = with(binding) {
        articleRefresh.isRefreshing = false
        adapter.setData(it.data){
            Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
            //TODO go detailView
        }
    }

    private fun handleLoading() {
        binding.articleRefresh.isRefreshing = true
    }

    private fun initViews() {
        initAddButton()
        initRecycler()
        initRefresh()
    }


    private fun initRefresh() {
        binding.articleRefresh.setOnRefreshListener {
            viewModel.fetchData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initAddButton() {
        binding.addArticle.setOnClickListener {
            val intent = Intent(context, ArtcleaddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecycler() {
        binding.articleView.adapter = adapter
        binding.articleView.layoutManager = LinearLayoutManager(context)
    }
}