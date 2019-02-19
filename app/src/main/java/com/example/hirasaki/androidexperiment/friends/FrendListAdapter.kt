package com.example.hirasaki.androidexperiment.friends

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.hirasaki.androidexperiment.R
import java.util.*
import com.example.hirasaki.androidexperiment.Models.FriendModel

// RecyclerView用のサンプルアダプタ
class FriendListAdapter(
        // private val list: List<FriendModel>,
        // private val listener: ListListener) : RecyclerView.Adapter<FriendListViewHolder>() {
        context: Context?,
        private val list: List<FriendModel>,
        private val listener: ListListener)
        : RecyclerView.Adapter<FriendListViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendListViewHolder {
        // Log.d("Adapter", "onCreateViewHolder")
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.friends_friendlist_row, parent, false)
        return FriendListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: FriendListViewHolder, position: Int) {
        // Log.d("Adapter", "onBindViewHolder")
        holder.friend_name.text = list[position].name
        // holder.detailView.text = list[position].detail
        holder.itemView.setOnClickListener {
            // listener.onClickRow(it, list[position])
        }
    }

    override fun getItemCount(): Int {
        // Log.d("Adapter", "getItemCount")
        return list.size
    }


    interface ListListener {
        fun onClickRow(tappedView: View, rowModel: FriendModel)
    }

    /*
        // レイアウトからビューを生成するInflater
        private val inflater = LayoutInflater.from(context)

        // リサイクラービューで表示するタイムゾーンのリスト
        private val timeZones = TimeZone.getAvailableIDs().map { id -> TimeZone.getTimeZone(id) }

        // 表示するべき値をViewにセットする
        override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
                // 位置に応じたタイムゾーンを得る
                val timeZone = timeZones[position]
                // 表示内容を更新する
                holder.timeZone.text = timeZone.id
        }

        // 新しくViewを作る時に呼ばれる
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
                // Viewを生成する
                val view = inflater.inflate(R.layout.friends_friendlist_row, parent, false)

                // ViewHolderを作る
                val viewHolder = SampleViewHolder(view)

                // viewをタップしたときの処理
                view.setOnClickListener {
                        // アダプター上の位置を得る
                        val position = viewHolder.adapterPosition
                        // 位置をもとに、タイムゾーンを得る
                        val timeZone = timeZones[position]
                        // コールバックを呼び出す
                        onTimeZoneClicked(timeZone)
                }

                return viewHolder
        }

        override fun getItemCount(): Int = timeZones.size

        // Viewへの参照をもっておくViewHolder
        class SampleViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val timeZone = view.findViewById<TextView>(R.id.friendlist_row_friend_name)
        }

   */

    /*
class FriendsListAdapter(context: Context,
    private val onTimeZoneClicked : (TimeZone) -> Unit)
    : RecyclerView.Adapter<FriendListViewHolder>() {
        */
}
