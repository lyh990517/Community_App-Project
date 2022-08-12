package yunho.app.myapplication.Data.RemoteDB

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Presentation.Adapter.ArticleAdapter

val adapter = ArticleAdapter()
val Ref = Firebase.database.getReference()
fun provideFirebaseDB(): DatabaseReference {
    var articleDB = Firebase.database.reference.child("articles")
    articleDB.addChildEventListener(object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val articleItem = snapshot.getValue(articleEntity::class.java)
            articleItem ?: return
            adapter.setData(adapter.articles + articleItem) {
                //게시글 올리기
            }
        }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

        }

        override fun onChildRemoved(snapshot: DataSnapshot) {

        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

        }

        override fun onCancelled(error: DatabaseError) {

        }

    })
    return articleDB
}
