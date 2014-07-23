import java.util.Random;


public class Matrix {
    public int[][] data;
    public int x, y, columns, rows;

    public Matrix(int[][] data) {
        this(data, 0, 0, data.length, data[0].length);
    }

    private Matrix(int[][] data, int x, int y, int columns, int rows) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.columns = columns;
        this.rows = rows;
    }

    public Matrix getSubMatrix(int x, int y, int columns, int rows) {
        return new Matrix(data, this.x + x , this.y + y, columns, rows);
    }

    public String toString() {

        StringBuffer sb = new StringBuffer();

        for (int i = y; i < y + rows; i++) {
            for (int j = x; j < x + columns; j++)
                sb.append(data[i][j]).append(" ");

            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
    
    public int sum(){
    	int sum = 0;
    	
    	for (int i = x; i < x+columns; i++) 
	        for (int j = y; j < y+rows; j++)
	            sum += data[i][j];
    	
    	return sum;
    }
	
	public static void main(String[] args) {
		Random random = new Random();
		int max = 50;
		int min = -50;
		int[][] testData = new int[10][10];

	    for (int i = 0; i < testData.length; i++) 
	        for (int j = 0; j < testData[i].length; j++)
	            testData[i][j] = random.nextInt(max - min) + min;

	    Matrix full = new Matrix(testData);

	    System.out.println("Full test matrix:");
	    System.out.println(full);

	    System.out.println();
	    
	    int lowest = full.sum();
	    int higest = lowest;
	    int setting_low[] = new int[4];
	    int setting_high[] = new int[4];
	    
	    for (int i = 0; i < full.data.length; i++){
	        for (int j = 0; j < full.data[i].length; j++){
	        	for (int col = full.data.length-i; col > 0; col--){ 
	    	        for (int row = full.data[i].length-j; row > 0; row--){
	    	        	Matrix sub1 = full.getSubMatrix(i, j, col, row);
	    	        	int subsum = sub1.sum();	    	        	
	    	        	if(lowest>subsum){
	    	        		System.out.println("lowest="+i+" "+j+" "+col+" "+row);
	    	        		setting_low[0] = i;
	    	        		setting_low[1] = j;
	    	        		setting_low[2] = col;
	    	        		setting_low[3] = row;
	    	        		System.out.println(subsum);
	    	        		lowest=subsum;
	    	        	}else if(higest<subsum){
	    	        		System.out.println("highest="+i+" "+j+" "+col+" "+row);
	    	        		setting_high[0] = i;
	    	        		setting_high[1] = j;
	    	        		setting_high[2] = col;
	    	        		setting_high[3] = row;
	    	        		System.out.println(subsum);
	    	        		higest=subsum;
	    	        	}
	    	        }
	        	}
			}
		}
	        	
	        
	            //testData[i][j] = random.nextInt(max - min) + min;
	    
	    System.out.println("Lowest sub matrix:");
	    Matrix subl = full.getSubMatrix(setting_low[0], setting_low[1], setting_low[2], setting_low[3]);
	    System.out.println(subl);
	    System.out.println("sum of sub = "+subl.sum());
	    
	    System.out.println("highest sub matrix:");
	    Matrix subh = full.getSubMatrix(setting_high[0], setting_high[1], setting_high[2], setting_high[3]);
	    System.out.println(subh);
	    System.out.println("sum of sub = "+subh.sum());
	}

}
