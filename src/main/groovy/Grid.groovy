class GridItem {
    def value

    GridItem(value) {
        this.value = value
    }

    def getValue() {
        return value
    }

    boolean isAlive() {
        this.value
    }
}


class Grid {
    int rows
    int columns

    int readRowIndex = 0
    int readColumnIndex = 0

    def data = new ArrayList()

    Grid() {
        this.rows = 1
        this.columns = 1
    }

    Grid(int rows, int columns) {
        this.rows = rows
        this.columns = columns
    }

    GridItem get(row, column) {
        if (row < 0 || row >= this.rows ||
                column < 0 || column >= this.columns) {
            throw new IndexOutOfBoundsException("Position requested out of grid")
        }
        return this.data[row * this.columns + column]
    }

    void nextRowAndColumn() {
        readColumnIndex ++
        if (readColumnIndex >= this.columns) {
            readColumnIndex = 0
            readRowIndex ++
        }
    }

    GridItem next() {
        def item
        try {
            item = this.get(readRowIndex, readColumnIndex)

            nextRowAndColumn()
        } catch(IndexOutOfBoundsException e) {
            item = null
        }

        return item
    }

    void push(GridItem item) {
        this.data.push(item)
    }

    ArrayList getData() {
        return this.data
    }

    def countNeighbours() {

    }
}