package com.arlib.task.useCase

import android.database.SQLException
import com.arlib.task.domain.models.Drug
import com.arlib.task.domain.repo.DrugsRepo
import com.arlib.task.domain.usecase.GetDrugsUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetDrugsUseCaseTest {

    @Mock
    private lateinit var drugsRepo: DrugsRepo

    private lateinit var getDrugsUseCase: GetDrugsUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getDrugsUseCase = GetDrugsUseCase(drugsRepo)
    }

    @Test
    fun `invoke should return drugs from database`() {
        val drugs =
            listOf(Drug("Dose 1", "Drug 1", "Strength 1"), Drug("Dose 2", "Drug 2", "Strength 2"))
        val flowOfDrugs: Flow<List<Drug>> = flowOf(drugs)

        runBlocking {
            Mockito.`when`(drugsRepo.cachingDrugs()).then { }
        }

        Mockito.`when`(drugsRepo.getDrugsFromDb()).thenReturn(flowOfDrugs)

        val resultFlow = runBlocking { getDrugsUseCase() }

        runBlocking {
            assertEquals(drugs, resultFlow.first())
        }

    }

    @Test
    fun `invoke should return empty list when database is empty`() {
        val flowOfDrugs: Flow<List<Drug>> = flowOf(emptyList())

        runBlocking {
            Mockito.`when`(drugsRepo.cachingDrugs()).then { }
        }

        Mockito.`when`(drugsRepo.getDrugsFromDb()).thenReturn(flowOfDrugs)

        val resultFlow = runBlocking { getDrugsUseCase() }

        runBlocking {
            assertEquals(emptyList<Drug>(), resultFlow.first())
        }

    }

    @Test(expected = SQLException::class)
    fun `invoke should throw exception when database retrieval fails`() {

        runBlocking {
            Mockito.`when`(drugsRepo.cachingDrugs()).then { }
        }
        Mockito.`when`(drugsRepo.getDrugsFromDb()).thenThrow(SQLException())

        runBlocking { getDrugsUseCase() }
    }
}
