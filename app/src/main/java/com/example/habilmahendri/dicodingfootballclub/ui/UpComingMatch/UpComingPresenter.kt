package com.example.habilmahendri.dicodingfootballclub.ui.UpComingMatch

import com.example.habilmahendri.dicodingfootballclub.model.repository.MatchRepositoryImpl
import com.example.habilmahendri.dicodingfootballclub.base.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class UpComingPresenter(val mView: BaseView.View, val matchRepositoryImpl: MatchRepositoryImpl) : BaseView.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getFootbalMatchData() {

        compositeDisposable.add(matchRepositoryImpl.getUpcomingMatch("4328")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayFootballMatch(it.events)
                    mView.hideLoading()
                })

    }

}