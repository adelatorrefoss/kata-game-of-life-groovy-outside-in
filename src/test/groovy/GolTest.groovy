import spock.lang.Specification

class GolTest extends Specification {
    void 'The algorithm should evolves from a seed'() {
        given:
        def gol = new Gol()
        Grid seed = new Grid()
        int maxIterations = 10

        when:
        def result = gol.evolves(seed, maxIterations)

        then:
        result instanceof GolIteration
        result.grid != null
        result.grid instanceof Grid
        result.iterations != null
    }
}
