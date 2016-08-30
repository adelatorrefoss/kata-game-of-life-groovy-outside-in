import spock.lang.Specification

import Grid
import NextServiceImpl
import GridItem
import GolAlgorithm

class NextServiceImplSpec extends Specification {

    NextServiceImpl createNextService(alg) {
        if (!alg) {
            alg = Mock(GolAlgorithm)
        }
        def nextService = new NextServiceImpl()
        nextService.alg = alg
        return nextService
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

    void 'should create new grid with the same size as seed'() {
        given:
        NextServiceImpl nextService = createNextService()
        Grid seed = Mock(Grid)

        when:
        Grid next = nextService.next(seed)

        then:
        // TODO How to check size without show internals of Grid to NextService
        // next.size() == seed.size()
        5 * seed.next() >>> [new GridItem(), new GridItem(), new GridItem(), new GridItem(), null]
    }

    void 'should calculate new item'() {
        given:
        Grid seed = Mock(Grid)
        GolAlgorithm alg = Mock(GolAlgorithm)
        NextServiceImpl nextService = createNextService(alg)

        when:
        Grid next = nextService.next(seed)

        then:
        5 * seed.next() >>> [new GridItem(), new GridItem(), new GridItem(), new GridItem(), null]
        4 * alg.calc(*_)
    }

    void 'should calculate new item passing neighbours'() {
        given:
        Grid seed = Mock(Grid)
        GolAlgorithm alg = Mock(GolAlgorithm)
        NextServiceImpl nextService = createNextService(alg)

        when:
        Grid next = nextService.next(seed)

        then:
        5 * seed.next() >>> [new GridItem(), new GridItem(), new GridItem(), new GridItem(), null]
        4 * alg.calc(_, _)
        4 * seed.countNeighbours()
    }

}
