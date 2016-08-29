import spock.lang.Specification

class GolAlgorithmImplSpec extends Specification {
    void 'should be called with valid item and num neighbours'() {
        given:
        def alg = new GolAlgorithmImpl()
        def gridItem = Mock(GridItem)
        def numNeighbours = null

        expect:
        alg.calc(gridItem, numNeighbours) instanceof GridItem
    }

    void 'should return a dead cell when only one cell and no neighbours'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = true
        def cell = new GridItem(isAlive)
        def numNeighbours = 0

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        !expected.isAlive()
    }

    void 'should return a dead cell when only one neighbour'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = true
        def cell = new GridItem(isAlive)
        def numNeighbours = 1

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        !expected.isAlive()
    }

    void 'should return a live cell when only one cell and two neighbours'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = true
        def cell = new GridItem(isAlive)
        def numNeighbours = 2

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        expected.isAlive()
    }

    void 'should return a live cell when only one cell and three neighbours'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = true
        def cell = new GridItem(isAlive)
        def numNeighbours = 3

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        expected.isAlive()
    }

    void 'should return a dead cell by overpopulation'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = true
        def cell = new GridItem(isAlive)
        def numNeighbours = 4

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        !expected.isAlive()
    }

    void 'when dead cell should return a live cell by reproduction'() {
        given:
        def alg = new GolAlgorithmImpl()
        def isAlive = false
        def cell = new GridItem(isAlive)
        def numNeighbours = 3

        when:
        def expected = alg.calc(cell, numNeighbours)

        then:
        expected.isAlive()
    }
}
