package com.lucifergotmad.githubusers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<GithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecycleList()
    }

    private val listUsers: ArrayList<GithubUser>
        @SuppressLint("Recycle")
        get() {
            val dataUserName = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataUserAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataUserLocation = resources.getStringArray(R.array.location)
            val dataUserRepository = resources.getStringArray(R.array.repository)
            val dataUserCompany = resources.getStringArray(R.array.company)
            val dataUserFollowers = resources.getStringArray(R.array.followers)
            val dataUserFollowing = resources.getStringArray(R.array.following)
            val dataUserTelephone = resources.getStringArray(R.array.followers)
            val dataUserStatus = resources.getStringArray(R.array.following)
            val listUser = ArrayList<GithubUser>()
            for (i in dataUserName.indices) {
                val user = GithubUser(
                    dataUserName[i],
                    dataName[i],
                    dataUserAvatar.getResourceId(i, -1),
                    dataUserLocation[i],
                    dataUserRepository[i],
                    dataUserCompany[i],
                    dataUserFollowers[i],
                    dataUserFollowing[i],
                    dataUserTelephone[i],
                    dataUserStatus[i]
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecycleList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listGithubUserAdapter = ListGithubUserAdapter(list)
        rvUsers.adapter = listGithubUserAdapter
    }
}