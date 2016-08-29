class GridItem {
    int row
    int column
    def value

    GridItem(value) {
        this.value = value
    }

    def getValue() {
        return value
    }
}


class Grid {
    int rows
    int columns

    int actualRow = 0
    int actualColumn = 0

    def data = new ArrayList()

    Grid() {
        this.rows = 1
        this.columns = 1
    }

    GridItem get(row, column) {
        if (row < 0 || row >= this.rows ||
                column < 0 || column >= this.columns) {
            throw new IndexOutOfBoundsException("Position requested out of grid")
        }
        return this.data[row * this.rows + column]
    }

    GridItem next() {
        //return new GridItem()
        //return null
    }

    void push(GridItem item) {
        item.row = this.actualRow
        item.column = this.actualColumn
        this.data.push(item)

        this.actualRow ++
        this.actualColumn ++
    }
}