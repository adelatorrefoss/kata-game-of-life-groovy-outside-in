import spock.lang.*

import GameOfLife.Grid
import GameOfLife.GolIteration
import GameOfLife.NextService

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

    private GameOfLife createGol(nextService) {
        new GameOfLife(nextService)
    }

    private GameOfLife createGol() {
        createGol(Mock(NextService))
    }

    void 'should return a grid and num iterations'() {
        given:
        GameOfLife gol = createGol()
        Grid seed = createSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result instanceof GolIteration
    }

    void 'should reach max iterations'() {
        given:
        GameOfLife gol = createGol()
        Grid seed = createUnstableSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations == maxIterations
    }

    void 'should stop when stable and not reach max iterations'() {
        given:
        def nextService = Mock(NextService)
        GameOfLife gol = createGol(nextService)

        Grid seed = createStableSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations < maxIterations

        1 * nextService.isStable() >> true
    }


/******
     * TODO
     * - stop when stable
     * - grid with rows and columns
     * - a single cell should die
     *
     */

}
