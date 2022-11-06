import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoTest {
    Algo algo;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        algo = new Algo();
    }

    @BeforeAll
    public static void started() {
        System.out.println("started tests");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @ParameterizedTest
    @MethodSource("sourceBinSearch")
    public void testBinSearch(int[] arr, int x, int expected) {
        //act
        int result = algo.binSearch(arr, x);
        //assert
        assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceBinSearch() {
        int[] arr = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        return Stream.of(Arguments.of(arr, 32, 3), Arguments.of(arr, 60, 2));
    }


    @Test
    public void testMergeNotNull() {
        //arrange
        int[][] regionTeamsToBeMerged = new int[][]{{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1}};
        //act
        int[] arrResult = algo.merge(regionTeamsToBeMerged[0], regionTeamsToBeMerged[1]);
        //assert
        assertNotNull(arrResult);
    }

    @ParameterizedTest
    @MethodSource("sourceNationalTeam")
    public void testNationalTeam(int[][] nationalTeams, int[] expected) {
        //act
        int[] actual = algo.nationalTeam(nationalTeams);
        //assert
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> sourceNationalTeam() {
        //arrange
        int[][] regionTeams = new int[][]{{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
        int[] expected = new int[]{51, 45, 31, 31, 30, 24, 22, 20, 18, 17};

        return Stream.of(Arguments.of(regionTeams, expected));
    }

}
