## refs

- [Building Web Applications with React and Kotlin/JS](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)
- [JetBrains/kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers)

## body

`pre.258` 時点での情報です。 `JetBrains/kotlin-wrappers` は頻繁に更新されているため、最新の情報を得るには実装を確認する必要があります。

### component を作成する

React component は、 `RComponent` を継承したクラスを作成します。

```kotlin
external interface MyComponentProps : Props 
```

```kotlin
external interface MyComponentState : State 
```

```kotlin
class MyComponentRComponent : RComponent<MyComponentProps, MyComponentState>() {
    override fun RBuilder.render() {
    }
}
```

```kotlin
val MyComponent: ComponentClass<MyComponentProps> = MyComponentRComponent::class.react
```

### @media の定義

メディアクエリは `media` を使用することで実現できます。

```kotlin
media("(max-width: 40rem)") {
}
```

ただ、この文字列をいたるところに書くとメンテナンス面で問題があります。このとき、メディアクエリを文字列として管理する方法もありますが、 `(CssBuilder, RuleSet) -> Rule`
を定義する方法もあります。例えば、 `Layout` に `mediaMedium` と定義すると、 `css` の中で `Layout.mediaMedium(this) { }` と使用できます。

```kotlin
object Layout {
    val mediaMedium: (CssBuilder, RuleSet) -> Rule = { cssBuilder, block ->
        cssBuilder.media("(max-width: 40rem)", block)
    }
}
```

```kotlin
css {
    Layout.mediaMedium(this) {
        flexDirection = FlexDirection.column
    }
}
```
