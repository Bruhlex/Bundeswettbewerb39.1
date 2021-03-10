public class Solve
{
    private int[][] loesung;
    
    public String ausgabeFormatieren(int s){
        String output = Integer.toString(s);
        if(s >= 0 && s < 10) {
            output = " " + output;
        }
        return output;
    }
    public void ausgabe(int[][] loesung){
            System.out.println("                /\\");
            System.out.println("               /  \\");
            System.out.println("              /    \\");
            System.out.println("             /"+ausgabeFormatieren(loesung[0][0])+"  "+ausgabeFormatieren(loesung[0][2])+"\\");
            System.out.println("            /___"+ausgabeFormatieren(loesung[0][1])+"___\\");
            System.out.println("           /\\   "+ausgabeFormatieren(loesung[2][1])+"   /\\");
            System.out.println("          /  \\"+ausgabeFormatieren(loesung[2][2])+"  "+ausgabeFormatieren(loesung[2][0])+"/  \\");
            System.out.println("         /    \\    /    \\");
            System.out.println("        /"+ausgabeFormatieren(loesung[1][0])+"  "+ausgabeFormatieren(loesung[1][2])+"\\  /"+ausgabeFormatieren(loesung[3][0])+"  "+ausgabeFormatieren(loesung[3][2])+"\\");
            System.out.println("       /___"+ausgabeFormatieren(loesung[1][1])+"___\\/___"+ausgabeFormatieren(loesung[3][1])+"___\\");
            System.out.println("      /\\  "+ausgabeFormatieren(loesung[5][1])+"    /\\   "+ausgabeFormatieren(loesung[7][1])+"   /\\");
            System.out.println("     /  \\"+ausgabeFormatieren(loesung[5][2])+"  "+ausgabeFormatieren(loesung[5][0])+"/  \\"+ausgabeFormatieren(loesung[7][2])+"  "+ausgabeFormatieren(loesung[7][0])+"/  \\");
            System.out.println("    /    \\    /    \\    /    \\");
            System.out.println("   /"+ausgabeFormatieren(loesung[4][0])+"  "+ausgabeFormatieren(loesung[4][2])+"\\  /"+ausgabeFormatieren(loesung[6][0])+"  "+ausgabeFormatieren(loesung[6][2])+"\\  /"+ausgabeFormatieren(loesung[8][0])+"  "+ausgabeFormatieren(loesung[8][2])+"\\ ");
            System.out.println("  /___"+ausgabeFormatieren(loesung[4][1])+"___\\/___"+ausgabeFormatieren(loesung[6][1])+"___\\/___"+ausgabeFormatieren(loesung[8][1])+"___\\ ");
    }
    
    public int[][] arrayKopieren(int[][] array, int index){
        int[][] newArray = new int[array.length-1][];
        for(int i = 0; i < array.length; i++){
            if(i < index) newArray[i] = array[i]; 
            else if(i > index) newArray[i-1] = array[i];
        }
        return newArray;
    }
    
    public boolean istPassend(int[] puzzleTeil, int y)
    {          
        if(y == 0 || y == 1 || y == 4) return true;
        else if(y == 2 && loesung[0][1] + puzzleTeil[1] == 0 && loesung[1][2] + puzzleTeil[2] == 0) return true;
        else if((y == 3 || y == 6 || y == 8) && loesung[y-1][0] + puzzleTeil[0] == 0) return true;
        else if(y == 5 && loesung[1][1] + puzzleTeil[1] == 0 && loesung[4][2] + puzzleTeil[2] == 0) return true;
        else if(y == 7 && loesung[6][2] + puzzleTeil[2] == 0 && loesung[3][1] + puzzleTeil[1] == 0) return true;
        return false;
    }
    
    public boolean puzzleLoesenStart(int [][] puzzle){
        if(puzzle.length != 9) return false;
        loesung = new int[][]{ {0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0} };
        return puzzleLoesen(puzzle, 0);
    }
    
    public boolean puzzleLoesen(int[][] puzzle, int position){  
        if(position == 9){
            ausgabe(loesung);
            return true;
        }
        
        for(int y = 0; y < puzzle.length; y++){
            for(int drehungen = 0; drehungen < 3; drehungen++){
                puzzle[y] = new int[]{puzzle[y][2], puzzle[y][0], puzzle[y][1]};
                if(istPassend(puzzle[y], position)){
                    loesung[position] = puzzle[y];
                    if(puzzleLoesen(arrayKopieren(puzzle, y), position + 1)) return true;
                    loesung[position] = new int[]{0,0,0};
                }
            }
         }
        return false;
     }
}
