package com.example.nodap.model

import com.google.gson.annotations.SerializedName

class ResSummonerData {
    var id :String? =null
    var accountId :String? =null
    var puuid :String? =null
    var name :String? =null
    var profileIconId :Long? =null
    var revisionDate :Long? =null
    var summonerLevel :Int? =null

    override fun toString(): String {
        return """
                id            = ${id}
                accountId     = ${accountId}
                puuid         = ${puuid}
                name          = ${name}
                profileIconId = ${profileIconId}
                revisionDate  = ${revisionDate}
                summonerLevel = ${summonerLevel}
        """.trimIndent()
    }
}
