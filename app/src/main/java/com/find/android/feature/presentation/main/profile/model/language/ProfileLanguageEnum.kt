package com.find.android.feature.presentation.main.profile.model.language

sealed class ProfileLanguageEnum(
    val language: String,
    val region: String,
) {

    object Turkish : ProfileLanguageEnum("Turkish", "TR")
    object EnglishUK : ProfileLanguageEnum("English", "UK")
    object EnglishUSA : ProfileLanguageEnum("English", "USA")
    object Deutsch : ProfileLanguageEnum("Deutsch", "DE")
    object Espanol : ProfileLanguageEnum("Espanol", "ES")
    object Francais : ProfileLanguageEnum("Francais", "FR")
    object Italiano : ProfileLanguageEnum("Italiano", "IT")


    companion object {
        val Languages = listOf(Turkish, EnglishUK, EnglishUSA, Deutsch, Espanol, Francais, Italiano)
    }
}