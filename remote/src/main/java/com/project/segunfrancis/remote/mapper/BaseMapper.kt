package com.project.segunfrancis.remote.mapper

import com.project.segunfrancis.data.model.BaseData
import com.project.segunfrancis.data.model.CoinsData
import com.project.segunfrancis.data.model.Data
import com.project.segunfrancis.remote.model.BaseResponse
import javax.inject.Inject

/**
 * Created by SegunFrancis
 */

class BaseMapper @Inject constructor() : Mapper<BaseResponse, BaseData> {
    override fun mapToDataLayer(type: BaseResponse): BaseData {
        return with(type) {
            BaseData(status, Data(data.coins.map {
                with(it) {
                    CoinsData(id, symbol, name, description, iconUrl, price)
                }
            }))
        }
    }
}