package com.example.nodap.model

class ResMatch {
    var platformId   : String? = null      //": "KR",
    var gameId       : Long? = null      //": 4646741345,
    var champion     : Int? = null      //": 41,
    var queue        : Int? = null      //": 450,
    var season       : Int? = null      //": 13,
    var timestamp    : Long? = null      //": 1600097262694,
    var role         : String? = null      //": "DUO_SUPPORT",
    var lane         : String? = null      //": "NONE",


    override fun toString(): String {
        return """
                  platformId : $platformId 
                  gameId     : $gameId 
                  champion   : $champion 
                  queue      : $queue 
                  season     : $season 
                  timestamp  : $timestamp 
                  role       : $role 
                  lane       : $lane 
        """.trimIndent()
    }
}
