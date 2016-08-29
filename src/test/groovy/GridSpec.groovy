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

    void 'should return with next method same items than inserted'() {
        given:
        Grid grid = new Grid(2,2)
        grid.push(new GridItem(1))
        grid.push(new GridItem(2))
        grid.push(new GridItem(3))
        grid.push(new GridItem(4))

        expect:
        grid.next().getValue() == 1
        grid.next().getValue() == 2
        grid.next().getValue() == 3
        grid.next().getValue() == 4
    }

    void 'should next method works in a no square config'() {
        given:
        Grid grid = new Grid(5,2)
        for (int i = 1; i <= 10; i++) {
            grid.push(new GridItem(i))
        }

        expect:
        grid.getData().size() == 10
        grid.getData().collect { it.getValue() } == [1,2,3,4,5,6,7,8,9,10]

        grid.next().getValue() == 1
        grid.next().getValue() == 2
        grid.next().getValue() == 3
        grid.next().getValue() == 4
        grid.next().getValue() == 5
        grid.next().getValue() == 6
        grid.next().getValue() == 7
        grid.next().getValue() == 8
        grid.next().getValue() == 9
        grid.next().getValue() == 10
    }

    void 'get num neighbours'() {
        given:
        Grid grid = new Grid(1,1)
        def alive = true
        grid.push(new GridItem(alive))

        expect:
        grid.countNeighbours() == 0
    }

    void 'get num neighbours in a minimal grid'() {
        given:
        Grid grid = new Grid(2,2)
        for (int i = 1; i <= 4; i++) {
            def alive = true
            grid.push(new GridItem(alive))
        }

        expect:
        grid.countNeighbours() == 3
    }

    void 'get num neighbours from central cell in a big grid'() {
        given:
        Grid grid = new Grid(3,3)
        for (int i = 1; i <= 9; i++) {
            def alive = true
            grid.push(new GridItem(alive))
        }

        when:
        grid.next()
        grid.next()
        grid.next()
        grid.next()
        def numNeighbours = grid.countNeighbours()

        then:
        numNeighbours == 8
    }

    void 'get num neighbours in a cross'() {
        given:
        Grid grid = new Grid(3,3)
        grid.push(new GridItem(false))
        grid.push(new GridItem(true))
        grid.push(new GridItem(false))
        grid.push(new GridItem(true))
        grid.push(new GridItem(false))
        grid.push(new GridItem(true))
        grid.push(new GridItem(false))
        grid.push(new GridItem(true))
        grid.push(new GridItem(false))


        when:
        grid.next()
        grid.next()
        grid.next()
        grid.next()
        def numNeighbours = grid.countNeighbours()

        then:
        numNeighbours == 4
    }
}

