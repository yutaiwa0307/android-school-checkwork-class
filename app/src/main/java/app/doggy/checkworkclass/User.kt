package app.doggy.checkworkclass

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val course: String,
    val comment: String,
)