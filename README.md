# チェックワーク 〜クラスを理解しよう！〜

## 作成するアプリ
- EditTextに入力した文字列を保存できる．
- アプリを起動したとき，保存した文字列がTextViewに表示される．

![checkwork_class](https://user-images.githubusercontent.com/49048577/144717724-5c698e20-e04b-4821-865d-bae86dd10e6e.png)

## 手順
### Step1：EditTextに入力した値を保存しよう！
SharedPreferencesを使用して，EditTextに入力した値を保存してみよう！

#### Hint 1-1
"SharedPreferences Kotlin"で検索してみよう！

#### Hint 1-2
保存したい文字列をSharedPreferencesに渡すときはこのようなコードを書くよ．
```
editor.putString(値を取り出すときに必要な鍵（文字列）, 保存したい文字列)
```

### Step2：Userクラスを作成しよう！
Step1で文字列を保存できたけど，保存したいデータの数だけ同じコードを書くのは大変だよね．

Step2では，保存したいデータをまとめて管理できるようなUserクラスを作成していこう！

Userクラスに必要な値は以下の通りだよ．
- 名前（文字列）
- コース（文字列）
- 一言コメント（文字列）

**Userクラスを作成したら，以下のコードを追記してね！**
```
@Serializable // 追記
data class User()
```

#### Hint 2-1
"data class Kotlin"で検索してみよう！

#### Hint 2-2
データをまとめて管理するクラスを作成するときはこのようなコードを書くよ．
```
data class User()
```

#### Hint 2-3
Userクラスに必要な値はこのように用意していくよ．
```
data class User(
    val name: String,
)
```

### Step3：Userクラスをインスタンス化しよう！
EditTextに入力した文字列を引数に渡して，Userクラスをインスタンス化しよう！

#### Hint 3-1
"クラス　インスタンス化　Kotlin"で検索してみよう！

#### Hint 3-2
クラスをインスタンス化するときはこのようなコードを書くよ．
```
val user = User(引数1, 引数2, 引数3)
```

### Step4：EditTextに入力した値をまとめて保存しよう！
Step3で作成したUserクラスのインスタンスを保存してみよう！

このとき，Userクラスを文字列に変換する必要があるよ．

以下のコードを参考にしてみよう！
```
editor.putString(USER, Json.encodeToString(保存したいUserクラスのインスタンス))
```

### Step5：保存した値を表示しよう！
Step4で保存した値を表示してみよう！

このとき，文字列に変換したUserクラスのインスタンスをUser型に戻す必要があるよ．

以下のコードを参考にしてみよう！
```
// デフォルトのUserを作成
val defaultUser = User("名前", "コース", "チェックワーク最高")
// 保存したUserの文字列を取得
val userString = sharedPref.getString(USER, Json.encodeToString(defaultUser))
// Userの文字列をUser型に戻す．
val user = if (userString != null) Json.decodeFromString(userString) else defaultUser
```

これで変数userに保存した値が代入されたので，あとはそれらの値を表示するだけだ！
