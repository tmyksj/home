package app.page

import app.component.NotFound
import kotlinx.browser.document
import react.FC
import react.fc
import react.useEffectOnce

val NotFound: FC<NotFoundProps> = fc {
    useEffectOnce {
        document.title = "Not Found"
    }

    NotFound { }
}
