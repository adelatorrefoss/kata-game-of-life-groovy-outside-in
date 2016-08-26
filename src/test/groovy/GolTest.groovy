import spock.lang.Specification

class GolTest extends Specification {
    private Grid createGrid() {
        new Grid()
    }

    private Gol createGol() {
        new Gol()
    }

    void 'The algorithm should evolves from a seed'() {
        given:
        def gol = createGol()
        Grid seed = createGrid()
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
