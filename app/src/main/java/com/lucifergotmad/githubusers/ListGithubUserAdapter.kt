package com.lucifergotmad.githubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ListGithubUserAdapter(private val listGithubUser: ArrayList<GithubUser>) :
    RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, avatar) = listGithubUser[position]
        holder.userAvatar.setImageResource(avatar)
        holder.userName.text = username
        holder.fullName.text = name
    }

    override fun getItemCount(): Int = listGithubUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userAvatar: CircleImageView = itemView.findViewById(R.id.user_avatar)
        val userName: TextView = itemView.findViewById(R.id.tv_user_name)
        val fullName: TextView = itemView.findViewById(R.id.tv_full_name)
    }

}