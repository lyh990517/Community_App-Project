package yunho.app.myapplication.Data.LocalDB

import android.content.Context
import androidx.room.Room

internal fun getArticleDB(context: Context) = Room.databaseBuilder(context,articleDatabase::class.java,articleDatabase.DB_NAME).build()

internal fun getArticleDao(database: articleDatabase) = database.Dao()