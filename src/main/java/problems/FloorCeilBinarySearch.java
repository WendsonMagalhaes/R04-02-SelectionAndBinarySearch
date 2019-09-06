package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: - Algoritmo in-place (nao pode usar memoria extra a nao ser
 * variaveis locais) - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		int leftIndex = 0;
		int rightIndex = array.length;
		int middleIndex = leftIndex + rightIndex / 2;

		if (array[leftIndex] > x) {
			return 0;
		} else {
			if (array[middleIndex] > x) {
				return floor(array, leftIndex, middleIndex, x);
			} else {
				return floor(array, middleIndex + 1, rightIndex, x);
			}
		}
	}

	private int floor(Integer[] array, int leftIndex, int rightIndex, int x) {

		int result = 0;
		int middleIndex = leftIndex + rightIndex / 2;

		if (array[middleIndex] > x && array[middleIndex - 1] <= x) {
			result = array[middleIndex - 1];
		} else if (array[middleIndex] < x && array[middleIndex + 1] < x) {
			result = floor(array, middleIndex, rightIndex - 1, x);
		} else if (array[middleIndex] == x) {
			result = array[middleIndex];
		} else if (array[middleIndex] < x && array[middleIndex + 1] > x) {
			result = array[middleIndex];
		} else {
			result = floor(array, leftIndex, middleIndex - 1, x);
		}
		return result;

	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int leftIndex = 0;
		int rightIndex = array.length;
		int middleIndex = leftIndex + rightIndex / 2;

		if (array[rightIndex - 1] < x) {
			return 0;
		} else {
			if (array[middleIndex] > x) {
				return ceil(array, leftIndex, middleIndex, x);
			} else {
				return ceil(array, middleIndex + 1, rightIndex, x);
			}
		}
	}

	private int ceil(Integer[] array, int leftIndex, int rightIndex, int x) {

		int result = 0;
		int middleIndex = (leftIndex + rightIndex) / 2;

		if (middleIndex == 0 && array[middleIndex] >= x) {
			result = array[middleIndex];
		} else if (array[middleIndex] >= x && array[middleIndex - 1] < x) {
			result = array[middleIndex];
		} else if (array[middleIndex] < x) {
			result = ceil(array, middleIndex + 1, rightIndex, x);
		} else if (array[middleIndex] > x && array[middleIndex - 1] < x) {
			result = array[middleIndex];
		} else {
			result = ceil(array, leftIndex, middleIndex - 1, x);
		}
		return result;

	}
}
