import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class WordSearchSolver {

	private String[][] grid;
	private int startX;
	private int startY;

	
	private int dirX;
	private int dirY;
	
	public WordSearchSolver(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		
		Scanner lineCounter = new Scanner(file);
		int colNumTotal = 0;
		int rowNumTotal = 0;
		//This creates the sizes for the rows and cols
		while(lineCounter.hasNextLine()) {
			rowNumTotal = lineCounter.nextLine().replaceAll("\\s+","").length();
			colNumTotal++;
		}
		lineCounter.close();
		
		Scanner scan = new Scanner(file);
		
		int p = 0;
		grid = new String[colNumTotal][rowNumTotal];
		
		while(scan.hasNextLine()) {
			String data = scan.nextLine().replaceAll("\\s+","");
			String[] StrRow = data.split("(?!^)");

			for (int i = 0; i < grid.length; i++) {
				grid[p][i] = StrRow[i];
			}
			p++;
		}
		
		
		
		scan.close();
		
	
		for (int i = 0; i < grid.length; i++) {
			for(int z = 0; z < grid[i].length; z++) {
				System.out.print(grid[i][z] + " ");
			}
			System.out.println("");
		} 
		
		
		System.out.println("");
	}
	
	
	public void WordSearchSolverMultiple(String filename, String wordList) throws FileNotFoundException {
		
		File wordFile = new File(filename);
		
		
		
		
		
		
		
		
	}
	
	
	
	public String[][] getBaseGrid() {
		//This goes though the first grid and then copies it to another grid that we will use.
		String[][] baseGrid = new String[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for(int z = 0; z < grid[i].length; z++) {
				baseGrid[i][z] = grid[i][z];	
			}
		}
		
	return baseGrid;
	}
	
	
	public void singleWordFinder(String currentWord) {
		String[][] theGrid = getBaseGrid();
	    String[] splitWord = currentWord.replaceAll("\\s", "").toUpperCase().split("");
	    int wordSize = splitWord.length;
	    int p = 0;
	    int down = -100000;
	   
	    while(down < 0) {
	    	for (int i = 0; i < theGrid.length; i++) {
				for(int z = 0; z < theGrid[i].length; z++) {
					
					if(theGrid[i][z].equals(splitWord[p])) {						
						p = 1;
						try {
						if(theGrid[i+1][z+1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, 1, 1, p);
							if(down > 0) {
								dirX = 1;
								dirY = 1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
												
						try {	
						if(theGrid[i+1][z].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, 1, 0, p);
							if(down > 0) {
								dirX = 1;
								dirY = 0;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i+1][z-1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, 1, -1, p);
							if(down > 0) {
								dirX = 1;
								dirY = -1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i][z+1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, 0, 1, p);
							if(down > 0) {
								dirX = 0;
								dirY = 1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i][z-1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, 0, -1, p);
							if(down > 0) {
								dirX = 0;
								dirY = -1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i-1][z+1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, -1, 1, p);
							if(down > 0) {
								dirX = -1;
								dirY = 1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i-1][z].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, -1, 0, p);
							if(down > 0) {
								dirX = -1;
								dirY = 0;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						try {
						if(theGrid[i-1][z-1].equals(splitWord[p])) {
							down = around(theGrid, wordSize, splitWord, i, z, -1, -1, p);
							if(down > 0) {
								dirX = -1;
								dirY = -1;
								break;
							}
						}}
						catch(IndexOutOfBoundsException e) {}
						
						
						
						
						p=0;
					}
				if(down > 0) {
					break;
				}
				
				}
				if(down > 0) {
					break;
				}
		    }
	    	break;
	    }
	    
	    if(down > 0) {
	    	System.out.println("The Word Was Found! (See the % Below)");
	    	
	    	String[][] foundGrid = new String[grid.length][grid[0].length];
			
			//This creates a new grid that shows the location of the word
			for (int i = 0; i < grid.length; i++) {
				for(int z = 0; z < grid[i].length; z++) {
					foundGrid[i][z] = grid[i][z];
				}	
			} 
			
			
		    //This adds % where the word originally was
		    for(int i = 0; i < wordSize; i++) {
		    	foundGrid[startX + dirX*i][startY + dirY*i] = ".";
		    }
		    
		    //This prints out the new grid
		    for (int i = 0; i < foundGrid.length; i++) {
				for(int z = 0; z < foundGrid[i].length; z++) {
					System.out.print(foundGrid[i][z] + " ");
				}
				System.out.println("");
			} 
	    }
	    else {
	    	System.out.println("\nError! Word not Found!");
	    }

	//    scan.close();
	}

	public int around(String[][] theGrid, int wordSize, String[] splitWord, int i, int z, int x, int y, int p) {
		int result;
		if(p >= wordSize) {
			startX = i;
			startY = z;
			result = 0;
		}
		else {
			
			try {
				if(theGrid[i+x*p][z+y*p].equals(splitWord[p])) {
					result = around(theGrid, wordSize, splitWord, i, z, x, y, p+1)+1;
					
					
				}
				else {
					return -10000;
				}
				
			}
				catch(IndexOutOfBoundsException e) {return -10000;}			
		}
		return result;
	} 
}
