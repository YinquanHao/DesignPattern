
// Factory design patten gives us the possibility to hide the detail of how to initialize the different instance.

public class ShapeFactory{
	public Shape getShape(String shapeType){
		if(ShapeType == null){
			return null;
		}
		if(ShapeType.equalsIgnoreCase("rectangle")){
			return new Rectangle();
		}else if(ShapeType.equalsIgnoreCase("circle")){
			return new Circle();
		}
	}
}

// use a Shape interface which can hide the detail implementation of a specific object
public interface Shape{
	void draw();
}

// make the class which contains the implementation detail of the required method.
public class Rectangle implements Shape {
	@Override
	public void draw(){
		System.out.println("rectanle");
	}
}


public class Circle implements Shape {
	@Override
	public void draw(){
		System.out.println("circle");
	}
}

//sample class loader
public class FactoryPattern {
	public static void main(String [] args){
		Factory factory = new Factory();
		Shape circle = factory.getShape("circle");
		Shape rectangle = factory.getShape("rectangle");
		circle.draw();
		rectangle.draw();

	}
} 