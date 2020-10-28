package com.project.segunfrancis.data.mapper

import com.project.segunfrancis.data.model.BaseData
import com.project.segunfrancis.domain.model.BaseDomain
import com.project.segunfrancis.domain.model.CoinsDomain
import com.project.segunfrancis.domain.model.DataDomain
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */
class BaseMapper @Inject constructor() : Mapper<BaseData, BaseDomain> {
    override fun mapToDomainLayer(type: BaseData): BaseDomain {
        return with(type) {
            BaseDomain(status, DataDomain(data.coins.map { coins ->
                with(coins) {
                    CoinsDomain(id, symbol, name, description, iconUrl, price)
                }
            }))
        }
    }
}