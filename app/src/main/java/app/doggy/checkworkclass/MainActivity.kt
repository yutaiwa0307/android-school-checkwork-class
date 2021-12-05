package app.doggy.checkworkclass

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.checkworkclass.databinding.ActivityMainBinding
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    // バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // SharedPreferencesのインスタンスを取得
        val sharedPref: SharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        // 保存した内容を表示する．
        binding.nameText.text = sharedPref.getString(NAME, "名前")
        binding.courseText.text = sharedPref.getString(COURSE, "コース")
        binding.commentText.text = sharedPref.getString(COMMENT, "チェックワーク最高！")

        // save_buttonを押したときの処理
        binding.saveButton.setOnClickListener {
            // SharedPreferences.Editorを取得する．
            val editor = sharedPref.edit()

            // Step1：EditTextに入力した値をEditorに渡す．
            editor.putString(NAME, binding.nameEditText.text.toString())
            editor.putString(NAME, binding.courseEditText.text.toString())
            editor.putString(NAME, binding.commentEditText.text.toString())

            //Userクラスの作成
            data class User(val name:String, val course:String, val comment:String)
            //Userクラスをインスタンス化
            val user=User(NAME, COURSE, COMMENT)
            //Userクラスのインスタンスを保存
            editor.putString(USER, Json.encodeToString(user))
            // デフォルトのUserを作成
            val defaultUser = User("名前", "コース", "チェックワーク最高")
// 保存したUserの文字列を取得
            val userString = sharedPref.getString(USER, Json.encodeToString(defaultUser))
// Userの文字列をUser型に戻す．
            val user = if (userString != null) Json.decodeFromString(userString) else defaultUser


            // 渡した値を保存する．
            editor.apply()
        }
    }

    companion object {
        // データを保存するときに用いるKey
        private const val NAME = "name"
        private const val COURSE = "course"
        private const val COMMENT = "comment"
        private const val USER = "user"
    }
}