package yunho.app.myapplication.Data.Repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Data.LocalDB.Dao.articleDao

class articleRepository(
    private val Dao : articleDao,
    private val IODispatcher : CoroutineDispatcher
) : repository{
    override suspend fun getAll(): List<articleEntity> = withContext(IODispatcher){
        Dao.getAll()
    }

    override suspend fun deleteOne(id: Long) = withContext(IODispatcher){
        Dao.deleteOne(id)
    }

    override suspend fun insertOne(entity: articleEntity) = withContext(IODispatcher){
        Dao.insertOne(entity)
    }

    override suspend fun updateOne(entity: articleEntity) = withContext(IODispatcher){
        Dao.updateOne(entity)
    }
}