package yunho.app.myapplication.Data.Repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Data.RemoteDB.Ref
import yunho.app.myapplication.Presentation.Adapter.ArticleAdapter

class FirebaseRepository(
    private val IODispatcher : CoroutineDispatcher,
) : repository {
    private var list = mutableListOf<articleEntity>()
    override suspend fun getAll(): List<articleEntity> = withContext(IODispatcher){
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                snapshot.child("articles").children.forEach {
                    val article = it.getValue(articleEntity::class.java)
                    list.add(article!!)
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
        list
    }

    override suspend fun deleteOne(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun insertOne(entity: articleEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOne(entity: articleEntity) {
        TODO("Not yet implemented")
    }
}