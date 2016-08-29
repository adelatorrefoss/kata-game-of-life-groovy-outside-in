class GameOfLife {



    class GridItem {

    }


    class Grid {

        GridItem next() {
            //return new GridItem()
            //return null
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


    interface NextService {
        boolean isStable()
        Grid next(Grid seed)
    }

    class NextServiceImpl implements NextService {

        boolean isStable() {
            return true
        }

        Grid next(Grid seed) {
            GridItem item
            Grid nextGrid = new Grid()
            while (item = seed.next()) {

            }
            return nextGrid
        }
    }



    // Game of life

    NextService nextSystem = new NextServiceImpl()

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
