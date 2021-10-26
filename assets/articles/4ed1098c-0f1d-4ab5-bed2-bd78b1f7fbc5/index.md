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

### カスタムタグを利用する

HTML の要素であれば、定義されたタグを利用することができます。一方、例えば SVG の要素など、宣言されていないタグを利用したいケースもあります。そのときは、タグを生成するメソッドを定義することで実現できます。

```kotlin
fun RBuilder.tag(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit) {
    tag(block) {
        HTMLTag(
            tagName = tagName,
            consumer = it,
            initialAttributes = mapOf(),
            namespace = null,
            inlineTag = true,
            emptyTag = false,
        )
    }
}
```

定義した `RBuilder.tag` は、次のように利用します。

```kotlin
tag("path") {
    attrs["d"] = "M 1 1 L 2 1 L 2 2 L 1 2"
}
```

### React router を利用する

次は、 React router を利用する例です。

```kotlin
BrowserRouter {
    Switch {
        Route {
            attrs.component = Home
            attrs.exact = true
            attrs.path = arrayOf("/")
        }
    }
}
```

React router にある `history` 、 `location` などは `RouteComponentProps` で定義されています。 `Route` で指定される component であれば、 `.react`
で得られる `ComponentClass<P>` で動作します。

```kotlin
external interface HomeProps : Props, RouteComponentProps
```

```kotlin
val Home: ComponentClass<HomeProps> = HomeRComponent::class.react
```

一方、`Route` で指定しない場合は `withRouter` を使用して `ComponentClass<P>` を得ます。

```kotlin
val Home: ComponentClass<HomeProps> = withRouter(HomeRComponent::class)
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
