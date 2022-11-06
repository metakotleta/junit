public class Main {
    public static void main(String[] args) {

        Algo algo = new Algo();

        int[] arr1 = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        int currentBookSize = 32;
        int place = algo.binSearch(arr1, currentBookSize);
        System.out.println("размер книги = " + currentBookSize + ", ответ " + place);
        currentBookSize = 60;
        place = algo.binSearch(arr1, currentBookSize);
        System.out.println("размер книги = " + currentBookSize + ", ответ " + place);

        int[][] regionTeams = new int[][]{{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};
        algo.printTeam(algo.nationalTeam(regionTeams));

    }

}


