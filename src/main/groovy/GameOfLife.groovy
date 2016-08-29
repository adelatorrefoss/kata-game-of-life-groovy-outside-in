class GameOfLife {



    class GridItem {

    }


    class Grid {

        GridItem next() {
            //return new GridItem()
            //return null
        }

        void push(GridItem item) {

        }

    }

    interface NextService {
        boolean isStable()
        Grid next(Grid seed)
    }


    interface GolAlgorithm {
        GridItem calc(GridItem item)
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
                seed.push(item)
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
