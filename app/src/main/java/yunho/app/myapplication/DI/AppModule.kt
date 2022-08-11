package yunho.app.myapplication.DI

import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import yunho.app.myapplication.Data.LocalDB.getArticleDB
import yunho.app.myapplication.Data.LocalDB.getArticleDao
import yunho.app.myapplication.Data.Repository.articleRepository
import yunho.app.myapplication.Presentation.ViewModel.ChatViewModel
import yunho.app.myapplication.Presentation.ViewModel.HomeViewModel
import yunho.app.myapplication.Presentation.ViewModel.MainViewModel
import yunho.app.myapplication.Presentation.ViewModel.UserViewModel

internal val AppModule = module {

    single { Dispatchers.IO }
    single { Dispatchers.Main }
    //data
    single { getArticleDB(get()) }
    single { getArticleDao(get()) }
    //repository
    single { articleRepository(get(), get()) }
    //usecase

    //viewmodel
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ChatViewModel(get()) }
    viewModel { UserViewModel(get()) }
}