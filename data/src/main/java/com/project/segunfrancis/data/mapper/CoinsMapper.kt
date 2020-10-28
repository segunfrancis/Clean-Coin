package com.project.segunfrancis.data.mapper

import com.project.segunfrancis.data.model.CoinsData
import com.project.segunfrancis.domain.model.CoinsDomain
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class CoinsMapper @Inject constructor(): Mapper<CoinsDomain, CoinsData> {
    override fun mapToDomainLayer(type: CoinsDomain): CoinsData {
        return with(type) {
            CoinsData(id, symbol, name, description, iconUrl, price)
        }
    }

    override fun mapToDataLayer(type: CoinsData): CoinsDomain {
        return with(type) {
            CoinsDomain(id, symbol, name, description, iconUrl, price)
        }
    }
}