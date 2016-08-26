import spock.lang.Specification

class GameOfLifeSpec extends Specification {
    private Grid createGrid() {
        new Grid()
    }

    private GameOfLife createGol() {
        new GameOfLife()
    }

    void 'should return a grid and num iterations'() {
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


    void 'should reach max iterations'() {
        given:
        def gol = createGol()
        Grid seed = createGrid()
        int maxIterations = 10

        when:
        def result = gol.evolves(seed, maxIterations)

        then:
        result.iterations == maxIterations
    }

    /******
     * TODO
     * - reach max iterations
     * - stop when stable
     * - grid with rows and columns
     * - a single cell should die
     *
     */

}
