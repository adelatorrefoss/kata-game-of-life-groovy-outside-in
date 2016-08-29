import spock.lang.Specification

import Grid
import GridItem

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

    void 'could store items in a position'() {
        given:
        Grid grid = new Grid()
        GridItem item = new GridItem(1)

        when:
        grid.push(item)
        def expected = grid.get(0,0)

        then:
        expected.getValue() == 1
    }

    /******
     * TODO
     * - next item from a grid
     * - Alg: a single cell should die
     *
     */
}

