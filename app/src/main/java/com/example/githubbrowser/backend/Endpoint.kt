package com.example.githubbrowser.backend

import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("users/{user}/repos")
    fun getRepositoriesForUser(@Path("user")username: String)
}