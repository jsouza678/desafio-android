package com.jsouza.repopullrequests.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jsouza.repopullrequests.data.remote.response.OwnerResponse

class PullsTypeConverter {

    companion object {
        private var gson = Gson()

        @TypeConverter
        fun fromOwner(
            owner: OwnerResponse?
        ): String? {
            if (owner == null) { return null }
            gson = Gson()
            val type = object : TypeToken<OwnerResponse>() {
            }.type

            return gson.toJson(owner, type)
        }

        @TypeConverter
        fun toOwner(
            owner: String?
        ): OwnerResponse? {
            if (owner == null) { return null }
            gson = Gson()
            val type = object : TypeToken<OwnerResponse>() {
            }.type

            return gson.fromJson(owner, type)
        }
    }
}
