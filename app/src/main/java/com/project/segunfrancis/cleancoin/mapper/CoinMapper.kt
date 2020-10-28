package com.project.segunfrancis.cleancoin.mapper

import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import com.project.segunfrancis.domain.model.CoinsDomain
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class CoinMapper @Inject constructor() : Mapper<CoinsDomain, Coin> {
    override fun mapToDomainLayer(type: Coin): CoinsDomain {
        return with(type) {
            CoinsDomain(id, symbol, name, description, iconUrl, price)
        }
    }

    override fun mapToAppLayer(type: CoinsDomain): Coin {
        return with(type) {
            Coin(id, symbol, name, description, iconUrl, price)
        }
    }
}