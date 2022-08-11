package yunho.app.myapplication.Presentation

import yunho.app.myapplication.Data.Entity.articleEntity

sealed class articleState{
    object Uninitialized : articleState()

    object Loading : articleState()

    data class success(
        val data : List<articleEntity>
    ) : articleState()

    object Delete : articleState()

    object Update : articleState()

    object Error : articleState()
}
