package grails301.domain.save.npe

import grails.transaction.Transactional

@Transactional
class TestController {

    def index() {
        def d = new Book()
        d.save(flush: true)
        render "OK: ${d.class}: ${d.errors}"
    }

    def hoge() {
        render text: [
            new Zombie(),
            new Book(),
            new Author(),
        ].collect { d ->
            d.save(flush: true)
            "OK: ${d.class}: ${d.errors}"
        }.join("<br>")
    }
}
