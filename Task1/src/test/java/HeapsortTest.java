import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.nsu.medvedev.v.HeapSort;

class HeapsortTest {
    @Test
    void sort_emptyArray() {
        int[] arr = {};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(new int[0], arr);
    }

    @Test
    void sort_some() {
        int[] expected = {1, 2, 3, 4, 8};
        int[] arr = {1, 4, 3, 2, 8};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void sort_sames() {
        int[] expected = {1, 1, 1, 1, 1};
        int[] arr = {1, 1, 1, 1, 1};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void sort_some1() {
        int[] expected = {1, 1, 1, 1, 2};
        int[] arr = {1, 1, 2, 1, 1};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void sort_one_el() {
        int[] expected = {1};
        int[] arr = {1};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void sort_negative() {
        int[] expected = {-6, -1, 5, 9};
        int[] arr = {5, -6, 9, -1};
        HeapSort.sort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }
}