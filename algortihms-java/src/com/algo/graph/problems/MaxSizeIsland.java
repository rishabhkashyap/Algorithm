package com.algo.graph.problems;

public class MaxSizeIsland {
	public static void main(String[] args) {
		int[][] island = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 0, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		int maxIslandSize = Integer.MIN_VALUE;
		for (int i = 0; i < island.length; i++) {
			for (int j = 0; j < island[0].length; j++) {
				if (island[i][j] == 1) {
					int islandSize = getIslandSize(island, i, j);
					maxIslandSize = Math.max(maxIslandSize, islandSize);
				}

			}
		}
		System.out.println("Island size = " + maxIslandSize);

	}

	private static int getIslandSize(int[][] island, int row, int column) {
		//Mark it visited
		island[row][column] = 0;

		// Check top of cell
		if (row - 1 >= 0 && island[row - 1][column] == 1) {
			return getIslandSize(island, row - 1, column) + 1;
		}
		// check bottom
		if (row + 1 < island.length && island[row + 1][column] == 1) {
			return getIslandSize(island, row + 1, column) + 1;
		}
		// check right of cell
		if (column + 1 < island[row].length && island[row][column + 1] == 1) {
			return getIslandSize(island, row, column + 1) + 1;
		}
		// Check left of cell
		if (column - 1 >= 0 && island[row][column - 1] == 1) {
			return getIslandSize(island, row, column - 1) + 1;
		}
		// check diagonal top right
		if (row - 1 >= 0 && column + 1 < island[row].length && island[row - 1][column + 1] == 1) {
			return getIslandSize(island, row - 1, column + 1) + 1;
		}
		// Check digonal top left
		if (row - 1 >= 0 && column - 1 >= 0 && island[row - 1][column - 1] == 1) {
			return getIslandSize(island, row - 1, column - 1) + 1;
		}
		// check diagonal bottom right
		if (row + 1 < island.length && column + 1 < island[row].length && island[row + 1][column + 1] == 1) {
			return getIslandSize(island, row + 1, column + 1) + 1;
		}

		// check diagonal bottom left
		if (row + 1 < island.length && column - 1 >= 0 && island[row + 1][column - 1] == 1) {
			return getIslandSize(island, row + 1, column - 1) + 1;
		}
		return 1;
	}

}
