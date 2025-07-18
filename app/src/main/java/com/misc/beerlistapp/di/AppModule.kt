package com.misc.beerlistapp.di


import com.misc.core.navigation.DefaultNavigator
import com.misc.core.navigation.Destination
import com.misc.core.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesDefaultNavigator(): Navigator {
        return DefaultNavigator(startDestination = Destination.Splash)
    }
}