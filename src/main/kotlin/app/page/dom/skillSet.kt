package app.page.dom

import app.page.skillSet.SkillSet
import app.page.skillSet.SkillSetRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.skillSet(handler: RHandler<SkillSetRProps>): ReactElement {
    return child(SkillSet::class, handler)
}