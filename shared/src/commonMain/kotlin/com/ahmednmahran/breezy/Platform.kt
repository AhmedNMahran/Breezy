package com.ahmednmahran.breezy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform