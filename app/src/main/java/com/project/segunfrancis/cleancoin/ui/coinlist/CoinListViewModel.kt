package com.project.segunfrancis.cleancoin.ui.coinlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.segunfrancis.cleancoin.mapper.CoinMapper
import com.project.segunfrancis.cleancoin.ui.coinlist.model.Coin
import com.project.segunfrancis.cleancoin.utils.Result
import com.project.segunfrancis.cleancoin.utils.asLiveData
import com.project.segunfrancis.domain.usecase.AddCoinsUseCase
import com.project.segunfrancis.domain.usecase.GetCoinsCacheUseCase
import com.project.segunfrancis.domain.usecase.GetCoinsRemoteUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * Created by SegunFrancis
 */

class CoinListViewModel @ViewModelInject constructor(
    private val getCoinsCacheUseCase: GetCoinsCacheUseCase,
    private val getCoinsRemoteUseCase: GetCoinsRemoteUseCase,
    private val addCoinsUseCase: AddCoinsUseCase,
    private val coinMapper: CoinMapper,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _coinResponse = MutableLiveData<Result<List<Coin>>>()
    val coinResponse = _coinResponse.asLiveData()

    init {
        getCoinsCache()
    }

    fun getCoinsRemote() {
        viewModelScope.launch(dispatcher) {
            getCoinsRemoteUseCase.execute()
                .onStart {
                    _coinResponse.postValue(Result.Loading)
                }
                .catch {
                    _coinResponse.postValue(Result.Error(it))
                }
                .collect { baseDomain ->
                    addCoins(baseDomain.data.coins.map {
                        coinMapper.mapToAppLayer(it)
                    })
                }
        }
    }

    private fun getCoinsCache() {
        viewModelScope.launch(dispatcher) {
            getCoinsCacheUseCase.execute()
                .collect { coins ->
                    _coinResponse.postValue(Result.Success(coins.map {
                        coinMapper.mapToAppLayer(it)
                    }))
                }
        }
    }

    private fun addCoins(coins: List<Coin>) {
        viewModelScope.launch(dispatcher) {
            addCoinsUseCase.execute(coins.map {
                coinMapper.mapToDomainLayer(it)
            })
                .collect { }
        }
    }
}