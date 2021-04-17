package com.ltts.examassessment

import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class MainActivity3(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val database="Exam"
    private val username="Username"
    private val password="Password"
    private val email="Email"
    private val phone="Phone Number"
    private val CREATE_TEST_TABLE = ("CREATE TABLE " +   "("
            + username + " TEXT," + password + " TEXT,"
            + email + " TEXT," + phone+ " INTEGER" + ")")
    private val DROP_TABLE_TEST = "DROP TABLE IF EXISTS ${database}table"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TEST_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE_TEST)
        onCreate(db)
    }

    fun getAllUser(): {
        val columns = arrayOf(username,password,email,phone)
        val sortOrder = "$username ASC"
        val userList = arrayListOf<Any>()
        val db = this.readableDatabase
        val cursor = db.query(TABLE_USER,columns,null, null, null, null, sortOrder)
        if (cursor.moveToFirst()) {
            do {
                val user =username (username = cursor.getString(cursor.getColumnIndex(username)),
                    password = cursor.getString(cursor.getColumnIndex(password)),
                    email = cursor.getString(cursor.getColumnIndex(email)),
                    mobile = cursor.getString(cursor.getColumnIndex(phone)).toInt())
                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }
    private fun test(username: String?, password: String?, email: String?, mobile: Int): Any {
    }
    fun addUser() {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(username, username)
        values.put(password, password)
        values.put(email, email)
        values.put(phone,phone)

        db.insert(TABLE_USER, null, values)
        db.close()
    }
    fun updateUser() {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(username,username)
        values.put(password, password)
        values.put(email,email)
        values.put(phone,phone)
        db.update(TABLE_USER, values, "$phone = ?",
            arrayOf(username.toString()))
        db.close()
    }
    fun checkUser(username: String, password: String): Boolean {
        val columns = arrayOf(username)
        val db = this.readableDatabase
        val selection = "$username = ? AND $password= ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null)
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        if (cursorCount > 0)
            return true
        return false
    }
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Exam.db"
        private const val TABLE_USER = "test"
    }
}