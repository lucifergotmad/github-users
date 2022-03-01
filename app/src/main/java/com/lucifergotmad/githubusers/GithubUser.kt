package com.lucifergotmad.githubusers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val username: String,
    val name: String,
    val avatar: Int,
    val location: String,
    val repository: String,
    val company: String,
    val followers: String,
    val following: String,
    val telephone: String,
    val status: String
) : Parcelable
