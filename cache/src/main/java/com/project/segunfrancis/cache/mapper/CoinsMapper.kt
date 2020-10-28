package com.project.segunfrancis.cache.mapper

import com.project.segunfrancis.cache.model.CoinsCache
import com.project.segunfrancis.data.model.CoinsData
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class CoinsMapper @Inject constructor() : Mapper<CoinsCache, CoinsData> {
    override fun mapToDataLayer(type: CoinsCache): CoinsData {
        return with(type) {
            CoinsData(id, symbol, name, description, iconUrl, price)
        }
    }

    override fun mapToCacheLayer(type: CoinsData): CoinsCache {
        return with(type) {
            CoinsCache(id, symbol, name, description, iconUrl, price)
        }
    }
}