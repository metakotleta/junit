public class Algo {


    public int binSearch(int[] arr, int x) {
        int res = -1;
        int left = 0;
        int right = arr.length - 1;
        if (x < arr[left]) return arr.length;
        if (x > arr[right]) return 0;
        while (left < right) {
            int middle = (left + right) / 2;

            if (arr[middle] > x) {//ищем слева
                res = arr.length - middle;
                right = middle - 1;
                if (middle == 0) res++;
            } else if (arr[middle] <= x) {//ищем справа
                left = middle + 1;
                if (arr[left] == x) res = arr.length - left - 1;
            }
            if (arr[right] == x) {
                res = arr.length - right - 1;
                break;
            }
        }
        return res;
    }

    public void printTeam(int[] team) {
        for (int i : team) {
            System.out.print(i + "\t");
        }
    }

    //метод поиска 10 игроков с лучшим рейтингом среди всех команд
    public int[] nationalTeam(int[][] regionalTeams) {
        int[] team = regionalTeams[0];//присваиваем изначально первую команду
        for (int i = 1; i < regionalTeams.length; i++) {
            team = merge(team, regionalTeams[i]);//делаем сортировку слияние двух команд последовательно
        }
        return team;
    }

    //сортировка слиянием двух массивов длиной 10
    //поиск среди двух команд 10 игроков с лучшим рейтингом
    public int[] merge(int[] team, int[] regionalTeams) {
        int n = 10;//равно 10, т.к. нам нужны первые 10
        int[] res = new int[n];
        //обнуляем счётчики
        int iTeam = 0;
        int iRegionalTeam = 0;

        for (int i = 0; i < 10; i++) {
            if (team[iTeam] >= regionalTeams[iRegionalTeam]) {
                res[i] = team[iTeam];
                iTeam++;
            } else {
                res[i] = regionalTeams[iRegionalTeam];
                iRegionalTeam++;
            }
        }
        return res;
    }

}
