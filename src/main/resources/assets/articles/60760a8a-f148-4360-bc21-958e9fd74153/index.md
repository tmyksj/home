## refs

- [JetBrains/kotlin-wrappers](https://github.com/JetBrains/kotlin-wrappers)
- [JetBrains/kotlin-wrappers kotlin-react-legacy](https://github.com/JetBrains/kotlin-wrappers/tree/pre.303/kotlin-react-legacy#readme)
- [JetBrains/kotlin-wrappers kotlin-react-router-dom](https://github.com/JetBrains/kotlin-wrappers/tree/pre.303/kotlin-react-router-dom#readme)
- [React Router FAQs](https://reactrouter.com/docs/en/v6/faq)

## body

`pre.303` 時点での情報です。 `JetBrains/kotlin-wrappers` は頻繁に更新されているため、最新の情報を得るには実装を確認する必要があります（気づかないうちに API が deprecated
され、さらに削除されるほどです……）。

### `pre.258` → `pre.303` の変更点

気づいた範囲ですが、 `pre.258` → `pre.303` までに変更があった箇所です。

- React の builder が `RBuilder` から `ChildrenBuilder` に変更されています。それに伴い `RBuilder` が `kotlin-react-legacy`
  に移動されたり、共通部分が `kotlin-react-core` にまとめられたりするなど、大きく構造が変わっています。
- React Router が `v5` → `v6` に更新されています。
- `kotlinext.js.jso` が `kotlinx.js.jso` に移され、 `kotlinext.js.jsObject` は削除されています。

### function component を作成する

function component は、 `FC` （ `kotlin-react` ）ないし `fc` （ `kotlin-react-legacy` ）で作成します。ここでは `kotlin-react-legacy`
を用いています（ `kotlin-styled` が `RBuilder` を使用しているためです）。

```kotlin
// Props は、 Props を継承した interface で定義します。
external interface MyComponentProps : Props {
    var initialValue: Int?
}
```

```kotlin
// FC<in P : Props> は kotlin-react-core に定義されています。
// fc は kotlin-react-legacy で定義されています。
val MyComponent: FC<MyComponentProps> = fc { props ->
    // delegate することで、 count に代入することが setCount と同じ意味になります。
    // useState は StateInstance<T> を返し、 StateInstance<T> に inline operator が定義されているので実現できています。
    var count by useState(props.initialValue ?: 0)

    // useEffect の dependencies に空の配列を渡す useEffectOnce も定義されています。
    useEffect {
        // ここに useEffect の処理を記述できます。

        cleanup {
            // ここに cleanup 処理を記述できます。
            // 複数回 cleanup を呼び出すこともできます。
        }
    }

    div {
        // ...
    }
}
```

### React Router を利用する

React Router を利用する例です。 React Router が `v6` になったタイミングで hooks に移行しているため、 `v5` のときと実装が若干異なります。

```kotlin
BrowserRouter {
    Routes {
        Route {
            attrs.element = createElement(Home)
            attrs.path = "/"
        }
    }
}
```

React Router にある `navigate` 、 `params` などは `useNavigate` 、 `useParams` などで得られるため、 component は function component
で定義するのが得策と思われます。

```kotlin
val MyComponent: FC<MyComponentProps> = fc {
    val params: Params = useParams()

    // ...
}
```
