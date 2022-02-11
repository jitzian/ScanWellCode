package com.example.scanwellchallenge.dagger.components

import com.example.scanwellchallenge.dagger.modules.NetworkModule
import com.example.scanwellchallenge.showRepos.viewmodel.MainViewModel
import dagger.Component

@Component(
    modules = [NetworkModule::class]
)
interface ComponentInjector {

    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): ComponentInjector
    }

}