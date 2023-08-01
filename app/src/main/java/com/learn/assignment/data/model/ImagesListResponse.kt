package com.learn.assignment.data.model

import java.io.Serializable

data class ImagesListResponse(
    val hits: MutableList<Hit?>?,
    val total: Int?,
    val totalHits: Int?
):Serializable {
    data class Hit(
        val collections: Int? = -1,
        val comments: Int? = -1,
        val downloads: Int? = -1,
        val id: Int?= -1,
        val imageHeight: Int?= -1,
        val imageSize: Int?= -1,
        val imageWidth: Int?= -1,
        val largeImageURL: String? = "",
        val likes: Int?= -1,
        val pageURL: String? = "",
        val previewHeight: Int?= -1,
        val previewURL: String? = "",
        val previewWidth: Int?= -1,
        val tags: String? = "",
        val type: String? = "",
        val user: String? = "",
        val userImageURL: String? = "",
        val user_id: Int?= -1,
        val views: Int?= -1,
        val webformatHeight: Int?= -1,
        val webformatURL: String? = "",
        val webformatWidth: Int?= -1
    ):Serializable
}