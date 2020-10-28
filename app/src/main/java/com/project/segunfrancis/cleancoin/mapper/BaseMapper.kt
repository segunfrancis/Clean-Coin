package com.project.segunfrancis.cleancoin.mapper

import com.project.segunfrancis.cleancoin.ui.coinlist.model.Base
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Data
import com.project.segunfrancis.domain.model.BaseDomain
import com.project.segunfrancis.domain.model.CoinsDomain
import com.project.segunfrancis.domain.model.DataDomain
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */
class BaseMapper @Inject constructor() : Mapper<BaseDomain, Base> {
    override fun mapToDomainLayer(type: Base): BaseDomain {
        return with(type) {
            BaseDomain(status, DataDomain(data.coins.map {
                with(it) {
                    CoinsDomain(id, symbol, name, description, iconUrl, price)
                }
            }))
        }
    }

    override fun mapToAppLayer(type: BaseDomain): Base {
        return with(type) {
            Base(status, Data(data.coins.map {
                with(it) {
                    Coin(id, symbol, name, description, iconUrl, price)
                }
            }))
        }
    }
}