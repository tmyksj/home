package app.component

import react.Props
import kotlin.js.Date

external interface DateStringProps : Props {

    var date: Date?

    var suffix: String?

}
