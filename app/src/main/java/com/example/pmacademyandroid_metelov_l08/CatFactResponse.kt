package com.example.pmacademyandroid_metelov_l08

class CatFactResponse : ArrayList<CatFactResponseItem>() {
    override fun toString(): String {
        return this.joinToString(prefix = "", postfix = "", separator = "")
    }
}