package Sept11;

public class Matrix3x3 {
	private double[][] a;
	
	public Matrix3x3( double a11, double a12, double a13,
				   double a21, double a22, double a23,
				   double a31, double a32, double a33){
		a = new double[3][3];
		a[0][0] = a11;
		a[0][1] = a12;
		a[0][2] = a13;
		a[1][0] = a21;
		a[1][1] = a22;
		a[1][2] = a23;
		a[2][0] = a31;
		a[2][1] = a32;
		a[2][2] = a33;
		
	}
	
	public Matrix3x3(){
		a = new double[3][3];
	}
	
	public void setRowColumn(int row, int col, double val){
		a[row][col] = val;
	}
	
	public double[][] getArray(){
		return a;
	}
	
	public Matrix3x3 addMatrix(Matrix3x3 other){
		Matrix3x3 temp = new Matrix3x3();
		double[][] otherMatrix = other.getArray();
		for(int row = 0; row < 3; row++ ){
			for(int col =0; col < 3; col++){
				temp.setRowColumn(row, col, this.a[row][col] + otherMatrix[row][col]);
			}
		}
		
		return temp;
	}
	
	public Matrix3x3 multiply(Matrix3x3 other){
		Matrix3x3 temp = new Matrix3x3();
		double[][] otherMatrix = other.getArray();
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				int sum = 0;
				for(int k = 0; k < 3; k++){
					sum += this.a[row][k] * otherMatrix[k][col];
				}
				temp.setRowColumn(row, col, sum);
			}
		}
		return temp;
	}
	
	public void transpose(){
		
		for(int row = 0; row < 2; row++){
			for(int col = row+1; col < 3; col++){
				double temp = this.a[row][col];
				this.a[row][col] = this.a[col][row];
				this.a[col][row] = temp;
			}
		}
		
		 
	}
	
	@Override
	public String toString(){
		StringBuilder string = new StringBuilder();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				string.append(a[i][j]);
				string.append(" ");
			}
			string.append("\n");
		}
		return string.toString();
	}
	
	public static void main(String[] args){
		Matrix3x3 test = new Matrix3x3(1,2,3,4,5,6,7,8,9);
		Matrix3x3 other = new Matrix3x3(1034,342,33,123,55,32,344,89,33);
		System.out.println(test);
		test.transpose();
		System.out.println(test);
	}

}
