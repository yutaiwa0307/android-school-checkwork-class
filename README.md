# チェックワーク 〜クラスを理解しよう！〜

## 作成するアプリ
- EditTextに入力した文字列を保存できる．
- アプリを起動したとき，保存した文字列がTextViewに表示される．



## 問題
### Step1：EditTextに入力した値を保存しよう！
SharedPreferencesを使用して，EditTextに入力した値を保存してみよう！

#### Hint 1-1
Mozerのデータ保存（ローカル）を参考にしよう．

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
Mozerのデータベース（Realm）を参考にしよう．

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

### Step3：EditTextに入力した値をまとめて保存しよう！
