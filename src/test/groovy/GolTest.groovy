import spock.lang.Specification

class GolTest extends Specification {

    void 'should return a new iteration' () {
        given:
        def gol = new Gol()

        def seed = new Grid()

        when:
        def next = gol.next(seed)

        then:
        next != null
    }
}
