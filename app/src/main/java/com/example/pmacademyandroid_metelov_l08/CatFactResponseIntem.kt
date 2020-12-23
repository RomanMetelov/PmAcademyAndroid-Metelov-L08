package com.example.pmacademyandroid_metelov_l08

import com.google.gson.annotations.SerializedName

data class CatFactResponseItem(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("deleted")
    val deleted: Boolean,
    @SerializedName("source")
    val source: String,
    @SerializedName("status")
    val status: Status,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("used")
    val used: Boolean,
    @SerializedName("user")
    val user: String
) {
    override fun toString(): String {
        return "\n" +
                "Status: " +
                status +
                "\n" +
                "Text: " +
                text +
                "\n" +
                "Updated by User \"$user\" at: $updatedAt" +
                "\n"
    }
}

data class Status(
    @SerializedName("sentCount")
    val sentCount: Int,
    @SerializedName("verified")
    val verified: Boolean,
    @SerializedName("feedback")
    val feedback: String
) {
    override fun toString(): String {
        if (verified) return "verified"
        return "non-verified"
    }
}