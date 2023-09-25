package com.packt.chaptereight.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class PetsRepositoryImpl(
    private  val catsAPI: CatsAPI,
    private val dispatcher: CoroutineDispatcher,
    private val catDao: CatDao
): PetsRepository {
    override suspend fun getPets(): Flow<List<Cat>> {
        return withContext(dispatcher) {
           catDao.getCats()
               .map { petsCached ->
                   petsCached.map { catEntity ->
                       Cat(
                           id = catEntity.id,
                           owner = catEntity.owner,
                           tags = catEntity.tags,
                           createdAt = catEntity.createdAt,
                           updatedAt = catEntity.updatedAt,
                           isFavorite = catEntity.isFavorite
                       )
                   }
               }
        }
    }

    override suspend fun fetchRemotePets() {
        withContext(dispatcher) {
            val response = catsAPI.fetchCats("cute")
            if (response.isSuccessful) {
                response.body()!!.map {
                    catDao.insert(CatEntity(
                        id = it.id,
                        owner = it.owner,
                        tags = it.tags,
                        createdAt = it.createdAt,
                        updatedAt = it.updatedAt,
                        isFavorite = it.isFavorite
                    ))
                }
            }
        }
    }

    override suspend fun updatePet(cat: Cat) {
        withContext(dispatcher) {
            catDao.update(CatEntity(
                id = cat.id,
                owner = cat.owner,
                tags = cat.tags,
                createdAt = cat.createdAt,
                updatedAt = cat.updatedAt,
                isFavorite = cat.isFavorite
            ))
        }
    }

    override suspend fun getFavoritePets(): Flow<List<Cat>> {
        return withContext(dispatcher) {
            catDao.getFavoriteCats()
                .map { petsCached ->
                    petsCached.map { catEntity ->
                        Cat(
                            id = catEntity.id,
                            owner = catEntity.owner,
                            tags = catEntity.tags,
                            createdAt = catEntity.createdAt,
                            updatedAt = catEntity.updatedAt,
                            isFavorite = catEntity.isFavorite
                        )
                    }
                }
        }
    }
}