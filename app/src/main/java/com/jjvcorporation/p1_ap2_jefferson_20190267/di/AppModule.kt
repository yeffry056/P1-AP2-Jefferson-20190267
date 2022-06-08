package com.jjvcorporation.p1_ap2_jefferson_20190267.di

import android.content.Context
import androidx.room.Room
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.PrestamoDao
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.PrestamosDb
import com.jjvcorporation.p1_ap2_jefferson_20190267.data.repository.prestamoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProviePersonasDb(@ApplicationContext appContext: Context): PrestamosDb
    {
        return Room.databaseBuilder(
            appContext,
            PrestamosDb::class.java,
            "PrestamosDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDao(prestamosDb: PrestamosDb): PrestamoDao{
        return  prestamosDb.prestamoDao
    }

    @Provides
    fun ProvidesPersonaRepository(prestamoDao: PrestamoDao) : prestamoRepository{
        return prestamoRepository(prestamoDao)
    }
}