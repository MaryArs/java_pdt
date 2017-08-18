package ru.stga.pdt.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,2);
		System.out.println("Расстояние между двумя точками через функцию = " + distance(p1,p2));
		System.out.println("Расстояние между двумя точками через метод в классе = " + p1.distance(p2));
		System.out.println("Расстояние между двумя точками через метод в классе  = " + p2.distance(p1));
	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
	}
}































