package com.example.habilmahendri.dicodingfootballclub.ui.LastMatch

import com.example.habilmahendri.dicodingfootballclub.base.BaseView
import com.example.habilmahendri.dicodingfootballclub.model.repository.MatchRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LastPresenter(val mView: BaseView.View, val matchRepositoryImpl: MatchRepositoryImpl): BaseView.Presenter {

    val compositeDisposable = CompositeDisposable()



    override fun getFootbalMatchData() {
        compositeDisposable.add(matchRepositoryImpl.getFootballMatch("4328")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })
    }



}


