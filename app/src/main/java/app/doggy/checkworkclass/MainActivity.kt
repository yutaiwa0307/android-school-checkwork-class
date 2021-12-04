package app.doggy.checkworkclass

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.doggy.checkworkclass.databinding.ActivityMainBinding

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
            // EditTextに入力した内容を保存する．
            val editor = sharedPref.edit()
            editor.putString(NAME, binding.nameEditText.text.toString())
            editor.putString(COURSE, binding.courseEditText.text.toString())
            editor.putString(COMMENT, binding.commentEditText.text.toString())
            editor.apply()
        }
    }

    companion object {
        private const val NAME = "name"
        private const val COURSE = "course"
        private const val COMMENT = "comment"
    }
}