package com.example.hirasaki.androidexperiment.pages.member.friends.utils

import com.example.hirasaki.androidexperiment.pages.member.friends.data.FriendModel;
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
        fun showFriendList(response: List<FriendModel>);
        fun showCreateResult(response: FriendModel);

        fun showError(message: String);
    }

    /**
     * MVPのPresenterが実装するインターフェース
     * Viewをクリックした時などにViewがPresenterに教えるために利用する
     */
    interface UserActions {
        fun fetchFriendList(): Job;
    }
}
