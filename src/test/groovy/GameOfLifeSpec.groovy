import spock.lang.*

import Grid
import GolIteration
import NextService

class GameOfLifeSpec extends Specification {

    Grid createSeed() {
        def grid = Stub(Grid)
        def gridItem = Stub(GridItem)
        gridItem.isAlive() >> true
        grid.getData() >> [gridItem, gridItem, gridItem]

        return grid
    }

    Grid createUnstableSeed() {
        def grid = Stub(Grid)
        def gridItem = Stub(GridItem)
        def gridItem2 = Stub(GridItem)
        gridItem.isAlive() >> true
        gridItem2.isAlive() >> false
        grid.getData() >> [gridItem, gridItem, gridItem2]

        return grid
    }

    GameOfLife createGol(nextService) {
        new GameOfLife(nextService)
    }

    GameOfLife createGol() {
        def nextService = Stub(NextService)
        def nextGrid = createSeed()
        nextService.next(_) >> nextGrid
        createGol(nextService)
    }

    GameOfLife createGolUnstable() {
        def nextService = Stub(NextService)
        def nextGridAllFalse = createSeed()
        def nextGridUnstable = createUnstableSeed()
        nextService.next(_) >>> [nextGridUnstable, nextGridAllFalse, nextGridUnstable, nextGridAllFalse,
                                 nextGridUnstable, nextGridAllFalse, nextGridUnstable, nextGridAllFalse,
                                 nextGridUnstable, nextGridAllFalse, nextGridUnstable, nextGridAllFalse]

        createGol(nextService)
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
        GameOfLife gol = createGolUnstable()
        Grid seed = createSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations == maxIterations
    }

    void 'should stop when stable and not reach max iterations'() {
        given:
        GameOfLife gol = createGol()

        Grid seed = createSeed()
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.iterations < maxIterations
    }

}
