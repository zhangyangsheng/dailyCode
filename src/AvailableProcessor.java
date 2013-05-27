
/**
 * 
 * @author zhangyangsheng
 *
 */
public class AvailableProcessor {
	public static void main(String[] args) {
		System.out.println("os name: " + System.getProperty("os.name"));
		System.out.println("available processors: " + Runtime.getRuntime().availableProcessors());
	}
}
