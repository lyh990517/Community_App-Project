package yunho.app.myapplication.Data.Repository

import kotlinx.coroutines.CoroutineDispatcher
import yunho.app.myapplication.Data.Entity.articleEntity

interface repository {

    suspend fun getAll() : List<articleEntity>

    suspend fun deleteOne(id : Long)

    suspend fun insertOne(entity: articleEntity)

    suspend fun updateOne(entity: articleEntity)
}