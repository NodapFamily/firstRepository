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
                id            = ${id} : String
                accountId     = ${accountId} : String
                puuid         = ${puuid} : String
                name          = ${name} : String
                profileIconId = ${profileIconId} : Long
                revisionDate  = ${revisionDate} : Long
                summonerLevel = ${summonerLevel} : Int
        """.trimIndent()
    }
}
