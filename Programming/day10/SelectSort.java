public class SelectSort<T extends Comparable> implements ISort<T> {
	public void sort(T[] in) {
		for(int offset = 0; offset < in.length; offset++) {
			T minValue = in[offset];
			int minIndex = offset;
			for(int i = offset; i < in.length; i++) {
				if(in[i].compareTo(minValue) < 0) {
					minValue = in[i];
					minIndex = i;
				}
			}
			T tempValue = in[offset];
			in[offset] = minValue;
			in[minIndex] = tempValue;
		}

		/*T previous = in[0];
		for(T element : in) {
			if(element.compareTo(previous) < 0) {
				System.out.println("List is not correctly sorted!");
				return;
			}
			previous = element;
		}

		System.out.println("List is correctly sorted!");*/
	}

	public String sortName() {
		return "Selection Sort";
	}
}
