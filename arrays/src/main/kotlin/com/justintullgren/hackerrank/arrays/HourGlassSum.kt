/**
 * <p> example:
 *   1 1 1 0 0 0
 *   0 1 0 0 0 0
 *   1 1 1 0 0 0
 *   0 0 2 4 4 0
 *   0 0 0 2 0 0
 *   0 0 1 2 4 0
 * </p>
 *
 * @see <a href="https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">Problem Statement</a>
 */
fun hourglassSum(arr: Array<Array<Int>>): Int {
    if (arr.size != 6) throw IllegalArgumentException("Input should be an array of size 6")
    arr.forEach { if (it.size != 6) throw IllegalArgumentException("Input data arrays should be of size 6") }

    val sums = mutableListOf<Int>()

    for (row in 0..3) {
        for (column in 0..3) {
            val hourGlassSum = (arr[row][column] // top
                    + arr[row][column + 1] // top
                    + arr[row][column + 2] // top
                    + arr[row + 1][column + 1]//middle
                    + arr[row + 2][column]//bottom
                    + arr[row + 2][column + 1]//bottom
                    + arr[row + 2][column + 2])//bottom
            sums.add(hourGlassSum)
        }
    }
    return sums.max() ?: 0

}



