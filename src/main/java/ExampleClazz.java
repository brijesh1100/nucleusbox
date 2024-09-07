import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExampleClazz {

	public static void main(String[] args) {
		System.out.println("ssds");
		
		
		int [][] cor = {{0,0},{0,1},{1,0},{1,1},{3,0},{3,1},{7,8}};
		
		int[] y = {0,1,3,7};
		int[] x = {0,1,8};
		Set<Integer> xCor = new HashSet<Integer>();
		Set<Integer> yCor = new HashSet<Integer>();
		for (int[] point : cor) {
			xCor.add(point[0]);
			yCor.add(point[1]);
		}
		
		List<Integer> xList = new ArrayList<Integer>(xCor);
		List<Integer> yList = new ArrayList<Integer>(yCor);
		
		
		for (int i = 0; i < xList.size(); i++) {
			for (int j = i+1; j < yList.size(); j++) {
				if(isPossible(xList.get(i),yList.get(j), cor)) {
					System.out.println("True");
					for (int k = 0; k < xList.size(); k++) {
						
					}
					
				}
			}
		}
		
		
		
	}
	
	public static boolean isPossible(int x, int y, int[][] cor){
		int[] aa = {x,y}; 
		for (int i = 0; i < cor.length; i++) {
			int[] arr = cor[i];
			if(Arrays.equals(arr, aa)) {
				return true;
			}
		}
		return false;
		
	}
}
