import spock.lang.Specification

import GameOfLife.Grid
import GameOfLife.GridItem

class GridSpec extends Specification {

    void 'should have rows and columns'() {
        given:
        Grid grid = new Grid()

        expect:
        grid.rows == 1
        grid.columns == 1
    }

    void 'could be accesed'() {
        given:
        Grid grid = new Grid()

        expect:
        grid.get(0,0) == null

        when:
        grid.get(1,0)

        then:
        thrown(IndexOutOfBoundsException)
    }

    /******
     * TODO
     * - next item from a grid
     * - push item to a grid
     * - Alg: a single cell should die
     *
     */
}

