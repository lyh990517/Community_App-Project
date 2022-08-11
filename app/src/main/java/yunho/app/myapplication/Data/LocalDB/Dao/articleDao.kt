package yunho.app.myapplication.Data.LocalDB.Dao

import androidx.room.*
import yunho.app.myapplication.Data.Entity.articleEntity

@Dao
interface articleDao {
    @Query("SELECT * FROM articleEntity")
    suspend fun getAll() : List<articleEntity>

    @Insert
    suspend fun insertOne(Entity: articleEntity)

    @Query("DELETE FROM articleEntity WHERE id = :id")
    suspend fun deleteOne(id: Long)

    @Update
    suspend fun updateOne(entity: articleEntity)
}