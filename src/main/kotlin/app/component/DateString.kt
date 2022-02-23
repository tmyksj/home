package app.component

import react.FC
import react.fc
import kotlin.js.Date

val DateString: FC<DateStringProps> = fc { props ->
    val date: Date = props.date ?: return@fc
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
