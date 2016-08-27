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


    /******
     * TODO
     * - grid with rows and columns
     * - a single cell should die
     *
     */
}
