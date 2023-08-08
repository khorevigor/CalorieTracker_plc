package com.plcoding.tracker_domain.di

import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.tracker_domain.repository.TrackerRepository
import com.plcoding.tracker_domain.use_case.CalculateMealNutrients
import com.plcoding.tracker_domain.use_case.DeleteTrackedFood
import com.plcoding.tracker_domain.use_case.GetFoodsForDate
import com.plcoding.tracker_domain.use_case.SearchFood
import com.plcoding.tracker_domain.use_case.TrackFood
import com.plcoding.tracker_domain.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @Provides
    @ViewModelScoped
    fun provideTrackerUseCases(
        trackerRepository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(trackerRepository),
            searchFood = SearchFood(trackerRepository),
            deleteTrackedFood = DeleteTrackedFood(trackerRepository),
            getFoodsForDate = GetFoodsForDate(trackerRepository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}
