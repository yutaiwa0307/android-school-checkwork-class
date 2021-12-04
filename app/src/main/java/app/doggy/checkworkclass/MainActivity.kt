package app.doggy.checkworkclass

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.checkworkclass.databinding.ActivityMainBinding
import kotlinx.serialization.decodeFromString
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
//        binding.nameText.text = sharedPref.getString(NAME, "名前")
//        binding.courseText.text = sharedPref.getString(COURSE, "コース")
//        binding.commentText.text = sharedPref.getString(COMMENT, "チェックワーク最高！")
        val defaultUser = User("名前", "コース", "チェックワーク最高")
        val userString = sharedPref.getString(USER, Json.encodeToString(defaultUser)) as String
        val user = Json.decodeFromString<User>(userString)
        binding.nameText.text = user.name
        binding.courseText.text = user.course
        binding.commentText.text = user.comment

        // save_buttonを押したときの処理
        binding.saveButton.setOnClickListener {
            // SharedPreferences.Editorを取得する．
            val editor = sharedPref.edit()

            // Step1：EditTextに入力した値をEditorに渡す．
//            editor.putString(NAME, binding.nameEditText.text.toString())
//            editor.putString(COURSE, binding.courseEditText.text.toString())
//            editor.putString(COMMENT, binding.commentEditText.text.toString())
            val user = User(
                binding.nameEditText.text.toString(),
                binding.courseEditText.text.toString(),
                binding.commentEditText.text.toString(),
            )
            editor.putString(USER, Json.encodeToString(user))

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