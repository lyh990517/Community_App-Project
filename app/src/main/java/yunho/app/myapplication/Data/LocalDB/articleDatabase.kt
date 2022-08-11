package yunho.app.myapplication.Data.LocalDB

import androidx.room.Database
import androidx.room.RoomDatabase
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.Data.LocalDB.Dao.articleDao

@Database(
    entities = [articleEntity::class],
    exportSchema = false,
    version = 1
)
abstract class articleDatabase : RoomDatabase(){
    companion object{
        const val DB_NAME = "article_DB"
    }
    abstract fun Dao() : articleDao
}