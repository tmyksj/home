package app.component.dateString

import react.RBuilder
import react.RComponent
import kotlin.js.Date

class DateStringRComponent : RComponent<DateStringProps, DateStringState>() {

    override fun RBuilder.render() {
        val date: Date = props.date ?: return
        val suffix: String? = props.suffix

        val fullYearString: String = date.getFullYear().toString()
        val monthString: String = (date.getMonth() + 1).toString().padStart(2, '0')
        val dateString: String = date.getDate().toString().padStart(2, '0')

        if (suffix == null) {
            +"${fullYearString}/${monthString}/${dateString}"
        } else {
            +"${fullYearString}/${monthString}/${dateString} $suffix"
        }
    }

}
