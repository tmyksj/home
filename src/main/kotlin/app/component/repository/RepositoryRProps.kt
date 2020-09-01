package app.component.repository

import react.RProps

external interface RepositoryRProps : RProps {

    var description: String

    var hrefDeploy: String?

    var hrefGitHub: String

    var repositoryName: String

    var srcImg: String

}
