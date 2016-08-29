// GolAlgorithm
interface GolAlgorithm {
    GridItem calc(GridItem item, numNeighbours)
}

class GolAlgorithmImpl implements GolAlgorithm {

    GridItem calc(GridItem item, numNeighbours) {
        def alive = false
        if (item.isAlive()) {
            if (numNeighbours >= 2 && numNeighbours <= 3) {
                alive = true
            }
        }
        return new GridItem(alive)
    }
}

// NextService
interface NextService {
    boolean isStable()
    Grid next(Grid seed)
}

class NextServiceImpl implements NextService {

    GolAlgorithm alg

    boolean isStable() {
        return true
    }

    Grid next(Grid seed) {
        GridItem item
        Grid nextGrid = new Grid()
        while (item = seed.next()) {
            def numNeighbours = seed.countNeighbours()
            def nextItem = alg.calc(item, numNeighbours)
            seed.push(nextItem)
        }
        return nextGrid
    }
}

class GolIteration {

    GolIteration(Grid grid, int iterations) {
        this.grid = grid
        this.iterations = iterations
    }

    Grid grid
    int iterations
}

class GameOfLife {

    // Game of life

    NextService nextSystem

    GameOfLife(nextSystem) {
        this.nextSystem = nextSystem
    }

    GolIteration run(Grid seed, int maxIterations) {

        def isStable = false
        int i = 0
        GolIteration next = null
        Grid nextSeed = null

        while (!isStable && i < maxIterations) {
            nextSeed = nextSystem.next(seed)
            isStable = nextSystem.isStable()
            i++
        }

        return new GolIteration(nextSeed, i)
    }
}
