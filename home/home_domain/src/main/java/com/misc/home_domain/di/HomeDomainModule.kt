package com.misc.home_domain.di

import com.misc.home_domain.repository.HomeRepository
import com.misc.home_domain.use_cases.HomeUseCases
import com.misc.home_domain.use_cases.RetrieveBeers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {
    @ViewModelScoped
    @Provides
    fun provideHomeUseCases(repository: HomeRepository): HomeUseCases {
        return HomeUseCases(
            getBeers = RetrieveBeers(repository)
        )
    }
}