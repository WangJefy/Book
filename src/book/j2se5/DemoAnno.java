package book.j2se5;

public class DemoAnno {
	@Description(desc="I am eyeColor",author="Jefy",age=18)
	public String eyeColor() {
		return "red";
	}
	public static void main(String[] args) {
		DemoAnno anno = new DemoAnno();
		String s = anno.eyeColor();
		System.out.println(s);
	}
}
