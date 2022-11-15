package com.assignment.localDataBase

import android.content.Context

object UserData {

    lateinit var context: Context

    fun setup(context: Context) {
        this.context = context
    }

    fun isLogin(): Boolean {
        return !getToken().isNullOrEmpty()
    }

    fun getToken(): String? {
       return SharedPreferencesTool.getString(context, SharedPreferencesKeys.PREF_USER_TOKEN.name)
    }

    fun setToken(token: String) {
        SharedPreferencesTool.setString(context, SharedPreferencesKeys.PREF_USER_TOKEN.name, token)
    }

    /*fun setLanguageID(context: Context, languageId:Int) {
        setChooseLanguage(context, languageId)
    }

    fun getLanguageID(context: Context): Int {
        return if (getChooseLanguage(context) > 0) getChooseLanguage(context) else getDeviceLanguage()
    }*/

    fun logout(context: Context) {
        SharedPreferencesTool.clearAllData(context)
    }

}