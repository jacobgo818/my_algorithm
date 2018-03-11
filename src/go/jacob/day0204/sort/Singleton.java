package go.jacob.day0204.sort;

public class Singleton {
	private volatile static Singleton instance = null;

	private Singleton() {
	}

	/*
	 * 双重校验
	 */
	public static Singleton getInstance() {
		if (instance == null)
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
					return instance;
				}
			}
		return instance;

	}

	/*
	 * 静态内部类
	 */
	private static class SingletonHolder {
		public static Singleton instance = new Singleton();
	}

	public static Singleton newInstance() {
		return SingletonHolder.instance;
	}

}
