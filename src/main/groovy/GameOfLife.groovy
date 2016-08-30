// GolAlgorithm
interface GolAlgorithm {
    GridItem calc(GridItem item, numNeighbours)
}

class GolAlgorithmImpl implements GolAlgorithm {

    GridItem calc(GridItem item, numNeighbours) {
        def alive = false
        if ((item.isAlive() &&
                numNeighbours >= 2 && numNeighbours <= 3) ||
                (!item.isAlive() &&
                        numNeighbours == 3)) {
            alive = true
        }
        return new GridItem(alive)
    }
}

// NextService
interface NextService {
    Grid next(Grid seed)
}

class NextServiceImpl implements NextService {

    GolAlgorithm alg

    NextServiceImpl(GolAlgorithm golAlg) {
        this.alg = golAlg
    }

    Grid next(Grid seed) {
        GridItem item

        // TODO: Forgot to initialize Grid with rows and columns
        // lack of tests
        Grid nextGrid = new Grid(seed.rows, seed.columns)

        // TODO: Found bug. When seed.next() returns null , this method returns an empty grid
        //    This behaviour is not controlled
        // 
        //  and found a bug in calculating neighbours after next
        //   we should separate this in current() and next()
        while (item = seed.current()) {
            def numNeighbours = seed.countNeighbours()
            def nextItem = alg.calc(item, numNeighbours)
            nextGrid.push(nextItem)
            seed.next()
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

    // TODO: isStable is not tested alone
    boolean isStable(Grid current, Grid next) {
        def currentData = current.getData().collect { it.isAlive() }
        def nextData = next.getData().collect { it.isAlive() }
        def isStable = currentData.equals(nextData)
        return isStable
    }

    GameOfLife(nextSystem) {
        this.nextSystem = nextSystem
    }

    GolIteration run(Grid seed, int maxIterations) {

        def isStable = false
        int i = 0
        Grid nextSeed = null

        while (!isStable && i < maxIterations) {
            nextSeed = nextSystem.next(seed)
            isStable = this.isStable(seed, nextSeed)
            i++
            seed = nextSeed
        }

        return new GolIteration(nextSeed, i)
    }
}
