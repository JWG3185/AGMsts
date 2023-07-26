package kr.co.kopo;

import java.util.Scanner;

public class CalcConsole {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); 
		
		Calc calc = new Calc();
		
		while (true) {
			System.out.print("입력: ");
			
			String button = scan.next();
			
			if("exit".equals(button)) {
				break;
			}
			
			calc.onButton(button);
			
			System.out.println(calc.getDisplay());
			
		}
		scan.close();
		
	}
}
