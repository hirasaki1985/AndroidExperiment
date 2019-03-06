package com.example.hirasaki.androidexperiment.friends.utils

import com.example.hirasaki.androidexperiment.friends.data.FriendModel;
import kotlinx.coroutines.Job

/**
 * それぞれの役割が持っているContract(契約)を定義しておくインターフェース
 */
public interface FriendContract {

    /**
     * MVPのViewが実装するインターフェース
     * PresenterがViewを操作する時に利用する
     */
    interface View {
        fun getFullRepositoryName(): String;

        fun showFriendList(response: List<FriendModel>);

        fun startBrowser(url: String);

        fun showError(message: String);
    }

    /**
     * MVPのPresenterが実装するインターフェース
     * Viewをクリックした時などにViewがPresenterに教えるために利用する
     */
    interface UserActions {
        fun fetchFriendList(): Job;

        fun prepare();
    }
}
