package yunho.app.myapplication.Presentation.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import yunho.app.myapplication.Data.RemoteDB.Ref
import yunho.app.myapplication.Data.Repository.FirebaseRepository
import yunho.app.myapplication.Data.Repository.articleRepository
import yunho.app.myapplication.Presentation.BaseViewModel
import yunho.app.myapplication.Presentation.articleState

class HomeViewModel(
    private val repository: FirebaseRepository
) : BaseViewModel() {
    private val _articleLiveData = MutableLiveData<articleState>(articleState.Uninitialized)
    val articleLiveData = _articleLiveData
    override fun fetchData(): Job = viewModelScope.launch{
        Log.e("fetched!","123")
        articleLiveData.postValue(articleState.Loading)
        articleLiveData.postValue(articleState.success(repository.getAll()))
    }
}