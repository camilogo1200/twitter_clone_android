package com.example.mptwitterclone.common

class DateUtils {

    companion object {
        fun getTweetTimeFormat(time: Long): String {
            val tweetDiff = System.nanoTime() - time
            val tempSec: Long = tweetDiff / (1000 * 1000 * 1000)
            val sec = tempSec % 60
            val min = tempSec / 60 % 60
            val hour = tempSec / (60 * 60) % 24
            val day = tempSec / (24 * 60 * 60) % 24

            return String.format("%dd %dh %dm %ds", day, hour, min, sec)
        }
    }
}
