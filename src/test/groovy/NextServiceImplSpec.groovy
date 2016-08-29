import spock.lang.Specification

import GameOfLife.Grid
import GameOfLife.NextServiceImpl

class NextServiceImplSpec extends Specification {

    NextServiceImpl createNextService() {
        new NextServiceImpl()
    }

    void 'should return a new grid'() {
        given:
        NextServiceImpl nextService = createNextService()
        Grid seed = new Grid()

        when:
        Grid next = nextService.next(seed)

        then:
        next instanceof Grid

    }

    void 'should go over all the grid calculating new grid'() {
        given:
        NextServiceImpl nextService = createNextService()

        // Mocking a class!!
        Grid seed = Mock(Grid)

        when:
        Grid next = nextService.next(seed)

        then:
        next instanceof Grid
        (1.._) * seed.next() >> null
    }



    /******
     * TODO
     * - Create new grid with results
     * - Calculate new item
     * - Save new item
     * - grid with rows and columns
     * - Alg: a single cell should die
     *
     */
}
