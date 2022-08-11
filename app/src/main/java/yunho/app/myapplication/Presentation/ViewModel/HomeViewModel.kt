package yunho.app.myapplication.Presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import yunho.app.myapplication.Data.Repository.articleRepository
import yunho.app.myapplication.Presentation.BaseViewModel
import yunho.app.myapplication.Presentation.articleState

class HomeViewModel(
    private val repository: articleRepository
) : BaseViewModel() {
    private val _articleLiveData = MutableLiveData<articleState>(articleState.Uninitialized)
    val articleLiveData = _articleLiveData
    override fun fetchData(): Job = viewModelScope.launch{
        
    }
}