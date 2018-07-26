//Three ways to make a singleton design pattern(thread safe);

//the easiest way to implement the singleton, however the performance is not good because of the synchronized getInstance method.
public class Singleton {
	private static Singleton instance;
	private Singleton(){}
	public static synchronized Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}

// this method is threadsafe because the use of concept of class loader, however this method has it's drawback. Because we initial the instance on class loader phase, waste of mem.
public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton(){}
	private static getInstance() {
		return instance;
	}
}

//best one use concept of classloader to ensure the threadsafe and it's memory friendly. Because the instance only being initialized, when we are calling the getInstance method.
public class Singleton {
	private static class SingletonHolder{
		private static final Singleton INSTANCE = new Singleton();
	}
	private Singleton(){}
	public static final Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
}

//singleton class loader
public class SingletonLoader{
	public static void main(String [] args){
		Singleton instance = Singleton.getInstance();
	}
}