import spock.lang.Specification

class GameOfLifeSpec extends Specification {
    private Grid createSeed() {
        new Grid()
    }

    private Grid createUnstableSeed() {
        new Grid()
    }

    Grid createStableSeed() {
        new Grid()
    }

    private GameOfLife createGol() {
        new GameOfLife()
    }

    void 'should return a grid and num iterations'() {
        given:
        def gol = createGol()
        Grid seed = createSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result instanceof GolIteration
        result.grid != null
        result.grid instanceof Grid
        result.iterations != null
    }

    void 'should reach max iterations'() {
        given:
        def gol = createGol()
        Grid seed = createUnstableSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations == maxIterations
    }

    void 'should stop when stable and not reach max iterations'() {
        given:
        def gol = createGol()
        Grid seed = createStableSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations < maxIterations
    }


/******
     * TODO
     * - stop when stable
     * - grid with rows and columns
     * - a single cell should die
     *
     */

}
