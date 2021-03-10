public class Testklasse
{
    private int[][] puzzle;
    private Solve solve = new Solve();
    public Testklasse()
    {
    }

    public void test()
    {
        puzzle = new int[][]{ {-1,-2,1},{2,-1,-1},{-1,-2,2},{-1,3,1},{2,-3,3},{-1,3,-2},{2,2,-1},{-3,2,-1},{-2,1,-3} };
        solve.puzzleLoesenStart(puzzle);
    }
    
    public void test2()
    {
        puzzle = new int[][]{ {10,10,4},{9,8,-7},{10,-5,10},{-2,10,7},{6,5,-2},{2,3,-4},{-6,-8,-10},{-9,10,10},{10,-3,2} };
        solve.puzzleLoesenStart(puzzle);
    }
    
    public void test3()
    {
        puzzle = new int[][]{ {-3,-2,-1},{-2,-4,1},{1,2,-4},{-3,-1,1},{2,3,1},{-3,-2,-4},{-3,1,-2},{3,4,-1},{-2,-3,4} };
        solve.puzzleLoesenStart(puzzle);
    }
}
