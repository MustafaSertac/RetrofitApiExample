package com.mustafaozt.retrofitapiexample.model

data class UserResponseList(
    val dataList: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)