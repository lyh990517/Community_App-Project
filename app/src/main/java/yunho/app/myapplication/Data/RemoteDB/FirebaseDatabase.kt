package yunho.app.myapplication.Data.RemoteDB

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Presentation.Adapter.ArticleAdapter
import yunho.app.myapplication.Presentation.ViewModel.HomeViewModel

val adapter = ArticleAdapter()
val Ref = Firebase.database.getReference()
fun provideFirebaseDB(viewModel : HomeViewModel,context: Context): DatabaseReference {
    var articleDB = Firebase.database.reference.child("articles")
    //데이터베이스 실시간 감지를 위한 리스너
    articleDB.addChildEventListener(object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {}
        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
        override fun onChildRemoved(snapshot: DataSnapshot) {}
        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
        override fun onCancelled(error: DatabaseError) {}
    })
    return articleDB
}
