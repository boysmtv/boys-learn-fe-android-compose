package com.based.kotlin.learncompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val view: Int,
    @DrawableRes val images: Int
)