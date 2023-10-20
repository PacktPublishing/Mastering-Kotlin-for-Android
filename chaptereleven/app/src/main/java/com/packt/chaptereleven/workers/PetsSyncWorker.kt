package com.packt.chaptereleven.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.packt.chaptereleven.data.PetsRepository

class PetsSyncWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val  petsRepository: PetsRepository
): CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            petsRepository.fetchRemotePets()
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}