package app.component.skillSet

import app.dto.SkillDto
import react.RState

external interface SkillSetRState : RState {

    var skillDtoList: List<SkillDto>?

    var height: Double?

    var width: Double?

}
