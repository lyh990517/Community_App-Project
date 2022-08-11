package yunho.app.myapplication.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class articleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val image: String,
    val time: String,
)