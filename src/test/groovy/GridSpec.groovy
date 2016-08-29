import spock.lang.Specification

import GameOfLife.Grid

class GridSpec extends Specification {

    void 'should have rows and columns'() {
        given:
        Grid grid = new Grid()

        expect:
        grid.rows == 1
        grid.columns == 1
    }

    /******
     * TODO
     * - grid with rows and columns
     * - next item from a grid
     * - push item to a grid
     * - Alg: a single cell should die
     *
     */
}

