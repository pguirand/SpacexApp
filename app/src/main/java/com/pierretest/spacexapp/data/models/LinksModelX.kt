package com.pierretest.spacexapp.data.models


import com.google.gson.annotations.SerializedName

data class LinksModelX(
    @SerializedName("article_link")
    val articleLink: String? = "",
    @SerializedName("flickr_images")
    val flickrImages: List<String?>? = listOf(),
    @SerializedName("mission_patch")
    val missionPatch: String? = "",
    @SerializedName("mission_patch_small")
    val missionPatchSmall: String? = "",
    @SerializedName("presskit")
    val presskit: String? = "",
    @SerializedName("reddit_campaign")
    val redditCampaign: String? = "",
    @SerializedName("reddit_launch")
    val redditLaunch: String? = "",
    @SerializedName("reddit_media")
    val redditMedia: String? = "",
    @SerializedName("reddit_recovery")
    val redditRecovery: Any? = Any(),
    @SerializedName("video_link")
    val videoLink: String? = "",
    @SerializedName("wikipedia")
    val wikipedia: String? = "",
    @SerializedName("youtube_id")
    val youtubeId: String? = ""
)