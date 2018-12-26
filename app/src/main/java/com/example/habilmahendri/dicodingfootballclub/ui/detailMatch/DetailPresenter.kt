package com.example.habilmahendri.dicodingfootballclub.ui.detailMatch

import com.example.habilmahendri.dicodingfootballclub.base.BaseView
import com.example.habilmahendri.dicodingfootballclub.model.repository.MatchRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailPresenter(val mView: DetailContract.View, val matchRepositoryImpl: MatchRepositoryImpl) : DetailContract.Presenter {


    val compositeDisposable = CompositeDisposable()


    override fun getFootbalMatchData(id: String) {
        compositeDisposable.add(matchRepositoryImpl.getDetailMatch(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayFootballMatch(it.events[0])
                })
    }


    override fun getTeamBadgeHome(id: String) {
        compositeDisposable.add(matchRepositoryImpl.getTeamAway(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayBadgeTeamAway(it.teams[0])

                })
    }

    override fun getTeamBadgeAway(id: String) {
        compositeDisposable.add(matchRepositoryImpl.getTeamAway(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    mView.displayBadgeTeamHome(it.teams[0])
                })
    }


}