package com.example.nodap.model

class ResMatchLists {
    var matches : List<ResMatch>? =null
    var startIndex : Long? =null
    var endIndex : Long? =null
    var totalGames : Long? =null


    override fun toString(): String {
        return """
                matches       = ${matches.toString()}
                startIndex    = ${startIndex}
                endIndex      = ${endIndex}
                totalGames    = ${totalGames}
        """.trimIndent()
    }
}