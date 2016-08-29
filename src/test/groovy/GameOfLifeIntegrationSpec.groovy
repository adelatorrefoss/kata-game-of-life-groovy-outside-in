import spock.lang.*

import Grid
import GolIteration
import NextServiceImpl

class GameOfLifeIntegrationSpec extends Specification {

    void 'should return a died grid with a single cell'() {
        given:
        def golAlg = new GolAlgorithmImpl()
        def nextService = new NextServiceImpl(golAlg)
        def gol = new GameOfLife(nextService)
        def seed = new Grid(3,3)
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        seed.push(new GridItem(true))
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        seed.push(new GridItem(false))
        int maxIterations = 10

        when:
        def result = gol.run(seed, maxIterations)

        then:
        result.grid.data.every { !it.isAlive }
        result.iterations == 1
    }
}
