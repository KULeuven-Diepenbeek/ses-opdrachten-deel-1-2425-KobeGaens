import unittest
from checkneighbours import get_same_neighbours_ids
#zelfde functies als in java bestand
class TestCheckNeighboursInGrid(unittest.TestCase):
    def test_gegevenEnkelElement_wanneerGetNeighbours_danLegeLijst(self):
        grid = [1]
        self.assertEqual(get_same_neighbours_ids(grid, 1, 1, 0), [])

    def test_gegevenHoekElement_wanneerGetNeighbours_danEenBuur(self):
        grid = [
            1, 2, 3,
            4, 1, 6,
            7, 8, 1
        ]
        self.assertEqual(get_same_neighbours_ids(grid, 3, 3, 0), [4])

    def test_gegevenRandElement_wanneerGetNeighbours_danTweeBuren(self):
        grid = [
            1, 1, 3,
            4, 1, 6,
            7, 8, 1
        ]
        self.assertEqual(sorted(get_same_neighbours_ids(grid, 3, 3, 1)), [0, 4])

    def test_gegevenMiddenElement_wanneerGetNeighbours_danSchuinBuren(self):
        grid = [
            1, 2, 3,
            4, 1, 6,
            7, 8, 1
        ]
        self.assertEqual(sorted(get_same_neighbours_ids(grid, 3, 3, 4)), [0, 8])

    def test_gegevenGeenOvereenkomendeBuren_wanneerGetNeighbours_danLegeLijst(self):
        grid = [
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        ]
        self.assertEqual(get_same_neighbours_ids(grid, 3, 3, 4), [])

    def test_gegevenAlleWaardenGelijk_wanneerGetNeighbours_danAlleBuren(self):
        grid = [
            1, 1, 1,
            1, 1, 1,
            1, 1, 1
        ]
        self.assertEqual(sorted(get_same_neighbours_ids(grid, 3, 3, 4)), [0,1,2,3,5,6,7,8])

    def test_gegevenIndex9_wanneerGetNeighbours_danIndexError(self):
        grid = [
            1, 5, 7,
            3, 8, 4,
            6, 5, 1
        ]
        with self.assertRaises(IndexError):
            get_same_neighbours_ids(grid, 3, 3, 9)

    def test_gegevenGroteArray_wanneerGetNeighbours_danGeenBuren(self):
        grid = [
            1, 5, 7, 1, 9,
            3, 8, 4, 6, 3,
            6, 5, 1, 8, 0,
            5, 3, 7, 0, 7,
            1, 7, 6, 4, 3
        ]
        self.assertEqual(get_same_neighbours_ids(grid, 5, 5, 24), [])

    def test_gegevenOnevenArray_wanneerGetNeighbours_danEenBuur(self):
        grid = [
            1, 5, 7, 4, 9,
            3, 8, 4, 6, 3
        ]
        self.assertEqual(get_same_neighbours_ids(grid, 5, 2, 3), [7])

if __name__ == '__main__':
    unittest.main()