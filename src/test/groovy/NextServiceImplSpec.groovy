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
        Grid seed = Mock(Grid)

        when:
        Grid next = nextService.next(seed)

        then:
        next instanceof Grid
        1 * seed.nextItem()
    }


    /******
     * TODO
     * - grid with rows and columns
     * - a single cell should die
     *
     */
}
