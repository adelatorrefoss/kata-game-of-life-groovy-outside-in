import Grid
import NextServiceImpl
import GridItem
import GameOfLife
import GolAlgorithmImpl

println "Game of Life"

def golAlg = new GolAlgorithmImpl()
def nextService = new NextServiceImpl(golAlg)
def gol = new GameOfLife(nextService)
int maxIterations = 10
def seed
def result

// seed
seed = new Grid(3,3)
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))

result = gol.run(seed, maxIterations)

println result.grid.getData().collect { it.isAlive() }
println result.iterations


// seed
seed = new Grid(5,5)
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(true))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))
seed.push(new GridItem(false))

result = gol.run(seed, maxIterations)

println result.grid.getData().collect { it.isAlive() }
println result.iterations




println "Groovy World!"