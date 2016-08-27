class GameOfLife {

    GameOfLife(nextSystem) {
        this.nextSystem = nextSystem
    }


    class Grid {
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
            return new Grid()
        }
    }

    NextService nextSystem = new NextServiceImpl()


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
